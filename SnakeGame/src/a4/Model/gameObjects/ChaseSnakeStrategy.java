package a4.Model.gameObjects;

import a4.Model.GameWorld;
/**
 * Weasel heading updated to point at 
 * current position of SnakeHead
 * @author Andreas
 *
 */
public class ChaseSnakeStrategy implements IStrategy{

	private GameWorld realGameWorld = new GameWorld();
	//Snakehead coordinates
	private float x2;
	private float y2;
	
	//Weasel coordinates
	private float x1;
	private float y1;

	
	private int headingDegrees;
	
	private Weasel client;
	
	public ChaseSnakeStrategy(Weasel client){
		this.client = client;
	}
	
	public String strategyName(){
		return " ChaseSnakeStrategy";
	}
	
	public void apply(int move) {
			for(GameObject obj: realGameWorld.getGameObjectCollection()){
				if(obj instanceof Snakes){
					//current coordinates of snake
					x2 = ((Snakes) obj).getSnakeHead().getLocationX();
					y2 = ((Snakes) obj).getSnakeHead().getLocationY();
					
					x1 = client.getLocationX();
					y1 = client.getLocationY();
					
					headingDegrees =  (int) Math.toDegrees(((Math.atan2((double)(y2-y1),(double)(x2-x1)))));
					if(headingDegrees < 0){
						headingDegrees += 360;
					}
					client.setHeading((int)headingDegrees);
								
					//MoveCode
					float angle = headingDegrees;
					float deltaX = (int) (Math.cos(Math.toRadians(angle))*client.getSpeed());
					float deltaY = (int) (Math.sin(Math.toRadians(angle))*client.getSpeed());
					
					float newX = deltaX*(((float)move)/150);
					float newY = deltaY*(((float)move)/150);
					
					
					client.translate(newX, newY);
					
					client.setHeadingFlag(true);
					
				}
				//client.rotate(Math.toRadians(client.getHeading()));
			}
			
			
		
	}

}
