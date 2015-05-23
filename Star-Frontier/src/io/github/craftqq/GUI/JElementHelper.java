package io.github.craftqq.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;

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
    
    public static JTextArea baueChatStyleTextArea(String text, int x, int y)
    {
        ChatTextArea ausgabe = new ChatTextArea();
        ausgabe.setBounds(x,y,140,35);
        ausgabe.setBackground(new Color(255,255,255));
        ausgabe.setForeground(new Color(0,0,0));
        ausgabe.setEnabled(true);
        ausgabe.setFont(new Font("SansSerif",0,12));
        ausgabe.setText(text);
        ausgabe.setBorder(BorderFactory.createBevelBorder(1));
        ausgabe.setEditable(false);
        ausgabe.fill();
        ausgabe.setVisible(true);
        return ausgabe;
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
class ChatTextArea extends JTextArea
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4538836711452941905L;

	public void fill()
	{
		Font f = this.getFont();
		Graphics g = this.getGraphics();
		FontMetrics fm = g.getFontMetrics(f);
		int i = fm.getHeight();
		int lines =(int) Math.ceil(((double)this.getHeight())/((double)i));
		String s = "";
		for(int j = 0; j<=lines;j++)
		{
			s = s.concat("\n");
		}
		this.setText(s);
	}
	
	@Override
	public void append(String s)
	{
        Document doc = getDocument();
        if (doc != null) 
        {
            try 
            {
            	Element root = doc.getDefaultRootElement();
            	Element first = root.getElement(0);
            	doc.remove(0, first.getEndOffset());
                doc.insertString(doc.getLength(), s, null);
            }
            catch (BadLocationException e) 
            {
            	
            }
        }
	}
}
