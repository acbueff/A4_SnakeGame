package demoTest;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel{
	private Tiger myTiger;
	
	public DisplayPanel(){
		myTiger = new Tiger(30);
		myTiger.translate(200, 200);
		myTiger.rotate(Math.toRadians(90));
	}
	
	
	
	
	
}
