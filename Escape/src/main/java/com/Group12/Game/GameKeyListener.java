package com.Group12.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameKeyListener implements KeyListener {

	private int lastKey;
	public void keyPressed(KeyEvent e) {

		lastKey = e.getKeyCode();

	}
	
	public int getLastKey() {
		return lastKey;
	}
	
	public void resetLastKey() {
		lastKey = 0;
	}
			
			//left
			//case KeyEvent.VK_A:

			//down
			//case KeyEvent.VK_S: 

			//right
			//case KeyEvent.VK_D :

			
			//Change from Menu State to Game State pressing ENTER KEY
			//If state is already in menu, do nothing
			//case KeyEvent.VK_ENTER: 
				//if(state == GameMain.GameState.GAME) {
				//	break;
				//}
				//else {
				//	state = GameMain.GameState.GAME;
				//	updateState.setState(state);
				//	repaint();
					
				

			//Change from Game State to Menu State by pressing ESC KEY
			//If state is already in Game, do nothing
			//case KeyEvent.VK_ESCAPE:
				//if(state == GameMain.GameState.MENU) {
				//	break;
				//}
				//else {
				//	state = GameMain.GameState.MENU;
				//	updateState.setState(state);	
				//	repaint();
				//}
				//break;
		

	

	public void keyReleased(KeyEvent e) {
		// Don't need this
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

