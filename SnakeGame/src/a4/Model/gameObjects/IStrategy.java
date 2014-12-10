package a4.Model.gameObjects;

/**
 * Strategy interface
 * @author Andreas
 *
 */
public interface IStrategy {
	public void apply(int move);
	
	public String strategyName();
}
