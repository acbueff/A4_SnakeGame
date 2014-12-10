package a4.Model;

/**
 * class is responsible for keeping track of score and amount of lives remaining
 * @author Andreas
 *
 */
public class Player {
	
	private int lives = 3;
	
	private int score = 0;
	
	
	public int getLives() {
		return lives;
	}

	
	
	public void decrementLives(){
		if(this.lives > 0){
			this.lives--;
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = this.score + score;
	}
	
	

}
