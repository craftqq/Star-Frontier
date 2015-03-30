

import io.github.awsdcrafting.Message;
import io.github.awsdcrafting.Setup;
import io.github.craftqq.StartFenster;

import javax.swing.*;

public class Main 
{
	private static JFrame fenster;
	public static void main(String[] args) 
	{
		Message.printMessage();
		Setup.load();
		fenster = new StartFenster();
		System.out.println(String.valueOf(Setup.music));
		System.out.println(String.valueOf(Setup.sound));
	}

}
