package io.github.craftqq.activeObjects;

import io.github.craftqq.passiveObjects.PassiveWaffe;

public  class ActiveWaffe implements ActiveObject
{
	private PassiveWaffe waffe;
	private int nachladeZeitVerbleibend;
	
	public ActiveWaffe(PassiveWaffe waffe_)
	{
		waffe = waffe_;
		nachladeZeitVerbleibend = 0;
	}
	
	public int gibType()
	{
		return waffe.gibType();
	}
	
	public boolean kannSchiessen()
	{
		return nachladeZeitVerbleibend == 0;
	}
	
	public void setzeGeschossen()
	{
		nachladeZeitVerbleibend += waffe.gibNachladeZeit();
	}
	
	public int gibReichweite()
	{
		return waffe.gibReichweite();
	}
	
	public int gibSchaden()
	{
		return waffe.gibSchaden();
	}
	
	public int gibGenauigkeit()
	{
		return waffe.gibGenauigkeit();
	}

	@Override
	public void rundenStep(int runde) 
	{
		if(nachladeZeitVerbleibend > 0)
		{
			nachladeZeitVerbleibend--;
		}
		
	}
}
