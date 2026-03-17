package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LargestSubmatrixWithRearrangementsTest {
	@Test
	@DisplayName("matrix = [[0,0,1],[1,1,1],[1,0,1]] -> 4")
	void testSolutionLargestSubmatrix1() {
		LargestSubmatrixWithRearrangements task 
			= new LargestSubmatrixWithRearrangements();
		LargestSubmatrixWithRearrangements.Solution solution = task.new Solution();
		int result = solution.largestSubmatrix(
			new int[][] {{0,0,1},{1,1,1},{1,0,1}});
		assert result == 4;
	}

	@Test
	@DisplayName("matrix = [[1,0,1,0,1]] -> 3")
	void testSolutionLargestSubmatrix2() {
		LargestSubmatrixWithRearrangements task 
			= new LargestSubmatrixWithRearrangements();
		LargestSubmatrixWithRearrangements.Solution solution = task.new Solution();
		int result = solution.largestSubmatrix(
			new int[][] {{1,0,1,0,1}});
		assert result == 3;
	}

	@Test
	@DisplayName("matrix = [[1,1,0],[1,0,1]] -> 2")
	void testSolutionLargestSubmatrix3() {
		LargestSubmatrixWithRearrangements task 
			= new LargestSubmatrixWithRearrangements();
		LargestSubmatrixWithRearrangements.Solution solution = task.new Solution();
		int result = solution.largestSubmatrix(
			new int[][] {{1,1,0},{1,0,1}});
		assert result == 2;
	}
}