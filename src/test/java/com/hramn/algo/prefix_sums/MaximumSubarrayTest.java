package com.hramn.algo.prefix_sums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumSubarrayTest {
	@Test
	@DisplayName("[-2,1,-3,4,-1,2,1,-5,4] -> 6")
	void testMaxSubArray1() {
		MaximumSubarray maximumSubarray = new MaximumSubarray();
		MaximumSubarray.Solution solution = maximumSubarray.new Solution();
		int result = solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
		assertEquals(result, 6);
	}

	@Test
	@DisplayName("[1] -> 1")
	void testMaxSubArray2() {
		MaximumSubarray maximumSubarray = new MaximumSubarray();
		MaximumSubarray.Solution solution = maximumSubarray.new Solution();
		int result = solution.maxSubArray(new int[]{1});
		assertEquals(result, 1);
	}

	@Test
	@DisplayName("[5,4,-1,7,8] -> 23")
	void testMaxSubArray3() {
		MaximumSubarray maximumSubarray = new MaximumSubarray();
		MaximumSubarray.Solution solution = maximumSubarray.new Solution();
		int result = solution.maxSubArray(new int[]{5,4,-1,7,8});
		assertEquals(result, 23);
	}
}
