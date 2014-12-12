package a4.Model.gameObjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import a4.Model.Point;

/**
 * Wall GameObjects, responsible for defining the boundary of the game
 * @author Andreas
 *
 */
public class Walls extends FixedObject{
	
	
	private int width, height;
	
	private boolean mark;
	
	private AffineTransform myRotation, myTranslation, myScale;
	
	public Walls(float posX, float posY, int width, int height, Color newColor){
		super.setPointLocation(0, 0);
		this.setWidth(width);
		this.setHeight(height);
		super.setColor(newColor);
		
		myRotation = new AffineTransform();
		myTranslation = new AffineTransform();
		myScale = new AffineTransform();
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int) this.getLocationX(),(int)this.getLocationY(),this.getWidth(),this.getHeight());
	}
	
	
	//Following methods
		//rotate,translate,resetTransform are AT related
		public void rotate(double radians){
			myRotation.rotate(radians);
		}
		
		public void translate(double dx,double dy){
			myTranslation.translate(dx,dy);
		}
		
		public void resetTransform(){
			myRotation.setToIdentity();
			myTranslation.setToIdentity();
			myScale.setToIdentity();
		}
		
		public float getLocationX(){
			
			return (float) myTranslation.getTranslateX();
		}
		
		public float getLocationY(){
			
			return (float) myTranslation.getTranslateY();
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

	
	//Overriding required to insure Walls objects are fixed
	public void setPointLocation(float x, float y){
		super.setPointLocation(null);
	}
	
	public void setPointLocation(Point newLocation){
		newLocation = new Point();
	}

	/**
	 * walls are filled rectangles
	 */
	public void draw(Graphics2D g) {
		AffineTransform saveAt = g.getTransform();
		
		g.setColor(this.getColor());
		
		/**
		if(this.getWidth() > this.getHeight()){
		g.fillRect((int)this.getLocationX() - this.getWidth()/2, (int)this.getLocationY() - this.getHeight()/2,
				    this.getWidth(), this.getHeight());
		}
		else{
			g.fillRect((int)this.getLocationX() - this.getWidth()/2, (int)this.getLocationY() - this.getHeight()/2,
				    this.getWidth(), this.getHeight());
		}
		*/
		g.transform(myTranslation);
		g.transform(myRotation);
		g.transform(myScale);
		g.fillRect(0, 0, width, height);
		
		g.setTransform(saveAt);
		
	}

	@Override
	public boolean collidesWith(ICollider otherObject) {
		// TODO Auto-generated method stub
		return false; 
	}

	@Override
	public void handleCollision(ICollider otherObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCollisionList(ICollider collobj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCollision(ICollider obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearCollisions(ArrayList<ICollider> collList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ICollider> getCollisionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMark(boolean mark) {
		this.mark = mark;
		
	}

	@Override
	public boolean getMark() {
		// TODO Auto-generated method stub
		return this.mark;
	}
	


}
