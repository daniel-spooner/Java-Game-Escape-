package com.group12.board_entity;

/**
 * Contains the positions and lifespans of Collectibles.
 * @author Daniel, Yuxi
 */
public class Collectible extends BoardEntity{
	
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
}
