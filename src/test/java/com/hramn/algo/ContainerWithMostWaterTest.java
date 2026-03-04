package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContainerWithMostWaterTest {
	@Test
	@DisplayName("height = [1,8,6,2,5,4,8,3,7] -> 49")
	void testSolutionMaxArea1() {
		ContainerWithMostWater task = new ContainerWithMostWater();
		ContainerWithMostWater.Solution solution = task.new Solution();
		int result = solution.maxArea(new int[] {1,8,6,2,5,4,8,3,7});
		assertEquals(49, result);
	}

	@Test
	@DisplayName("height = [1,1] -> 1")
	void testSolutionMaxArea2() {
		ContainerWithMostWater task = new ContainerWithMostWater();
		ContainerWithMostWater.Solution solution = task.new Solution();
		int result = solution.maxArea(new int[] {1,1});
		assertEquals(1, result);
	}
}
