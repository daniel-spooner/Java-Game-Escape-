package com.Group12.Game;

/**
 * Enemy Class for setting Enemy Initial position
 * @author Yuxi, Daniel
 *
 */
public class Enemy extends BoardEntity {
	 //int HP;
	 //int x, y;
	
	
	 /**
	  * Create enemy at X and Y position
	  * @param x coordinate
	  * @param y coordinate
	  */
	 public Enemy(int x, int y) {
		 //this.HP = 100;
		 this.xPos = x;
		 this.yPos = y;
	 }
	 
	 
	 /*
	 public void takeDamage(int damage) {
		 HP -= damage;
	 }
	 
	 public int getHP() {
		 return HP;
	 }
	 
	 public boolean enemyAlive(int damage) {
	 if (HP <= 0) {
	 // enemy die
		 return false;
	 	}
	 	return true;
	 }
	 */
}
