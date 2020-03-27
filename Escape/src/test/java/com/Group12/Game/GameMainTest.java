package com.Group12.Game;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameMainTest {

	@Test
	public void test() {
		GameMain test = GameMain.getInstance();
		
		int output = test.getScore();
		assertEquals(0,output);
	}

}
