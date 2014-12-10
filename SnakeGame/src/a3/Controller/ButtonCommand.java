package a3.Controller;


import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * JPanel which contains all command buttons
 * @author Andreas
 *
 */
public class ButtonCommand extends JPanel{
	
	//DO NOT NEED
	private static JButton snakeHitBody;
	private static JButton birdHitSnake;
	private static JButton snakeHitMoney;
	private static JButton snakeEatsFood;
	private static JButton snakeHitWall;
	private static JButton weaselHitSnake;
	private static JButton changeStrategies;
	private static JButton tick;
	//DO NOT NEED
	private static JButton pausePlay;
	private static JButton delete;
	private static JButton quit;
	
	
	public ButtonCommand(){
	
	this.setBorder(new TitledBorder("Commands:"));
	this.setLayout(new GridLayout(10,1));
	
	//JButton 
	pausePlay = new JButton("Pause");
	pausePlay.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	this.add(pausePlay);
	
	delete = new JButton ("Delete");
	delete.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	this.add(delete);
	
	
	quit = new JButton ("Quit");
	quit.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	this.add(quit);
	

	}
	
	//getters for buttons
	public JButton getPausePlay(){
		return pausePlay;
	}
	
	//sets string of
	public void modePausePlay(boolean mode){
		if(mode){
			pausePlay.setText("Pause");
		}else{
			pausePlay.setText("Play");
		}
	}
	
	public JButton getDelete(){
		return delete;
	}
	

	public JButton getQuit(){
		return quit;
	}
	
	
	//UP FOR REMOVAL
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
	
	
	
	
	
	
	
	
	
	
	
}
