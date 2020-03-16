package com.Group12.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

// enum entityType { Open, Wall, Player, Enemy, Punishment, Reward, Weapon, Start, End }

@SuppressWarnings("serial")
public class DisplayManager extends JPanel{
	
	JFrame gameWindow;
	Board board;
	
	DisplayManager(){
		gameWindow = new JFrame("Escape");
		gameWindow.setSize(500, 500);
		gameWindow.setVisible(true);
		gameWindow.setResizable(false);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	DisplayManager(int sizeX, int sizeY) {
		gameWindow = new JFrame("Escape");
		
		gameWindow.setResizable(false);
		this.setPreferredSize(new Dimension(sizeX, sizeY));
		gameWindow.add(this);
		gameWindow.pack();
		
		gameWindow.setVisible(true);
	    gameWindow.setLocationRelativeTo(null);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void dispBoard(Graphics2D g2d) {
		int boardX = this.board.getXSize();
		int boardY = this.board.getYSize();
		int cellSize = this.board.getCellSize();
		
		for(int y = 0; y < boardY; y++) {
			for(int x = 0; x < boardX; x++) {
				if(this.board.getCellType(x, y) == cellType.Open) {
					g2d.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
				}else {
					g2d.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
				}
				g2d.fillRect(x*cellSize, y*cellSize, cellSize, cellSize);
			}
		}
	}
	
	public void display(Board board) { // This should take arguments for all types of game objects
		this.board = board;
		gameWindow.add(this);
	}
	
	//add more methods for displaying other objects
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		dispBoard(g2d);
		// call more disp funcs here
	}
	
	public static void main(String[] args) {
		
		Board b = new Board();
		for(int i = 0; i < b.getXSize(); i++) {
			b.setCellType(i, i%5, cellType.Wall);
		}
		
		DisplayManager d = new DisplayManager(b.getXSize() * b.getCellSize(), b.getYSize() * b.getCellSize());
		
    	d.display(b);
    	
	}
}
