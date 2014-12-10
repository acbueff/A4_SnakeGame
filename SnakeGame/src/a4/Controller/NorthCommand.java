package a4.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a4.Model.GameWorld;
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
