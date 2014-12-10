package a4.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a4.Model.GameWorld;
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
