package com.Group12.Game;
import java.util.Random; 
import java.util.ArrayList;


public class Enemy {
	 int HP;
	 int x, y;
	 Board board;
	 
	 public Enemy(int x, int y, Board board) {
		 this.HP = 100;
		 this.x = x;
		 this.y = y;
		 this.board = board;
	 }
	 
	 
	 public int getX() {
		 return x;
	 }
	 
	 public int getY() {
		 return y;
	 }
	 
	 public void takeDemage(int demage) {
		 HP -= demage;
	 }
	 public boolean enemyAlive(int demage) {
	 if (HP <= 0) {
	 // enemy die
		 return false;
	 	}
	 	return true;
	 }
}
