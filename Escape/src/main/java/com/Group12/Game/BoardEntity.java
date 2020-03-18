package com.Group12.Game;

/**
 * A representation of an entity on a coordinate plane.
 * @author Yuxi
 *
 */
interface BoardEntity {
	/**
	 * Returns the entity's x coordinate.
	 * @return the x coordinate
	 */
	public int getXPos();
	
	/**
	 * Returns the entity's y coordinate.
	 * @return the y coordinate
	 */
	public int getYPos();
	
	/**
	 * Sets the entity's x coordinate.
	 * @param x the new x coordinate
	 */
	public void setX(int x);
	
	/**
	 * Sets the entity's y coordinate.
	 * @param y the new y coordinate
	 */
	public void setY(int y);
}
