package com.Group12.Game;

import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Random;
import java.util.Scanner; 

/**
 * Handles the game's logic.
 * @author Nicholas, Daniel, Wilson, Yuxi
 *
 */
public class GameMain{
	
	// Attributes
	
	private static GameMain gameMain = null;
	
	private ArrayList<Enemy> enemies;
	private ArrayList<Punishment> punishments;
	private ArrayList<BonusReward> bonusRewards;
	private ArrayList<ObjectiveReward> objectiveRewards;
	// WeaponCollectible not currently implemented
	
	private MainCharacter mainChar;
	private Board board;
	
	private int score;
	
	public enum GameState{MENU,GAME,WIN,LOSE};
	private GameState state;
	
	private TickTimer tick;
	private GameKeyListener keyListener;
	private DisplayManager display;

	private int goalX;
	private int goalY;

	// Methods
	
	
	private GameMain() {


		this.enemies 			= new ArrayList<>();
		this.punishments		= new ArrayList<>();
		this.bonusRewards 		= new ArrayList<>();
		this.objectiveRewards	= new ArrayList<>();
		
		//mainChar and board initialized in startGame()


		setState(GameState.MENU);	//Ensure DisplayManager will display MENU state at initialization.
		this.score = 0;
		this.tick = new TickTimer();
		this.keyListener = new GameKeyListener();
		this.display = new DisplayManager();
	}
	

	/**
	 * Returns the single instance of GameMain
	 * if it exists; otherwise, it creates the instance.
	 * @return the instance of GameMain
	 */
	public static GameMain getInstance() {
		if(gameMain == null) {
			gameMain = new GameMain();
		}
		return gameMain;
	}
	
	/**
	 * Gets the state of the application.
	 * @return the current state of the game
	 */
	public GameState getState() {	//TODO:Don't need this?
		return state;
	}
	
	/**
	 * Sets the state of the application.
	 * @param state the new state of the application
	 */
	public void setState(GameState state) {
		this.state = state;
		display.stateChange(this.state);
	}
	
	/**
	 * Gets the KeyListener from the application.
	 * @return the KeyListener object
	 */
	
	/**
	 * Gets most recent key from GameKeyListener
	 * @return
	 */
	//TODO: is this necessary? Update() could just call keylistener.getLastKey() by itself.
	public int getKey() {
		int keycode;
		keycode = this.keyListener.getLastKey();
		return keycode;
	}
	
	/**
	 * Gets the current score of the game.
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	//TODO: how to get to startGame from menu?
	public void startGame() {
		// Initialization
		makeBoard("map1");		//TODO: don't hardcode + decide on proper file location
		display.addKeyListener(keyListener); 	//TODO: Added addKeyListener to function to DisplayManager.java BUT CHECK PLEASE
		keyListener.resetLastKey();
		setState(GameState.GAME);
		score = 500;	//hardcoded initial score state
		
		Thread t = new Thread(tick);
		t.start();
	}
	
	/**
	 * Should be called on an interval by a TickTimer and nothing else.
	 * <p>
	 * Updates the current state of the game if the 'tick' has ended,
	 * performing player actions, moving enemies, and checking win conditions.
	 */
	public void update() {

		int recentKey;
		//getLastKey() from GameKeyListener and getKey() returns type int. Every key has an equivalent number. No need to get KeyEvent type?
		recentKey = getKey();
		// If the game should be paused. 27 corresponds with key 'esc'.
		if (recentKey == 27) {
			tick.pauseTick();
			setState(GameState.MENU);
			// But if we pause TickTimer, how do we unpause?
			// Proposal: maybe runTick() is always on and running update() 
			//  but only tracks time when active? have to discuss later
		}
		
		// If a full 'tick' has passed: 
		else if (tick.getTickCount() >= (long) 3000) { // current hardcoded milliseconds per 'tick'
			tick.resetTickCount(); // probably thread-unsafe - if this doesn't execute fast we double-update (unlikely unless tick.fps far too high)
			keyListener.resetLastKey();
			
			// The actual logic
			// Update the player - covers player input, intentional collision
			updatePlayer(recentKey);
			// Update the enemies - covers enemy movement, unintentional collision
			updateEnemies();
			// Check current win/lose conditions
			if (mainChar.getXPos() == goalX && mainChar.getYPos() == goalY) {
				System.out.println("Game over! You win!");
				setState(GameState.WIN);
				tick.pauseTick();
			}
			else if (score <= 0 || mainChar.getHealth() <= 0) { //TODO: re-implement getHealth() and setHealth(), easier to handle lose-cons
				System.out.println("Game over! You lose!");
				setState(GameState.LOSE);
				tick.pauseTick();
			}
		}
		
		// Always update display
		display.repaint();
	}
	
	private void updatePlayer(int input) {		//TODO: Get and set Player Position for each case and collision checking?
		switch(input) {
		case 87:	//W
			break;
		case 65:	//A
			break;
		case 83:	//S
			break;
		case 68:	//D
			break;
		}
		
	}
	
	private void updateEnemies() {
		
	}
	
	private void updateDisplay() {
		
	}
	

	private void moveAllEnemy() {
		for (BoardEntity ee : this.enemies) {
			moveEnemy((Enemy)ee);
		}
	}
	
