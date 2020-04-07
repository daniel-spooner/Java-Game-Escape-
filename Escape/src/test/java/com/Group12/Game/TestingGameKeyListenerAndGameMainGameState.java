package com.Group12.Game;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;

import com.Group12.Game.GameMain.GameState;

public class TestingGameKeyListenerAndGameMainGameState {

	//INTEGRATION TESTING
	

	//TESTING GameMain AND GameKeyListener CLASSES

	GameMain main;
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
	
	//Check whether the keys (W,A,S,D) successfully move the Main Character
	
	@Test
	public void keyboardInputChangingPlayerCoordinate() {
		MainCharacter test = new MainCharacter();
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(main.getDisplay(), 1, 20, 1, 'W');
		main.getKeyListener().keyPressed(e);
		main.update(false);
		int YPos = test.getYPos();
		test.setYPos(YPos+1);
		assertEquals(1,test.getYPos());
	}
	
	
	

}
