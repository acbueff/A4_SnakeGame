package a2.Model;

import a2.View.IObserver;


/**
 * Observable objects
 * @author Andreas
 *
 */
public interface IObservable {
	
	public void addObserver(IObserver obs);
	
	public void notifyObservers();
}
