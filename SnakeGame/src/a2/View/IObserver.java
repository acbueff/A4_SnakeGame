package a2.View;

import a2.Model.IObservable;

/**
 * Interface for observer objects
 * @author Andreas
 *
 */
public interface IObserver {
	
	public void update(IObservable o, Object arg);
	
}
