package test1.test2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * This is a KeyListener with a single attribute. There's probably a way to do an inner class in the window.
 * @author Nicholas
 *
 */
public class EscapeGameKeyListener extends JPanel {
	
	// Attributes
	private String lastKey = "";

	// Methods
	public EscapeGameKeyListener() {
		KeyListener listener = new KeyListener() {
			public void keyTyped(KeyEvent e) {
				// Should never happen
			}

			public void keyPressed(KeyEvent e) {
				lastKey = KeyEvent.getKeyText(e.getKeyCode());
			}

			public void keyReleased(KeyEvent e) {
				// Should not be reacted to
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}
	
	/**
	 * Returns the last key that was pressed.
	 * @return lastKey This is a string.
	 */
	public String getLastKey() {
		return lastKey;
	}

	/**
	 * Resets the 'lastKey' variable to an empty string.
	 */
	public void resetLastKey() {
		lastKey = "";
	}
	
}
