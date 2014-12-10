package a2.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a2.Model.GameWorld;
import a2.Model.GameWorldProxy;
import a2.Model.gameObjects.GameObject;
import a2.Model.gameObjects.Snakes;
/**
 * Snake hits body segment
 * @author Andreas
 *
 */
public class HitBodyCommand extends AbstractAction{
	
	private GameWorld realGameWorld = new GameWorld();
	
	
	public HitBodyCommand(){
		super("Snake hit Body(1)");
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		realGameWorld.GameCollisionBodySegment();
		realGameWorld.notifyObservers();
	
	}

	
}
