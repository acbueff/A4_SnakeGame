package a4.Model;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Random;

import a4.Model.gameObjects.Food;
import a4.Model.gameObjects.GameObject;
import a4.Model.gameObjects.GameObjectCollection;
import a4.Model.gameObjects.Money;
import a4.Model.gameObjects.Snakes;
import a4.Model.gameObjects.Sweeper;
import a4.View.IObserver;
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
		
	public void addSweeper(Point2D point){
		realGameWorld.addSweeper(point);
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
