package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SwimInRisingWaterTest {
	@Test
	@DisplayName("grid = [[0,2],[1,3]] -> 3")
	void testSolutionSwimInWater1() {
		SwimInRisingWater task = new SwimInRisingWater();
		SwimInRisingWater.Solution solution = task.new Solution();
		int result = solution.swimInWater(new int[][] {{0,2},{1,3}});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]] -> 16")
	void testSolutionSwimInWater2() {
		SwimInRisingWater task = new SwimInRisingWater();
		SwimInRisingWater.Solution solution = task.new Solution();
		int result = solution.swimInWater(new int[][] {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}});
		assertEquals(16, result);
	}
}
