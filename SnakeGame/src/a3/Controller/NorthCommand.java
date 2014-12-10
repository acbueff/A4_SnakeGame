package a3.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.Model.GameWorld;
/**
 * Snake heading directed north
 * @author Andreas
 *
 */
public class NorthCommand extends AbstractAction{
	
	private GameWorld realGameWorld = new GameWorld();

	
	public void actionPerformed(ActionEvent e) {
		realGameWorld.changeHeading("n");
		
	}

}
