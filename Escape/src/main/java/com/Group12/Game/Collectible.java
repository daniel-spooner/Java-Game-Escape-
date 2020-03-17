package com.Group12.Game;
public class Collectible implements BoardEntity{
	private int x;
	private int y;
	public Collectible(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getXPos() {
		return x;
	}
	
	public int getYPos() {
		return y;
	}
	public void setX(int x) {
		 this.x=x;
	 }
	 public void setY(int y) {
		 this.y=y;
	 }
}


class BonusReward extends Collectible{
	private int lifespan;
	public BonusReward(int x, int y, int lifespan) {
		super(x, y);
		this.lifespan=lifespan;
	}
	public int getlifespan() {
		return lifespan;
	}
}
class Punishment extends Collectible{
	private int damage;
	public Punishment(int x, int y,int damage) {
		super(x, y);
		this.damage = damage;
	
	}
	public int getdamage() {
		return damage;
	}
}
class ObjectiveReward extends Collectible{
	private int rewards;
	public ObjectiveReward(int x, int y, int rewards) {
		super(x, y);
		this.rewards = rewards;
	}
	public int getrewards() {
		return rewards;
	}
}	
