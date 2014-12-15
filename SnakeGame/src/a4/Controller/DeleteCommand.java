package a4.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a4.Model.GameWorld;
import a4.Model.ISelectable;
import a4.Model.gameObjects.GameObject;

public class DeleteCommand extends AbstractAction{

	private GameWorld realGameWorld = new GameWorld();
	
	
	public DeleteCommand(){
		super("Delete");
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		for(GameObject obj: realGameWorld.getGameObjectCollection()){
			if(obj instanceof ISelectable){
				if(((ISelectable)obj).isSelected()){
					
					realGameWorld.getGameObjectCollection().remove(obj);
				}
			}
		}
	
	}
	
	
}
