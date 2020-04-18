package com.group12.board_entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CollectibleTest {

	BonusReward bo;
	Punishment pu;
	ObjectiveReward ob;
	
	
	@Before
	public void setupTests() {
		bo = new BonusReward(5, 10, 10, 100);
		pu = new Punishment(10,20,20);
		ob = new ObjectiveReward(20,30,50);
	}
	
	
	@Test
	public void testBonusRewardgetLifespan() {
		assertEquals(10, bo.getLifespan());
	}
	
	@Test
	public void testBonusRewardPos() {
		assertEquals(5, bo.getXPos());
		assertEquals(10, bo.getYPos());
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
	public void testPunishmentPos() {
		assertEquals(10, pu.getXPos());
		assertEquals(20, pu.getYPos());
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
	public void testObjectiveRewardPos() {
		assertEquals(20, ob.getXPos());
		assertEquals(30, ob.getYPos());
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

