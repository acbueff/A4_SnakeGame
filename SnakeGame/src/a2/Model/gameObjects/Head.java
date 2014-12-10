package a2.Model.gameObjects;
import java.awt.Color;

/**
 * Head class provides Snakes class means of steering itself with user input
 * 
 * @author 	Andreas
 *
 */
public class Head extends MoveableObject implements ISteerable {
	
	public Head(int heading, int speed, float posX, float posY,Color newColor){
		this.setHeading(heading);
		this.setSpeed(speed);
		this.setPointLocation(posX, posY);
		super.setColor(newColor);
	}

	//Move Head through GameWorld
	public void move() {
		
		float angle = (90 - this.getHeading());
		
		float deltaX = (int) (Math.cos(Math.toRadians(angle))*this.getSpeed());
		float deltaY = (int) (Math.sin(Math.toRadians(angle))*this.getSpeed());
		
		float newX = this.getLocationX() + deltaX;
		float newY = this.getLocationY() + deltaY;
		
		
		this.setPointLocation(newX, newY);

	}
	

	public String toString() {
		String snakeHead ="SnakeHead: ";
		String locX = "loc=" + Float.toString(this.getLocationX());
		String locY = ","+Float.toString(this.getLocationY());
		String color =" color=" + this.getColor().toString();
		String speed = " speed=" + Integer.toString(this.getSpeed());
		String heading = " heading=" + Integer.toString(this.getHeading());
		
		
		return snakeHead + locX + locY + color + speed + heading;
	}



	/**
	 * User input dictates whether Head is facing north, east, south, and west
	 */
	public void changeHeading(String dir) {
		
		switch(dir){
		case "n":
			this.setHeading(0);
			break;
		case "e":
			this.setHeading(90);
			break;
		case "s":
			this.setHeading(180);
			break;
		case "w":
			this.setHeading(270);
			break;
		default:
		
			System.out.println("1000years rick and morty");
		}
		
	}
	
	//Security issues
	public void setColor(Color newColor){
		newColor = null;
	}

	

}
