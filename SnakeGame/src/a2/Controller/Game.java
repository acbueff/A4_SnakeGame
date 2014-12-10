package a2.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import a2.Model.Clock;
import a2.Model.GameWorld;
import a2.Model.Player;
import a2.View.MapView;
import a2.View.ScoreView;

/**
 * Creates GameWorld and manages user commands
 * and updates GameWorld
 * @author Andreas
 *
 */
public class Game extends JFrame {
	private GameWorld gw;
	private Scanner input;
	private MapView mv;
	private ScoreView sv;
	private ButtonCommand bc;

	/**
	 * Game Constructor, setsup GUI and assigns commands
	 */
	public Game(){
		//variables active in game
		gw = new GameWorld();
		gw.initLayout();
		//observers, views
		mv = new MapView();
		sv = new ScoreView();
		
		gw.addObserver(mv);
		gw.addObserver(sv);
		gw.notifyObservers();
		
		bc = new ButtonCommand(); 
		
		//COMMAND OBJECTS
		HitBodyCommand hitBodyCmd = new HitBodyCommand();
		HitBirdCommand hitBirdCmd = new HitBirdCommand();
		HitMoneyCommand hitMoneyCmd = new HitMoneyCommand();
		EatFoodCommand eatFoodCmd = new EatFoodCommand();
		HitWallCommand hitWallCmd = new HitWallCommand();
		HitWeaselCommand hitWeaselCmd = new HitWeaselCommand();
		StrategiesCommand stratCmd = new StrategiesCommand();
		TickCommand tickCmd = new TickCommand();
		QuitCommand quitCmd = new QuitCommand();
		//COMMAND for Snake Directions
		NorthCommand northCmd = new NorthCommand();
		SouthCommand southCmd = new SouthCommand();
		EastCommand eastCmd = new EastCommand();
		WestCommand westCmd = new WestCommand();
		//COMMAND for FileMenu
		NewCommand newCmd = new NewCommand();
		SaveCommand saveCmd = new SaveCommand();
		UndoCommand undoCmd = new UndoCommand();
		SoundCommand soundCmd = new SoundCommand();
		AboutCommand aboutCmd = new AboutCommand();
		
		
		
		setSize(1000, 800);
		setTitle("Snake Game");
		setLocation(200,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//MENU
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem mItem = new JMenuItem("New");
		mItem.setAction(newCmd);
		fileMenu.add(mItem);
		mItem = new JMenuItem("Save");
		mItem.setAction(saveCmd);
		fileMenu.add(mItem);
		mItem = new JMenuItem("Undo");
		mItem.setAction(undoCmd);
		fileMenu.add(mItem);
		
		//Sound in FileMenu
		JCheckBoxMenuItem soundItem = new JCheckBoxMenuItem("Sound");
		soundItem.setAction(soundCmd);
		fileMenu.add(soundItem);
		
		
		mItem = new JMenuItem("About");
		mItem.setAction(aboutCmd);
		fileMenu.add(mItem);
		mItem = new JMenuItem("Quit");
		mItem.setAction(quitCmd);
		fileMenu.add(mItem);
		bar.add(fileMenu);
		
		//CommandMenu
		JMenu commandMenu = new JMenu("Command");
		JMenuItem cItem = new JMenuItem("Snake hit Body");
		cItem.setAction(hitBodyCmd);
		commandMenu.add(cItem);
		
		cItem = new JMenuItem("Bird hit Snake");
		cItem.setAction(hitBirdCmd);
		commandMenu.add(cItem);
		
		cItem = new JMenuItem("Snake hit Money");
		cItem.setAction(hitMoneyCmd);
		commandMenu.add(cItem);
		
		cItem = new JMenuItem("Snake eats Food");
		cItem.setAction(eatFoodCmd);
		commandMenu.add(cItem);
		
		cItem = new JMenuItem("Snake hit Wall");
		cItem.setAction(hitWallCmd);
		commandMenu.add(cItem);
		
		//Change Strategies
		cItem = new JMenuItem("Change Strategies");
		cItem.setAction(stratCmd);
		commandMenu.add(cItem);
		
		//Snake collided with Weasel
		cItem = new JMenuItem("Weasel hit Snake");
		cItem.setAction(hitWeaselCmd);
		commandMenu.add(cItem);
		
		bar.add(commandMenu);
		
		
		this.setJMenuBar(bar);
		
		//Score Panel
		JPanel topPanel = new JPanel();
		topPanel.setBorder (new LineBorder(Color.ORANGE,2));
		this.add(topPanel,BorderLayout.NORTH);
		
		//SCORE VIEW
		JLabel time = sv.getTimeLabel();
		topPanel.add(time);
		JLabel currentScore = sv.getScoreLabel();
		topPanel.add(currentScore);
		JLabel livesLeft = sv.getLives();
		topPanel.add(livesLeft);
		//ADD SOUND LABEL
		JLabel soundState = sv.getSound();
		topPanel.add(soundState);
		
		//ADD Buttons to GameFrame
		bc.getSnakeHitBody().setAction(hitBodyCmd);//1
		bc.getBirdHitSnake().setAction(hitBirdCmd);//2
		bc.getSnakeHitMoney().setAction(hitMoneyCmd);//3
		bc.getSnakeEatsFood().setAction(eatFoodCmd);//4
		bc.getSnakeHitWall().setAction(hitWallCmd);//5
		bc.getWeaselHitSnake().setAction(hitWeaselCmd);//weasel
		bc.getChangeStrategies().setAction(stratCmd);
		bc.getTick().setAction(tickCmd);
		bc.getQuit().setAction(quitCmd);
		this.add(bc, BorderLayout.WEST);
		
		
		//Center
		JPanel centerPanel = new JPanel();
		JTextPane mapLabel = mv.getMapDisplay();//display text of map
		centerPanel.setBorder(new EtchedBorder());
		centerPanel.setBackground(Color.blue);
		centerPanel.add(mapLabel);
		this.add(centerPanel,BorderLayout.CENTER);
		
		//ADD KeyStrokes to Frame
		//when in focus
		int mapName = JComponent.WHEN_IN_FOCUSED_WINDOW;
		//For each Panel
		InputMap cmap = centerPanel.getInputMap(mapName);
		InputMap lmap = bc.getInputMap(mapName);
		InputMap tmap = topPanel.getInputMap(mapName);
		//KeyStrokes
		KeyStroke downArrowKey = KeyStroke.getKeyStroke("DOWN");
		KeyStroke upArrowKey = KeyStroke.getKeyStroke("UP");
		KeyStroke rightArrowKey = KeyStroke.getKeyStroke("RIGHT");
		KeyStroke leftArrowKey = KeyStroke.getKeyStroke("LEFT");
		KeyStroke spaceKey = KeyStroke.getKeyStroke("SPACE");
		//InputMap assign
		//for south
		cmap.put(downArrowKey, "down");
		lmap.put(downArrowKey, "down");
		tmap.put(downArrowKey, "down");
		//for north
		cmap.put(upArrowKey, "up");
		lmap.put(upArrowKey, "up");
		tmap.put(upArrowKey, "up");
		//for east
		cmap.put(rightArrowKey, "right");
		lmap.put(rightArrowKey, "right");
		tmap.put(rightArrowKey, "right");
		//for west
		cmap.put(leftArrowKey, "left");
		lmap.put(leftArrowKey, "left");
		tmap.put(leftArrowKey, "left");
		//for space-bar change strategies
		cmap.put(spaceKey, "space");
		lmap.put(spaceKey, "space");
		tmap.put(spaceKey, "space");
		
		
		//ActionMAP
		ActionMap aCmap = centerPanel.getActionMap();
		ActionMap aLmap = bc.getActionMap();
		ActionMap aTmap = topPanel.getActionMap();
		
		//ActionMap assign
		//forSouth
		aCmap.put("down",southCmd);
		aLmap.put("down",southCmd);
		aTmap.put("down",southCmd);
		//forNorth
		aCmap.put("up",northCmd);
		aLmap.put("up",northCmd);
		aTmap.put("up",northCmd);
		//forEast
		aCmap.put("right",eastCmd);
		aLmap.put("right",eastCmd);
		aTmap.put("right",eastCmd);
		//forWest
		aCmap.put("left",westCmd);
		aLmap.put("left",westCmd);
		aTmap.put("left",westCmd);
		//for space-bar change strategies
		aCmap.put("space",stratCmd);
		aLmap.put("space",stratCmd);
		aTmap.put("space",stratCmd);
		
		
		setVisible(true);
		
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
				//gw.notifyObservers();
				break;
			case "s":
				gw.changeHeading("s");
				//gw.notifyObservers();
				break;
			case "e":
				gw.changeHeading("e");
				//gw.notifyObservers();
				break;
			case "w":
				gw.changeHeading("w");
				//gw.notifyObservers();
				break;
			case "1":
				gw.GameCollisionBodySegment();
				//gw.notifyObservers();
				break;
			case "2":
				gw.GameCollisionBird();
				//gw.notifyObservers();
				break;
			case "3":
				gw.GameCollisionMoney();
				//gw.notifyObservers();
				break;
			case "4":
				gw.GameCollisionFood();
				//gw.notifyObservers();
				break;
			case "5":
				gw.GameCollisionWall();
				//gw.notifyObservers();
				break;
			case "t":
				gw.tickGameClock();
		
				break;
			
			case "q":
				gw.quitGame();
				break;
			default:
				System.out.println("Only enter an allowable command");
			}	
		
	}
	
}
