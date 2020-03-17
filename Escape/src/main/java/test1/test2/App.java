package test1.test2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Main application (maybe GameMain.startGame() plus a visualizer). 
 * Opens a window, listens to keyboard inputs, has a task run every "timerLength" seconds.
 * @author Nicholas
 *
 */
public class App 
{
	private static EscapeGameWindow window;
	private static Timer timer;
	
    public static void main( String[] args )
    {
    	int timerLength = 3; 	// in seconds
    	int timerMilli = timerLength * 1000;
    	
    	App.window = new EscapeGameWindow(timerMilli);
    	App.timer = new Timer();
    	
    	TimerTask keyGetter = new TimerTask() {
    		public void run() {
		    	EscapeGameKeyListener kl = App.window.getKeyListener();
		    	String lastKey = kl.getLastKey();
		    	
		    	System.out.println(lastKey);
		    	
		    	// New cycle means new lastKey tracking:
		    	kl.resetLastKey();
		    	
		    	// Cancelling the timer will actually be called by outer function update() if the game has ended
		    	if (lastKey.equals("Escape")) {
		    		App.timer.cancel();
		    		System.out.println("Cancelling Timer!");
		    	}
		    	
		    	// Current proposed chain of events:
		    	// update(lastKey); which does
		    	// 	updatePlayer(lastKey); should handle player movement/shooting, returns void
		    	//	updateEnemies(); should handle enemy movement/"collision" (if any position intersects mainChar)
		    	// 	win/lose condition logic at end of update()
		    	// In run(), however, just the line "update(lastKey);" is all that would be needed
		    }
    	};
    	
    	// Starts the timer 3 seconds after main()
    	App.timer.scheduleAtFixedRate(keyGetter, (long) timerMilli, (long) timerMilli);
    	
    }
}
