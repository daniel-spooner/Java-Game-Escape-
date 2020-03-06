package com.Group12.Game;

enum cellType { Open, Wall }

public class Cell {
	
	// Attributes
	cellType type;
	
	
	// Constructors
	public Cell() {
		type = cellType.Open;
	}
	
	public Cell(cellType ct) {
		type = ct;
	}
	
	
	// Public Methods
	public cellType getType() {
		return type;
	}
	
	public void setType (cellType ct) {
		type = ct;
	}
	
}
