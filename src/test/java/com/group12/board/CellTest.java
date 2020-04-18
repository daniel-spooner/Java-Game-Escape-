package com.group12.board;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.group12.board.Cell.cellType;

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