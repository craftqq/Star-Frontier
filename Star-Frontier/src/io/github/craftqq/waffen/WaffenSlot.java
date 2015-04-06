package io.github.craftqq.waffen;

public class WaffenSlot 
{
	private int maxClass;
	private int size;
	private boolean teilbar;
	protected int lockedType;
	
	public WaffenSlot(int maxClass_, int size_, boolean teilbar_)
	{
		maxClass = maxClass_;
		size = size_;
		teilbar = teilbar_;
		lockedType = 0;
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
	
	public int gibType()
	{
		return lockedType;
	}
}
