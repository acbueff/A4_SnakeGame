package a3.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
/**
 * Save the game command
 * @author Andreas
 *
 */
public class SaveCommand extends AbstractAction{

	public SaveCommand(){
		super("Save");
	}
	
	public void actionPerformed(ActionEvent e) {

		System.out.println("Save Command, File Menu");
		
	}

}
