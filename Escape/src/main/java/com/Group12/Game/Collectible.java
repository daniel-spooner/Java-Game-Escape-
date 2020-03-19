package com.Group12.Game;

public class Collectible extends BoardEntity{
	
	//private int x;
	//private int y;
	
	public Collectible() {
		super();
	}
	
	public Collectible(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	/*
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public void setX(int x) {
		this.xPos = x;
	}
	
	public void setY(int y) {
		this.yPos = y;
	}
	 */
}


class BonusReward extends Collectible{
	private int lifespan;
	private int score;
	
	public BonusReward() {
		super();
		this.score = 100;
		this.lifespan = 20;
	}
	
	public BonusReward(int x, int y, int lifespan, int score) {
		super(x, y);
		this.lifespan = lifespan;
		this.score = score;
	}
	
	public int getLifespan() {
		return lifespan;
	}
	
	public int decLifespan() {
		this.lifespan --;
		return this.lifespan;
	}
	
	public int getScore() {
		return this.score;
	}
	
}

class Punishment extends Collectible{
	
	private int damage;
	
	public Punishment() {
		super();
		this.damage = 50;
	}
	
	public Punishment(int x, int y, int damage) {
		super(x, y);
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}
}

class ObjectiveReward extends Collectible {
	
	private int score;
	
	public ObjectiveReward() {
		super();
		this.score = 50;
	}
	
	public ObjectiveReward(int x, int y, int score) {
		super(x, y);
		this.score = score;
	}
	
	public int getScore() {
		return this.score;
	}
}	
