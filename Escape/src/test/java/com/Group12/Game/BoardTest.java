package com.Group12.Game;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
	
	Board board = new Board();
	
	@Test
	void testingInBounds() {
		Board board = new Board();
		
		Boolean result = board.inBounds(0, 0);
		assertEquals(true, result);
		
		result = board.inBounds(100, 100);
		assertEquals(false, result);
	}

}
