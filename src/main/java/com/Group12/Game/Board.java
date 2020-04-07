package com.Group12.Game;


/**
 * Represents the board where the game takes place
 * @author Daniel
 *
 */

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
	
	/**
	 * Constructor for the board object
	 * @param xSize the size of the X dimension
	 * @param ySize the size of the Y dimension
	 * @param cellSize the pixel size of a single cell
	 */
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
	
	/**
	 * Determine if coordinates are within the 
	 * @param x the X coordinate to be checked
	 * @param y the Y coordinate to be checked
	 * @return A boolean value, true if x and y both in bounds, false otherwise
	 */
	public Boolean inBounds(int x, int y) {
		return (x >= 0 && y >= 0 && x < xSize && y < ySize);
	}
	
	/**
	 * Getter for a specific cell in the board
	 * @param x the x coordinate of the cell
	 * @param y the y coordinate of the cell
	 * @return The cell at the corresponding x and y coordinate
	 */
	public Cell getCell(int x, int y) {
		return boardMatrix[x][y];
	}
	
	/**
	 * Getter for the type of a cell in the board
	 * @param x the x coordinate of the cell
	 * @param y the y coordinate of the cell
	 * @return The type of the cell at the corresponding x and y coordinate
	 */
	public cellType getCellType(int x, int y) {
		return boardMatrix[x][y].getType();
	}
	
	/**
	 * Setter for the type of a cell in the board
	 * @param x the x coordinate of the cell
	 * @param y the y coordinate of the cell
	 * @param type the type that the cell is set to
	 */
	public void setCellType(int x, int y, cellType type) {
		boardMatrix[x][y].setType(type);
	}
	
	
	/** 
	 * Getter for the pixel size of a single cell in the board 
	 * @return the size of a cell
	 */
	public int getCellSize() {return cellSize;}
	
	/** 
	 * Getter for the X dimension of the board 
	 * @return the X dimension of the board
	 */
	public int getXSize() {return xSize;}
	
	/** 
	 * Getter for the Y dimension of the board 
	 * @return the Y dimension of the board
	 */
	public int getYSize() {return ySize;}
	
	
	/** 
	 * Setter for the pixel size of a single cell in the board 
	 * @param size the size to set each cell to
	 */
	public void setCellSize(int size) {cellSize = size;}
	
	/** 
	 * Setter for the X dimension of the board
	 * @param size the new X dimension of the board
	 */
	public void setXSize(int size) {xSize = size;}
	
	/** 
	 * Setter for the Y dimension of the board
	 * @param size the new Y dimension of the board
	 */
	public void setYSize(int size) {ySize = size;}
	
}
