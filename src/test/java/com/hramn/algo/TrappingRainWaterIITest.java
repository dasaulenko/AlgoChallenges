package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrappingRainWaterIITest {
	@Test
	@DisplayName("heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] -> 4")
	void testSolutionTrapRainWater1() {
		TrappingRainWaterII task = new TrappingRainWaterII();
		TrappingRainWaterII.Solution solution = task.new Solution();
		int result = solution.trapRainWater(new int[][] {
			{1,4,3,1,3,2},
			{3,2,1,3,2,4},
			{2,3,3,2,3,1}
		});
		assertEquals(4, result);
	}

	@Test
	@DisplayName("heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]] -> 10")
	void testSolutionTrapRainWater2() {
		TrappingRainWaterII task = new TrappingRainWaterII();
		TrappingRainWaterII.Solution solution = task.new Solution();
		int result = solution.trapRainWater(new int[][] {
			{3,3,3,3,3},
			{3,2,2,2,3},
			{3,2,1,2,3},
			{3,2,2,2,3},
			{3,3,3,3,3}
		});
		assertEquals(10, result);
	}
}
