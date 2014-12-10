package a2.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a2.Model.GameWorld;
/**
 * Increment Game clock
 * @author Andreas
 *
 */
public class TickCommand extends AbstractAction {
	private GameWorld realGameWorld = new GameWorld();
	
	
	public TickCommand(){
		super("Tick");
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		realGameWorld.tickGameClock();
		realGameWorld.notifyObservers();
	
	}
}
