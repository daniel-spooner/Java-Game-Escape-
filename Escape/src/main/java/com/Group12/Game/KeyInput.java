package com.Group12.Game;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.awt.event.KeyAdapter;


public class KeyInput extends KeyAdapter implements KeyListener{
	
	BoardEntity character = new BoardEntity();
	int x = character.getXPos();
	int y = character.getXPos();

	
	public void keyDemo(){

		
		JFrame frame = new JFrame();
	    frame.setSize(300, 300);
	    frame.setVisible(true);
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// NO NEED
			}

			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				int newPos;
				

					//up
					if(key == KeyEvent.VK_W) {
						newPos = character.getXPos() + 1;
						character.setX(newPos);
						System.out.println(newPos);
					}
					//left
					else if(key == KeyEvent.VK_A) {
						newPos = character.getYPos() - 1;
						character.setY(newPos);
						System.out.println(newPos);
					}
					//down
					else if(key == KeyEvent.VK_S) {
						newPos = character.getXPos() - 1;
						character.setX(newPos);
						System.out.println(newPos);
					}//right
					else if(key == KeyEvent.VK_D) {
						newPos = character.getYPos() + 1;
						character.setY(newPos);
						System.out.println(newPos);
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
				

			@Override
			public void keyReleased(KeyEvent e) {
				// NO NEED
				
			} 
		
		
	
		
		
		
		});
	}




	public static void main(String[] args) {
		KeyInput asdf = new KeyInput();
		asdf.keyDemo();
		System.out.println("hi");
		
	}



}
