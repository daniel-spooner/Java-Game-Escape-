package com.Group12.Game;

import java.awt.*;
import javax.swing.JFrame;

public class DisplayManager {
	
	JFrame gameWindow;
	Board gameBoard;
	
	DisplayManager(){
		gameWindow = new JFrame("Display Test");
		gameWindow.setSize(500, 500);
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	DisplayManager(int x, int y) {
		gameWindow = new JFrame("Display Test");
		gameWindow.setSize(x, y);
		gameWindow.setVisible(true);
		gameWindow.setResizable(false);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setBoard(Board b) {
		gameBoard = b;
	}
	
	public void drawBoardTest() {

		/*
		Color openColor = new Color(0.7f, 1.0f, 0.7f);
		Color wallColor = new Color(0.4f, 0.2f, 0.2f);
		
		int boardX = gameBoard.getXSize();
		int boardY = gameBoard.getYSize();
		int cellSize = gameBoard.getCellSize();
		
		for (int i = 0; i < boardX; i ++) {
		
			for (int j = 0; j < boardY; j++) {
				BoxDraw sqr = new BoxDraw();
				if(gameBoard.getCellType(i, j) == cellType.Open) {
					sqr.setBoxColor(openColor);
				}else {
					sqr.setBoxColor(wallColor);
				}
				sqr.setBoxVals(i * cellSize, j * cellSize, cellSize);
				gameWindow.add(sqr);
			}
		}
		*/
			BoxDraw sqr = new BoxDraw();
			sqr.setBoxColor(new Color(1.0f, 0.0f, 1.0f));
			sqr.setBoxVals(0, 0, 300);
			gameWindow.add(sqr);
			BoxDraw sqr2 = new BoxDraw();
			sqr2.setBoxColor(new Color(0.0f, 1.0f, 1.0f));
			sqr2.setBoxVals(300, 0, 500);
			gameWindow.add(sqr2);
		// Look into layouts
		// Or make this class the painting class
	}
	
	public static void main(String[] args) {
    	Board b = new Board();
    	DisplayManager d = new DisplayManager(b.getXSize() * b.getCellSize(), b.getYSize() * b.getCellSize());
    	d.setBoard(b);
    	d.drawBoardTest();
    	
	}
	
	
}

/*
Frame f= new Frame("Board Test"); 
f.setSize(40*xSize,40*ySize);    
f.setLayout(null);    
f.setVisible(true);
//f.dispose();


JFrame frame = new JFrame("Board Display Test");
frame.setSize(300, 300);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
*/