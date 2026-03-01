package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountNumberOfMaximumBitwiseORSubsetsTest {
	@Test
	@DisplayName("nums = [3,1] -> 2")
	void testSolutionCountMaxOrSubsets1() {
		CountNumberOfMaximumBitwiseORSubsets task = new CountNumberOfMaximumBitwiseORSubsets();
		CountNumberOfMaximumBitwiseORSubsets.Solution solution = task.new Solution();
		int result = solution.countMaxOrSubsets(new int[] {3,1});
		assertEquals(result, 2);
	}

	@Test
	@DisplayName("nums = [2,2,2] -> 7")
	void testSolutionCountMaxOrSubsets2() {
		CountNumberOfMaximumBitwiseORSubsets task = new CountNumberOfMaximumBitwiseORSubsets();
		CountNumberOfMaximumBitwiseORSubsets.Solution solution = task.new Solution();
		int result = solution.countMaxOrSubsets(new int[] {2,2,2});
		assertEquals(result, 7);
	}

	@Test
	@DisplayName("nums = [3,2,1,5] -> 6")
	void testSolutionCountMaxOrSubsets3() {
		CountNumberOfMaximumBitwiseORSubsets task = new CountNumberOfMaximumBitwiseORSubsets();
		CountNumberOfMaximumBitwiseORSubsets.Solution solution = task.new Solution();
		int result = solution.countMaxOrSubsets(new int[] {3,2,1,5});
		assertEquals(result, 6);
	}
}
