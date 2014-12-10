package a2.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a2.Model.GameWorld;
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
