package com.hramn.algo.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumSizeSubarraySumTest {
	@Test
	@DisplayName("target = 7, nums = [2,3,1,2,4,3] -> 2")
	void testBruteforceSolutionMinSubArrayLen1() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.BruteforceSolution solution 
				= minimumSizeSubarraySum.new BruteforceSolution();
		int result = 
				solution.minSubArrayLen(7, new int[] {2,3,1,2,4,3});
		assertEquals(result, 2);
	}

	@Test
	@DisplayName("target = 4, nums = [1,4,4] -> 1")
	void testBruteforceSolutionMinSubArrayLen2() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.BruteforceSolution solution 
				= minimumSizeSubarraySum.new BruteforceSolution();
		int result = 
				solution.minSubArrayLen(4, new int[] {1,4,4});
		assertEquals(result, 1);
	}

	@Test
	@DisplayName("target = 11, nums = [1,1,1,1,1,1,1,1] -> 0")
	void testBruteforceSolutionMinSubArrayLen3() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.BruteforceSolution solution 
				= minimumSizeSubarraySum.new BruteforceSolution();
		int result = 
				solution.minSubArrayLen(
				11, new int[] {1,1,1,1,1,1,1,1});
		assertEquals(result, 0);
	}

	@Test
	@DisplayName("target = 7, nums = [2,3,1,2,4,3] -> 2")
	void testSlidingWindowSolution_20250227MinSubArrayLen1() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.SlidingWindowSolution_20250227 solution 
				= minimumSizeSubarraySum.new SlidingWindowSolution_20250227();
		int result = 
				solution.minSubArrayLen(7, new int[] {2,3,1,2,4,3});
		assertEquals(result, 2);
	}

	@Test
	@DisplayName("target = 4, nums = [1,4,4] -> 1")
	void testSlidingWindowSolution_20250227MinSubArrayLen2() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.SlidingWindowSolution_20250227 solution 
				= minimumSizeSubarraySum.new SlidingWindowSolution_20250227();
		int result = 
				solution.minSubArrayLen(1, new int[] {1,4,4});
		assertEquals(result, 1);
	}

	@Test
	@DisplayName("target = 11, nums = [1,1,1,1,1,1,1,1] -> 0")
	void testSlidingWindowSolution_20250227MinSubArrayLen3() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.SlidingWindowSolution_20250227 solution 
				= minimumSizeSubarraySum.new SlidingWindowSolution_20250227();
		int result = 
				solution.minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1});
		assertEquals(result, 0);
	}

	@Test
	@DisplayName("target = 7, nums = [2,3,1,2,4,3] -> 2")
	void testSlidingWindowSolutionMinSubArrayLen1() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.SlidingWindowSolution solution 
				= minimumSizeSubarraySum.new SlidingWindowSolution();
		int result = 
				solution.minSubArrayLen(7, new int[] {2,3,1,2,4,3});
		assertEquals(result, 2);
	}

	@Test
	@DisplayName("target = 4, nums = [1,4,4] -> 1")
	void testSlidingWindowSolutionMinSubArrayLen2() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.SlidingWindowSolution solution 
				= minimumSizeSubarraySum.new SlidingWindowSolution();
		int result = 
				solution.minSubArrayLen(1, new int[] {1,4,4});
		assertEquals(result, 1);
	}

	@Test
	@DisplayName("target = 11, nums = [1,1,1,1,1,1,1,1] -> 0")
	void testSlidingWindowSolutionMinSubArrayLen3() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.SlidingWindowSolution solution 
				= minimumSizeSubarraySum.new SlidingWindowSolution();
		int result = 
				solution.minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1});
		assertEquals(result, 0);
	}

	@Test
	@DisplayName("target = 7, nums = [2,3,1,2,4,3] -> 2")
	void testSolution_betterMinSubArrayLen1() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.Solution_better solution 
				= minimumSizeSubarraySum.new Solution_better();
		int result = 
				solution.minSubArrayLen(7, new int[] {2,3,1,2,4,3});
		assertEquals(result, 2);
	}

	@Test
	@DisplayName("target = 4, nums = [1,4,4] -> 1")
	void testSolution_betterMinSubArrayLen2() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.Solution_better solution 
				= minimumSizeSubarraySum.new Solution_better();
		int result = 
				solution.minSubArrayLen(1, new int[] {1,4,4});
		assertEquals(result, 1);
	}

	@Test
	@DisplayName("target = 11, nums = [1,1,1,1,1,1,1,1] -> 0")
	void testSolution_betterMinSubArrayLen3() {
		MinimumSizeSubarraySum minimumSizeSubarraySum 
				= new MinimumSizeSubarraySum();
		MinimumSizeSubarraySum.Solution_better solution 
				= minimumSizeSubarraySum.new Solution_better();
		int result = 
				solution.minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1});
		assertEquals(result, 0);
	}
}
