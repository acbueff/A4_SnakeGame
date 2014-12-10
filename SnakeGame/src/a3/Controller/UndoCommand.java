package a3.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
/**
 * Undo command
 * @author Andreas
 *
 */
public class UndoCommand extends AbstractAction{
	
	public UndoCommand(){
		super("Undo");
	}
	
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Hit Undo in FileMenu");
		
	}
}
