package a2.Model;

import java.awt.Color;
import java.util.Random;

import a2.Model.gameObjects.Birds;
import a2.Model.gameObjects.FixedObject;
import a2.Model.gameObjects.Food;
import a2.Model.gameObjects.GameObject;
import a2.Model.gameObjects.GameObjectCollection;
import a2.Model.gameObjects.Money;
import a2.Model.gameObjects.MoveableObject;
import a2.Model.gameObjects.Snakes;
import a2.Model.gameObjects.Walls;
import a2.Model.gameObjects.Weasel;
import a2.View.IObserver;
/**
 * code here to accept and hold a GameWorld, provide implementations
 * of all the public methods in a GameWorld, forward allowed
 * calls to the actual GameWorld, and reject calls to methods
 * which the outside(Views) should not be able to access in the GameWorld
 * @author Andreas
 *
 */
public class GameWorldProxy implements IGameWorld, IObservable{
	//
	
	private GameWorld realGameWorld;
	
	
	
	public GameWorldProxy(GameWorld gw){ realGameWorld = gw;}
	
	public Clock getGameClock(){
		return realGameWorld.getGameClock();
	}
	
	public Player getGameUser(){
		return realGameWorld.getGameUser();
	}
	
	public GameObjectCollection getGameObjectCollection(){
		return realGameWorld.getGameObjectCollection();
	}
	
	
	
	
	
	

	
	
	
	
	public boolean getSound(){
		return realGameWorld.getSound();
	}

	@Override
	public void addObserver(IObserver obs) {
		realGameWorld.addObserver(obs);
		
	}
		
	

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(IObserver obj : realGameWorld.getRegObserver()){
			obj.update(this, null);
		}
	}

	
}
