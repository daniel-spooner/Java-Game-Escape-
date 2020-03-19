package com.Group12.Game;

/**
 * Runs GameMain.update() some number of times per second,
 * and keeps track of how many milliseconds have passed since beginning execution.
 * @author Daniel
 *
 */
public class TickTimer implements Runnable {

	private boolean tickActive;
	private int fps;
	private int delay;
	private long tickCount;
	// private long maxCount;
	private GameMain game;
	
	/** 
	 * Default constructor.
	 */
	public TickTimer() { // Defaults to 50 fps
		this(50);
	}
	
	/**
	 * Creates a TickTimer with a number of function calls per second.
	 * @param fps "function-calls" per second 
	 */
	public TickTimer(int fps) {
		this.fps = fps;
		this.delay = 1000/fps;
		this.game = GameMain.getInstance();
	}
 
	private void runTick() {
		if (tickActive) {
			
			//game.placeholder();
			game.update();
			
			try {
				Thread.sleep(delay);
			} catch (Exception e) {
				System.out.println(e);
			}
			tickCount += delay;
			
			runTick();
		}
	}
	
	/**
	 * Pauses the TickTimer, causing it to stop running after its next loop.
	 */
	public void pauseTick() {
		tickActive = false;
	}
	
	/**
	 * Unpauses the TickTimer, causing it to continue running after being paused.
	 */
	public void unpauseTick() {
		if(!tickActive) {
			tickActive = true;
			runTick();
		}
	}
	
	/**
	 * Gets the current count of milliseconds since reset.
	 * @return milliseconds since reset
	 */
	public long getTickCount() {
		return tickCount;
	}
	
	/**
	 * Resets the current tracker of milliseconds.
	 */
	public void resetTickCount() {
		tickCount = 0;
	}
   
	/**
	 * Starts the main execution loop of TickTimer.
	 */
	public void run() {
		tickCount = 0;
		tickActive = true;
		
		runTick();
	}
	
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new TickTimer());
		t.start();

	}
} 

