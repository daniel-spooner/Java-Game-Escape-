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



		this.score = 0;
		this.tick = new TickTimer();
		this.keyListener = new GameKeyListener();
		this.display = new DisplayManager();
		setState(GameState.MENU);		//Ensure DisplayManager will display MENU state at initialization.
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
	 * Gets the current score of the game.
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	//TODO: how to get to startGame from menu?
	public void startGame() {
		// Initialization
		makeBoard("map1");
		display.addKeyListener(keyListener);
		keyListener.resetLastKey();
		
		setState(GameState.MENU);
		display.stateChange(getState());
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
		int recentKey = this.keyListener.getLastKey();
		
		// If the game is paused and should be unpaused. 
		// VK_RETURN is 13.
		if (getState() == GameState.MENU) {
			if (recentKey == 13) {
				tick.unpauseTick();
				setState(GameState.GAME);
				updateDisplay();
			}
		}
		
		// If the game is not paused and...
		else if (getState() == GameState.GAME) {
			
			// ... should be paused. 
			// VK_ESCAPE is 27.
			if (recentKey == 27) {
				tick.pauseTick();
				setState(GameState.MENU);
			}
			
			// ... a full 'tick' has passed.
			else if (tick.getTickCount() >= (long) 3000) { // current hardcoded milliseconds per 'tick'
				tick.resetTickCount(); // probably thread-unsafe - if this doesn't execute fast we double-update (unlikely unless tick.fps far too high)
				keyListener.resetLastKey();
				
				// The actual logic
				// Update the player - covers player input, intentional collision
				updatePlayer(recentKey);
				// Update the enemies - covers enemy movement, unintentional collision
				updateEnemies();
				// Spawn and update BonusRewards - TODO
				
				// Check current win/lose conditions
				if (objectiveRewards.isEmpty() && mainChar.getXPos() == goalX && mainChar.getYPos() == goalY) {
					System.out.println("Game over! You win!");
					setState(GameState.WIN);
					tick.pauseTick();
				}
				else if (score <= 0 || !mainChar.checkAlive()) {
					System.out.println("Game over! You lose!");
					setState(GameState.LOSE);
					tick.pauseTick();
				}
				
				// Update full display
				updateDisplay();
			}
			
			// Always update user interface if the game is not paused
			updateUserInterface();
		}
	}
	
	/**
	 * Checks if the input from player is valid, and updates the main character position.
	 * @param input the key input pressed by player.
	 */
	private void updatePlayer(int input) {		
		int currentXPos = mainChar.getXPos();
		int currentYPos = mainChar.getYPos();
		switch(input) {
		case 87:	//W 87
			if( isValidMove(currentXPos,currentYPos+1) == true) {
				mainChar.setYPos(currentYPos+1);
			}
			break;
		case 65:	//A 65
			if( isValidMove(currentXPos-1,currentYPos) == true) {
				mainChar.setXPos(currentXPos-1);
			}
			break;
		case 83:	//S 83
			if( isValidMove(currentXPos,currentYPos-1) == true) {
				mainChar.setYPos(currentYPos-1);
			}
			break;
		case 68:	//D 68
			if( isValidMove(currentXPos+1,currentYPos) == true) {
				mainChar.setXPos(currentXPos+1);
			}
			break;
		default:	//wait, no player position update
			break;
		}
		checkCollisions();
	}
	
	private void updateEnemies() {
		/* Steps to take:
		 * 1. Make all enemies move (unless one is already on the mainCharacter)
		 * 2. checkCollisions() to react if any enemies ended on the mainCharacter
		 */
		for (Enemy e : this.enemies) {
			moveEnemy(e);
		}
		checkCollisions();
	}
	
	private void updateDisplay() { //TODO
		throw new UnsupportedOperationException();
	}
	
	private void updateUserInterface() { //TODO
		throw new UnsupportedOperationException();
	}
	
	private void moveEnemy(Enemy e) {
		int dirc; //dirc = 0 is up, 1 is down,  2 is left, 3 is right
		// [0][0] [i][0]
		// [0][j] [i][j]
		boolean mainCharUp = mainChar.getYPos() < e.getYPos();
		boolean mainCharRight = mainChar.getXPos() < e.getXPos();
		int yDist = Math.abs(mainChar.getYPos() - e.getYPos());
		int xDist = Math.abs(mainChar.getXPos() - e.getXPos());
		
		// enemy is standing on mainCharacter (should never happen; enemies deleted on collision atm)
		if (yDist == 0 && xDist == 0) {
			return;
		}
		
		// check closest direction to mainCharacter
		if (yDist > xDist) {
			if (mainCharUp) {
				dirc = 0;
			}
			else {
				dirc = 1;
			}
		}
		else { //xDist >= yDist
			if (mainCharRight) {
				dirc = 2;
			}
			else {
				dirc = 3;
			}
		}
		
		// loop until valid move made (no protection against poorly made map file)
		Random rand = new Random();
		int newX;
		int newY;
		
		// System.out.println(dirc);
		
		while (true) {
			switch (dirc) {
			case 0:
				// up
				newX = e.getXPos();
				newY = e.getYPos()-1;
				break;
			case 1:
				// down
				newX = e.getXPos();
				newY = e.getYPos()+1;
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
		
			if (isValidMove(newX, newY) && !hasEnemy(newX,newY)) {
				e.setXPos(newX);
				e.setYPos(newY);
				return;
			} 
			else {
				dirc = rand.nextInt(4);
			}
		}
	}
	
	// checks all lists only if something intersects with mainCharacter
	// called at end of updatePlayer and updateEnemy
	private void checkCollisions() {
		int mx = mainChar.getXPos();
		int my = mainChar.getYPos();
		
		// check enemies, punishments, bonusRewards, objectiveRewards, weaponCollectibles (dne) 
		// backwards iteration for safer removal (alternative: using an iterator)
		for (int i = this.enemies.size()-1; i >= 0; i--) {
			Enemy obj = this.enemies.get(i);
			if (obj.getXPos() == mx && obj.getYPos() == my) {
				this.enemies.remove(i);
				// Enemy-Character interaction:
				mainChar.setHealth(mainChar.getHealth()-1);
			}
		}
		
		for (int i = this.punishments.size()-1; i >= 0; i--) {
			Punishment obj = this.punishments.get(i);
			if (obj.getXPos() == mx && obj.getYPos() == my) {
				this.punishments.remove(i);
				// Punishment-Character interaction:
				score = score - 50;
			}
		}
		
		for (int i = this.bonusRewards.size()-1; i >= 0; i--) {
			BonusReward obj = this.bonusRewards.get(i);
			if (obj.getXPos() == mx && obj.getYPos() == my) {
				this.bonusRewards.remove(i);
				// BonusReward-Character interaction:
				score = score + 100;
			}
		}
		
		for (int i = this.objectiveRewards.size()-1; i >= 0; i--) {
			ObjectiveReward obj = this.objectiveRewards.get(i);
			if (obj.getXPos() == mx && obj.getYPos() == my) {
				this.objectiveRewards.remove(i);
				// ObjectiveReward-Character interaction (besides win condition):
				score = score + 300;
			}
		}
	}

	
	//check the location is valid to move.
	private boolean isValidMove(int x, int y) {
		return board.inBounds(x, y) && board.getCellType(x, y) != cellType.BARRIER;
	}
	
	
	//check the location does have other enemy.
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
		String fullpath;
		fullpath = "src/main/resources/" + filename;
		
		try {
			file = new File(fullpath);
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





	public static void main(String[] args) {
		GameMain g = GameMain.getInstance();
	}

}
