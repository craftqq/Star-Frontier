

import io.github.awsdcrafting.Message;
import io.github.awsdcrafting.Setup;
import io.github.craftqq.GUI.ChatTextArea;
import io.github.craftqq.GUI.Fenster;
import io.github.craftqq.GUI.JElementHelper;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.DefaultCaret;

public class Main 
{
	private static Fenster fenster;
	
	public static void main(String[] args) 
	{        
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		Message.printMessage();
		Setup.load();
		fenster = new Fenster("Star Frontier", 1600, 900);
		ChatTextArea chat = JElementHelper.baueChatStyleTextArea("", 20, 768, 1000, 120, 100);
		JScrollPane scrollChat = JElementHelper.baueScrollPane(chat, 20, 768, 1000, 120);
		fenster.add(scrollChat);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.initialize();
		DefaultCaret caret = (DefaultCaret)chat.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		chat.fill("Welcome to Star Frontier!");
	}

}
