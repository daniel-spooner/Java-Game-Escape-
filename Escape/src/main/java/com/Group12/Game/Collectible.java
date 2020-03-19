package com.Group12.Game;

public class Collectible extends BoardEntity{
	 
	/**
	 * Contains the positions and lifespans of Collectibles.
	 * Authors: Daniel, Yuxi
	 */
	
	//private int x;
	//private int y;
	
	
	public Collectible() {
		super();
	}
	/**
	 * Setting Collectible coordinates.
	 * @param x coordinate
	 * @param y coordinate
	 */
	public Collectible(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	/*
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public void setX(int x) {
		this.xPos = x;
	}
	
	public void setY(int y) {
		this.yPos = y;
	}
	 */
}

/**
 * Creates Bonus Reward 
 */
class BonusReward extends Collectible{
	
	private int lifespan;
	private int score;
	
	public BonusReward() {
		super();
		this.score = 100;
		this.lifespan = 20;
	}
	/**
	 * Creating bonus reward for main character to obtain
	 * @param x coordinate
	 * @param y coordinate
	 * @param lifespan how long the bonus will last on the board
	 * @param score obtained from collecting reward
	 */
	public BonusReward(int x, int y, int lifespan, int score) {
		super(x, y);
		this.lifespan = lifespan;
		this.score = score;
	}
	//getter function for Lifespan
	public int getLifespan() {
		return lifespan;
	}
	
	//Reducing Lifespan of Bonus Reward
	public int decLifespan() {
		this.lifespan --;
		return this.lifespan;
	}
	//getter function to obtain score of reward
	public int getScore() {
		return this.score;
	}
	
}
/**
 * Punishment collectible class
 */
class Punishment extends Collectible{
	
	private int damage;
	
	public Punishment() {
		super();
		this.damage = 50;
	}
	/**
	 * Creating Punishment for user to collide with
	 * @param x coordinate
	 * @param y coordinate
	 * @param damage that will be done to the player
	 */
	public Punishment(int x, int y, int damage) {
		super(x, y);
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}
}
/**
 * Creates Objective Reward 
 */
class ObjectiveReward extends Collectible {
	
	private int score;
	/**
	 * Setting score of Objective Reward
	 */
	public ObjectiveReward() {
		super();
		this.score = 50;
	}
	/**
	 * Creating objective reward for main character to obtain
	 * @param x coordinate
	 * @param y coordinate
	 * @param score obtained from collecting reward
	 */
	public ObjectiveReward(int x, int y, int score) {
		super(x, y);
		this.score = score;
	}
	/**
	 * Gets the score
	 * @return score
	 */
	
	public int getScore() {
		return this.score;
	}
}	
