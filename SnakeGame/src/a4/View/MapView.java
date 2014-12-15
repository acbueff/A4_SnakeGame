package a4.View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

import javax.swing.JPanel;
import javax.swing.Timer;





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
public class MapView extends JPanel implements IObserver,MouseListener,MouseMotionListener, MouseWheelListener{
	
	private GameWorldProxy gwp;
	private Point2D oldPoint;
	private Point2D newPoint;
	private boolean oneSweepAdd = true;
	
	
	private  double windowLeft = 0;
	private  double windowRight = 600;
	private  double windowTop = 600;
	private  double windowBottom= 0;
	private double h = windowTop - windowBottom;
	private double w = windowRight - windowLeft;
	
	private AffineTransform worldToND, ndToScreen, theVTM, inverseVTM;
	
	//Timer theTimer = new Timer(10, (ActionListener) this);
	
	
	//update calls repaint on itself
	public void update(IObservable o, Object arg) {
		 this.addMouseListener(this);
		 this.addMouseWheelListener(this);
		 this.addMouseMotionListener(this);
		gwp = (GameWorldProxy) o;
		
		
		this.repaint();
		
	}
	
	public double getWindowRight(){
		return windowRight;
	}
	
	public double getWindowTop(){
		return windowTop;
	}
	
	public double getWindowLeft(){
		return windowLeft;
	}
	
	public double getWindowBottom(){
		return windowBottom;
	}
	
	
	public void zoomIn(){
		System.out.println("zoomIn was called");
		
		windowLeft += w*0.00005;
		windowRight -= w*0.00005;
		windowTop -= h*0.00005;
		windowBottom += h*0.00005;
		this.repaint();
	}
	public void zoomOut(){
		System.out.println("zoomOut was called");
		//double h = windowTop - windowBottom;
		//double w = windowRight - windowLeft;
		windowLeft = windowLeft - w*0.00005;
		windowRight = windowRight + w*0.00005;
		windowTop += h*0.00005;
		windowBottom -= h*0.00005;
		this.repaint();
	}
	
	public void panLeft(){
		windowLeft -= w*0.00005;
		windowRight -= w*0.00005;
		//windowTop -= h*0.0005;
		//windowBottom += h*0.0005;
		this.repaint();
	}
	
	public void panRight(){
		windowLeft += w*0.00005;
		windowRight += w*0.00005;
		//windowTop -= h*0.0005;
		//windowBottom += h*0.0005;
		this.repaint();
	}
	
	public void panUp(){
		//windowLeft += w*0.0005;
		//windowRight -= w*0.0005;
		windowTop += h*0.00005;
		windowBottom += h*0.00005;
		this.repaint();
	}
	
	public void panDown(){
		//windowLeft += w*0.0005;
				//windowRight -= w*0.0005;
				windowTop -= h*0.00005;
				windowBottom -= h*0.00005;
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
		
		worldToND = buildWorldToNDXform(windowRight,windowTop,windowLeft,windowBottom);
		ndToScreen = buildNDToScreenXform(this.getWidth(),this.getHeight());
		theVTM = (AffineTransform) ndToScreen.clone();
		theVTM.concatenate(worldToND);
		
		//screen coordinate transformation to g2d object
		//g2d.translate(0, this.getHeight());
		//g2d.scale(1, -1);
		
		g2d.transform(theVTM);
		for(GameObject obj: ((GameWorldProxy)gwp).getGameObjectCollection()){//MAYBE BETTER ITERATOR...Later
			
			obj.draw(g2d);
		}
		g2d.setTransform(saveAT);
	}
	
	public AffineTransform buildWorldToNDXform(double width,double height,double left, double bottom){
		AffineTransform W2ND = new AffineTransform();
		AffineTransform scale = new AffineTransform();
		W2ND.translate(0-left,0-bottom);
		scale.scale(1/width, 1/height);
		scale.concatenate(W2ND);
		return scale;
	}
	
	public AffineTransform buildNDToScreenXform(double swidth, double sheight){
		AffineTransform NDS = new AffineTransform();
		//AffineTransform scale = new AffineTransform();
		AffineTransform trans = new AffineTransform();
		NDS.scale(swidth, 0-sheight);
		trans.translate(0, sheight);
		trans.concatenate(NDS);
		return trans;
	}
	
	public void mouseClicked(MouseEvent e) {
		Point2D get = e.getPoint();
		//Point temp = new Point(get.x,get.y);
		worldToND = buildWorldToNDXform(windowRight,windowTop,windowLeft,windowBottom);
		ndToScreen = buildNDToScreenXform(this.getWidth(),this.getHeight());
		theVTM = (AffineTransform) ndToScreen.clone();
		theVTM.concatenate(worldToND);
		//inverse ATM
		try{
			inverseVTM = theVTM.createInverse();
		}catch(NoninvertibleTransformException e1){
			inverseVTM = theVTM; //MAY CHANGE WHAT TO DO LATER
		}
		
		Point2D p = inverseVTM.transform(get, null);
		oldPoint = inverseVTM.transform(get, null);
		
		if(!gwp.getMode()){
			
			
			
			if(e.isShiftDown() && oneSweepAdd){
				oneSweepAdd = false;
				gwp.addSweeper(p);
			}
		}
		
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

	public void mouseEntered(MouseEvent arg0) {}

	
	public void mouseExited(MouseEvent e) {}

	
	public void mousePressed(MouseEvent e) {oldPoint = e.getPoint(); }

	
	public void mouseReleased(MouseEvent e) {
		this.oneSweepAdd =true;
	}

	//ZOOM IN. ZOOM OUT
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(gwp.getMode()){
		System.out.println("VALUE OF WHEEL:" + e.getWheelRotation());
		double click = e.getWheelRotation();
		if(click > 0){
			for(int i = 0; i < click; i++){
			 this.zoomIn();
			}
			
		}
		else if(click < 0){
			
			for(int j = 0; j < Math.abs(click); j++){	
			this.zoomOut();}
			
		}
		
		click =0;
		
	}
	}

	
	public void mouseDragged(MouseEvent e) {
		//Point2D oldPoint = e.getPoint();
		Point2D mouseOldLoc;
		double x, y;
		try {
			
			worldToND = buildWorldToNDXform(windowRight,windowTop,windowLeft,windowBottom);
			ndToScreen = buildNDToScreenXform(this.getWidth(),this.getHeight());
			theVTM = (AffineTransform) ndToScreen.clone();
			theVTM.concatenate(worldToND);
			inverseVTM = theVTM.createInverse();
			mouseOldLoc = oldPoint;
			oldPoint = inverseVTM.transform(e.getPoint(), null);
			System.out.println("Mouse being dragged!");
			
			if(gwp.getMode()){
			if (oldPoint != null && mouseOldLoc != null)
			 {
				 
				x = mouseOldLoc.getX() - oldPoint.getX();
				y = mouseOldLoc.getY() - oldPoint.getY();
				
				if(Math.abs(x) > Math.abs(y)){
					if(x < 0){
						this.panRight();
					}
					else{
						this.panLeft();
					}
				}
				else{
					if(y < 0){
						this.panUp();
					}else{
						this.panDown();
					}
				}
				
				this.repaint();
			 }
			}
			
			} catch (NoninvertibleTransformException ea)
			{
				System.out.println(ea);
			}

		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
