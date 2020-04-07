package com.Group12.Game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CollectibleTest {

	BonusReward bo;
	Punishment pu;
	ObjectiveReward ob;
	int x = 5;
	int y = 10;
	
	@Before
	public void setupTests() {
		bo = new BonusReward(x, y, 10, 100);
		pu = new Punishment(x,y,20);
		ob = new ObjectiveReward(x,y,50);
	}
	
	
	@Test
	public void testBonusRewardgetLifespan() {
		assertEquals(10, bo.getLifespan());
	}
	
	
	@Test
	public void testBonusRewardgetScore() {
		assertEquals(100, bo.getScore());
	}
	
	@Test
	public void testBonusRewarddecLifespan() {
		bo.decLifespan();
		assertEquals(9, bo.getLifespan());
	}

	@Test
	public void testBonusRewardDefault() {
		bo = new BonusReward();
		assertEquals(20, bo.getLifespan());
		assertEquals(100, bo.getScore());
	}
	
	@Test
	public void testPunishmentgetDamage() {
		assertEquals(20, pu.getDamage());
	}
	
	@Test
	public void testPunishmentDefault() {
		pu = new Punishment();
		assertEquals(50, pu.getDamage());
	}

	@Test
	public void testObjectiveRewardgetScore() {
		assertEquals(50, ob.getScore());
	}
	
	@Test
	public void testObjectiveRewardDefault() {
		ob = new ObjectiveReward();
		assertEquals(50, ob.getScore());
	}

	
}

