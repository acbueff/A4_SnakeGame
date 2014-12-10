package a4.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a4.Model.GameWorld;

public class PausePlayCommand extends AbstractAction{
	
	private GameWorld realGameWorld = new GameWorld();	
	
	public PausePlayCommand(){
		
			super("Pause");
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		realGameWorld.setFlag(true);
		if(realGameWorld.getMode()){
			realGameWorld.setMode(false);
			realGameWorld.notifyObservers();
		}else{
			realGameWorld.setMode(true);
			realGameWorld.notifyObservers();
		}
	}

	
	
}
