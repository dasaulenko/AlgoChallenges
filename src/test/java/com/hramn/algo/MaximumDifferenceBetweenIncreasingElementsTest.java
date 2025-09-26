package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumDifferenceBetweenIncreasingElementsTest {
	@Test
	@DisplayName("nums = [7,1,5,4] -> 4")
	void testSolutionMaximumDifference1() {
		MaximumDifferenceBetweenIncreasingElements task = new MaximumDifferenceBetweenIncreasingElements();
		MaximumDifferenceBetweenIncreasingElements.Solution solution = task.new Solution();
		int result = solution.maximumDifference(new int[] {7,1,5,4});
		assertEquals(4, result);
	}

	@Test
	@DisplayName("nums = [9,4,3,2] -> -1")
	void testSolutionMaximumDifference2() {
		MaximumDifferenceBetweenIncreasingElements task = new MaximumDifferenceBetweenIncreasingElements();
		MaximumDifferenceBetweenIncreasingElements.Solution solution = task.new Solution();
		int result = solution.maximumDifference(new int[] {9,4,3,2});
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("nums = [1,5,2,10] -> 9")
	void testSolutionMaximumDifference3() {
		MaximumDifferenceBetweenIncreasingElements task = new MaximumDifferenceBetweenIncreasingElements();
		MaximumDifferenceBetweenIncreasingElements.Solution solution = task.new Solution();
		int result = solution.maximumDifference(new int[] {1,5,2,10});
		assertEquals(9, result);
	}
}
