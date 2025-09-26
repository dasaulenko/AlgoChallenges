package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMaximumLengthOfValidSubsequenceITest {
	@Test
	@DisplayName("nums = [1,2,3,4] -> 4")
	void testSolutionMaximumLength1() {
		FindMaximumLengthOfValidSubsequenceI task = new FindMaximumLengthOfValidSubsequenceI();
		FindMaximumLengthOfValidSubsequenceI.Solution solution = task.new Solution();
		int result = solution.maximumLength(new int[] {1,2,3,4});
		assertEquals(4, result);
	}

	@Test
	@DisplayName("nums = [1,2,1,1,2,1,2] -> 6")
	void testSolutionMaximumLength2() {
		FindMaximumLengthOfValidSubsequenceI task = new FindMaximumLengthOfValidSubsequenceI();
		FindMaximumLengthOfValidSubsequenceI.Solution solution = task.new Solution();
		int result = solution.maximumLength(new int[] {1,2,1,1,2,1,2});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("nums = [1,3] -> 2")
	void testSolutionMaximumLength3() {
		FindMaximumLengthOfValidSubsequenceI task = new FindMaximumLengthOfValidSubsequenceI();
		FindMaximumLengthOfValidSubsequenceI.Solution solution = task.new Solution();
		int result = solution.maximumLength(new int[] {1,3});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("nums = [1,2,3,4] -> 4")
	void testBestSolutionMaximumLength1() {
		FindMaximumLengthOfValidSubsequenceI task = new FindMaximumLengthOfValidSubsequenceI();
		FindMaximumLengthOfValidSubsequenceI.BestSolution solution = task.new BestSolution();
		int result = solution.maximumLength(new int[] {1,2,3,4});
		assertEquals(4, result);
	}

	@Test
	@DisplayName("nums = [1,2,1,1,2,1,2] -> 6")
	void testBestSolutionMaximumLength2() {
		FindMaximumLengthOfValidSubsequenceI task = new FindMaximumLengthOfValidSubsequenceI();
		FindMaximumLengthOfValidSubsequenceI.BestSolution solution = task.new BestSolution();
		int result = solution.maximumLength(new int[] {1,2,1,1,2,1,2});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("nums = [1,3] -> 2")
	void testBestSolutionMaximumLength3() {
		FindMaximumLengthOfValidSubsequenceI task = new FindMaximumLengthOfValidSubsequenceI();
		FindMaximumLengthOfValidSubsequenceI.BestSolution solution = task.new BestSolution();
		int result = solution.maximumLength(new int[] {1,3});
		assertEquals(2, result);
	}
}