	//In moveenemy, I ask enemy to search MC's position 
	//and judege whether it is allowed to move, This function isValidMove(x,y) I write in Board class (avoid wall or boundary)
	//and then move towards MC
	//The problem here is I have to get position of MC so I think we should public mainCharacter.
	private void moveEnemy(Enemy e) {
		 while(true) {
			 int dirc; //dirc = 0 is up, 1 is down,  2 is left, 3 is right
			 // IS VALID MOVE HAS BEEN DELETED FROM BOARD, ADD IT IN GAMEMAIN
			 if(mainChar.getYPos() - e.getYPos() > 0 && Math.abs(mainChar.getYPos() - e.getYPos()) >= Math.abs(mainChar.getXPos() - e.getXPos()) && isValidMove(e.getXPos(),  e.getYPos()+1)) {
				 dirc = 0;
			 }
			 else if(mainChar.getYPos() - e.getYPos() < 0 && Math.abs(mainChar.getYPos() - e.getYPos()) >= Math.abs(mainChar.getXPos() - e.getXPos()) && isValidMove( e.getXPos(),  e.getYPos()-1)) {
				 dirc = 1;
			 }
			 else if(mainChar.getXPos() - e.getXPos() < 0 && Math.abs(mainChar.getXPos() - e.getXPos()) >= Math.abs(mainChar.getYPos() - e.getYPos()) && isValidMove( e.getXPos()-1,  e.getYPos())) {
				 dirc = 2;
			 }
			 else if(mainChar.getXPos() - e.getXPos() > 0 && Math.abs(mainChar.getXPos() - e.getXPos()) >= Math.abs(mainChar.getYPos() - e.getYPos()) && isValidMove( e.getXPos()+1,  e.getYPos())) {
				 dirc = 3;
			 }
			 else
			 {
				 Random rand = new Random();
				 dirc = rand.nextInt(4);
			 }
			 int newX, newY;
			 System.out.println(dirc);
			 switch (dirc) {
				 case 0:
				 // up
				 newX = e.getXPos();
				 newY = e.getYPos()+1;
				 break;
			 case 1:
				 // down
				 newX = e.getXPos();
				 newY = e.getYPos()-1;
				 break;
			 case 2:
				 // left
				 newX = e.getXPos()-1;
				 newY = e.getYPos();
				 break;
			 case 3:
				 // right
				 newX = e.getXPos()+1;
				 newY = e.getYPos();
				 break;
			 default:
				 //Should set enemy is a reasonable location.
				 newX = -1;
				 newY = -1;
			}
		 
		 
		 if (isValidMove(newX, newY)) {
			e.setXPos(newX);
			e.setYPos(newY);
			return;
		 }
		 }

	}
	
	//when Enemy e collision with MC.
	//private void collision(Enemy e)
	//{
	//	if(e.x == mainChar.getXPos() && e.y == mainChar.getYPos()) {
		//	((MainCharacter)mainChar).setHealth(100);
		//}
	//}
	
	
	private boolean isValidMove(int x, int y) {
		return board.inBounds(x, y) && board.getCellType(x, y) != cellType.BARRIER && !hasEnemy(x,y);
	}
	
	
	private boolean hasEnemy(int x, int y) {
		for (BoardEntity e : this.enemies) {
			if (e.getXPos() == x && e.getYPos() == y) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * This method reads from a file and uses it to initialize
	 * board, enemies, collectibles, and mainChar.
	 * @param filename the name of the file that makeBoard reads from.
	 */
	private void makeBoard(String filename) {
		// file format: xDim yDim
		// remaining yDim lines of xDim characters: board layout & entity placement
		File file;
		Scanner sc;
		try {
			file = new File(filename);
		}
		catch (java.lang.NullPointerException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			sc = new Scanner(file);
		}
		catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		int xSize;
		int ySize;
		xSize = sc.nextInt();
		ySize = sc.nextInt();
		this.board = new Board(xSize, ySize);
		sc.nextLine();
		
		/* characters in file:
		 * 	. = Open
		 * 	# = Barrier
		 * all other characters also on Open tiles
		 * 	@ = MainCharacter
		 * 	G = Goal
		 * 	E = Enemy
		 * 	P = Punishment
		 * 	O = ObjectiveReward
		 * 	W = WeaponCollectible
		 */
		
		for (int i = 0; i < ySize; i++) {
			String line;
			try {
				line = sc.nextLine();	//TODO: determine if file must end with newline character (currently does not)
			}
			catch (java.util.NoSuchElementException e) {
				line = sc.next();
			}
			for (int j = 0; j < xSize; j++) {
				char c = line.charAt(j);
				switch (c) {
				case '#':
					this.board.setCellType(j, i, cellType.BARRIER);
					break;
				case '@':
					this.mainChar = new MainCharacter(j, i);
					break;
				case 'G':
					this.goalX = j;
					this.goalY = i;
					break;
				case 'E':
					this.enemies.add(new Enemy(j, i));
					break;
				case 'P':

					this.punishments.add(new Punishment(j, i, 50));
					break;
				case 'O':
					this.objectiveRewards.add(new ObjectiveReward(j, i, 50));

					break;
				case 'W':
					// WeaponCollectible has not yet been implemented
					break;
				case '.':	default:
					//board.setCellType(j, i, cellType.OPEN);	// at time of writing, cells initialized as OPEN
					break;
				}
			}
		}
		
		sc.close();
		
	}
	public static void main(String args[]) {
		GameMain n = new GameMain();
	
	}






}
