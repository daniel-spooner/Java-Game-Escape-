package com.Group12.Game;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.Group12.Game.GameMain.STATE;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.KeyAdapter;



// enum entityType { Open, Wall, Player, Enemy, Punishment, Reward, Weapon, Start, End }

@SuppressWarnings("serial")
public class DisplayManager extends JPanel{
	
	JFrame gameWindow;
	JFrame Jbutton;
	Board board;
	GameMain updateState = new GameMain();
	GameMain.STATE state = GameMain.STATE.MENU;


	
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

		
		gameWindow.addKeyListener(new KeyListener() {


			public void keyTyped(KeyEvent e) {
				// Don't need this
				
			}
			BoardEntity character = new BoardEntity();
			int x = character.getXPos();
			int y = character.getXPos();

			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				int newPos;
			
					//up
				switch(key) {
					

					case KeyEvent.VK_W:
						if(state==GameMain.STATE.GAME) {
							newPos = character.getXPos() + 1;
							character.setX(newPos);
							System.out.println(newPos);
							break;
						}
					
					//left
					case KeyEvent.VK_A:
						if(state==GameMain.STATE.GAME) {
							newPos = character.getYPos() - 1;
							character.setY(newPos);
							System.out.println(newPos);
							break;
						}
					//down
					case KeyEvent.VK_S: 
						if(state==GameMain.STATE.GAME) {
							newPos = character.getXPos() - 1;
							character.setX(newPos);
							System.out.println(newPos);
							break;
						}
					//right
					case KeyEvent.VK_D :
						if(state==GameMain.STATE.GAME) {
							newPos = character.getYPos() + 1;
							character.setY(newPos);
							System.out.println(newPos);
							break;
						}
						else {
							break;
						}

					
					//Change from Menu State to Game State pressing ENTER KEY
					//If state is already in menu, do nothing
					case KeyEvent.VK_ENTER: 
						if(state == GameMain.STATE.GAME) {
							break;
						}
						else {
							state = GameMain.STATE.GAME;
							updateState.setState(state);
							repaint();
							
						}
					break;
				
					//Change from Game State to Menu State by pressing ESC KEY
					//If state is already in Game, do nothing
					case KeyEvent.VK_ESCAPE:
						if(state == GameMain.STATE.MENU) {
							break;
						}
						else {
							state = GameMain.STATE.MENU;
							updateState.setState(state);	
							repaint();
						}
						break;

				
				}
			}
			

			public void keyReleased(KeyEvent e) {
				// Don't need this
				
			}
		});
	}

	private void dispBoard(Graphics2D g2d) {
		int boardX = this.board.getXSize();
		int boardY = this.board.getYSize();
		int cellSize = this.board.getXSize();
		
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
	 
	public void display(Board board) { // This should take arguments for all types of game objects
		this.board = board;
		gameWindow.add(this);
	}
	
	//add more methods for displaying other objects
	public void paint(Graphics g) {
		Graphics menu = (Graphics2D) g;
		Graphics2D g2d = (Graphics2D) g;
		if(state ==  GameMain.STATE.GAME) {
			dispBoard(g2d);
		}
		else if(state == GameMain.STATE.MENU) {
			dispMenu(menu);
		}

	}

// call more disp funcs here
	

	public static void main(String[] args) {
		
		Board b = new Board();
		for(int i = 0; i < b.getXSize(); i++) {
			b.setCellType(i, i%5, cellType.Wall);
		}
		
		DisplayManager d = new DisplayManager(b.getXSize() * b.getXSize(), b.getYSize() * b.getXSize());
		
    	d.display(b);
    	
	}
	
}
	


