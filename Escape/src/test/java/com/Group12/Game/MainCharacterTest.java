package com.Group12.Game;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainCharacterTest {

	//Checks if Initial health is set to 100
	@Test
	public void	initialHealth() {
		MainCharacter test = new MainCharacter();
		int output = test.getHealth();
		assertEquals(100,output);
	}
	//
	@Test
	public void decreaseHealthByOne() {
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
	public void decreaseHealthTo99() {
		MainCharacter test = new MainCharacter();
		boolean output = true;
		//Decrease the health 100 times from initial 100 health.
		for(int i = 0; i<99; i++) {
			output = test.decHealth();
		}
		assertEquals(true,output);
		
	}
	@Test
	public void checkIfAlive() {
		MainCharacter test = new MainCharacter();	
		//Decrease the health 100 times from initial 100 health.
		for(int i = 0; i<100; i++) {
			test.decHealth();
		}
		boolean output = test.checkAlive();
		assertEquals(false,output);
		
	}	
	@Test
	public void mainCharXPos() {
		MainCharacter test = new MainCharacter();
		int XPos = test.getXPos();
		test.setXPos(XPos+1);
		assertEquals(1,test.getXPos());
		XPos = test.getXPos();
		test.setXPos(XPos-1);
		assertEquals(0,test.getXPos());
		
	}
	@Test
	public void mainCharYPos() {
		MainCharacter test = new MainCharacter();
		int YPos = test.getYPos();
		test.setYPos(YPos+1);
		assertEquals(1,test.getYPos());
		YPos = test.getYPos();
		test.setYPos(YPos-1);
		assertEquals(0,test.getYPos());
		
	}


}
