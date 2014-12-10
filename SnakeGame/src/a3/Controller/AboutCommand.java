package a3.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import a3.Model.GameWorld;

/**
 * Display About information
 * @author Andreas
 *
 */
public class AboutCommand extends AbstractAction{
	
	private GameWorld realGameWorld = new GameWorld();
	public AboutCommand(){
		super("About");
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JOptionPane.showMessageDialog(null, realGameWorld.aboutGame());
		
	}
}
