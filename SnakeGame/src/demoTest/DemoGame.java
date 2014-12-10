package demoTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import a2.Model.GameWorld;
import a2.View.MapView;
import a2.View.ScoreView;

public class DemoGame extends JFrame{
	
	//private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	
	
	
	
	private JMenuBar createMenuBar(){
			
			JMenuBar bar = new JMenuBar();
			
			JMenu fileMenu = new JMenu("File");
			JMenuItem mItem = new JMenuItem("New");
			fileMenu.add(mItem);
			mItem = new JMenuItem("Save");
			fileMenu.add(mItem);
			mItem = new JMenuItem("Undo");
			fileMenu.add(mItem);
			mItem = new JMenuItem("Sound");//has to work
			fileMenu.add(mItem);
			mItem = new JMenuItem("About");//has to work
			fileMenu.add(mItem);
			mItem = new JMenuItem("Quit");// has to work
			fileMenu.add(mItem);
			bar.add(fileMenu);
			
			JMenu commandMenu = new JMenu("Command");
			JMenuItem cItem = new JMenuItem("Snake hit Body");
			commandMenu.add(cItem);
			cItem = new JMenuItem("Bird hit Snake");
			commandMenu.add(cItem);
			cItem = new JMenuItem("Snake hit Money");
			commandMenu.add(cItem);
			cItem = new JMenuItem("Snake eats Food");//has to work
			commandMenu.add(cItem);
			cItem = new JMenuItem("Snake hit Wall");//has to work
			commandMenu.add(cItem);
			bar.add(commandMenu);
			
			
			return bar;
		}
	
	
	
	public DemoGame(){
		/**
		gw = new GameWorld();
		gw.initLayout();
		mv = new MapView();
		sv = new ScoreView();
		gw.addObserver(mv);
		gw.addObserver(sv);
		*/
		
		setSize(1000, 800);
		setTitle("Snake Game");
		setLocation(200,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//menu
		JMenuBar topBar = createMenuBar();
		this.setJMenuBar(topBar);
		ScoreView gameScoreView = new ScoreView();
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder (new LineBorder(Color.green,2));
		this.add(topPanel,BorderLayout.NORTH);
		
		JLabel time = gameScoreView.getTimeLabel();
		topPanel.add(time);
		JCheckBox soundBox = new JCheckBox();
		topPanel.add(soundBox);
		
		//
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder("Commands:"));
		leftPanel.setLayout(new GridLayout(10,1));
		this.add(leftPanel, BorderLayout.WEST);
		//JButton stuff
		JButton snakeHitBody = new JButton ("Snake hit Body(1)");
		leftPanel.add(snakeHitBody);
		JButton birdHitSnake = new JButton ("Bird hit Sanke(2)");
		leftPanel.add(birdHitSnake);
		JButton snakeHitMoney = new JButton ("Snake hit Money(3)");
		leftPanel.add(snakeHitMoney);
		JButton snakeEatsFood = new JButton ("Snake eats Food(4)");
		leftPanel.add(snakeEatsFood);
		JButton snakeHitWall = new JButton ("Snake hit Wall(5)");
		leftPanel.add(snakeHitWall);
		JButton weaselHitSnake = new JButton ("Weasel hit Snake");
		leftPanel.add(weaselHitSnake);
		JButton changeStrategies = new JButton ("Change Strategies");
		leftPanel.add(changeStrategies);
		JButton tick = new JButton ("Tick");
		leftPanel.add(tick);
		JButton quit = new JButton ("Quit");
		leftPanel.add(quit);
		
		
		//Center
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new EtchedBorder());
		centerPanel.setBackground(Color.GRAY);
		this.add(centerPanel,BorderLayout.CENTER);
		
		
		
		
		
		
		setVisible(true);
		
		
		
	}
	
}
