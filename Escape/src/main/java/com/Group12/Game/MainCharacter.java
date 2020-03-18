package com.Group12.Game;

/**
 * Represents the Main Character entity in the game.
 * @author Wilson, Yuxi, Nicholas, Daniel
 *
 */
public class MainCharacter extends BoardEntity {
	
	// Attributes
	//private int x, y;
	private int health;
	//private Weapon gun;				// different weapons have not yet been implemented
	
	// Methods
	
	/**
	 * Default constructor.
	 */
	public MainCharacter() {
		this(0, 0);
	}
	
	/**
	 * Creates a new MainCharacter with initial health 100 at internal position (x, y).
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public MainCharacter(int x, int y) {
		this.health = 1;
		this.xPos = x;
		this.yPos = y;
		//this.gun = new Weapon();	// different weapons have not yet been implemented
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
	 * Sets the current health of the MainCharacter.
	 */
	public boolean decHealth() {
		this.health --;
		return this.health > 0;
	}
	
	/**
	 * Checks if the MainCharacter's health is greater than 0.
	 * @return true if getHealth() is greater than 0, otherwise false
	 */
	public boolean checkAlive() {
		return getHealth() > 0;
	}
	
	// BoardEntity implementation
	/*
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
	*/
	
}



	





