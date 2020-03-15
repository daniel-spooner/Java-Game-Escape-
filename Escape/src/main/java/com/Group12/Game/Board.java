package com.Group12.Game;

public class Board {
	
	// Attributes
	private int cellSize;
	private int xSize;
	private int ySize;
	private Cell[][] boardMatrix;
	
	// Constructors
	public Board() {
		xSize = 25;
		ySize = 20;
		cellSize = 25;
		boardMatrix = new Cell[xSize][ySize];
    	for(int x = 0; x < xSize; x ++) {
    		for(int y = 0; y < ySize; y ++) {
    			boardMatrix[x][y] = new Cell();
    		}
    	}
	}
	
	// Public Methods
	public void loadBoard(String filename) {
		// Read and load a board from a json file
	}
	
	public void drawBoard() {
		// draw the board on the window
	}
	
	public Cell getCell(int x, int y) {
		return boardMatrix[x][y];
	}
	
	public cellType getCellType(int x, int y) {
		return boardMatrix[x][y].getType();
	}
	
	public void setCellType(int x, int y, cellType type) {
		boardMatrix[x][y].setType(type);
	}
	
	
	public int getCellSize() {return cellSize;}
	public int getXSize() {return xSize;}
	public int getYSize() {return ySize;}
	
	public void setCellSize(int size) {cellSize = size;}
	public void setXSize(int size) {xSize = size;}
	public void setYSize(int size) {ySize = size;}
	
}
