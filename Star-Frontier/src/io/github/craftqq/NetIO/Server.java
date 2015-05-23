package io.github.craftqq.NetIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread
{
	protected ServerSocket server;
	protected boolean running;
	protected ArrayList<Connection> connections;
	protected int port;
	protected int next;
	
	public Server()
	{
		this(55055);
	}
	
	public Server(int port_)
	{
		connections = new ArrayList<Connection>();
		port = port_;
		next = 0;
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
			Connection c = new Connection(so, nextIdentifier());
			connections.add(c);
			c.run();
		}
		for(Connection c: connections)
		{
			c.send("CONNECTION:CLOSE");
			c.close();
		}
		return;
	}
	
	public void sendAll(String s)
	{
		for(Connection c: connections)
		{
			c.send(s);
		}
	}
	
	public String[] getAll()
	{
		ArrayList<String> receiveStrings = new ArrayList<String>();
		for(Connection c: connections)
		{
			receiveStrings.add(c.receive());
		}
		return receiveStrings.toArray(new String[0]);
	}
	
	protected synchronized int nextIdentifier()
	{
		int i = next;
		next++;
		return i;
	}
	
	public void stopServer()
	{
		running = false;
	}
}
class Connection extends Thread
{
	protected Socket socket;
	protected PrintWriter pw;
	protected BufferedReader br;
	protected boolean alive;
	protected int identifier;
	
	public Connection(Socket client, int identifier_)
	{
		socket = client;
		identifier = identifier_;
	}
	
	public Connection(Socket client)
	{
		this(client, 0);
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
	
	public String receive()
	{
		String s = "";
		try
		{
			while(br.ready())
			{
				s = s.concat(br.readLine());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
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
			
		}
		return;
	}
	
	protected void stopClient()
	{
		alive = false;
	}
}