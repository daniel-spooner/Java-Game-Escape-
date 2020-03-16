package com.Group12.Game;

public class Board{
	
	// Attributes
	private int cellSize;
	private int xSize;
	private int ySize;
	private Cell[][] boardMatrix;
	
	// Constructors
	public Board() {
		this(25, 20, 30);
	}
	
	public Board(int xSize, int ySize) {
		this(xSize, ySize, 30);
	}
	
	public Board(int xSize, int ySize, int cellSize) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.cellSize = cellSize;
		boardMatrix = new Cell[xSize][ySize];
    	for(int x = 0; x < xSize; x ++) {
    		for(int y = 0; y < ySize; y ++) {
    			boardMatrix[x][y] = new Cell();
    		}
    	}
	}
	
	// Public Methods
	
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
