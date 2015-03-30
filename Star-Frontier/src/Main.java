

import io.github.awsdcrafting.Message;
import io.github.awsdcrafting.Setup;
import io.github.craftqq.StartFenster;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main 
{
	private static JFrame fenster;
	
	public static void main(String[] args) 
	{        
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		Message.printMessage();
		Setup.load();
		fenster = new StartFenster();
		System.out.println(String.valueOf(Setup.music));
		System.out.println(String.valueOf(Setup.sound));
	}

}
