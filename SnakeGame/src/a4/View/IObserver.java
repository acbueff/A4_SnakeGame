package a4.View;

import a4.Model.IObservable;

/**
 * Interface for observer objects
 * @author Andreas
 *
 */
public interface IObserver {
	
	public void update(IObservable o, Object arg);
	
}
