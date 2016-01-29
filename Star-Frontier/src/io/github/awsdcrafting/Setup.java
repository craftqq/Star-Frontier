package io.github.awsdcrafting;

import io.github.craftqq.FileIO.DateiLeser;
import io.github.craftqq.FileIO.DateiSchreiber;

import java.io.File;
import java.io.IOException;

public class Setup
{
	public static boolean sound;
	public static boolean music;
	
	public static void load()
	{
		File f = new File("settings.txt");
		System.out.println(f.getPath());
		if(!f.exists())
		{
			System.out.println("f existiert nicht");
			return;
		}
		String[] settings = DateiLeser.leseDatei(f);
		for(String s: settings)
		{
			System.out.println(s);
			String[] t = s.trim().split("=");
			String name = t[0].trim().toLowerCase();
			String setting = t[1].trim();
			switch(name)
			{
			case "music":
			{
				music = setting.equalsIgnoreCase("true");
				break;
			}
			case "sound":
			{
				sound = setting.equalsIgnoreCase("true");
				break;
			}
			default:
				break;
			}
		}
	}

}
