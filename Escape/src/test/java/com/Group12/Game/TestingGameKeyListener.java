package com.Group12.Game;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.Group12.Game.GameMain.GameState;

import java.awt.event.KeyEvent;
public class TestingGameKeyListener {
	
	
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
	public void getLastKeyMethodTest() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 0, 0, 0, 'A');
		test.keyPressed(e);
		assertEquals(65,test.getLastKey());
	}
	
	@Test
    public void resetLastKeyMethodTest() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(display, 0, 0, 0, 'A');
		test.keyPressed(e);
		 test.resetLastKey();
		 assertEquals(0,test.getLastKey());
    }

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
	}	GameMain main;
	TickTimer tick;
	
	@Before 
	public void createNewGameMain() {
		main = GameMain.getInstance();
		main.startGame();
		tick = new TickTimer(25);
		main.setTickTimer(tick);
		Thread t = new Thread(tick);
		t.start();
		tick.pauseTick();
	}

	//Testing if hitting the Enter Key Results in changing the GameState from Menu to Game within GameMain
    @Test
	public void keyboardInputChangingGameStatetoGame() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(main.getDisplay(), 1, 20, 1, 10);
		main.getKeyListener().keyPressed(e);
		main.update(false);

		assertEquals(main.getState(),GameState.GAME);
	
	}	
    
    //Testing if hitting the Escape Key Results in changing the GameState from Game to Menu.
	@Test
	public void keyboardInputChangingGameStatetoMenu() {
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(main.getDisplay(), 1, 20, 1, 10);
		main.getKeyListener().keyPressed(e);
		main.update(false);
		@SuppressWarnings("deprecation")
		KeyEvent e1 = new KeyEvent(main.getDisplay(), 1, 20, 1, 27);
		main.getKeyListener().keyPressed(e1);
		main.update(false);

		assertEquals(main.getState(),GameState.MENU);
	
	}
	
	
	

	


}
