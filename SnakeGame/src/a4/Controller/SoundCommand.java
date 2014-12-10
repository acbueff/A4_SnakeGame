package a4.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a4.Model.GameWorld;
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
		realGameWorld.setFlag(true);
		realGameWorld.setSound(!realGameWorld.getSound());
		
	}

}
