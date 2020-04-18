package com.group12.board_entity;

/**
 * Punishment collectible class
 * @author Daniel, Yuxi
 */
public class Punishment extends Collectible{
	
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