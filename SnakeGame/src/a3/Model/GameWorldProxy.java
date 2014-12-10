package a3.Model;

import java.awt.Color;
import java.util.Random;

import a3.Model.gameObjects.Birds;
import a3.Model.gameObjects.FixedObject;
import a3.Model.gameObjects.Food;
import a3.Model.gameObjects.GameObject;
import a3.Model.gameObjects.GameObjectCollection;
import a3.Model.gameObjects.Money;
import a3.Model.gameObjects.MoveableObject;
import a3.Model.gameObjects.Snakes;
import a3.Model.gameObjects.Walls;
import a3.Model.gameObjects.Weasel;
import a3.View.IObserver;
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
	
	private Random random = new Random();
	
	
	public GameWorldProxy(GameWorld gw){ realGameWorld = gw;}
	
	
	public boolean getMode(){
		return realGameWorld.getMode();
	}
	
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
	
	public void GameCollisionFood(){
		int growthPool = 0;
		for(GameObject food : realGameWorld.getGameObjectCollection()){
			if(food instanceof Food){
				growthPool = ((Food)food).getAmount();
				System.out.println("\n" + "Amount of food: " + growthPool + "\n");
				realGameWorld.getGameObjectCollection().remove(food);
				for(GameObject snake : realGameWorld.getGameObjectCollection()){
					if(snake instanceof Snakes){
						((Snakes)snake).setNewSegCount(growthPool);
					}	
				}
				
				int moneyObjectAmount = random.nextInt(3) + 1;
				for(int k = 0; k < moneyObjectAmount; k++){
					realGameWorld.getGameObjectCollection().add(new Money(random.nextInt(500)+10,random.nextInt(500)+10, Color.GREEN));
				}	
				realGameWorld.getGameObjectCollection().add(new Food(random.nextInt(500)+10, random.nextInt(500)+10, Color.ORANGE));
				
			break;	
			}
			
		}
		this.notifyObservers();

	}

	
}
