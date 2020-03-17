package com.Group12.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
public class MainCharacter implements BoardEntity {
	private int x;
	private int y;
	private int health = 100;
	private Collectible col;
	private Weapon gun;
	 public MainCharacter(int x, int y) {
		 this.health = 100;
		 this.x = x;
		 this.y = y;
		 this.gun = new Weapon();
	 }
	
	public int getHealth() {
		return health;
	}
	
	//setHealth changes current health to current health - damage for more flexibility.
	//best to rename to damageHealth instead
	public void setHealth(int damage) {
		health = getHealth() - damage; 
		
	}
	
	//Checks if get Health is equal to 0, and returns state of player.
	public boolean checkAlive() {
		if(getHealth() == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public int getXPos() {
		return x;
	
	}
	
	public int getYPos() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		int newPos;
		
	
		//up
		if(key == KeyEvent.VK_W) {
			newPos = getXPos() + 1;
			setX(newPos);
			
		}
		//left
		else if(key == KeyEvent.VK_A) {
			newPos = getYPos() - 1;
			setY(newPos);
		}
		//down
		else if(key == KeyEvent.VK_S) {
			newPos = getXPos() - 1;
			setX(newPos);
		}//right
		else if(key == KeyEvent.VK_D) {
			newPos = getYPos() + 1;
			setY(newPos);
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

	
	public static void main (String args[]) {
	/*	MainCharacter asdf = new MainCharacter();
		int z = asdf.getHealth();
		System.out.println(z);
		
		asdf.setHealth(50);
		boolean y =asdf.checkAlive();
		z = asdf.getHealth();
		System.out.println(y);
		System.out.println(z);
		
		asdf.setHealth(50);
		y =asdf.checkAlive();
		z = asdf.getHealth();
		System.out.println(y);
		System.out.println(z);
		*/
		
	}
}



	





