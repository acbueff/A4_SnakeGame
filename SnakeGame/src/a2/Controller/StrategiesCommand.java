package a2.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a2.Model.GameWorld;
/**
 * Change Weasel Strategy
 * @author Andreas
 *
 */
public class StrategiesCommand extends AbstractAction{

private GameWorld realGameWorld = new GameWorld();
	
	
	public StrategiesCommand(){
		super("Change Strategies");
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		realGameWorld.ChangeWeaselStrategy();
		
		realGameWorld.notifyObservers();
	
	}
}
