package demoTest;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import a4.Model.Point;

public class Tiger extends Animal{

	private Point center;
	private Color myColor;
	private int size;
	private AffineTransform myRotation, myTranslation, myScale;
	
	public Tiger(int size){
		this.size = size;
		center = new Point(0,0);
		myColor = Color.red;
		
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
	
		public void draw(Graphics2D g2d){
			g2d.setColor(myColor);
			g2d.transform(myRotation);
			g2d.transform(myTranslation);
			
			g2d.fillOval((int)this.getLocationX(), (int)this.getLocationY(), this.size, this.size/2);
			
		}

} 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

