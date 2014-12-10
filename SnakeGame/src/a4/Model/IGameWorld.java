package a4.Model;

import a4.Model.gameObjects.GameObjectCollection;
/**
 * Interface for GameWorld, specifically proxy
 * @author Andreas
 *
 */
public interface IGameWorld {
	
	public boolean getMode();
	
	public Clock getGameClock();
	
	public Player getGameUser();
	
	
	public GameObjectCollection getGameObjectCollection();
	
	
	public boolean getSound();
	
	public void GameCollisionFood();

	
}
