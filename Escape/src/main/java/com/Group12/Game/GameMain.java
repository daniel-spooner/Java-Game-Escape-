package com.Group12.Game;

/**
 * Handles the game's logic.
 * @author Nicholas, Daniel, Wilson, Yuxi
 *
 */
public class GameMain {
	
	// Attributes
	
	private static GameMain gameMain;
	
	private Enemy[] enemies;
	private Collectible[] collectibles;
	private MainCharacter[] mainChar;
	private Board board;
	
	private int objectivesRemaining;
	private StateType gameState;
	private int score;
	private TickTimer tick;
	
	// Methods
	
	private GameMain() {
		enemies = new Enemy[];
		collectibles = new Collectible[];
		mainChar = new MainCharacter;
		board = new Board;
		
		objectivesRemaining = 4;
		//gameState = Menu;		//TODO: once the enumeration is finalized
		score = 0;
		tick = new TickTimer;
	}
	
	/**
	 * This method returns the single instance of GameMain
	 * if it exists, otherwise it creates a new instance.
	 * @return GameMain	This returns the instance of GameMain.
	 */
	public static GameMain getInstance() {
		if(gameMain == null) {
			gameMain = new GameMain();
		}
		return gameMain;
	}
	
	public void startGame() {
		
	}
	
	public void update() {
		
	}
	
	private void updatePlayer() {
		
	}
	
	private void updateEnemies() {
		
	}
	
	private void updateDisplay() {
		
	}
	
	private void makeBoard(String x) {
		
	}


}
