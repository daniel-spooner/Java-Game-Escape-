package com.Group12.Game;



public class Enemy implements BoardEntity {
	 int HP;
	 int x, y;
	 
	 
	 public Enemy(int x, int y) {
		 this.HP = 100;
		 this.x = x;
		 this.y = y;
	 }
	 
	 public void setX(int x) {
		 this.x=x;
	 }
	 public void setY(int y) {
		 this.y=y;
	 }
	 public int getXPos() {
		 return x;
	 }
	 
	 public int getYPos() {
		 return y;
	 }
	 
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
}
