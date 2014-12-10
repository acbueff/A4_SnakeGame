package a4.Model.gameObjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

import a4.Model.Point;

/**
 * Food object responsible for increasing BodySegments of Snake object
 * Adding new Money objects to GameWorld
 * Food objects location and color are fixed
 * @author Andreas
 *
 */
public class Food extends FixedObject {
	
	//private GameWorldProxy proxy = new GameWorldProxy();//MAYBE BETTER METHOD EXISTS
	private Random random = new Random();
	private boolean mark;
	private AffineTransform myRotation, myTranslation, myScale;
	 
	
	final private int size = 15;
	private int amount;
	
	public Food(float posX, float posY, Color newColor){
		
		super.setPointLocation(0, 0);//local space
		super.setColor(newColor);
		this.setAmount(random.nextInt(9) + 1);		
		
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

	/**
	 * filled circle
	 */
	public void draw(Graphics2D g) {
		
		AffineTransform saveAt = g.getTransform();
		
		g.setColor(this.getColor());
		
		g.transform(myTranslation);
		g.transform(myRotation);
		g.transform(myScale);
		g.fillOval(0, 0, size, size);
		
		g.setTransform(saveAt);
	}
	
	public boolean collidesWith(ICollider otherObject) {
		
		
		
		return false;
	}



	public void handleCollision(ICollider otherObject) {
		//probably more to add
		
		
		
	}

	
	public int getSize() {
	
	return size;
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
