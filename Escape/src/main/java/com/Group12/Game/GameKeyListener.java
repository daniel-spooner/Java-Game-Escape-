package com.Group12.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
	public void keyTyped(KeyEvent e) {
		// Don't need this
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		int newPos;
		
		switch(key) {
			
			//up
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
}

