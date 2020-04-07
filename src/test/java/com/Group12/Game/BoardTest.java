package com.Group12.Game;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	
	Board board;
	
	@Before
	public void setup() {
		board = new Board();
	}
	
	@Test
	public void testingBoardConstructor2arg() {
		board = new Board(10, 15);
		int result = board.getXSize();
		assertEquals(10, result);
		result = board.getYSize();
		assertEquals(15, result);
	}
	
	
	
	@Test
	public void testingInBounds() {
		Boolean result;
		result = board.inBounds(0, 0);
		assertEquals(true, result);
		result = board.inBounds(100, 100);
		assertEquals(false, result);
		result = board.inBounds(0, 100);
		assertEquals(false, result);
		result = board.inBounds(100, 0);
		assertEquals(false, result);
		
	}
	
	@Test
	public void testingGetCellType() {
		cellType result = board.getCellType(0, 0);
		assertEquals(cellType.OPEN, result);
	}
	
	
	@Test
	public void testingSetCellType() {
		board.setCellType(0, 0, cellType.BARRIER);
		cellType result = board.getCellType(0, 0);
		assertEquals(cellType.BARRIER, result);
	}
	
	@Test
	public void testingGetCellSize() {
		int result = board.getCellSize();
		assertEquals(30, result);
	}
	
	@Test
	public void testingGetXSize() {
		int result = board.getXSize();
		assertEquals(25, result);
	}
	
	@Test
	public void testingGetYSize() {
		int result = board.getYSize();
		assertEquals(20, result);
	}
	
	@Test
	public void testingSetCellSize() {
		board.setCellSize(10);
		int result = board.getCellSize();
		assertEquals(10, result);
	}
	
	@Test
	public void testingSetXSize() {
		board.setXSize(10);
		int result = board.getXSize();
		assertEquals(10, result);
	}
	
	@Test
	public void testingSetYSize() {
		board.setYSize(10);
		int result = board.getYSize();
		assertEquals(10, result);
	}
	
}
