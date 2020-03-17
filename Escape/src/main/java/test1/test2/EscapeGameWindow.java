package test1.test2;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 * This is the window. It has the KeyListener, the JFrame, and the progress bar we may not get around to using.
 * @author Nicholas
 *
 */
public class EscapeGameWindow {
	
	private JFrame frame;
	private EscapeGameKeyListener keyListener;
	private JProgressBar progressBar;
	
	public EscapeGameWindow(int taskLength) {
		frame = new JFrame();
		keyListener = new EscapeGameKeyListener();
		frame.add(keyListener);
		frame.setSize(1280, 720);

		buildProgressBar(taskLength);
		frame.add(progressBar);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//	TODO: actual updating of the progress bar, figuring out how to size it down and to the side 
		//	(less important than actual logic)
		progressBar.setValue(taskLength-100);
	}
	
	private void buildProgressBar(int taskLength) {
		progressBar = new JProgressBar(0, taskLength);
		progressBar.setValue(taskLength);
	}
	
	public EscapeGameKeyListener getKeyListener() {
		return keyListener;
	}

}
