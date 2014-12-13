package a4.Model.gameObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import a4.Model.Point;

public class BirdsWing {
	private Point top, bottomLeft, bottomRight;
	private Color myColor = Color.green;
	private AffineTransform myRotation, myTranslation, myScale;
	
	public BirdsWing(){
		top = new Point(0,20);
		bottomLeft = new Point(-10,-20);
		bottomRight = new Point(10,-20);
		
		myRotation = new AffineTransform();
		myTranslation = new AffineTransform();
		myScale = new AffineTransform();
	}
	
	//Following methods
		//rotate,translate,resetTransform are AT related
		public void rotate(double radians){
			myRotation.rotate(Math.toRadians(radians));
		}
		
		public void scale(double sx, double sy){
			myScale.scale(sx, sy);
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
		
		
		public void draw(Graphics2D g){
			AffineTransform saveAt = g.getTransform();
			
			g.transform(myTranslation);
			g.transform(myScale);
			g.transform(myRotation);
			
			
			g.setColor(myColor);
			g.drawLine((int)top.getX(), (int)top.getY(), (int)bottomLeft.getX(), (int)bottomLeft.getY());
			g.drawLine((int)bottomLeft.getX(), (int)bottomLeft.getY(), (int)bottomRight.getX(), (int)bottomRight.getY());
			g.drawLine((int)bottomRight.getX(), (int)bottomRight.getY(), (int)top.getX(), (int)top.getY());
			//g.fillRect(0,0,40,40);
			
			g.setTransform(saveAt);
		}
		
		
	
	
	
}