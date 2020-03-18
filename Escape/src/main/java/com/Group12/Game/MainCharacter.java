package com.Group12.Game;

/**
 * Represents the Main Character entity in the game.
 * @author Wilson, Yuxi, Nicholas
 *
 */
public class MainCharacter implements BoardEntity {
	
	// Attributes
	private int x;
	private int y;
	private int health = 100;
	private Weapon gun;				// different weapons have not yet been implemented
	
	// Methods
	
	/**
	 * Creates a new MainCharacter with initial health 100 at internal position (x, y).
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public MainCharacter(int x, int y) {
		this.health = 100;
		this.x = x;
		this.y = y;
		this.gun = new Weapon();	// different weapons have not yet been implemented
	}
	
	/**
	 * Default constructor.
	 */
	public MainCharacter() {
		this(0,0);
	}
	
	/**
	 * Gets the current health of the MainCharacter.
	 * @return the current health
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Sets the current health of the MainCharacter.
	 * @param health the new health value
	 */
	public void setHealth(int health) {
		this.health = health; 
	}
	
	/**
	 * Checks if the MainCharacter's health is greater than 0.
	 * @return true if getHealth() is greater than 0, otherwise false
	 */
	public boolean checkAlive() {
		return getHealth() > 0;
	}
	
	// BoardEntity implementation	
	public int getXPos() {
		return x;
	}
	
	public int getYPos() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}



	





