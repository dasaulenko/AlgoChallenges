package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMaximumLengthOfValidSubsequenceIITest {
	@Test
	@DisplayName("nums = [1,2,3,4,5], k = 2 -> 5")
	void testSolutionMaximumLength1() {
		FindMaximumLengthOfValidSubsequenceII task = new FindMaximumLengthOfValidSubsequenceII();
		FindMaximumLengthOfValidSubsequenceII.Solution solution = task.new Solution();
		int result = solution.maximumLength(new int[] {1,2,3,4,5}, 2);
		assertEquals(5, result);
	}

	@Test
	@DisplayName("nums = [1,4,2,3,1,4], k = 3 -> 4")
	void testSolutionMaximumLength2() {
		FindMaximumLengthOfValidSubsequenceII task = new FindMaximumLengthOfValidSubsequenceII();
		FindMaximumLengthOfValidSubsequenceII.Solution solution = task.new Solution();
		int result = solution.maximumLength(new int[] {1,4,2,3,1,4}, 3);
		assertEquals(4, result);
	}

	@Test
	@DisplayName("nums = [1,2,3,4,5], k = 2 -> 5")
	void testBestSolutionMaximumLength1() {
		FindMaximumLengthOfValidSubsequenceII task = new FindMaximumLengthOfValidSubsequenceII();
		FindMaximumLengthOfValidSubsequenceII.BestSolution solution = task.new BestSolution();
		int result = solution.maximumLength(new int[] {1,2,3,4,5}, 2);
		assertEquals(5, result);
	}

	@Test
	@DisplayName("nums = [1,4,2,3,1,4], k = 3 -> 4")
	void testBestSolutionMaximumLength2() {
		FindMaximumLengthOfValidSubsequenceII task = new FindMaximumLengthOfValidSubsequenceII();
		FindMaximumLengthOfValidSubsequenceII.BestSolution solution = task.new BestSolution();
		int result = solution.maximumLength(new int[] {1,4,2,3,1,4}, 3);
		assertEquals(4, result);
	}
}
