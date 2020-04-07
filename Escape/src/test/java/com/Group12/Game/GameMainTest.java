package com.Group12.Game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameMainTest {
	
	GameMain gm = GameMain.getInstance();
	TickTimer tick;
	
	@Test
	public void testingGetScore() {
		assertEquals(0, gm.getScore());
	}
	
	@Test
	public void testingGetInstance() {
		assertEquals(0, gm.getScore());
		GameMain gm2 = GameMain.getInstance();
		assertTrue(gm2 == gm);	// pointer match, not value
	}

	@Test
	public void testingStartGame() {
		gm.startGame();
		assertEquals(500, gm.getScore());
	}
	
	// Integration test
	
	@Test
	public void testingUpdate() {
		
	}
	
}
