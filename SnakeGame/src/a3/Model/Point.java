package a3.Model;

/**
 * Identifies point locations of individual objects
 * @author Andreas
 *
 */
public class Point {
	private float x, y;
	
	public Point(){
		x = 0; y = 0;
	}
	
	public Point(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	//ugh
	public Point getPoint(){
		return new Point(this.x,this.y);
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setX(float newX){
		this.x = newX;
	}
	
	public void setY(float newY){
		this.y = newY;
	}
	

}
