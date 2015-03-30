package io.github.craftqq.FileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class DateiSchreiber 
{
	
	public static void schreibeDatei(String name, String[] inhalt)
	{
		try
		{
			FileWriter fw = new FileWriter(name);
			BufferedWriter bw = new BufferedWriter(fw);
			for(String s: inhalt)
			{
				bw.write(s);
				bw.newLine();
			}
			bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
}
