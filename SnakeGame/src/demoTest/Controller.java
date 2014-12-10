package demoTest;

public class Controller  {
	private Model model;
	private View v1;
	private View v2;
	
	public Controller(){
		model = new Model();
		v1 = new View();
		v2 = new View();
		model.addObserver(v1);
	}
}
