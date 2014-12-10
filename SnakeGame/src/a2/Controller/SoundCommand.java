package a2.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;

import a2.Model.GameWorld;
/**
 * Sound command
 * @author Andreas
 *
 */
public class SoundCommand extends AbstractAction{
	
	private GameWorld realGameWorld = new GameWorld();

	
	public SoundCommand(){
		
		super("Sound");
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		realGameWorld.setSound(!realGameWorld.getSound());
		
	}

}
