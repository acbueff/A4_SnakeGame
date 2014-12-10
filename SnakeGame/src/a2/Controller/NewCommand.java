package a2.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
/**
 * New Game command
 * @author ghost
 *
 */
public class NewCommand extends AbstractAction{
	
	public NewCommand(){
		super("New");
	}
	
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Hit New in FileMenu");
		
	}

}
