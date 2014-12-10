package a3.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.Model.GameWorld;
/**
 * Change Snake heading to east
 * @author Andreas
 *
 */
public class EastCommand extends AbstractAction{
	private GameWorld realGameWorld = new GameWorld();

	
	public void actionPerformed(ActionEvent e) {
		realGameWorld.changeHeading("e");
		
	}

}
