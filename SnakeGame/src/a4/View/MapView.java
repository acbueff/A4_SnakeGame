package a4.View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import a4.Model.GameWorldProxy;
import a4.Model.IObservable;
import a4.Model.ISelectable;
import a4.Model.Point;
import a4.Model.gameObjects.GameObject;
/**
 * MapView updates current positions of GameObjects
 * displays contents of the game graphically
 * @author Andreas
 *
 */
public class MapView extends JPanel implements IObserver, MouseListener{
	
	private GameWorldProxy gwp;
	
	
	
	//update calls repaint on itself
	public void update(IObservable o, Object arg) {
		 this.addMouseListener(this);
		gwp = (GameWorldProxy) o;
		
		
		this.repaint();
		
	}
	
	//SKELETON
	//Iterate through the GameWorld
	public void paintComponent(Graphics g){
		//Iterator
		//GameWorldProxy
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform saveAT = g2d.getTransform();
		
		//screen coordinate transformation to g2d object
		g2d.translate(0, this.getHeight());
		g2d.scale(1, -1);
		for(GameObject obj: ((GameWorldProxy)gwp).getGameObjectCollection()){//MAYBE BETTER ITERATOR...Later
			
			obj.draw(g2d);
		}
		//g2d.setTransform(saveAT);
	}

	
	public void mouseClicked(MouseEvent e) {
		java.awt.Point get = e.getPoint();
		Point p = new Point(get.x,get.y);
		
		if(e.isControlDown()){
			for(GameObject obj1: gwp.getGameObjectCollection()){
				if(obj1 instanceof ISelectable){
					if(((ISelectable)obj1).contains(p)){
						((ISelectable)obj1).setSelected(true);
					}
				}
			}
		}
		else{
			
			for(GameObject obj: gwp.getGameObjectCollection()){
				if(obj instanceof ISelectable){
				
					
					if(((ISelectable)obj).contains(p) ){
						
						((ISelectable)obj).setSelected(true);
					}
					else{
						((ISelectable)obj).setSelected(false);
					}
				}
			
			}
			
		}
		
		this.repaint();//MAY NOT BE REQUIRED
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
