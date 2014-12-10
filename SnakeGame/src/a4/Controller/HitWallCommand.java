package a4.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a4.Model.GameWorld;
/**
 * Snake hits wall
 * @author Andreas
 *
 */
public class HitWallCommand extends AbstractAction{
	private GameWorld realGameWorld = new GameWorld();
	
	public HitWallCommand(){
		super("Snake hit Wall(5)");
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		realGameWorld.GameCollisionWall();
		realGameWorld.notifyObservers();
	
	}
}
