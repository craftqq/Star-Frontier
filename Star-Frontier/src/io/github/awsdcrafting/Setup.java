package io.github.awsdcrafting;

import io.github.craftqq.DateiLeser;

public class Setup
{
	public static boolean sound;
	public static boolean music;
	
	public static void load()
	{
		String[] settings = DateiLeser.leseDatei("settings.txt");
		for(String s: settings)
		{
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
