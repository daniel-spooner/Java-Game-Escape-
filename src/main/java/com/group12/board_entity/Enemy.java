package com.group12.board_entity;

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
		 this.xPos = x;
		 this.yPos = y;
	 }
	 public Enemy() {
		 super();
	 }
	 
	 
	
}
