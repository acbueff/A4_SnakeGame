package a4.Model;

import a4.View.IObserver;


/**
 * Observable objects
 * @author Andreas
 *
 */
public interface IObservable {
	
	public void addObserver(IObserver obs);
	
	public void notifyObservers();
}
