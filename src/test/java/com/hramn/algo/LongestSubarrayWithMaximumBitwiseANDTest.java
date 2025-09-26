package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LongestSubarrayWithMaximumBitwiseANDTest {
	@Test
	@DisplayName("nums = [1,2,3,3,2,2] -> 2")
	void testSolutionLongestSubarray1() {
		LongestSubarrayWithMaximumBitwiseAND task = new LongestSubarrayWithMaximumBitwiseAND();
		LongestSubarrayWithMaximumBitwiseAND.Solution solution = task.new Solution();
		int result = solution.longestSubarray(new int[] {1,2,3,3,2,2});
		assertEquals(result, 2);
	}

	@Test
	@DisplayName("nums = [1,2,3,4] -> 1")
	void testSolutionLongestSubarray2() {
		LongestSubarrayWithMaximumBitwiseAND task = new LongestSubarrayWithMaximumBitwiseAND();
		LongestSubarrayWithMaximumBitwiseAND.Solution solution = task.new Solution();
		int result = solution.longestSubarray(new int[] {1,2,3,4});
		assertEquals(result, 1);
	}
}
