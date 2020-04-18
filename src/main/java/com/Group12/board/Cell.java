package com.group12.board;


/**
 * A class representing a unit in the game board
 * @author Daniel
 *
 */
public class Cell {

	public enum cellType { OPEN, BARRIER }
	
	// Attributes
	
	private cellType type;
	
	
	// Constructors
	/**
	 * Creates a new Cell object with default state "Open"
	 */
	public Cell() {
		this.type = cellType.OPEN;
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
