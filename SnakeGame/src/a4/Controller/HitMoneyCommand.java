package a4.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a4.Model.GameWorld;
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
		if(realGameWorld.getSound() && realGameWorld.getMode()){
			realGameWorld.getMoneySound().play();
			
		}else{
			realGameWorld.getMoneySound().stop();
		}
		realGameWorld.GameCollisionMoney();
		realGameWorld.notifyObservers();
	
	}

}
