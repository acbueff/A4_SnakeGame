package a1.Model.gameObjects;
import java.awt.Color;
import java.util.ArrayList;

import a1.Model.Point;

/**
 * Snake Object for Game
 * Will consist of a Head object and Body Segments which can grow
 * during course of the game.
 * @author Andreas
 *
 */
public class Snakes extends MoveableObject {
	
	private Head snakeHead;//will dictate direction of Snakes object
	private int startSize = 3;//bodySeg amount
	private ArrayList<Integer> bodySegHeading;//tracks position of individual BodySegment headings
	private ArrayList<BodySegment> bodySegPos;//collects BodySegments comprising Snakes body
	private Point oldLocation;
	private int newSegCount;//Used to indicate whether new BodySegments have been added
	
	
	private static Snakes theSnake;//single global reference to the snake
	
	//Private for singleton
	private Snakes(int heading, int speed, float posX, float posY, Color newColor){
		
		this.snakeHead = new Head(heading,speed,posX,posY,newColor);
		this.bodySegPos = new ArrayList<BodySegment>();
		
			
	}
	
	public Color getColor(){
		return this.snakeHead.getColor();
	}
	
	/**
	 * Gives theSnake 3 BodySegments for the beginning of new Games
	 */
	public void NewSnake(){
		theSnake.ClearBodySegment();
		theSnake.setNewSegCount(this.startSize);
		for(int n = 0; n < startSize; n++){
			 this.move();
		}
		
	}
	
	
	/**
	 * Empty array of BodySegments
	 */
	public void ClearBodySegment(){
		theSnake.bodySegPos.clear();
	}
	
	/**
	 * Add new BodySegment at position of where Snakes Head was
	 * @param amount
	 */
	public void addBodySegment(int pos, Point oldLocation){
		
		this.bodySegPos.add(pos, new BodySegment(this.snakeHead.getHeading(),this.snakeHead.getSpeed(),oldLocation.getX(),oldLocation.getY(),this.snakeHead.getColor()));
		
	}
	
	/**
	 * Get heading directions of all present BodySegments
	 * Utilized for movement of individual BodySegments
	 */
	public void getCurrentSegHeadings(){
		this.bodySegHeading = new ArrayList<Integer>();
		for(int j = 0; j < this.bodySegPos.size();j++ ){
			this.bodySegHeading.add(j,((BodySegment)bodySegPos.get(j)).getHeading());
		}
		
	}
	
	/**
	 * Clear bodySegHeading array
	 */
	public void clearCurrentSegHeadings(){
		this.bodySegHeading.clear();
	}

	
	
	
	/**
	 * provide access to theSnake, creating it if necessary
	 * Implementation of a singleton
	 * @param heading
	 * @param speed
	 * @param posX
	 * @param posY
	 * @param newColor
	 * @return
	 */
	public static Snakes getSnakes(int heading, int speed, float posX, float posY, Color newColor){
		if(theSnake == null){
			theSnake = new Snakes(heading, speed, posX, posY, newColor);
		}
		return theSnake;
	}
	
	/**
	 * Snakes objects move the objects they contain, Head and BodySegments
	 */
	public void move() {
	
		//Save old location of Head
		oldLocation = new Point(this.snakeHead.getLocationX(),this.snakeHead.getLocationY());
		
		this.snakeHead.move();//move Head
		this.getCurrentSegHeadings();//capture current headings of all BodySegments
		
		if(this.getNewSegCount() != 0){ //In cases of new BodySegments added due to Food objects
			this.addBodySegment(0,oldLocation);
			this.decrementNewSegCount();
			this.clearCurrentSegHeadings();//clear BodySegment headings due to new BodySegment
			this.getCurrentSegHeadings();//get new BodySegment headings for reference
			
		}
		else{ 
			//Move first BodySegment and set its heading to Head
			((BodySegment)this.bodySegPos.get(0)).move();
			((BodySegment)this.bodySegPos.get(0)).setHeading(this.snakeHead.getHeading());
			//BodySegments following the first one move and set Heading to those found in bodySegHeading 
			for(int i = 1; i < this.bodySegPos.size(); i++){
				
				((BodySegment)this.bodySegPos.get(i)).move();
				((BodySegment)this.bodySegPos.get(i)).setHeading(this.bodySegHeading.get(i-1));
			}
			this.clearCurrentSegHeadings();
			
		}	
	}
	
	/**
	 * Change direction of snake by changing heading of Head
	 * @param dir
	 */
	public void changeSnakeHeading(String dir){
		this.snakeHead.changeHeading(dir);
	}

	/**
	 * Print contents of Snakes
	 * References toString methods of Head and BodySegments
	 */
	public String toString() {
		String snakeHead = this.snakeHead.toString() +"\n";
		String bodySeg = "";
		for(int s = 0; s < this.bodySegPos.size(); s++){
			bodySeg = bodySeg + ((BodySegment)bodySegPos.get(s)).toString() + "\n";
		}
		
		return snakeHead + bodySeg;
	}

	public int getNewSegCount() {
		return newSegCount;
	}

	public void setNewSegCount(int newSegCount) {
		this.newSegCount = newSegCount;
	}
	
	public void decrementNewSegCount(){
		this.newSegCount = this.newSegCount -1;
	}

	//Overriding
	public void setColor(Color newColor){
		newColor = null;
		
	}
	

	

}
