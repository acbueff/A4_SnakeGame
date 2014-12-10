package a4.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a4.Model.GameWorld;
/**
 * Quit the game command
 * @author Andreas
 *
 */
public class QuitCommand extends AbstractAction{
	private GameWorld realGameWorld = new GameWorld();
	
	public QuitCommand(){
		super("Quit");
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		realGameWorld.quitGame();
		realGameWorld.notifyObservers();
	
	}
}
