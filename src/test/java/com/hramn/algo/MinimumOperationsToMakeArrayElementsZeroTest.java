package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumOperationsToMakeArrayElementsZeroTest {
	@Test
	@DisplayName("queries = [[1,2],[2,4]] -> 3")
	void testSolution20250906MinOperations1() {
		MinimumOperationsToMakeArrayElementsZero task = new MinimumOperationsToMakeArrayElementsZero();
		MinimumOperationsToMakeArrayElementsZero.Solution20250906 solution = task.new Solution20250906();
		long result = solution.minOperations(new int[][] {{1,2},{2,4}});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("queries = [[2,6]] -> 4")
	void testSolution20250906MinOperations2() {
		MinimumOperationsToMakeArrayElementsZero task = new MinimumOperationsToMakeArrayElementsZero();
		MinimumOperationsToMakeArrayElementsZero.Solution20250906 solution = task.new Solution20250906();
		long result = solution.minOperations(new int[][] {{2,6}});
		assertEquals(4, result);
	}
}
