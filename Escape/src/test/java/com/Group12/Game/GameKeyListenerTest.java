package com.Group12.Game;

import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.event.KeyEvent;
import java.util.Scanner;
public class GameKeyListenerTest {
	
	
	//Lower case and upper case Characters have different keycodes but the game works with either inputs!?

	//The lower case (keycodes =  uppercase keycodes + 32) !?


	@Test
	public void testingWKey() {
		DisplayManager display = new DisplayManager();
		GameKeyListener test = new GameKeyListener();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 0, 0, 0, 'W');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(87,test.getLastKey());
		
	}
	@Test
	public void testingAKey() {
		DisplayManager display = new DisplayManager();
		GameKeyListener test = new GameKeyListener();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'A');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(65,test.getLastKey());
		
	}
	@Test
	public void testingSKey() {
		DisplayManager display = new DisplayManager();
		GameKeyListener test = new GameKeyListener();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'S');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(83,test.getLastKey());
		
	}
	@Test
	public void testingDKey() {
		DisplayManager display = new DisplayManager();
		GameKeyListener test = new GameKeyListener();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'D');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(68,test.getLastKey());
		
	}
	@Test 
	public void testingLowerWCaseKey() {
		DisplayManager display = new DisplayManager();
		GameKeyListener test = new GameKeyListener();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'w');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(119,test.getLastKey());
		
	}	

	@Test 
	public void testingLowerACaseKey() {
		DisplayManager display = new DisplayManager();
		GameKeyListener test = new GameKeyListener();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'a');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(97,test.getLastKey());
		
	}	

	@Test 
	public void testingLowerSCaseKey() {
		DisplayManager display = new DisplayManager();
		GameKeyListener test = new GameKeyListener();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 's');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(115,test.getLastKey());
		
	}	@Test 
	public void testingLowerDCaseKey() {
		DisplayManager display = new DisplayManager();
		GameKeyListener test = new GameKeyListener();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'd');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(100,test.getLastKey());
		
	}

	
	


}
