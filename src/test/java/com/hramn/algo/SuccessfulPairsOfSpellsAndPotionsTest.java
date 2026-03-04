package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SuccessfulPairsOfSpellsAndPotionsTest {
	@Test
	@DisplayName("spells = [5,1,3], potions = [1,2,3,4,5], success = 7 -> [4,0,3]")
	void testSolutionSuccessfulPairs1() {
		SuccessfulPairsOfSpellsAndPotions task = new SuccessfulPairsOfSpellsAndPotions();
		SuccessfulPairsOfSpellsAndPotions.Solution solution = task.new Solution();
		int[] result = solution.successfulPairs(new int[] {5,1,3}, new int[] {1,2,3,4,5}, 7);
		assertArrayEquals(new int[] {4,0,3}, result);
	}

	@Test
	@DisplayName("spells = [3,1,2], potions = [8,5,8], success = 16 -> [2,0,2]")
	void testSolutionSuccessfulPairs2() {
		SuccessfulPairsOfSpellsAndPotions task = new SuccessfulPairsOfSpellsAndPotions();
		SuccessfulPairsOfSpellsAndPotions.Solution solution = task.new Solution();
		int[] result = solution.successfulPairs(new int[] {3,1,2}, new int[] {8,5,8}, 16);
		assertArrayEquals(new int[] {2,0,2}, result);
	}
}
