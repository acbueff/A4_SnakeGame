package a1.Model.gameObjects;


/**
 * Position of GameObjects are unable to move
 * @author Andreas
 *
 */
public abstract class FixedObject extends GameObject {
	
	//length of time object existed
	private int age = 0;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void incrementAge(){
		this.setAge(this.getAge() + 1);
	}

}
