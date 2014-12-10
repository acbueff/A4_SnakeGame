package a1.Model;

/**
 * Clock class to record passage of time in game
 * @author Andreas
 *
 */
public class Clock {
	
	private int count;
	
	//Initial clock begins at 0
	public Clock(){
		setCount(0);
	}
	/**
	 * Increments clock time by a value of 1
	 */
	public void tick(){
		this.setCount(getCount() + 1);
	}
	
	/**
	 * Optional method to restart clock at 0
	 */
	public void reset(){
		this.setCount(0);
	}
	
	/**
	 * Obtain current time 'ticks'
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Private method to set count value
	 * @param count
	 */
	private void setCount(int count) {
		this.count = count;
	}
	
}

