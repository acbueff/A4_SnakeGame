package a2.Model.gameObjects;
import java.awt.Color;

/**
 * Birds class responsible for attacking snake in GameWorld
 * Color is fixed on instantiation
 * @author Andreas
 *
 */
public class Birds extends MoveableObject {
	
	private int size;
	
	/**
	 * Bird constructor with user input
	 */
	public Birds(int size, int heading, int speed, float posX, float posY, Color newColor ){
		this.size = size;
		this.setHeading(heading);
		this.setSpeed(speed);
		this.setPointLocation(posX, posY);
		super.setColor(newColor);
		
	}
	
	public void setColor(Color newColor){
		newColor = null;
	
	}
	
	public int getSize(){
		return size;
	}
	
	public void setSize(int newSize){
		this.size = newSize;
	}

	//Moves bird through GameWorld
	public void move() {
		float angle = (90 - this.getHeading());
		
		float deltaX = (int) (Math.cos(Math.toRadians(angle))*this.getSpeed());
		float deltaY = (int) (Math.sin(Math.toRadians(angle))*this.getSpeed());
		
		float newX = this.getLocationX() + deltaX;
		float newY = this.getLocationY() + deltaY;
		
		
		this.setPointLocation(newX, newY);
		
		
	}

	
	public String toString() {
		
		String bird ="Bird: ";
		String locX = "loc=" + Float.toString(this.getLocationX());
		String locY = ","+Float.toString(this.getLocationY());
		String color =" color=" + this.getColor().toString();
		String speed = " speed=" + Integer.toString(this.getSpeed());
		String heading = " heading=" + Integer.toString(this.getHeading());
		
		return bird + locX + locY + color + speed + heading;
	}
	
	



	

}
