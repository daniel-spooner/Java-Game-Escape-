package com.Group12.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;


public class KeyInput extends KeyAdapter{
	
	MainCharacter character;
	
	public void keyInput(MainCharacter character) {
		this.character = character;
	}

	public void keyPressed(KeyEvent e) {
		character.keyPressed(e);
		
	}

}
