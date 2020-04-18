package com.Group12.Game;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
	
	Cell cell;
	
	@Before
	public void setup() {
		cell = new Cell();
	}
	
	@Test
	public void testingCellConstrucor() {
		cell = new Cell(cellType.OPEN);
		cellType result = cell.getType();
		assertEquals(cellType.OPEN, result);
	}
	
	@Test
	public void testingGetType() {
		cellType result = cell.getType();
		assertEquals(cellType.OPEN, result);
	}
	
}