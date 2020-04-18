package com.group12.board_entity;

/**
 * Creates Objective Reward 
 * @author Daniel, Yuxi
 */
public class ObjectiveReward extends Collectible {
	
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

