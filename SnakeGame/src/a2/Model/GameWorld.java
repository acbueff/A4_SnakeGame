package a2.Model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import a2.Model.gameObjects.Birds;
import a2.Model.gameObjects.ChaseSnakeStrategy;
import a2.Model.gameObjects.FixedObject;
import a2.Model.gameObjects.FollowHeadingStrategy;
import a2.Model.gameObjects.Food;
import a2.Model.gameObjects.GameObject;
import a2.Model.gameObjects.GameObjectCollection;
import a2.Model.gameObjects.Money;
import a2.Model.gameObjects.MoveableObject;
import a2.Model.gameObjects.Snakes;
import a2.Model.gameObjects.Walls;
import a2.Model.gameObjects.Weasel;
import a2.View.IObserver;
import a2.View.MapView;
import a2.View.ScoreView;



/**
 * Game World class holds collection of GameObject classes
 * 
 * @author Andreas
 *
 */
public class GameWorld implements IObservable, IGameWorld{
	private Random random = new Random();
	private static Player gameUser = new Player();
	private static Clock gameClock = new Clock();
	private final int WALL_SMALL = 6;
	private final int WALL_LARGE = 988;
	
	private static boolean Sound;
	
	private static ArrayList<IObserver> RegObserver = new ArrayList<IObserver>();//Register observers
	
	//Initial game objects that exist during course of Game

	//Container to store game objects
	private static GameObjectCollection gameObjectCollection;
	
	
	//factory methods
	public Snakes makeSnake(){ return Snakes.getSnakes(0,5,random.nextInt(200)+400,random.nextInt(200)+400,Color.RED);}
	
	public Birds makeBird(){return new Birds(random.nextInt(10)+1, random.nextInt(361), 10, random.nextInt(301), random.nextInt(1001), Color.CYAN);}
	
	public Food makeFood(){return new Food(random.nextInt(970)+10, random.nextInt(970)+10, Color.ORANGE);}
	
	public Money makeMoney(){return new Money(random.nextInt(970)+10,random.nextInt(970)+10, Color.GREEN);}
	
	public Weasel makeWeasel(){return new Weasel(random.nextInt(361), random.nextInt(970)+10, random.nextInt(970)+10, Color.YELLOW);}
	
	public Walls makeWall(String dir){
			if(dir.equals("n")){
				return new Walls(500, 997, WALL_LARGE, WALL_SMALL, Color.BLACK);//north wall
			}
			else if(dir.equals("e")){
				return new Walls(997, 500, WALL_SMALL, WALL_LARGE, Color.BLACK);//east wall
			}
			else if(dir.equals("s")){
				return new Walls(500, 3, WALL_LARGE, WALL_SMALL, Color.BLACK);
			}
			else{
				return new Walls(3, 500, WALL_SMALL, WALL_LARGE, Color.BLACK);
			}
	}
	/**
	 *Creates initial Game Layout
	 *Provides values for all GameObjects
	 * 
	 */
	public void initLayout(){
		
		//Class holds all game objects in an ArrayList	
		gameObjectCollection = new GameObjectCollection();
		
		//Snakes is a singleton
		Snakes theSnake = makeSnake();
		//Initializes theSnake with three BodySegment objects
		theSnake.NewSnake();
		
		Birds theBird = makeBird();
		Money theMoney = makeMoney();
		Food theFood = makeFood();
		Weasel firstWeasel = makeWeasel();
		firstWeasel.setStrategy(new ChaseSnakeStrategy(firstWeasel));
		Weasel secondWeasel = makeWeasel();
		secondWeasel.setStrategy(new FollowHeadingStrategy(secondWeasel));
		
		Walls nWall = makeWall("n");
		Walls eWall = makeWall("e");
		Walls sWall = makeWall("s");
		Walls wWall = makeWall("w");
		
		//Add Game objects for initial Game layout 
		 gameObjectCollection.add(theSnake);
		 gameObjectCollection.add(theBird);
		 gameObjectCollection.add(theMoney);
		 gameObjectCollection.add(theFood);
		 gameObjectCollection.add(firstWeasel);
		 gameObjectCollection.add(secondWeasel);
		 gameObjectCollection.add(nWall);
		 gameObjectCollection.add(eWall);
		 gameObjectCollection.add(sWall);
		 gameObjectCollection.add(wWall);
		 
		 
		 this.notifyObservers();
		 
	
		 
	}
	
	
	//for sound getters n setters
	public void setSound(boolean sound){
		Sound = sound;
		this.notifyObservers();
	}
	
	
	
