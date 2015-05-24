package io.github.craftqq.NetIO;

import io.github.craftqq.utility.BidirectionalMap;
import io.github.craftqq.utility.Observable;
import io.github.craftqq.utility.ObservableObserver;
import io.github.craftqq.utility.Observer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server extends Thread implements ObservableObserver
{
	protected ServerSocket server;
	protected boolean running;
	protected HashMap<Integer, Connection> connections;
	protected BidirectionalMap<Integer, String> clientNames;
	protected int port;
	protected int next;
	private int id;
	private ArrayList<Observer> observers;
	
	
	public Server()
	{
		this(55055);
	}
	
	public Server(int port_)
	{
		connections = new HashMap<Integer, Connection>();
		clientNames = new BidirectionalMap<Integer, String>();
		observers = new ArrayList<Observer>();
		port = port_;
		next = 0;
		id = 0;
	}
	
	private synchronized int nextIdentifier()
	{
		int i = id;
		id++;
		return i;
	}
	
	public void run()
	{
		try
		{
			server = new ServerSocket(port);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println();
			System.out.println("Could not create Server!");
			return;
		}
		running = true;
		while(running)
		{
			Socket so;
			try
			{
				so = server.accept();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				continue;
			}
			Connection c = new Connection(so);
			synchronized(this){
				int i = nextIdentifier();
				clientNames.put(i, "Guest_"+i);
				connections.put(i,c);
			}
			c.subscribe(this);
			c.run();
		}
		for(Connection c: connections.values())
		{
			c.send("CONNECTION:CLOSE");
			c.close();
		}
		return;
	}
	
	public void sendAll(String s)
	{
		for(Connection c: connections.values())
		{
			c.send(s);
		}
	}
	
	public void sendTo(String s, String recipient)
	{
		Connection c = connections.get(recipient);
		c.send(s);
	}
	
	public void sendExcept(String s, String excluded)
	{
		int i = clientNames.getKey(excluded);
		for(Connection c:connections.values())
		{
			if(c.getIdentifier() == i)
			{
				continue;
			}
			c.send(s);
		}
	}
	
	public void stopServer()
	{
		running = false;
	}

	@Override
	public void subscribe(Observer o) 
	{
		observers.add(o);
	}

	@Override
	public void unsubscribe(Observer o) 
	{
		observers.remove(o);
	}

	@Override
	public void notify(String message, Observable source)
	{
		Connection c = (Connection)source;
		if(message.toLowerCase().toUpperCase().startsWith("CONNECTION"))
		{
			String s = message.substring(11);
			if(s.equalsIgnoreCase("CLOSE"))
			{
				c.close();
				connections.remove(c.getIdentifier());
				clientNames.removeByKey(c.getIdentifier());
			}
			else if(s.toLowerCase().toUpperCase().startsWith("NEWNAME"))
			{
				String name = s.substring(8);
				int i = c.getIdentifier();
				clientNames.removeByKey(i);
				clientNames.put(i, name);
			}
		}
		else
		{
			for(Observer o: observers)
			{
				o.notify(message, this);
			}
		}
	}
}
class Connection extends Thread implements Observable
{
	protected Socket socket;
	protected PrintWriter pw;
	protected BufferedReader br;
	protected boolean alive;
	protected int identifier;
	private ArrayList<Observer> observers;
	
	public Connection(Socket client, int identifier_)
	{
		socket = client;
		identifier = identifier_;
	}
	
	public Connection(Socket client)
	{
		this(client, 0);
	}
	
	public int getIdentifier()
	{
		return identifier;
	}
	
	protected void close()
	{
		try {
			socket.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		stopClient();
	}
	
	public void send(String s)
	{
		pw.write(s);
	}
	
	public void run()
	{
		try
		{
			pw = new PrintWriter(socket.getOutputStream());
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println();
			System.out.println("Error while connecting");
			return;
		}
		
		alive = true;
		while(alive)
		{
			try
			{
				if(br.ready())
				{
					String s = "";
					while(br.ready())
					{
						s = s.concat(br.readLine()+"\n");
					}
					for(Observer o: observers)
					{
						o.notify(s, this);
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return;
	}
	
	protected void stopClient()
	{
		alive = false;
	}

	@Override
	public void subscribe(Observer o) 
	{
		observers.add(o);
	}

	@Override
	public void unsubscribe(Observer o) 
	{
		observers.remove(o);
	}
}