package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LongestBinarySubsequenceLessThanOrEqualToKTest {
	@Test
	@DisplayName("s = \"1001010\", k = 5 -> 5")
	void testSolutionLongestSubsequence1() {
		LongestBinarySubsequenceLessThanOrEqualToK task = new LongestBinarySubsequenceLessThanOrEqualToK();
		LongestBinarySubsequenceLessThanOrEqualToK.Solution solution = task.new Solution();
		int result = solution.longestSubsequence("1001010", 5);
		assertEquals(5, result);
	}

	@Test
	@DisplayName("s = \"00101001\", k = 1 -> 6")
	void testSolutionLongestSubsequence2() {
		LongestBinarySubsequenceLessThanOrEqualToK task = new LongestBinarySubsequenceLessThanOrEqualToK();
		LongestBinarySubsequenceLessThanOrEqualToK.Solution solution = task.new Solution();
		int result = solution.longestSubsequence("00101001", 1);
		assertEquals(6, result);
	}
}
