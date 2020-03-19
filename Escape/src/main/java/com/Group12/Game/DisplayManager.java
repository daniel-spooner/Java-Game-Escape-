package com.Group12.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyListener;


/**
 * Handles graphical display.
 * @author Daniel, Wilson
 *
 */
@SuppressWarnings("serial")
public class DisplayManager extends JPanel{
	
	// Attributes
	JFrame gameWindow;
	Board board;

	//Enum to hold current state. Used when updating display
	GameMain.GameState currentState;
	
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
		//gameWindow.addKeyListener(new GameKeyListener());
	}
	//Add this function?
	public void addKeyListener(KeyListener kl) {
		gameWindow.addKeyListener(new GameKeyListener());
	}
	//Graphics to Display Game Screen
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
	//Graphics to Display the Lose Screen
	private void dispLose(Graphics lose) {
		lose.setColor(Color.black);
		lose.fillRect(0,0,800,750);
		Font fnt0 = new Font("arial", Font.BOLD, 100);
		lose.setFont(fnt0);
		lose.setColor(Color.red);
		lose.drawString("YOU LOSE",100,200);
		
	}
	//Graphics to Display the Win Screen
	private void dispWin(Graphics win) {
		win.setColor(Color.white);
		win.fillRect(0,0,800,750);
		Font fnt0 = new Font("arial", Font.BOLD, 100);
		win.setFont(fnt0);
		win.setColor(Color.red);
		win.drawString("YOU WIN",100,200);
		
	}

	/**
	 * Changes the current state of game. Called by GameMain.
	 * @param currentState the State to be changed to
	 */
	public void stateChange(GameMain.GameState currentState) {
		this.currentState = currentState;
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
		Graphics win = (Graphics2D) g;
		Graphics2D lose = (Graphics2D) g;
		if(currentState ==  GameMain.GameState.GAME) {
			dispBoard(g2d);
		}
		else if(currentState == GameMain.GameState.MENU) {
			dispMenu(menu);
		}
		else if(currentState == GameMain.GameState.WIN) {
			dispWin(win);
		}
		else if(currentState == GameMain.GameState.LOSE) {
			dispLose(lose);
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
