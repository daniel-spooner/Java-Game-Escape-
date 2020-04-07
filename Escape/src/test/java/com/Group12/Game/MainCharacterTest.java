package com.Group12.Game;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainCharacterTest {
	
	//The boundary of when health will change state are ( Health > 0) and ( Health <= 0).

	//Checks if Initial health is set to 100.
	@Test
	public void	initialHealth() {
		MainCharacter test = new MainCharacter();
		int output = test.getHealth();
		assertEquals(100,output);
	}
	//Checks if taking damage one time from initial health will set health to be < 0 (It shouldn't).
	@Test
	public void decreaseHealthByOne() {
		MainCharacter test = new MainCharacter();
		boolean output = test.decHealth();
		assertEquals(true,output);
		
	}
	//Checks if decreasing the health <= 0, the function decHealth() should return false. The player is dead.
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
	//Checks if decreasing the health to 1, the function decHealth() should return true. The player is alive with 1 Health Point.
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
	
	//Tests checkAlive() method. Brining the main char health down to 0 should have the method return false.
	@Test
	public void MainCharDead() {
		MainCharacter test = new MainCharacter();	
		//Decrease the health 100 times from initial 100 health.
		for(int i = 0; i<100; i++) {
			test.decHealth();
		}
		boolean output = test.checkAlive();
		assertEquals(false,output);
		
	}	
	
	//Tests checkAlive() method. Brining the main char health down to 1 should have the method return true.
	@Test
	public void MainCharAlive() {
		MainCharacter test = new MainCharacter();	
		//Decrease the health 100 times from initial 100 health.
		for(int i = 0; i<99; i++) {
			test.decHealth();
		}
		boolean output = test.checkAlive();
		assertEquals(true,output);
		
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
