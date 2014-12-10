package a3.View;

import a3.Model.IObservable;

/**
 * Interface for observer objects
 * @author Andreas
 *
 */
public interface IObserver {
	
	public void update(IObservable o, Object arg);
	
}
