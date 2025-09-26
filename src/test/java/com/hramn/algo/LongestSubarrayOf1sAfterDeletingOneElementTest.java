package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LongestSubarrayOf1sAfterDeletingOneElementTest {
	@Test
	@DisplayName("nums = [1,1,0,1] -> 3")
	void testSolutionLongestSubarray1() {
		LongestSubarrayOf1sAfterDeletingOneElement task = new LongestSubarrayOf1sAfterDeletingOneElement();
		LongestSubarrayOf1sAfterDeletingOneElement.Solution solution = task.new Solution();
		int result = solution.longestSubarray(new int[] {1,1,0,1});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("nums = [0,1,1,1,0,1,1,0,1] -> 5")
	void testSolutionLongestSubarray2() {
		LongestSubarrayOf1sAfterDeletingOneElement task = new LongestSubarrayOf1sAfterDeletingOneElement();
		LongestSubarrayOf1sAfterDeletingOneElement.Solution solution = task.new Solution();
		int result = solution.longestSubarray(new int[] {0,1,1,1,0,1,1,0,1});
		assertEquals(5, result);
	}

	@Test
	@DisplayName("nums = [1,1,1] -> 2")
	void testSolutionLongestSubarray3() {
		LongestSubarrayOf1sAfterDeletingOneElement task = new LongestSubarrayOf1sAfterDeletingOneElement();
		LongestSubarrayOf1sAfterDeletingOneElement.Solution solution = task.new Solution();
		int result = solution.longestSubarray(new int[] {1,1,1});
		assertEquals(2, result);
	}
}
