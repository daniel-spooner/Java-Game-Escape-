package com.Group12.Game;

public class MainCharacter {
	
	private int health = 100;
	
	//private Weapon currentWeapon;
	
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



	





