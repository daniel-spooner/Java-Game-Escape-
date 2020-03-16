package com.Group12.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;


public class KeyInput extends KeyAdapter{
	
	BoardEntity character;
	
	public void keyInput(BoardEntity character) {
		this.character = character;
	}
	public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	int newPos;
	

	//up
	if(key == KeyEvent.VK_W) {
		newPos = character.getXPos() + 1;
		character.setX(newPos);
	}
	//left
	else if(key == KeyEvent.VK_A) {
		newPos = character.getYPos() - 1;
		character.setY(newPos);
	}
	//down
	else if(key == KeyEvent.VK_S) {
		newPos = character.getXPos() - 1;
		character.setX(newPos);
	}//right
	else if(key == KeyEvent.VK_D) {
		newPos = character.getYPos() + 1;
		character.setY(newPos);
	}
	else if(key == KeyEvent.VK_LEFT) {
		//shoot
	}
	else if(key == KeyEvent.VK_RIGHT) {
		//shoot
	}
	else if(key == KeyEvent.VK_UP) {
		//shoot
	}
	else if(key == KeyEvent.VK_DOWN) {
		//shoot             
	}
	}



}