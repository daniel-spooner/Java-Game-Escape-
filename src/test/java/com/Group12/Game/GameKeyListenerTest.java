package com.group12.game;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.KeyEvent;
public class GameKeyListenerTest {
	
	
	//Lower case and upper case Characters have different Keycodes, but KeyPressed handles both cases with the same keycode
	//The lower case keycodes =  uppercase keycodes + 32
	//Boundaries of GameKeyListener Class are the keys (W,A,S,D,Enter,Escape). All other keys have no impact in the game.
	
	DisplayManager display;
	GameKeyListener test;
	@Before
	public void exectuedBeforeEach() {
		display = new DisplayManager();
		test = new GameKeyListener();
	}

		
	@Test
	public void TestingGetLastKey() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 0, 0, 0, 'A');
		test.keyPressed(e);
		assertEquals(65,test.getLastKey());
	}
	
	@Test
    public void TestingResetLastKey() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 0, 0, 0, 'A');
		test.keyPressed(e);
		 test.resetLastKey();
		 assertEquals(0,test.getLastKey());
    }

	@Test
	public void TestingKeyPressedW() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 0, 0, 0, 'W');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(87,test.getLastKey());
		
	}
	@Test
	public void TestingKeyPressedA() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'A');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(65,test.getLastKey());
		
	}
	@Test
	public void TestingKeyPressedS() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'S');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(83,test.getLastKey());
		
	}
	@Test
	public void TestingKeyPressedD() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'D');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(68,test.getLastKey());
		
	}
	@Test 
	public void TestingLowerWCaseKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'w');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(119,test.getLastKey());
		
	}	

	@Test 
	public void TestingLowerACaseKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'a');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(97,test.getLastKey());
		
	}	

	@Test 
	public void TestingLowerSCaseKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 's');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(115,test.getLastKey());
		
	}	
	@Test 
	public void TestingLowerDCaseKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'd');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(100,test.getLastKey());
		
	}
	@Test
	public void TestingOtherKeys() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'X');
		assertNotEquals(97,test.getLastKey());
		
	}
	//Virtual Key Code equivalent of Enter Key is 13
	@Test
	public void TestingEnterKey() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 10);
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(10,test.getLastKey());
	}
	//Virtual Key Code equivalent of Escape Key is 27
	@Test
	public void TestingESCKey() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 27);
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		
		assertEquals(27,test.getLastKey());
	}	

}
