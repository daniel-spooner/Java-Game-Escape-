package com.Group12.Game;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnemyTest {

	@Test
	public void testEnemyDefault() {
		Enemy e= new Enemy();
		assertEquals(0, e.getXPos());
		assertEquals(0, e.getYPos());
	}

}
