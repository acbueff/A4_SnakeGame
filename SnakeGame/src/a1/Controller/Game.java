package a1.Controller;

import java.util.Scanner;

import a1.Model.Clock;
import a1.Model.GameWorld;
import a1.Model.Player;

/**
 * Creates GameWorld and manages user commands
 * and updates GameWorld
 * @author Andreas
 *
 */
public class Game {
	private GameWorld gw;
	private Player user;
	private Clock clock;
	private Scanner input;
	
	/**
	 * Game Constructor also calls method play() to begin game
	 */
	public Game(){
		//variables active in game
		gw = new GameWorld();
		user = new Player();
		clock = new Clock();
		gw.initLayout();
		play();
	}
	
	
	
	/**
	 * Begins Game and executes user commands
	 */
	private void play(){
		System.out.println("SNAKE GAME!");
		
		//Continuously loop to receive user commands
		while(true){
			
			getCommand();
			
		}
	}
	
	/**
	 * Gets and executes user commands
	 */
	public void getCommand(){
		input = new Scanner(System.in);
		System.out.println("\n"+"enter command: ");
		
		String command = input.nextLine();
		
			switch(command){
			case "n":
				gw.changeHeading("n");
				break;
			case "s":
				gw.changeHeading("s");
				break;
			case "e":
				gw.changeHeading("e");
				break;
			case "w":
				gw.changeHeading("w");
				break;
			case "1":
				gw.GameCollisionBodySegment(user);
				break;
			case "2":
				gw.GameCollisionBird(user);
				break;
			case "3":
				gw.GameCollisionMoney(user);
				break;
			case "4":
				gw.GameCollisionFood(user);
				break;
			case "5":
				gw.GameCollisionWall(user);
				break;
			case "t":
				clock.tick();
				gw.moveGameObject();
				gw.ageGameObjects();
				
				break;
			case "d":
				gw.GameDisplay(user, clock);
				break;
			case "m":
				gw.printGameObject();
				break;
			case "q":
				System.out.println("Quitting Game");
				System.exit(0);
				break;
			default:
				System.out.println("Only enter an allowable command");
			}	
		
	}
	
}
