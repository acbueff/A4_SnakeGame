package a4.Model.gameObjects;

import a4.Model.GameWorld;
/**
 * Weasel Game object follows current heading
 * Once Weasel hits a wall object, heading is reversed
 * @author Andreas
 *
 */
public class FollowHeadingStrategy implements IStrategy{
	
	private Weasel client;
	
	
	private GameWorld realGameWorld = new GameWorld();
	
	public FollowHeadingStrategy(Weasel client){
		
		this.client = client;
	}

	public String strategyName(){
		return " FollowHeadingStrategy";
	}
	
	public void apply(int move) {
		
		
	
		//detect position of Wall Objects
		if( realGameWorld.getWallSize(true) <= client.getLocationX() && client.getLocationX()<= realGameWorld.getWallSize(false)
				&& realGameWorld.getWallSize(true) <= client.getLocationY() && client.getLocationY() <= realGameWorld.getWallSize(false)){
				
				float angle = client.getHeading();
				float deltaX = (int) (Math.cos(Math.toRadians(angle))*client.getSpeed());
				float deltaY = (int) (Math.sin(Math.toRadians(angle))*client.getSpeed());
				
				float newX =   deltaX*(((float)move)/50);
				float newY = deltaY*(((float)move)/50);
				
				
				client.translate(newX, newY);
				
			
		}else{
		
		//MoveCode
		//reverse heading
		float angle = 180 + client.getHeading();
		if(angle > 360){
			angle = angle - 360;
		}
		client.setHeading((int)angle);
		float deltaX = (int) (Math.cos(Math.toRadians(angle))*client.getSpeed());
		float deltaY = (int) (Math.sin(Math.toRadians(angle))*client.getSpeed());
		
		float newX = deltaX*(((float)move)/50);
		float newY = deltaY*(((float)move)/50);
		
		client.translate(newX, newY);
		client.setHeadingFlag(true);
		}
		
	}

}
