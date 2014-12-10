package a2.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a2.Model.GameWorld;
/**
 * Snake eats food
 * @author Andreas
 *
 */
public class EatFoodCommand extends AbstractAction{
	
	private GameWorld realGameWorld = new GameWorld();
	
	
	public EatFoodCommand(){
		super("Snake eats Food(4)");
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		realGameWorld.GameCollisionFood();
		realGameWorld.notifyObservers();
	
	}
}
