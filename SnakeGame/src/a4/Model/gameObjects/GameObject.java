package a4.Model.gameObjects;
import java.awt.Color;
import java.awt.geom.AffineTransform;

import a4.Model.IDrawable;
import a4.Model.Point;


/**
 * Abstract Game Objects which will encompass all elements
 * for GameWorld
 * @author Andreas
 *
 */
public abstract class GameObject implements IDrawable, ICollider{
	
	//points identify center of object
	private Point location;
	private Color color;

	
	public void setPointLocation(float x, float y){
		
			 this.location = new Point(x, y);
			
	}
	
	public void setPointLocation(Point newLocation){
		this.location = newLocation;
	}
	
	
	

	
	/**
	 * Retrieve x point location
	 * @return int x
	 */
	public float getLocationX(){
		return this.location.getX();
	}
	
	/**
	 * Retrieve y point location
	 * @return int y
	 */
	public float getLocationY(){
		return this.location.getY();
	}
	
	

	
	
	/**
	 * User returns color of Game object
	 * @return color of object
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * Changes color of object
	 * @return Color
	 */
	public void setColor(Color newColor){
		this.color = newColor;
	}
	
	/**IRRELEPHANT
	public abstract String toString();
	*/
}
