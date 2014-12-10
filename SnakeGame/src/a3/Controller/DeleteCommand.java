package a3.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import a3.Model.GameWorld;
import a3.Model.ISelectable;
import a3.Model.gameObjects.GameObject;

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
