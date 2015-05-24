

import io.github.awsdcrafting.Message;
import io.github.awsdcrafting.Setup;
import io.github.craftqq.GUI.ChatTextArea;
import io.github.craftqq.GUI.Fenster;
import io.github.craftqq.GUI.JElementHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class Main 
{
	private static Fenster fenster;
	private static JTextField chatEingabe;
	private static ChatTextArea chat;
	private static JScrollPane scrollChat;
	
	
	public static void main(String[] args) 
	{
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		Message.printMessage();
		Setup.load();
		fenster = new Fenster("Star Frontier", 1600, 900);
		chat = JElementHelper.baueChatStyleTextArea("", 20, 768, 1000, 95, 100);
		scrollChat = JElementHelper.baueScrollPane(chat, 20, 768, 1000, 95);
		chatEingabe = JElementHelper.baueTextField("", 20, 863, 1000, 35, new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String text = chatEingabe.getText();
				chat.append("\n"+text);
				chatEingabe.setText("");
			}
		});
		fenster.add(scrollChat);
		fenster.add(chatEingabe);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.initialize();
		DefaultCaret caret = (DefaultCaret)chat.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		chat.fill("Welcome to Star Frontier!");
	}

}
