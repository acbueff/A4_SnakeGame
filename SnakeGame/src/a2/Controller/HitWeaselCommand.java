package a2.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a2.Model.GameWorld;
/**
 * Weasel hit Snake GameObject
 * @author Andreas
 *
 */
public class HitWeaselCommand extends AbstractAction{
	private GameWorld realGameWorld = new GameWorld();
	
	public HitWeaselCommand(){
		super("Weasel hit Snake");
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		realGameWorld.GameCollisionWeasel();
		realGameWorld.notifyObservers();
	
	}
}
