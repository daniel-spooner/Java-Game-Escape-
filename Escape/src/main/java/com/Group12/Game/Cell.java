package com.Group12.Game;

enum cellType { Open, Wall }

public class Cell {
	
	// Attributes
	private cellType type;
	
	
	// Constructors
	public Cell() {
		this.type = cellType.Open;
	}
	
	public Cell(cellType type) {
		this.type = type;
	}
	
	
	// Public Methods
	public cellType getType() {
		return this.type;
	}
	
	public void setType (cellType type) {
		this.type = type;
	}
	
}
