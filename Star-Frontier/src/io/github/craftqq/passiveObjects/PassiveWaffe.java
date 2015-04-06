package io.github.craftqq.passiveObjects;

public class PassiveWaffe implements BuyablePassiveObject 
{
	public static final int WEAPON_NONE = 0;
	public static final int WEAPON_CANNON = 1;
	public static final int WEAPON_LASER = 2;
	public static final int WEAPON_ROCKET = 3;
	public static final int WEAPON_BOMB = 4;

	protected int type;
	protected int genauigkeit;
	protected int reichweite;
	protected int schaden;
	protected Preis preis;
	protected int nachladeZeit;
	
	public PassiveWaffe(int type_, int genauigkeit_, int reichweite_, int schaden_, Preis preis_, int nachladeZeit_)
	{
		type = type_;
		genauigkeit = genauigkeit_;
		reichweite = reichweite_;
		schaden = schaden_;
		preis = preis_;
		nachladeZeit = nachladeZeit_;
	}
	
	public int gibType()
	{
		return type;
	}
	
	
	public int gibReichweite()
	{
		return reichweite;
	}
	
	public int gibSchaden()
	{
		return schaden;
	}
	
	public int gibGenauigkeit()
	{
		return genauigkeit;
	}
	
	public int gibNachladeZeit()
	{
		return nachladeZeit;
	}
	
	@Override
	public Preis gibPreis()
	{
		return preis;
	}

}
