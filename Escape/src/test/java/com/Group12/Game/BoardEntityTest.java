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
		assertEquals(x, be.getXPos());
	}
	
	@Test
	public void testingGetYPos() {
		assertEquals(y, be.getYPos());
	}
	
	@Test
	public void testingDefaultConstructor() {
		be = new BoardEntity();
		assertEquals("x should be 0 by default", 0, be.getXPos());
		assertEquals("y should be 0 by default", 0, be.getYPos());
	}
	
	@Test
	public void testingParameterizedConstructor() {
		be = new BoardEntity(3, 6);
		assertEquals("x should be 3", 3, be.getXPos());
		assertEquals("y should be 6", 6, be.getYPos());
	}
	
	@Test
	public void testingSetXPos() {
		be.setXPos(15);
		assertEquals(15, be.getXPos());
	}
	
	@Test 
	public void testingSetYPos() {
		be.setYPos(30);
		assertEquals(30, be.getYPos());
	}
	
}
