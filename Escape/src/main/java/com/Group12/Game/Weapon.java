package com.Group12.Game;
public class Weapon {
	int ammo;
	int damage;
	public Weapon(){
		this.ammo = 4;
		this.damage = 50;
	}
	
	}
	public int getAmmo{
		return ammo;
	}
	public int getDamage{
		return damage;
	}
	public void shot{
		ammo--;
	}
}
