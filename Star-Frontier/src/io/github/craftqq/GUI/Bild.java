package io.github.craftqq.GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Bild extends JPanel 
{
	/**
     * 
     */
    private static final long serialVersionUID = 7818554427936626541L;
    private BufferedImage img;
	private boolean drawAll;
	private boolean isValid;
	
	public Bild() 
	{
		img = null;
		drawAll = true;
		isValid = false;
	}
	public Bild(Image image)
	{
		this(image, true);
	}
	
	public Bild(Image image, boolean drawAll) 
	{
		this.drawAll = drawAll;
		if(image == null)
		{
			img = null;
			isValid = false;
		}
		else if(image instanceof BufferedImage)
		{
			img = (BufferedImage) image;
			isValid = true;
		}
		else
		{
			BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		    // Draw the image on to the buffered image
		    Graphics2D bGr = bimage.createGraphics();
		    bGr.drawImage(img, 0, 0, null);
		    bGr.dispose();
		    img = bimage;
		    isValid = true;
		}
	}
	
	public Bild(String bild)
	{
		this(bild,true);
	}
	
	public Bild(String bild, boolean drawAll)
	{
		try
		{
			img = ImageIO.read(new File(bild));
			isValid = true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			isValid = false;
		}
		this.drawAll = drawAll;
	}
	
	@Override
	public void paint(Graphics g)
	{
		if(!isValid) return;
		Graphics2D g2d = (Graphics2D) g;
		int bx1 = this.getX();
		int by1 = this.getY();
		int bx2 = bx1 + this.getWidth();
		int by2 = by1 + this.getHeight();
		int width;
		int height;
		if(drawAll)
		{
			width = img.getWidth();
			height = img.getHeight();
		}
		else
		{
			width = this.getWidth() <= img.getWidth() ? this.getWidth() : img.getWidth();
			height = this.getHeight() <= img.getHeight() ? this.getHeight() : img.getHeight();
		}
		g2d.drawImage(img, bx1, by1, bx2, by2, 0, 0, width, height, null);
	}
	
}
