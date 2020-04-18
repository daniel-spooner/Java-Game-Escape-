package com.group12.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Handles Key Inputs
 * @author Wilson, Nicholas
 *
 */
public class GameKeyListener implements KeyListener {
	
    private int lastKey;    

    /**
     * Getter method for more recent key pressed.
     * @return integer equivalent of Virtual Key Code
     */
    public int getLastKey() {
        return lastKey;
    }
    
    /**
     * Resets the lastKey to 0. 0 in Virtual Key Code represents nothing. 
     */
    public void resetLastKey() {
        lastKey = 0;
    }
    
    /**
	 * Obtains the most recent key pressed.
	 */
	public void keyPressed(KeyEvent e) {
        lastKey = e.getKeyCode();
    }

	public void keyReleased(KeyEvent e) {
		// Don't need this
	}
    
	public void keyTyped(KeyEvent e) {
		// Don't need this
	}
}

