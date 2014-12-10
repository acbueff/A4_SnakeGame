package a2.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a2.Model.GameWorld;
/**
 * Snake hits Money GameObject
 * @author Andreas
 *
 */
public class HitMoneyCommand extends AbstractAction{

	private GameWorld realGameWorld = new GameWorld();	
	
	public HitMoneyCommand(){
		super("Snake hit Money(3)");
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		realGameWorld.GameCollisionMoney();
		realGameWorld.notifyObservers();
	
	}

}
