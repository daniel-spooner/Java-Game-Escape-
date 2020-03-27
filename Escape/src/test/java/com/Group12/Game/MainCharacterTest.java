package com.Group12.Game;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainCharacterTest {

	
	@Test
	public void	initialHealth() {
		MainCharacter test = new MainCharacter();
		int output = test.getHealth();
		assertEquals(100,output);
	}
	@Test
	public void decHealthByOne() {
		MainCharacter test = new MainCharacter();
		boolean output = test.decHealth();
		assertEquals(true,output);
		
	}
	@Test
	public void decreaseHealthToZero() {
		MainCharacter test = new MainCharacter();
		boolean output = true;
		//Decrease the health 100 times from initial 100 health.
		for(int i = 0; i<100; i++) {
			output = test.decHealth();
		}
		assertEquals(false,output);
		
	}
	@Test
	public void checkIfAlive() {
		MainCharacter test = new MainCharacter();
		
		//
		for(int i = 0; i<100; i++) {
			test.decHealth();
		}
		boolean output = test.checkAlive();
		assertEquals(false,output);
		
	}
	

}
