package Observer_Pattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject
{

	private List<Observer> observers = new ArrayList<Observer>();
	
	private void attach(Observer observer) 
	{
		observers.add(observer);
	}
	
	private void detach(Observer observer) 
	{
		observers.remove(observer);
	}
	
	public void notifyObservers() 
	{
		for(Observer ob : observers)
		{
			ob.update(this);
		}
	}
}