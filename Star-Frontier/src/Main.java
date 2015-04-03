

import io.github.awsdcrafting.Message;
import io.github.awsdcrafting.Setup;
import io.github.craftqq.GUI.JElementHelper;
import io.github.craftqq.GUI.Fenster;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main 
{
	private static Fenster fenster;
	
	public static void main(String[] args) 
	{        
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		Message.printMessage();
		Setup.load();
		fenster = new Fenster("Star Frontier", 1600, 900);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.initialize();
	}

}
