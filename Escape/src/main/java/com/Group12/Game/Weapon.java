package com.Group12.Game;
public class Weapon {
	int ammo;
	int damage;
	public Weapon Pistol{
		this.ammo = 4;
		this.damage = 25;
	}
	public Weapon Rifle{
		this.ammo = 2;
		this.damage = 100;
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
