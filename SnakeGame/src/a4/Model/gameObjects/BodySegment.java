package a4.Model.gameObjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

/**
 * BodySegment provides body of Snakes object.
 * BodySegment has a fixed color
 * @author Andreas 
 *
 */
public class BodySegment extends MoveableObject{
	
	
	private final int size =10;
	private boolean mark;
	private AffineTransform myRotation, myTranslation, myScale;
	
	public int getBodySize(){
		return this.size;
	}
	
	
	public BodySegment(int heading, int speed, float posX, float posY, Color newColor){
		this.setHeading(heading);
		this.setSpeed(speed);
		this.setPointLocation(posX, posY);
		super.setColor(newColor);
		
		myRotation = new AffineTransform();
		myTranslation = new AffineTransform();
		myScale = new AffineTransform();
		
		//this.translate(posX, posY);
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
			
			public float getPointX(){
				return super.getLocationX();
			}
			
			public float getLocationY(){
				
				return (float) myTranslation.getTranslateY();
			}
			
			public float getPointY(){
				return super.getLocationY();
			}

	//NOT implemented
	public void move(int time) {
		
		float angle = (90 - this.getHeading());
		
		float deltaX = (int) (Math.cos(Math.toRadians(angle))*this.getSpeed());
		float deltaY = (int) (Math.sin(Math.toRadians(angle))*this.getSpeed());
		
		float newX =  deltaX;
		float newY =  deltaY;
		
		this.translate(newX, newY);
		//this.setPointLocation(newX, newY);
		
	}
	
	public void update(){
		this.translate(super.getLocationX(), super.getLocationY());
	}


	//Overriding for security
	public void setColor(Color newColor){
		newColor = null;
		
	}

	@Override
	public void draw(Graphics2D g) {
		AffineTransform saveAt = g.getTransform();
		g.setColor(this.getColor());
		//this.translate(super.getLocationX(), super.getLocationY());
		g.transform(myTranslation);
		g.transform(myRotation);
		g.transform(myScale);
		g.fillRect(0, 0, size, size); 
		
		g.setTransform(saveAt);
		
	}

	@Override
	public boolean collidesWith(ICollider otherObject) {
		
		return false;
	}


	@Override
	public void handleCollision(ICollider otherObject) {
		
		
	}


	@Override
	public void addCollisionList(ICollider collobj) {
		collobj.addCollisionList(this);
		
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
	

}
