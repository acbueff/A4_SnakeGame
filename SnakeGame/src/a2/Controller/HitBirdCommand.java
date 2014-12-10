package a2.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a2.Model.GameWorld;
/**
 * Snake gets hit by bird
 * @author Andreas
 *
 */
public class HitBirdCommand extends AbstractAction{

private GameWorld realGameWorld = new GameWorld();
	
	
	public HitBirdCommand(){
		super("Bird hit Snake(2)");
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		realGameWorld.GameCollisionBird();
		realGameWorld.notifyObservers();
	
	}
}
