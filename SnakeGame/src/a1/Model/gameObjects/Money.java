package a1.Model.gameObjects;
import java.awt.Color;
import java.util.Random;

/**
 * Money class which allows player score to increase
 * Color is changeable, but not location
 * @author Andreas
 *
 */
public class Money extends FixedObject{
	
	Random random = new Random();
	
	//Value of money to be added to player score
	private final int value = random.nextInt(99) + 1;
	
	//Constructor
	public Money(float posX, float posY, Color newColor){
		super.setPointLocation(posX, posY);
		this.setColor(newColor);
		
	}

	
	public String toString() {
		
		String money ="Money: ";
		String locX = "loc=" + Float.toString(this.getLocationX());
		String locY = ","+Float.toString(this.getLocationY());
		String color =" color=" + this.getColor().toString();
		String value = " value=" + Integer.toString(this.getValue());
		String age = " age=" + Integer.toString(this.getAge());
		
		
		return money + locX + locY + color + value + age;
	}

	public int getValue() {
		return value;
	}

	
	
	

	
	
	

}
