package a2.View;

import javax.swing.*;

import a2.Model.Clock;
import a2.Model.GameWorldProxy;
import a2.Model.IObservable;
import a2.Model.Player;
/**
 * ScoreView updates the current score GameWorld states
 * @author Andreas
 *
 */
public class ScoreView extends JPanel implements IObserver {

	private int tick = 0;
	private int score = 0;
	private int lives = 0;
	private String state ="OFF";

	
	private JLabel timeLabel = new JLabel("Time: " + tick);
	private JLabel scoreLabel = new JLabel("Score: " + score);
	private JLabel livesLabel = new JLabel("Lives:" + lives);
	private JLabel soundLabel = new JLabel("Sound: " + state);
	
	public void update(IObservable o, Object arg) {
		
			
		
			tick = ((GameWorldProxy)o).getGameClock().getCount();
			this.timeLabel.setText("Time: " + tick);
			
		
		
			score = ((GameWorldProxy)o).getGameUser().getScore();
			this.scoreLabel.setText("Score:" + score);
			
			lives = ((GameWorldProxy)o).getGameUser().getLives();
			this.livesLabel.setText("Lives: "+lives);
			
			//sound on or off
			if(((GameWorldProxy)o).getSound()){
				this.state ="ON";
				this.soundLabel.setText("Sound: " + state);	
			}else{
				this.state ="OFF";
				this.soundLabel.setText("Sound: " + state);
			}
			
		
	}
	
	public JLabel getTimeLabel(){
		return this.timeLabel;
	}
	
	public JLabel getScoreLabel(){
		return this.scoreLabel;
	}
	
	public JLabel getLives(){
		return this.livesLabel;
	}
	
	public JLabel getSound(){
		return this.soundLabel;
	}
	
	
	
	
	
	

}
