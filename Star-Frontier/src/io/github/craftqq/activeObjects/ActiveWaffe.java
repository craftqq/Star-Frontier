package io.github.craftqq.activeObjects;

public abstract class ActiveWaffe 
{
	protected int type;
	public static final int WEAPON_NONE = 0;
	public static final int WEAPON_CANNON = 1;
	public static final int WEAPON_LASER = 2;
	public static final int WEAPON_ROCKET = 3;
	public static final int WEAPON_BOMB = 4;
	
	public int gibType()
	{
		return type;
	}
	
	public abstract boolean hasReloaded();
	
	public abstract int gibReichweite();
	
	public abstract int gibSchaden();
}
