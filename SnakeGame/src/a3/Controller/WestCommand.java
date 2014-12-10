package a3.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.Model.GameWorld;
/**
 * Direct snake heading west
 * @author Andreas
 *
 */
public class WestCommand extends AbstractAction {
	private GameWorld realGameWorld = new GameWorld();

	
	public void actionPerformed(ActionEvent e) {
		realGameWorld.changeHeading("w");
		
	}
}
