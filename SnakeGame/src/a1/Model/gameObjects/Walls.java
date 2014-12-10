package a1.Model.gameObjects;
import java.awt.Color;

import a1.Model.Point;

/**
 * Wall GameObjects, responsible for defining the boundary of the game
 * @author Andreas
 *
 */
public class Walls extends FixedObject {
	
	
	private int width, height;
	
	public Walls(float posX, float posY, int width, int height, Color newColor){
		super.setPointLocation(posX, posY);
		this.setWidth(width);
		this.setHeight(height);
		super.setColor(newColor);
		
	}
	
	//Color cannot be changed after instantiation
	public void setColor(Color newColor){
		newColor = null;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		String wall ="Wall: ";
		String locX = "loc=" + Float.toString(this.getLocationX());
		String locY = ","+Float.toString(this.getLocationY());
		String color =" color=" + this.getColor().toString();
		String width = " width=" + Integer.toString(this.getWidth());
		String height = " height=" + Integer.toString(this.getHeight());
		String age = " age=" + Integer.toString(this.getAge());
		
		
		return wall + locX + locY + color + width + height +  age;
	}
	
	//Overriding required to insure Walls objects are fixed
	public void setPointLocation(float x, float y){
		super.setPointLocation(null);
	}
	
	public void setPointLocation(Point newLocation){
		newLocation = new Point();
	}
	


}
