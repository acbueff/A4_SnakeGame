package a1.Model.gameObjects;

/**
 * GameObjects with changeable positions
 * @author Andreas
 *
 */
public abstract class MoveableObject extends GameObject {
	
	private int heading;
	private int speed;
	
	/**
	 * Update object location based on current heading and speed
	 */
	public abstract void move();

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHeading() {
		return heading;
	}

	public void setHeading(int heading) {
		this.heading = heading;
	}

	

}
