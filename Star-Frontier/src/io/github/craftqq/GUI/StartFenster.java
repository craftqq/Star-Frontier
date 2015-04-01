package io.github.craftqq.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartFenster extends JFrame 
{
	private static final long serialVersionUID = 155551L;
	
	private JMenuBar menuBar;
	
	public StartFenster()
	{
        this.setTitle("Star Frontier");
        this.setSize(800, 600);
        generateMenu();
        this.setJMenuBar(menuBar);
        
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(800,600));
        contentPane.setBackground(new Color(192,192,192));

        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
	}
	
    private void generateMenu()
    {
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu help = new JMenu("Help");
        
        JMenuItem open = new JMenuItem("Open   ");
        open.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        System.out.println("Hier ist noch nichts.");}});
        JMenuItem save = new JMenuItem("Save   ");
        save.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        System.out.println("Hier ist noch nichts.");}});
        JMenuItem exit = new JMenuItem("Exit   ");
        exit.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        System.exit(0);}});
        JMenuItem preferences = new JMenuItem("Preferences   ");
        preferences.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        System.out.println("Hier ist noch nichts.");}});
        JMenuItem about = new JMenuItem("About   ");
        about.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        System.out.println("Dies ist ein Weltraumstrategiespiel.");
        System.out.println("Version: ");}});

        
        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        tools.add(preferences);
        help.add(about);

        menuBar.add(file);
        menuBar.add(tools);
        menuBar.add(help);
    }

}
