package io.github.craftqq.FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DateiLeser 
{
	
	public static String[] leseDatei(String name)
	{
		ArrayList<String> al = new ArrayList<String>();
		try
		{
			FileReader fr = new FileReader(name);
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			while(s != null)
			{
				al.add(s);
				s = br.readLine();
			}
			br.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al.toArray(new String[0]);
	}
	
}