	public boolean getSound(){
		return Sound;
	}
	
	
	public Clock getGameClock(){
		return gameClock;
	}
	
	//Player getter
	public Player getGameUser(){
		return gameUser;
	}
	
	//Get size of wall, for use in weasel strategy
	public int getWallSize(boolean choice){
		if(choice == true){
			return this.WALL_SMALL;
		}
		else{ return this.WALL_LARGE;}
	}
	
	//About command
	public String aboutGame(){
		String name = "Andreas Bueff";
		String course = "CSc 133 - Object-Oriented Computer Graphics Programming";
		String other = "Version 2.0";
		
		return name + "\n" + course + "\n" + other;
	}
	
	//Getter for GameObjectCollection
	public GameObjectCollection getGameObjectCollection(){
		return gameObjectCollection;
	}
	
	//Getter for list containing observers
	public ArrayList<IObserver> getRegObserver(){
		return RegObserver;
	}

	/**
	 * Passes new direction to Snakes object 
	 * Snakes object faces new direction
	 * @param dir new direction
	 */
	public void changeHeading(String dir){
		for(int i = 0; i<gameObjectCollection.size(); i++){
			if(gameObjectCollection.get(i) instanceof Snakes){
				((Snakes)gameObjectCollection.get(i)).changeSnakeHeading(dir);
				
				
			}
		}
		this.notifyObservers();
	}
	
	/**
	 * All objects able to move in GameWorld collection use move method
	 */
	public void moveGameObject(){
		/**
		for(int i = 0; i < gameObjectCollection.size(); i++){
			if(gameObjectCollection.get(i) instanceof MoveableObject){
				((MoveableObject)gameObjectCollection.get(i)).move();
			}
		}
		*/
		for(GameObject obj: gameObjectCollection){
			if(obj instanceof MoveableObject){
				((MoveableObject)obj).move();
			}
		}
		
	}
	
	
	/**
	 * Print all Game Objects
	 * 
	 */
	public void printGameObject(){
				
		for(GameObject obj: gameObjectCollection){
			if(obj instanceof Snakes){
				System.out.println(obj.toString());
			}
			else if(obj instanceof Birds){
				System.out.println(obj.toString());
			}
			else if(obj instanceof Money){
				System.out.println(obj.toString());
			}
			else if(obj instanceof Money){
				System.out.println(obj.toString());
			}
			else if(obj instanceof Food){
				System.out.println(obj.toString());
			}
			else if(obj instanceof Walls){
				System.out.println(obj.toString());
			}
			else if(obj instanceof Weasel){
				System.out.println(obj.toString());
			}
			
		}
		
	}
	
	
	/**
	 * Change in game state resulting from
	 * Snake Head colliding with Snake BodySegment
	 * Player loses a life and Game either ends or starts over
	 * @param player
	 */
	public void GameCollisionBodySegment(){
		
		for(GameObject bodySeg : gameObjectCollection){
			
				if(bodySeg instanceof Snakes){
					
					gameUser.decrementLives();//player loses a life
					if(gameUser.getLives() == 0){
						
						this.quitGame();
						
					}
					else{//Begin Game with new layout
						this.initLayout();
					}break;
				}
		}
		
		this.notifyObservers();
	}
	
	/**
	 * Change in game state resulting from
	 * Snake Head colliding with Money object
	 * Money object is removed and Player score increase 
	 * @param player
	 */
	public void GameCollisionMoney(){
		
		for(GameObject money : gameObjectCollection){
			
				if(money instanceof Money){
					//if more than one money select one at random to remove
					int value = ((Money) money).getValue();
					System.out.println("\n"+ "Money value: " + value);
					gameUser.setScore(value);
					System.out.println("Player score: " + gameUser.getScore() + "\n");
					gameObjectCollection.remove(money);
					
					break;
				}
				
		}
		this.notifyObservers();
	}
	
	/**
	 * Change in game state resulting from
	 * Snake Head colliding with Bird
	 * Player loses a life and Game either ends or starts over
	 * @param player
	 */
	public void GameCollisionBird(){
		for(GameObject bird : gameObjectCollection){
			
			if( bird instanceof Birds){
				gameUser.decrementLives();
				if(gameUser.getLives() == 0){
					this.quitGame();
				}
				else{
					initLayout();
				}break;
			}
			
		}
		this.notifyObservers();
	}
	
