package com.Group12.Game;


public class TickTimer implements Runnable {

   //Thread t;
	int FPS;
	int delay;
	long tickCount;
	// long maxCount;
	Boolean tickActive;
   
	public TickTimer() {
		this(30);
	}

	public TickTimer(int FPS) {
		this.FPS = FPS;
		this.delay = 1000/FPS;
	}
 
	private void runTick() {
		if (tickActive) {
			try {
				Thread.sleep(delay);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			tickCount += delay;
			
			/*
			System.out.println(tickCount);
			if (tickCount > 5000) {
				pauseTick();
			}
			*/
			
			runTick();
		}
	}
	
	public void pauseTick() {
		tickActive = false;
	}
	
	public void unpauseTick() {
		tickActive = true;
		runTick();
	}
	
	public void resetTickCount() {
		tickCount = 0;
	}
   
	
	public void run() {
		tickCount = 0;
		tickActive = true;
		//System.out.println("Delay: " + delay);
		runTick();
	}
   
   
	public static void main(String[] args) throws Exception {
      
		Thread t = new Thread(new TickTimer());
		t.start();
      
	}
} 

