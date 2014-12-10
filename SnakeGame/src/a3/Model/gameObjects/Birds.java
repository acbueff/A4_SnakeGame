package a3.Model.gameObjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import a3.Controller.HitBirdCommand;
import a3.Model.IDrawable;
import a3.Model.ISelectable;
import a3.Model.Point;

/**
 * Birds class responsible for attacking snake in GameWorld
 * Color is fixed on instantiation
 * @author Andreas
 *
 */
public class Birds extends MoveableObject implements IDrawable, ICollider, ISelectable {
	
	private int size;
	private boolean mark;//for removal from collision
	private boolean isSelected;//for selection
	/**
	 * Bird constructor with user input
	 */
	public Birds(int size, int heading, int speed, float posX, float posY, Color newColor ){
		this.size = size*5;
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
	public void move(int time) {
		float angle = (90 - this.getHeading());
		
		float deltaX = (int) (Math.cos(Math.toRadians(angle))*this.getSpeed());
		float deltaY = (int) (Math.sin(Math.toRadians(angle))*this.getSpeed());
		
		float newX = this.getLocationX() + deltaX*(((float)time)/50);
		float newY = this.getLocationY() + deltaY*(((float)time)/50);
		
		
		this.setPointLocation(newX, newY);
		
		
	}

	
	/**
	 * birds are filled ovals
	 * draws object in its current color and size at
	 * current location. Location of each object is
	 * the center point of object. 
	 */
	public void draw(Graphics g) {
		if(isSelected()){
			
			int R = Math.abs(255 - this.getColor().getRed());
			int G = Math.abs(255 - this.getColor().getGreen());
			int B = Math.abs(255 - this.getColor().getBlue());
			g.setColor(new Color(R,G,B));	
			g.fillOval((int)this.getLocationX(), (int)this.getLocationY(), this.size, this.size/2);
					
		}else{
		
			g.setColor(this.getColor());    
			g.fillOval((int)this.getLocationX(),(int) this.getLocationY(), this.size, this.size/2);
		
		}
	}

	//bounding circles for bird
	public boolean collidesWith(ICollider otherObject) {
		
		return false;
	}



	public void handleCollision(ICollider otherObject) {
		//Blank?
		
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
	public boolean contains(Point p) {
		//mouse selection
		int px = (int) p.getX();
		int py = (int) p.getY();
		
		//shape location
		int xLoc = (int)this.getLocationX();//keep in mind true center of circle
		int yLoc = (int)this.getLocationY();
		
		if((px >= xLoc) && (px <= xLoc+size)
			&& (py >= yLoc && (py <= yLoc+size/2))){return true;}
		else{return false;}
		
	}


	

}
