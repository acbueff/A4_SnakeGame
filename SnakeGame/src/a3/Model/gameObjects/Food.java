package a3.Model.gameObjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import a3.Controller.EatFoodCommand;
import a3.Model.GameWorld;
import a3.Model.GameWorldProxy;
import a3.Model.Point;

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
	 
	
	final private int size = 15;
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

	/**
	 * filled circle
	 */
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval((int)this.getLocationX()-size/2, (int)this.getLocationY()-size/2, size, size);
		
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
