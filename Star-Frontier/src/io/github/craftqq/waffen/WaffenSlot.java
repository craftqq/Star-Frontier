package io.github.craftqq.waffen;

public class WaffenSlot 
{
	private int maxClass;
	private int size;
	private boolean teilbar;
	
	public WaffenSlot(int maxClass_, int size_, boolean teilbar_)
	{
		maxClass = maxClass_;
		size = size_;
		teilbar = teilbar_;
	}
	
	public int gibKlasse()
	{
		return maxClass;
	}
	
	public int gibSize()
	{
		return size;
	}
	
	public boolean istTeilbar()
	{
		return teilbar;
	}
}
