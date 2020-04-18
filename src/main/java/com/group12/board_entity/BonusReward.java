package com.group12.board_entity;

/**
 * Creates Bonus Reward 
 * @author Daniel, Yuxi
 */
public class BonusReward extends Collectible{
	
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