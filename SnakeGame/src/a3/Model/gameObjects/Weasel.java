package a3.Model.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import a3.Model.IDrawable;
import a3.Model.ISelectable;
import a3.Model.Point;
/**
 * Weasel movable GameObject
 * @author Andreas
 *
 */
public class Weasel extends MoveableObject implements ISelectable{
	
	private IStrategy curStrategy;
	private IStrategy firstStrategy;
	private IStrategy secondStrategy;
	private boolean choice = true; ///use weasel strategy?

	private Random random = new Random();
	private boolean mark;
	private boolean isSelected;
	
	private int speed = random.nextInt(11) + 5;
	
	
	private final int size = 40;
	private int msecCount = 50;
	
	public Weasel(int heading, int posX, int posY, Color newColor){
		
		this.setHeading(heading);
		this.setSpeed(this.speed);
		this.setPointLocation(posX, posY);
		super.setColor(newColor);
		
	}
	
	public int getSize(){
		return this.size;
	}
	
	public void setStrategy(IStrategy newStrategy){
		curStrategy = newStrategy;
	}
	
	public IStrategy getStrategy(){
		return curStrategy;
	}
	
	public void invokeStrategy(int move){
		curStrategy.apply(move);
	}
	
	public void strategyList(IStrategy firstStrategy, IStrategy secondStrategy){
		this.firstStrategy = firstStrategy;
		this.setStrategy(this.firstStrategy);
		this.secondStrategy = secondStrategy;
		
	}
	
	public void  switchStrategy(boolean choice){
		if(choice){
			this.setStrategy(firstStrategy);
		}
		else{
			this.setStrategy(secondStrategy);
		}
	}

	@Override
	public void move(int move) {
		
		if(msecCount != 0){
			
			this.invokeStrategy(move);
			msecCount--;
		}else{
			choice = !choice;
			this.switchStrategy(choice);
			msecCount = 500;
		}
	}

	
	//Overriding to prevent access
	public void setColor(Color newColor){
		newColor = null;
	}

	/**
	 * weasel are unfilled rectangles
	 */
	public void draw(Graphics g) {
		if(isSelected()){
			
			int R = Math.abs(255 - this.getColor().getRed());
			int G = Math.abs(255 - this.getColor().getGreen());
			int B = Math.abs(255 - this.getColor().getBlue());
			g.setColor(new Color(R,G,B));	
			g.fillRect((int)this.getLocationX() - size/2, (int)this.getLocationY() - size/4, size, size/2);
					
		}else{

			g.setColor(this.getColor());				
			g.drawRect((int)this.getLocationX() - size/2, (int)this.getLocationY() - size/4, size, size/2);
		}
		
	}

	@Override
	public boolean collidesWith(ICollider otherObject) {
		boolean result = false;
		//if(otherObject instanceof Walls){
			
		//}//ADD STUFF FOR WALL LATER
		
		
		return result;
	}

	@Override
	public void handleCollision(ICollider otherObject) {
		
		
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
		int xLoc = (int)this.getLocationX()-(size/2);//keep in mind true center of circle
		int yLoc = (int)this.getLocationY()-(size/4);
		
		if((px >= xLoc) && (px <= xLoc+size)
			&& (py >= yLoc && (py <= yLoc+size/2))){return true;}
		else{return false;}
		
	}
	

}
