package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumFruitsHarvestedAfterAtMostKStepsTest {
	@Test
	@DisplayName("fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4 -> 9")
	void testMySolutionMaxTotalFruits1() {
		MaximumFruitsHarvestedAfterAtMostKSteps task = new MaximumFruitsHarvestedAfterAtMostKSteps();
		MaximumFruitsHarvestedAfterAtMostKSteps.MySolution solution = task.new MySolution();
		int result = solution.maxTotalFruits(new int[][] {{2,8},{6,3},{8,6}}, 5, 4);
		assertEquals(result, 9);
	}

	@Test
	@DisplayName("fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4 -> 14")
	void testMySolutionMaxTotalFruits2() {
		MaximumFruitsHarvestedAfterAtMostKSteps task = new MaximumFruitsHarvestedAfterAtMostKSteps();
		MaximumFruitsHarvestedAfterAtMostKSteps.MySolution solution = task.new MySolution();
		int result = solution.maxTotalFruits(new int[][] {{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}}, 5, 4);
		assertEquals(result, 14);
	}

	@Test
	@DisplayName("fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2 -> 0")
	void testMySolutionMaxTotalFruits3() {
		MaximumFruitsHarvestedAfterAtMostKSteps task = new MaximumFruitsHarvestedAfterAtMostKSteps();
		MaximumFruitsHarvestedAfterAtMostKSteps.MySolution solution = task.new MySolution();
		int result = solution.maxTotalFruits(new int[][] {{0,3},{6,4},{8,5}}, 3, 2);
		assertEquals(result, 0);
	}

		@Test
	@DisplayName("fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4 -> 9")
	void testBestTimeSolutionMaxTotalFruits1() {
		MaximumFruitsHarvestedAfterAtMostKSteps task = new MaximumFruitsHarvestedAfterAtMostKSteps();
		MaximumFruitsHarvestedAfterAtMostKSteps.BestTimeSolution solution = task.new BestTimeSolution();
		int result = solution.maxTotalFruits(new int[][] {{2,8},{6,3},{8,6}}, 5, 4);
		assertEquals(result, 9);
	}

	@Test
	@DisplayName("fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4 -> 14")
	void testBestTimeSolutionMaxTotalFruits2() {
		MaximumFruitsHarvestedAfterAtMostKSteps task = new MaximumFruitsHarvestedAfterAtMostKSteps();
		MaximumFruitsHarvestedAfterAtMostKSteps.BestTimeSolution solution = task.new BestTimeSolution();
		int result = solution.maxTotalFruits(new int[][] {{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}}, 5, 4);
		assertEquals(result, 14);
	}

	@Test
	@DisplayName("fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2 -> 0")
	void testBestTimeSolutionMaxTotalFruits3() {
		MaximumFruitsHarvestedAfterAtMostKSteps task = new MaximumFruitsHarvestedAfterAtMostKSteps();
		MaximumFruitsHarvestedAfterAtMostKSteps.BestTimeSolution solution = task.new BestTimeSolution();
		int result = solution.maxTotalFruits(new int[][] {{0,3},{6,4},{8,5}}, 3, 2);
		assertEquals(result, 0);
	}
}
