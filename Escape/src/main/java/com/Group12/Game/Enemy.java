package com.Group12.Game;


public class Enemy extends BoardEntity {
	 //int HP;
	 //int x, y;
	 
	 public Enemy(int x, int y) {
		 //this.HP = 100;
		 this.xPos = x;
		 this.yPos = y;
	 }
	 
	 public void setX(int x) {
		 this.xPos = x;
	 }
	 public void setY(int y) {
		 this.yPos = y;
	 }
	 
	 public int getXPos() {
		 return xPos;
	 }
	 
	 public int getYPos() {
		 return yPos;
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
