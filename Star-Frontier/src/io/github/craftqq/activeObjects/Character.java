package io.github.craftqq.activeObjects;

public abstract class Character 
{
	protected String name;
	
	public Character(String name_)
	{
		name = name_;
	}
	public String name()
	{
		return name;
	}
}
