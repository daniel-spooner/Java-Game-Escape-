package com.Group12.Game;

import javax.swing.JPanel;

public class Board extends JPanel{
	
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
	public void loadBoard(String filename) {
		// Read and load a board from a json file
	}
	
	public void drawBoard() {
		// draw the board on the window
	}
	
	public void printAsciiBoard() {
		System.out.print("\n");
		for(int y = 0; y < ySize; y ++) {
			for(int x = 0; x < xSize; x ++) {
				if(boardMatrix[x][y].getType() == cellType.Wall) {
					System.out.print("W ");
				}else {
					System.out.print("O ");
				}
			}
			System.out.print("\n");
		}
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
