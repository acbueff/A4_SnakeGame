package a4.Model.gameObjects;

import java.util.ArrayList;

public interface ICollider {
	
	public void addCollisionList(ICollider collobj);
	public void removeCollision(ICollider obj);//maybe change
	public void clearCollisions(ArrayList<ICollider> collList);
	public ArrayList<ICollider> getCollisionList();
	
	public void setMark(boolean mark);
	public boolean getMark();
	
	public boolean collidesWith(ICollider otherObject);
	
	public void handleCollision(ICollider otherObject);
	
	
}
