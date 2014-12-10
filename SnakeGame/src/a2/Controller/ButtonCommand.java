package a2.Controller;


import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * JPanel which contains all command buttons
 * @author Andreas
 *
 */
public class ButtonCommand extends JPanel{
	
	private static JButton snakeHitBody;
	private static JButton birdHitSnake;
	private static JButton snakeHitMoney;
	private static JButton snakeEatsFood;
	private static JButton snakeHitWall;
	private static JButton weaselHitSnake;
	private static JButton changeStrategies;
	private static JButton tick;
	private static JButton quit;
	
	
	public ButtonCommand(){
	
	this.setBorder(new TitledBorder("Commands:"));
	this.setLayout(new GridLayout(10,1));
	
	//JButton 
	snakeHitBody = new JButton ("Snake hit Body(1)");
	snakeHitBody.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	this.add(snakeHitBody);
	
	
	birdHitSnake = new JButton ("Bird hit Snake(2)");
	birdHitSnake.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	this.add(birdHitSnake);
	
	snakeHitMoney = new JButton ("Snake hit Money(3)");
	snakeHitMoney.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	this.add(snakeHitMoney);
	
	snakeEatsFood = new JButton ("Snake eats Food(4)");
	snakeEatsFood.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	this.add(snakeEatsFood);
	
	snakeHitWall = new JButton ("Snake hit Wall(5)");
	snakeHitWall.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	this.add(snakeHitWall);
	
	weaselHitSnake = new JButton ("Weasel hit Snake");
	weaselHitSnake.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	this.add(weaselHitSnake);
	
	changeStrategies = new JButton ("Change Strategies");
	this.add(changeStrategies);
	
	tick = new JButton ("Tick");
	tick.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	this.add(tick);
	
	quit = new JButton ("Quit");
	quit.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	this.add(quit);
	

	}
	
	//getters for buttons
	public JButton getSnakeHitBody(){
		return snakeHitBody;
	}
	
	public JButton getBirdHitSnake(){
		return birdHitSnake;
	}
	
	public JButton getSnakeHitMoney(){
		return snakeHitMoney;
	}
	
	public JButton getSnakeEatsFood(){
		return snakeEatsFood;
	}
	
	public JButton getSnakeHitWall(){
		return snakeHitWall;
	}
	
	public JButton getWeaselHitSnake(){
		return weaselHitSnake;
	}
	
	public JButton getChangeStrategies(){
		return changeStrategies;
	}
	
	public JButton getTick(){
		return tick;
	}
	
	public JButton getQuit(){
		return quit;
	}
	
	
	
	
	
	
	
	
	
	
	
}
