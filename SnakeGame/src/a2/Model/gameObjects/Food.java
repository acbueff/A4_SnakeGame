package a2.Model.gameObjects;
import java.awt.Color;
import java.util.Random;

import a2.Model.Point;

/**
 * Food object responsible for increasing BodySegments of Snake object
 * Adding new Money objects to GameWorld
 * Food objects location and color are fixed
 * @author Andreas
 *
 */
public class Food extends FixedObject {

	private Random random = new Random();
	
	private int amount;
	
	public Food(float posX, float posY, Color newColor){
		
		super.setPointLocation(posX, posY);
		super.setColor(newColor);
		this.setAmount(random.nextInt(9) + 1);		
		
	}

	@Override
	public String toString() {
		
		String food ="Food: ";
		String locX = "loc=" + Float.toString(this.getLocationX());
		String locY = ","+Float.toString(this.getLocationY());
		String color =" color=" + this.getColor().toString();
		String amount = " amount=" + Integer.toString(this.getAmount());
		String age = " age=" + Integer.toString(this.getAge());
		
		
		return food + locX + locY + color + amount + age;
	}
	
	
	//Overriding to prevent access
	public void setColor(Color newColor){
		newColor = null;
	}
	

	public int getAmount() {
		return amount;
	}

	private void setAmount(int amount) {
		this.amount = amount;
	}
	
	//Security principles
	public void setPointLocation(float x, float y){
		super.setPointLocation(null);
	}
	
	public void setPointLocation(Point newLocation){
		newLocation = new Point();
	}
	
	
	
	

	
}
