package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumUniqueSubarraySumAfterDeletionTest {
	@Test
	@DisplayName("nums = [1,2,3,4,5] -> 15")
	void testSolutionMaxSum1() {
		MaximumUniqueSubarraySumAfterDeletion task = new MaximumUniqueSubarraySumAfterDeletion();
		MaximumUniqueSubarraySumAfterDeletion.Solution solution = task.new Solution();
		int result = solution.maxSum(new int[] {1,2,3,4,5});
		assertEquals(15, result);
	}

	@Test
	@DisplayName("nums = [1,1,0,1,1] -> 1")
	void testSolutionMaxSum2() {
		MaximumUniqueSubarraySumAfterDeletion task = new MaximumUniqueSubarraySumAfterDeletion();
		MaximumUniqueSubarraySumAfterDeletion.Solution solution = task.new Solution();
		int result = solution.maxSum(new int[] {1,1,0,1,1});
		assertEquals(1, result);
	}

	@Test
	@DisplayName("nums = [1,2,-1,-2,1,0,-1] -> 3")
	void testSolutionMaxSum3() {
		MaximumUniqueSubarraySumAfterDeletion task = new MaximumUniqueSubarraySumAfterDeletion();
		MaximumUniqueSubarraySumAfterDeletion.Solution solution = task.new Solution();
		int result = solution.maxSum(new int[] {1,2,-1,-2,1,0,-1});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("nums = [1,2,3,4,5] -> 15")
	void testOptSolutionMaxSum1() {
		MaximumUniqueSubarraySumAfterDeletion task = new MaximumUniqueSubarraySumAfterDeletion();
		MaximumUniqueSubarraySumAfterDeletion.OptSolution solution = task.new OptSolution();
		int result = solution.maxSum(new int[] {1,2,3,4,5});
		assertEquals(15, result);
	}

	@Test
	@DisplayName("nums = [1,1,0,1,1] -> 1")
	void testOptSolutionMaxSum2() {
		MaximumUniqueSubarraySumAfterDeletion task = new MaximumUniqueSubarraySumAfterDeletion();
		MaximumUniqueSubarraySumAfterDeletion.OptSolution solution = task.new OptSolution();
		int result = solution.maxSum(new int[] {1,1,0,1,1});
		assertEquals(1, result);
	}

	@Test
	@DisplayName("nums = [1,2,-1,-2,1,0,-1] -> 3")
	void testOptSolutionMaxSum3() {
		MaximumUniqueSubarraySumAfterDeletion task = new MaximumUniqueSubarraySumAfterDeletion();
		MaximumUniqueSubarraySumAfterDeletion.OptSolution solution = task.new OptSolution();
		int result = solution.maxSum(new int[] {1,2,-1,-2,1,0,-1});
		assertEquals(3, result);
	}
}
