package io.github.craftqq.activeObjects;

import io.github.craftqq.GameLogic.NPCLogic;

public class NPC extends Character 
{
	protected NPCLogic logic;
	
	public NPC(String name, NPCLogic logic_)
	{
		super(name);
		logic = logic_;
	}
}
