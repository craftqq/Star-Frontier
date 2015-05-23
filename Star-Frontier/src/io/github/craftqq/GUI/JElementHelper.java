package io.github.craftqq.GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class JElementHelper 
{
	public static JButton baueKnopf(String text, int x, int y, ActionListener listener)
    {
        JButton knopf = new JButton();
        knopf.setBounds(x,y,140,35);
        knopf.setBackground(new Color(214,217,223));
        knopf.setForeground(new Color(0,0,0));
        knopf.setEnabled(true);
        knopf.setFont(new Font("SansSerif",0,12));
        knopf.setText(text);
        knopf.setVisible(true);
        knopf.addActionListener(listener);
        return knopf;
    }
    
    public static JLabel baueLabel(String text, int x, int y)
    {
        JLabel label = new JLabel();
        label.setBounds(x,y,140,35);
        label.setBackground(new Color(214,217,223));
        label.setForeground(new Color(0,0,0));
        label.setEnabled(true);
        label.setFont(new Font("SansSerif",0,12));
        label.setText(text);
        label.setVisible(true);
        return label;
    }
    
    public static JTextArea baueTextArea(String text, int x, int y)
    {
        JTextArea eingabe = new JTextArea();
        eingabe.setBounds(x,y,140,35);
        eingabe.setBackground(new Color(255,255,255));
        eingabe.setForeground(new Color(0,0,0));
        eingabe.setEnabled(true);
        eingabe.setFont(new Font("SansSerif",0,12));
        eingabe.setText(text);
        eingabe.setBorder(BorderFactory.createBevelBorder(1));
        eingabe.setVisible(true);
        return eingabe;
    }
    
    public static JTextField baueTextField(String text, int x, int y)
    {
    	JTextField feld = new JTextField();
        feld.setBounds(x,y,140,35);
        feld.setBackground(new Color(255,255,255));
        feld.setForeground(new Color(0,0,0));
        feld.setEnabled(true);
        feld.setFont(new Font("SansSerif",0,12));
        feld.setText(text);
        feld.setBorder(BorderFactory.createBevelBorder(1));
        feld.setVisible(true);
        return feld;
    }
    
    public static <T> JComboBox<T> baueComboBox(int x, int y)
    {
        JComboBox<T> comboBox = new JComboBox<T>();
        comboBox.setBounds(x, y, 140, 35);
        comboBox.setBackground(new Color(214, 217, 223));
        comboBox.setForeground(new Color(0, 0, 0));
        comboBox.setEnabled(true);
        comboBox.setFont(new Font("sansserif", 0, 12));
        comboBox.setVisible(true);
        return comboBox;
    }
    
    public static <T> JList<T> baueList(int x, int y)
    {
        JList<T> list = new JList<T>();
        list.setBounds(x, y, 140, 35);
        list.setBackground(new Color(214, 217, 223));
        list.setForeground(new Color(0, 0, 0));
        list.setEnabled(true);
        list.setFont(new Font("sansserif", 0, 12));
        list.setVisible(true);
        return list;
    }
}
