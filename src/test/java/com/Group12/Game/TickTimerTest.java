package com.Group12.Game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TickTimerTest {
	
	TickTimer t;
	
	@Before
	public void setup() {
		t = new TickTimer();
	}
	
	@Test
	public void testingGetTickCount() {
		t.resetTickCount();
		int result = (int)t.getTickCount();
		assertEquals(0, result);
	}

	@Test
	public void testingPauseTick() {
		// not sure how to test these methods with an assertion, so just running them
		t.pauseTick();
		t.unpauseTick();
	}
	
}