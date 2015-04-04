package io.github.craftqq.waffen;

public abstract class Waffe 
{
	public static final int WEAPON_NONE = 0;
	public static final int WEAPON_CANNON = 1;
	public static final int WEAPON_ROCKET = 2;
	public static final int WEAPON_BOMB = 3;
	
	public abstract int gibType();
	
	public abstract boolean hasReloaded();
	
	public abstract int gibReichweite();
	
	public abstract int gibSchaden();
}
