package io.github.craftqq.passiveObjects;

public class Preis 
{
	private int credits;
	private int stahl;
	private int tritan;
	
	public Preis(int credits_, int stahl_, int tritan_)
	{
		credits = credits_;
		stahl = stahl_;
		tritan = tritan_;
	}
	
	public int gibCredits()
	{
		return credits;
	}
	
	public int gibStahl()
	{
		return stahl;
	}
	
	public int gibTritan()
	{
		return tritan;
	}
}
