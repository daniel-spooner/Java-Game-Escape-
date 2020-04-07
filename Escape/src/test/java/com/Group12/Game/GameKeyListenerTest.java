package com.Group12.Game;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Group12.Game.GameMain.GameState;

import java.awt.event.KeyEvent;
public class GameKeyListenerTest {
	
	
	//Lower case and upper case Characters have different Keycodes, but KeyPressed handles both cases with the same keycode
	//The lower case keycodes =  uppercase keycodes + 32
	//Boundaries of GameKeyListener Class are the keys (W,A,S,D,Enter,Escape). All other keys have no impact in the game.
	
	DisplayManager display = new DisplayManager();
	GameKeyListener test = new GameKeyListener();

	@Test
	public void testingWKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 0, 0, 0, 'W');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(87,test.getLastKey());
		
	}
	@Test
	public void testingAKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'A');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(65,test.getLastKey());
		
	}
	@Test
	public void testingSKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'S');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(83,test.getLastKey());
		
	}
	@Test
	public void testingDKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'D');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(68,test.getLastKey());
		
	}
	@Test 
	public void testingLowerWCaseKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'w');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(119,test.getLastKey());
		
	}	

	@Test 
	public void testingLowerACaseKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'a');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(97,test.getLastKey());
		
	}	

	@Test 
	public void testingLowerSCaseKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 's');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(115,test.getLastKey());
		
	}	
	@Test 
	public void testingLowerDCaseKey() {

		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 'd');
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(100,test.getLastKey());
		
	}
	//Virtual Key Code equivalent of Enter Key is 13
	@Test
	public void testingEnterKey() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 10);
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		assertEquals(10,test.getLastKey());
	}
	//Virtual Key Code equivalent of Escape Key is 27
	@Test
	public void testingESCKey() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 27);
		test.keyPressed(e);
		//System.out.println(test.getLastKey());
		
		assertEquals(27,test.getLastKey());
	}
	//Integration Test
	
	//Testing if hitting the Enter Key Results in changing the GameState from Menu to Game.
	@Test
	public void keyboardInputChangingGameStatetoGame() {
		GameMain main = GameMain.getInstance();
		DisplayManager display = new DisplayManager();
		
		main.startGame();
		TickTimer tick = new TickTimer(25);
		main.setTickTimer(tick);
		Thread t = new Thread(tick);
		t.start();
		
		tick.pauseTick();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 10);
		main.keyListener.keyPressed(e);
		main.update(false);

		assertEquals(main.getState(),GameState.GAME);
	
	}	//Testing if hitting the Escape Key Results in changing the GameState from Game to Menu.
	@Test
	public void keyboardInputChangingGameStatetoMenu() {
		GameMain main = GameMain.getInstance();
		DisplayManager display = new DisplayManager();
		
		main.startGame();
		TickTimer tick = new TickTimer(25);
		main.setTickTimer(tick);
		Thread t = new Thread(tick);
		t.start();
		
		tick.pauseTick();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 1, 20, 1, 10);
		main.keyListener.keyPressed(e);
		main.update(false);
		@SuppressWarnings("deprecation")
		KeyEvent e1 = new KeyEvent(display, 1, 20, 1, 27);
		main.keyListener.keyPressed(e1);
		main.update(false);

		assertEquals(main.getState(),GameState.MENU);
	
	}
	
	
	


}
