package com.Group12.Game;

enum cellType { Open, Wall }

/**
 * A class representing a unit in the game board
 * @author Daniel
 *
 */
public class Cell {
	
	// Attributes
	
	private cellType type;
	
	
	// Constructors
	/**
	 * Creates a new Cell object with default state "Open"
	 */
	public Cell() {
		this.type = cellType.Open;
	}
	
	/**
	 * Creates a new Cell object
	 * @param type	The type of Cell that is to be created
	 */
	public Cell(cellType type) {
		this.type = type;
	}
	
	
	// Public Methods
	/**
	 * getter for the type of the Cell
	 * @return the type of the Cell
	 */
	public cellType getType() {
		return this.type;
	}
	
	/**
	 * setter for the type of the Cell
	 * @param type	The type to set the Cell to
	 */
	public void setType (cellType type) {
		this.type = type;
	}
	
}
