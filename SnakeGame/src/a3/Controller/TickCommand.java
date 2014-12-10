package a3.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.Model.GameWorld;
/**
 * Increment Game clock
 * @author Andreas
 *
 */
public class TickCommand extends AbstractAction {
	private GameWorld realGameWorld = new GameWorld();
	private int delay;
	
	public TickCommand(int delay){
		super("Tick");
		this.delay = delay;
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		realGameWorld.tickGameClock(delay);
		realGameWorld.notifyObservers();
	
	}
}
