package a4.Model.gameObjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import a4.Model.ISelectable;
import a4.Model.Point;

/**
 * Money class which allows player score to increase
 * Color is changeable, but not location
 * @author Andreas
 *
 */
public class Money extends FixedObject implements ISelectable{
	
	Random random = new Random();
	
	private final int size = 15;
	private boolean mark;//for removal in collisions
	private boolean isSelected;
	private AffineTransform myRotation, myTranslation, myScale;
	//Value of money to be added to player score
	private final int value = random.nextInt(99) + 1;
	
	//Constructor
	public Money(float posX, float posY, Color newColor){
		super.setPointLocation(posX, posY);
		this.setColor(newColor);
		

		myRotation = new AffineTransform();
		myTranslation = new AffineTransform();
		myScale = new AffineTransform();
		
		
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
	
	public int getSize(){
		return size;
	}

	/**
	 * Money is an unfilled circle
	 */
	public void draw(Graphics2D g) {
		
		AffineTransform saveAt = g.getTransform();
		
		if(isSelected()){
			
			int R = Math.abs(255 - this.getColor().getRed());
			int G = Math.abs(255 - this.getColor().getGreen());
			int B = Math.abs(255 - this.getColor().getBlue());
			g.setColor(new Color(R,G,B));	
			g.transform(myTranslation);
			g.transform(myRotation);
			g.transform(myScale);
			g.drawOval(0, 0, size, size);
					
		}else{
		g.setColor(this.getColor());
		g.transform(myTranslation);
		g.transform(myRotation);
		g.transform(myScale);
		g.drawOval(0, 0, size, size);//issue with float maybe?
		}
		
		g.setTransform(saveAt);
	}

	
	public int getValue() {
		return value;
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

	
	public boolean getMark() {
		
		return this.mark;
	}

	@Override
	public void setSelected(boolean yesNo) {
		isSelected = yesNo;
		
	}

	@Override
	public boolean isSelected() {
		
		return isSelected;
	}

	@Override
	public boolean contains(Point2D p) {
		Point2D localPoint = null;
		try{
			localPoint = myTranslation.createInverse().transform(p,null);
		}catch(NoninvertibleTransformException e1){
			System.out.println("Error of type: " + e1);
			//localPoint = new Point2D(this.getLocationX(),this.getLocationY());
		}
		
		
		//mouse selection
		double px =  p.getX();
		double py =  p.getY();
		
		//shape location
		double xLoc = this.getLocationX();//+size/2;//keep in mind true center of circle
		double yLoc = this.getLocationY();//+size/2;
		
		/**
		double xLoc = localPoint.getX()-size/2;//keep in mind true center of circle
		double yLoc = localPoint.getY()-size/2;*/
		
		if((px >= xLoc) && (px <= xLoc+size)
			&& (py >= yLoc && (py <= yLoc+size))){return true;}
		else{
			
			return false;}
		
	}

	
	
	

	
	
	

}
