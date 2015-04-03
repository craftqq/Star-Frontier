package io.github.awsdcrafting;

import io.github.craftqq.waffen.WaffenSlot;

public class Raumschiff 
{
	private WaffenSlot[] waffenSlots;
	private int armor;
	private int interiorSpace;
	private boolean canTransportCargo;
	
	public Raumschiff(int anzahlWaffen, int armor_, int interiorSpace_, boolean canTransportCargo_)
	{
		waffenSlots = new WaffenSlot[anzahlWaffen];
		armor = armor_;
		interiorSpace = interiorSpace_;
		canTransportCargo = canTransportCargo_;
	}
	
	public boolean kannCargoTransportieren()
	{
		return canTransportCargo;
	}
	
	public int gibInteriorSpace()
	{
		return interiorSpace;
	}
	
	public int gibarmor()
	{
		return armor;
	}
	
	public int gibAnzahlWaffenSlots()
	{
		return waffenSlots.length;
	}
	public WaffenSlot gibWaffenSlot(int slot)
	{
		return waffenSlots[slot];
	}
}
