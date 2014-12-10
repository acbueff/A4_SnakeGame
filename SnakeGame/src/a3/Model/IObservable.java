package a3.Model;

import a3.View.IObserver;


/**
 * Observable objects
 * @author Andreas
 *
 */
public interface IObservable {
	
	public void addObserver(IObserver obs);
	
	public void notifyObservers();
}
