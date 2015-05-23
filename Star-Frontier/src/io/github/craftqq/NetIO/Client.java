package io.github.craftqq.NetIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client 
{
	protected Socket socket;
	protected boolean connected;
	protected PrintWriter pw;
	protected BufferedReader br;
	
	public Client(String host, int port)
	{
		try
		{
			socket = new Socket(host, port);
			pw = new PrintWriter(socket.getOutputStream());
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			connected = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println();
			System.out.println("Could not connect!");
			connected = false;
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
}
