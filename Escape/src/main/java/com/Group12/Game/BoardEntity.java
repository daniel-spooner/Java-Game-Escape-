package com.Group12.Game;

/**
 * A representation of an entity on a coordinate plane.
 * @author Yuxi, Daniel
 *
 */
public class BoardEntity {
	
	int xPos;
	int yPos;
	
	/**
	 * Returns the entity's x coordinate.
	 * @return the x coordinate
	 */
	public int getXPos() {
		return xPos;
	}
	
	/**
	 * Returns the entity's y coordinate.
	 * @return the y coordinate
	 */
	public int getYPos() {
		return yPos;
	}
	
	/**
	 * Sets the entity's x coordinate.
	 * @param x the new x coordinate
	 */
	public void setXPos(int x) {
		xPos = x;
	}
	
	/**
	 * Sets the entity's y coordinate.
	 * @param y the new y coordinate
	 */
	public void setYPos(int y) {
		yPos = y;
	}
}
