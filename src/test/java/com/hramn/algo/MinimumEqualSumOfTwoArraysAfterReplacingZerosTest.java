package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumEqualSumOfTwoArraysAfterReplacingZerosTest {
	@Test
	@DisplayName("nums1 = [3,2,0,1,0], nums2 = [6,5,0] -> 12")
	void testSolutionMinSum1() {
		MinimumEqualSumOfTwoArraysAfterReplacingZeros task = 
				new MinimumEqualSumOfTwoArraysAfterReplacingZeros();
		MinimumEqualSumOfTwoArraysAfterReplacingZeros.Solution solution = 
				task.new Solution();
		long result = solution.minSum(new int[] {3,2,0,1,0}, new int[] {6,5,0});
		assertEquals(12, result);
	}

	@Test
	@DisplayName("nums1 = [2,0,2,0], nums2 = [1,4] -> -1")
	void testSolutionMinSum2() {
		MinimumEqualSumOfTwoArraysAfterReplacingZeros task = 
				new MinimumEqualSumOfTwoArraysAfterReplacingZeros();
		MinimumEqualSumOfTwoArraysAfterReplacingZeros.Solution solution = 
				task.new Solution();
		long result = solution.minSum(new int[] {2,0,2,0}, new int[] {1,4});
		assertEquals(-1, result);
	}
}
