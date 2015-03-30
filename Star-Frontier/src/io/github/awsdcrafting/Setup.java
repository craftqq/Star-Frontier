package io.github.awsdcrafting;

import io.github.craftqq.DateiLeser;

public class Setup
{
	public static boolean sound;
	public static boolean music;
	
	public static void load()
	{
		System.out.println("Welcome to Star Frontier!");
		String[] settings = DateiLeser.leseDatei("settings.txt");
		
	}

}
