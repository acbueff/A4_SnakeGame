package a2.Model;

import java.awt.Color;

import a2.Model.gameObjects.Birds;
import a2.Model.gameObjects.FixedObject;
import a2.Model.gameObjects.Food;
import a2.Model.gameObjects.GameObject;
import a2.Model.gameObjects.GameObjectCollection;
import a2.Model.gameObjects.Money;
import a2.Model.gameObjects.MoveableObject;
import a2.Model.gameObjects.Snakes;
import a2.Model.gameObjects.Walls;
/**
 * Interface for GameWorld, specifically proxy
 * @author Andreas
 *
 */
public interface IGameWorld {
	
	public Clock getGameClock();
	
	public Player getGameUser();
	
	
	public GameObjectCollection getGameObjectCollection();
	
	
	public boolean getSound();

	
}
