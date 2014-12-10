package a2.Model.gameObjects;

/**
 * Strategy interface
 * @author Andreas
 *
 */
public interface IStrategy {
	public void apply();
	
	public String strategyName();
}
