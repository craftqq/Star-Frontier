package io.github.craftqq;

public class GameEngine 
{
	public static final int STATE_BLANK = 0;
	public static final int STATE_INITIALIZED = 1;
	public static final int STATE_ACTIVE = 2;
	public static final int STATE_WAITING = 3;
	public static final int STATE_INITIALIZING = -1;
	public static final int STATE_STOPPING = -2;
	public static final int STATE_STOPPED = -3;
	public static final int STATE_DECONSTRUCTING = -4;
	
	private static int state;
	
	public static void initialize()
	{
		state = STATE_INITIALIZING;
		
		
		
		state = STATE_INITIALIZED;
	}
	
	public static void start()
	{
		
		
		
		state = STATE_WAITING;
	}
	
	public static void step()
	{
		state = STATE_ACTIVE;
		
		
		
		state = STATE_WAITING;
	}
	
	public static void stop()
	{
		state = STATE_STOPPING;
		
		
		
		state = STATE_STOPPED;
	}
	
	public static void deconstruct()
	{
		state = STATE_DECONSTRUCTING;
		
		
		
		state = STATE_BLANK;
	}
	
	public static int state()
	{
		return state;
	}
}