	/**
	 * Change in game state resulting from
	 * Snake Head colliding with Food object
	 * Food object is removed and Snake BodySegment increases
	 * New Food and one or more Money objects are generated into the GameWorld  
	 * @param player
	 */
	public void GameCollisionFood(){
		int growthPool = 0;
		for(GameObject food : gameObjectCollection){
			if(food instanceof Food){
				growthPool = ((Food)food).getAmount();
				System.out.println("\n" + "Amount of food: " + growthPool + "\n");
				gameObjectCollection.remove(food);
				for(GameObject snake : gameObjectCollection){
					if(snake instanceof Snakes){
						((Snakes)snake).setNewSegCount(growthPool);
					}	
				}
				
				int moneyObjectAmount = random.nextInt(3) + 1;
				for(int k = 0; k < moneyObjectAmount; k++){
					gameObjectCollection.add(new Money(random.nextInt(970)+10,random.nextInt(970)+10, Color.GREEN));
				}	
				gameObjectCollection.add(new Food(random.nextInt(970)+10, random.nextInt(970)+10, Color.ORANGE));
				
			break;	
			}
			
		}
		this.notifyObservers();

	}
	
	/**
	 * Change in game state resulting from
	 * Snake Head colliding with Wall
	 * Player loses a life and Game either ends or starts over
	 * @param player
	 */
	public void GameCollisionWall(){
		
		for(GameObject wall : gameObjectCollection){
			if(wall instanceof Walls){
				gameUser.decrementLives();
				if(gameUser.getLives() == 0){
					this.quitGame();
				}
				else{
					initLayout();
				}break;
			}
		}
		
		this.notifyObservers();
		
	}
	
	
	/**
	 * Weasel GameObject collision with Snake
	 */
	public void GameCollisionWeasel(){
		for(GameObject obj : gameObjectCollection){
			
			if( obj instanceof Weasel){
				gameUser.decrementLives();
				if(gameUser.getLives() == 0){
					this.quitGame();
				}
				else{
					initLayout();
				}break;
			}
			
		}
		this.notifyObservers();
		
		
	}
	
	/**
	 * Change strategy of all Weasel GameObjects
	 */
	public void ChangeWeaselStrategy(){
		for(GameObject obj: gameObjectCollection){
			if(obj instanceof Weasel){
				if(((Weasel)obj).getStrategy() instanceof ChaseSnakeStrategy){
					((Weasel)obj).setStrategy(new FollowHeadingStrategy((Weasel)obj));
				}else{ ((Weasel)obj).setStrategy(new ChaseSnakeStrategy((Weasel)obj)); }
			}
		}
		this.notifyObservers();
	}
	
	/**
	 * Increase the age of all Fixed GameObjects in the GameWorld
	 */
	public void ageGameObjects(){
		for(GameObject fixed: gameObjectCollection){
			if(fixed instanceof FixedObject){
				((FixedObject) fixed).incrementAge();
			}
		}
		
	}
	
	/**
	 * Tick Game Clock, also ages and moves gameObjects
	 */
	public void tickGameClock(){
		gameClock.tick();
		this.moveGameObject();
		this.ageGameObjects();
		this.notifyObservers();
	}
	

	/**
	 * Display player statistics and current time
	 * @param player
	 * @param clock
	 */
	public void GameDisplay(){
		
		System.out.println("Player lives: " + gameUser.getLives() + "\n");
		
		System.out.println("Game Clock: " + gameClock.getCount() + "\n");
		
		System.out.println("Current Score: " + gameUser.getScore() + "\n");
			
		
	}
	
	/**
	 * Quits game based on user confirmation
	 * Also responsible for restarting the game
	 */
	public void quitGame(){
		int result;
		if(gameUser.getLives() == 0){
			 result = JOptionPane.showConfirmDialog(null, "No more lives, you want to quit?", "Confrim exit", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		}else{
			result = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Confrim exit", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		}
		
		if(result == JOptionPane.YES_OPTION){ System.exit(0);}
		else{ 
			gameUser = new Player();
			gameClock = new Clock();
			this.initLayout();
			this.notifyObservers();
		}
	}

	/**
	 * add observer objects
	 */
	public void addObserver(IObserver obs) {
		RegObserver.add(obs);
		
	}

	/**
	 * update all observer objects
	 */
	public void notifyObservers() {
		GameWorldProxy proxy =  new GameWorldProxy(this);
		for(IObserver obj : RegObserver){
				obj.update((IObservable)proxy, null);
			
		}
		
	}



	
	
}
