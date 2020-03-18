package com.Group12.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameKeyListener implements KeyListener {
	
    private int lastKey;

    public int getLastKey() {
        return lastKey;
    }

    public void resetLastKey() {
        lastKey = 0;
    }
    
	public void keyTyped(KeyEvent e) {
		// Don't need this
	}
	
	public void keyPressed(KeyEvent e) {
        lastKey = e.getKeyCode();
    }
	

	public void keyReleased(KeyEvent e) {
		// Don't need this
	}
}

