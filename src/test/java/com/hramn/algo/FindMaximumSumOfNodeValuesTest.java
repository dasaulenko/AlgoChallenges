package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMaximumSumOfNodeValuesTest {
	@Test
	@DisplayName("nums = [1,2,1], k = 3, edges = [[0,1],[0,2]] -> 6")
	void testSourceMaximumValueSum1() {
		FindMaximumSumOfNodeValues main = new FindMaximumSumOfNodeValues();
		FindMaximumSumOfNodeValues.Solution solution = main.new Solution();
		long result = solution.maximumValueSum(
				new int[] {1,2,1}, 3, new int[][] {{0,1},{0,2}});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("nums = [2,3], k = 7, edges = [[0,1]] -> 9")
	void testSourceMaximumValueSum2() {
		FindMaximumSumOfNodeValues main = new FindMaximumSumOfNodeValues();
		FindMaximumSumOfNodeValues.Solution solution = main.new Solution();
		long result = solution.maximumValueSum(
				new int[] {2,3}, 7, new int[][] {{0,1}});
		assertEquals(9, result);
	}

	@Test
	@DisplayName("nums = [7,7,7,7,7,7], k = 3,"  
			+ " edges = [[0,1],[0,2],[0,3],[0,4],[0,5]] -> 42")
	void testSourceMaximumValueSum3() {
		FindMaximumSumOfNodeValues main = new FindMaximumSumOfNodeValues();
		FindMaximumSumOfNodeValues.Solution solution = main.new Solution();
		long result = solution.maximumValueSum(
				new int[] {7,7,7,7,7,7}, 3, 
				new int[][] {{0,1},{0,2},{0,3},{0,4},{0,5}});
		assertEquals(42, result);
	}
}
