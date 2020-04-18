package com.group12.game;

/**
 * Runs GameMain.update() some number of times per second,
 * and keeps track of how many milliseconds have passed since beginning execution.
 * @author Daniel, Yuxi Hu
 *
 */
public class TickTimer implements Runnable {

	private boolean tickActive;
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
		this.delay = 1000/fps;
		this.game = GameMain.getInstance();
	}
 
	public void runTick() {
		boolean updateEnemy = true;
		while (true) {
			game.update(updateEnemy);
			try {
				Thread.sleep(delay/2);
			} catch (Exception e) {
				System.out.println(e);
			}
		
			if (tickActive) {
				tickCount += delay;
			}
			
			updateEnemy = !updateEnemy;
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
			//runTick();
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
	
//	public static void main(String[] args) throws Exception {
//		Thread t = new Thread(new TickTimer());
//		t.start();
//
//	}
} 

