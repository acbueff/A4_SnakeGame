package a3.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.Model.GameWorld;
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
		if(realGameWorld.getSound()  && realGameWorld.getMode()){
			realGameWorld.getWeaselSound().play();
			
		}else{
			realGameWorld.getWeaselSound().stop();
		}
		
		realGameWorld.GameCollisionWeasel();
		realGameWorld.notifyObservers();
	
	}
}
