package a2.View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import a2.Model.GameWorldProxy;
import a2.Model.IObservable;
import a2.Model.gameObjects.GameObject;
/**
 * MapView updates current positions of GameObjects
 * @author Andreas
 *
 */
public class MapView extends JPanel implements IObserver{
	
	private JTextPane mapDisplay  = new JTextPane();
	private String mapState = "";
	public void update(IObservable o, Object arg) {
		 this.mapState = "";
		
		 for(GameObject obj: ((GameWorldProxy)o).getGameObjectCollection()){
			 this.mapState = this.mapState + "\r\n" + ((GameObject)obj).toString() + "\n";
		 }
		 System.out.println(this.mapState);//print to console
		 this.mapDisplay.setText(this.mapState);;//update JTextPane
		 
		
	}
	
	public JTextPane getMapDisplay(){
		return this.mapDisplay;
	}

}
