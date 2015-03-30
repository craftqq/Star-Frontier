

import io.github.awsdcrafting.Setup;
import io.github.craftqq.StartFenster;

import javax.swing.*;

public class Main 
{
	private static JFrame fenster;
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		Setup.doStuff();
		fenster = new StartFenster();
	}

}
