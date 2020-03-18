package com.Group12.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * Handles graphical display and keyboard input.
 * @author Daniel, Wilson
 *
 */
@SuppressWarnings("serial")
public class DisplayManager extends JPanel{
	
	// Attributes
	JFrame gameWindow;
	Board board;
	GameMain updateState = new GameMain();
	GameMain.STATE state = GameMain.STATE.MENU;

	
	
	// are these constructors private or public or what?
	DisplayManager(){
		this(500, 500);
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
		gameWindow.addKeyListener(new GameKeyListener()); //TODO: make this an object passed by GameMain
	}


	private void dispBoard(Graphics2D g2d) {
		int boardX = this.board.getXSize();
		int boardY = this.board.getYSize();
		int cellSize = this.board.getXSize();
		
		for(int y = 0; y < boardY; y++) {
			for(int x = 0; x < boardX; x++) {
				if(this.board.getCellType(x, y) == cellType.OPEN) {
					g2d.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
				}else {
					g2d.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
				}
				g2d.fillRect(x*cellSize, y*cellSize, cellSize, cellSize);
			}
		}
	}
	//Graphics to Display the Menu Screen
	private void dispMenu(Graphics menu) {
		menu.setColor(Color.black);
		menu.fillRect(0,0,800,750);
		Font fnt0 = new Font("arial", Font.BOLD, 100);
		menu.setFont(fnt0);
		menu.setColor(Color.red);
		menu.drawString("ESCAPE",100,100);
		Font fnt1 = new Font("arial", Font.BOLD,45);
		menu.setFont(fnt1);
		menu.setColor(Color.blue);
		menu.drawString("Play",100,200);
		menu.drawString("Settings",100,300);
		menu.drawString("Help",100,400);

	}
	
	/**
	 * Displays a Board onto the game window.
	 * @param board the board to be displayed
	 */
	public void display(Board board) { // This should take arguments for all types of game objects
		this.board = board;
		gameWindow.add(this);
		repaint();
	}
	
	// TODO: add more methods for displaying other objects
	
	/**
	 * does something idk
	 */
	public void paint(Graphics g) {
		Graphics menu = (Graphics2D) g;
		Graphics2D g2d = (Graphics2D) g;
		if(state ==  GameMain.GameState.GAME) {
			dispBoard(g2d);
		}
		else if(state == GameMain.GameState.MENU) {
			dispMenu(menu);
		}
        //call more disp funcs here
	}
	
	public static void main(String[] args) {
		Board b = new Board();
		for(int i = 0; i < b.getXSize(); i++) {
			b.setCellType(i, i%5, cellType.BARRIER);
		}
		
		DisplayManager d = new DisplayManager(b.getXSize() * b.getXSize(), b.getYSize() * b.getXSize());
		
    	d.display(b);

	}
}
