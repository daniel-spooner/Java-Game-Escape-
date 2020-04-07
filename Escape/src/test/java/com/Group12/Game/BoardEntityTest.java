package com.Group12.Game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BoardEntityTest {
	
	BoardEntity be;
	int x = 5;
	int y = 10;
	
	@Before
	public void setupTests() {
		be = new BoardEntity(x, y);
	}
	
	@Test
	public void testingGetXPos() {
		
	}
	
	@Test
	public void testingGetYPos() {
		
	}
	
	@Test
	public void testingDefaultConstructor() {
		be = new BoardEntity();
		assertEquals("x should be 0 by default", 0, be.getXPos());
		assertEquals("y should be 0 by default", 0, be.getYPos());
	}
	
	@Test
	public void testingRegularConstructor() {
		
	}
	
	@Test
	public void testingSetXPos() {
		
	}
	
	@Test 
	public void testingSetYPos() {
		
	}
	
}
