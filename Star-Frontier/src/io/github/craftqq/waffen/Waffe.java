package io.github.craftqq.waffen;

public abstract class Waffe 
{
	int type;
	public static int WEAPON_NONE = 0;
	public static int WEAPON_CANNON = 1;
	public static int WEAPON_ROCKET = 2;
	public static int WEAPON_BOMB = 3;
	
	public int gibType()
	{
		return type;
	}
}
