package a4.View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import a4.Model.GameWorldProxy;
import a4.Model.IObservable;
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
	private int msecCount = 50;

	
	private JLabel timeLabel = new JLabel("Time: " + tick);
	private JLabel scoreLabel = new JLabel("Score: " + score);
	private JLabel livesLabel = new JLabel("Lives:" + lives);
	private JLabel soundLabel = new JLabel("Sound: " + state);
	
	public void update(IObservable o, Object arg) {
		if(((GameWorldProxy)o).getMode()){
			
			
			//Calculates time based off of 20msec, has timer display accurately	
			if(msecCount!=0){
				if(msecCount == 1){
				((GameWorldProxy)o).getGameClock().tick();	
				tick = ((GameWorldProxy)o).getGameClock().getCount();
				this.timeLabel.setText("Time: " + tick);
				}
				msecCount--;
			}
			else{
				msecCount = 50;
			}
			
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
		//else{
			
		//}
		
			
		
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
