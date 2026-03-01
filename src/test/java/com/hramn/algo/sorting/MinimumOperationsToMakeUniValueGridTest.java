package com.hramn.algo.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumOperationsToMakeUniValueGridTest {
	@Test
	@DisplayName("grid = [[2,4],[6,8]], x = 2 -> 4")
	void testMinOperations1() {
		MinimumOperationsToMakeUniValueGrid parent = new MinimumOperationsToMakeUniValueGrid();
		MinimumOperationsToMakeUniValueGrid.Solution solution = parent.new Solution();
		int result = solution.minOperations(new int[][] {{2,4},{6,8}}, 2);
		assertEquals(4, result);
	}

	@Test
	@DisplayName("grid = [[1,5],[2,3]], x = 1 -> 5")
	void testMinOperations2() {
		MinimumOperationsToMakeUniValueGrid parent = new MinimumOperationsToMakeUniValueGrid();
		MinimumOperationsToMakeUniValueGrid.Solution solution = parent.new Solution();
		int result = solution.minOperations(new int[][] {{1,5},{2,3}}, 1);
		assertEquals(5, result);
	}

	@Test
	@DisplayName("grid = [[1,2],[3,4]], x = 2 -> -1")
	void testMinOperations3() {
		MinimumOperationsToMakeUniValueGrid parent = new MinimumOperationsToMakeUniValueGrid();
		MinimumOperationsToMakeUniValueGrid.Solution solution = parent.new Solution();
		int result = solution.minOperations(new int[][] {{1,2},{3,4}}, 2);
		assertEquals(-1, result);
	}
}
