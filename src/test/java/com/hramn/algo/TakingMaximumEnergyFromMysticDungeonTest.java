package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TakingMaximumEnergyFromMysticDungeonTest {
	@Test
	@DisplayName("energy = [5,2,-10,-5,1], k = 3 -> 3")
	void testSolutionMaximumEnergy1() {
		TakingMaximumEnergyFromMysticDungeon task = new TakingMaximumEnergyFromMysticDungeon();
		TakingMaximumEnergyFromMysticDungeon.Solution solution = task.new Solution();
		int result = solution.maximumEnergy(new int[] {5,2,-10,-5,1}, 3);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("energy = [-2,-3,-1], k = 2 -> -1")
	void testSolutionMaximumEnergy2() {
		TakingMaximumEnergyFromMysticDungeon task = new TakingMaximumEnergyFromMysticDungeon();
		TakingMaximumEnergyFromMysticDungeon.Solution solution = task.new Solution();
		int result = solution.maximumEnergy(new int[] {-2,-3,-1}, 2);
		assertEquals(-1, result);
	}
}
