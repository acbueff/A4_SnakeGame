package a3.Model;

import java.awt.Color;

import a3.Model.gameObjects.Birds;
import a3.Model.gameObjects.FixedObject;
import a3.Model.gameObjects.Food;
import a3.Model.gameObjects.GameObject;
import a3.Model.gameObjects.GameObjectCollection;
import a3.Model.gameObjects.Money;
import a3.Model.gameObjects.MoveableObject;
import a3.Model.gameObjects.Snakes;
import a3.Model.gameObjects.Walls;
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
