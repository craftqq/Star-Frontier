package io.github.craftqq.NetIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread
{
	protected Socket socket;
	protected boolean connected;
	protected PrintWriter pw;
	protected BufferedReader br;
	protected String host;
	protected int port;
	protected boolean open;
	
	public Client(String host_, int port_)
	{
		host = host_;
		port = port_;
	}
	
	public void connect()
	{
		try
		{
			socket = new Socket(host, port);
			connected = true;
			open = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println();
			System.out.println("Could not connect!");
			connected = false;
			return;
		}
		try
		{
			pw = new PrintWriter(socket.getOutputStream());
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			connected  = false;
		}
	}
	
	public void disconnect()
	{
		if(connected)
		{
			pw.println("CONNECTION:CLOSE");
			try
			{
				socket.close();
				connected = false;
				open = false;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			connected  = false;
		}
	}
	
	public void close()
	{
		disconnect();
		pw.close();
		try
		{
			br.close();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public boolean isConnected()
	{	
		return connected;
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
		if(!connected)
		{
			if(open)
			{
				disconnect();
			}
			connect();
		}
		while(connected)
		{
			
		}
		if(open)
		{
			disconnect();
		}
	}
}
