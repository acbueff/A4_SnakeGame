package a3.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import a3.Model.GameWorld;
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
