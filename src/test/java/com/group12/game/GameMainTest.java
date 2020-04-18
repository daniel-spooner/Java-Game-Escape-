package com.group12.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameMainTest {
	
	GameMain gm = GameMain.getInstance();
	TickTimer tick;
	
	@Test
	public void testingGetInstance() {
		GameMain gm2 = GameMain.getInstance();
		assertTrue(gm2 == gm);	// pointer match, not value
	}
	
	// How do you do unit tests on a singleton?
	// Also, this is an integration test
	
	@Test
	public void testingStartGameAndGetScoreAndSetStateAndUpdate() {
		tick = new TickTimer(7);
		gm.setTickTimer(tick);
		
		gm.startGame();
		assertEquals(500, gm.getScore());
		
		Thread t = new Thread(tick);
		t.start();

		tick.pauseTick();
		assertEquals(0, tick.getTickCount());
		
		// simulate game unpaused
		tick.unpauseTick();
		gm.setState(GameMain.GameState.GAME);
		
		// check that GameMain properly calls resetTickCount at least once
		boolean postResetLow = false;
		boolean preResetHigh = false;
		
		while (tick.getTickCount() <= 2000) {	// should not reach twice the reset point
			
			// this is strange; the value of getTickCount() is not updated properly unless this line is here
			System.out.println(tick.getTickCount());
			
			if (preResetHigh) {
				if (postResetLow) {
					tick.pauseTick();
					gm.setState(GameMain.GameState.MENU);
					break;
				}
				else if (tick.getTickCount() <= 500) {
					postResetLow = true;
				}
			}
			else if (tick.getTickCount() > 500) {
				preResetHigh = true;
			}
		}
		
		assertTrue("tickCount should reach above 500 before a loop",	preResetHigh);
		assertTrue("tickCount should reach below 500 after a loop", 	postResetLow);

	}
	
}
