package a2.Model.gameObjects;

import java.awt.Color;
import java.util.Random;
/**
 * Weasel movable GameObject
 * @author Andreas
 *
 */
public class Weasel extends MoveableObject {
	
	private IStrategy curStrategy;
	 
	private Random random = new Random();
	
	private int speed = random.nextInt(11) + 1;
	
	public Weasel(int heading, int posX, int posY, Color newColor){
		
		this.setHeading(heading);
		this.setSpeed(this.speed);
		this.setPointLocation(posX, posY);
		super.setColor(newColor);
		
	}
	
	public void setStrategy(IStrategy newStrategy){
		curStrategy = newStrategy;
	}
	
	public IStrategy getStrategy(){
		return curStrategy;
	}
	
	public void invokeStrategy(){
		curStrategy.apply();
	}

	@Override
	public void move() {
		this.invokeStrategy();
		
	}

	@Override
	public String toString() {
		String weasel ="Weasel: ";
		String locX = "loc=" + Float.toString(this.getLocationX());
		String locY = ","+Float.toString(this.getLocationY());
		String color =" color=" + this.getColor().toString();
		String speed = " speed=" + Integer.toString(this.getSpeed());
		String heading = " heading=" + Integer.toString(this.getHeading());
		String strategy = " Strategy: " + this.getStrategy().strategyName();
		
		return weasel + locX + locY + color + speed + heading + strategy;
	}
	
	//Overriding to prevent access
	public void setColor(Color newColor){
		newColor = null;
	}

}
