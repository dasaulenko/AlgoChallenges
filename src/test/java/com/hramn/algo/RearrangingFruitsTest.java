package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RearrangingFruitsTest {
	@Test
	@DisplayName("basket1 = [4,2,2,2], basket2 = [1,4,1,2] -> 1")
	void testSolutionMinCost1() {
		RearrangingFruits task = new RearrangingFruits();
		RearrangingFruits.Solution solution = task.new Solution();
		long result = solution.minCost(new int[] {4,2,2,2}, new int[] {1,4,1,2});
		assertEquals(result, 1);
	}

	@Test
	@DisplayName("basket1 = [2,3,4,1], basket2 = [3,2,5,1] -> -1")
	void testSolutionMinCost2() {
		RearrangingFruits task = new RearrangingFruits();
		RearrangingFruits.Solution solution = task.new Solution();
		long result = solution.minCost(new int[] {2,3,4,1}, new int[] {3,2,5,1});
		assertEquals(result, -1);
	}
}
