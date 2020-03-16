package com.Group12.Game;
public class Collectible {
	private String name;
	public Collectible(String item) {
		this.name = item;
	}
	
	public class BonusReward extends Collectible{
		private int lifespan;
		public BonusReward(String item, int lifespan) {
		this.lifespan=lifespan;
		super(item);
		}
		public int getlifespan() {
			return lifespan;
		}
	}
	public class Punishment extends Collectible{
		private int damage;
		public Punishment(String item,int damage) {
		this.damage = damage;
		super(item);
		}
		public int getdamage() {
			return damage;
		}
	}
	public class ObjectiveReward extends Collectible{
		private int rewards;
		public ObjectiveReward(String item,int rewards) {
		this.rewards = rewards;
		super(item);
		}
		public int getrewards() {
			return rewards;
		}
	}	
}
