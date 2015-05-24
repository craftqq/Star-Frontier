package io.github.craftqq.observe;

public interface Observable 
{
	public void subscribe(Observer o);
	public void unsubscribe(Observer o);
}
