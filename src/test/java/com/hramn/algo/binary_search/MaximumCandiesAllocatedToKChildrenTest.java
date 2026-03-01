package com.hramn.algo.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumCandiesAllocatedToKChildrenTest {
	@Test
	@DisplayName("candies = [5,8,6], k = 3 -> 5")
	void testMaximumCandies1() {
		MaximumCandiesAllocatedToKChildren parent = new MaximumCandiesAllocatedToKChildren();
		MaximumCandiesAllocatedToKChildren.Solution solution = parent.new Solution();
		int result = solution.maximumCandies(new int[] {5,8,6}, 3);
		assertEquals(5, result);
	}

	@Test
	@DisplayName("candies = [2,5], k = 11 -> 0")
	void testMaximumCandies2() {
		MaximumCandiesAllocatedToKChildren parent = new MaximumCandiesAllocatedToKChildren();
		MaximumCandiesAllocatedToKChildren.Solution solution = parent.new Solution();
		int result = solution.maximumCandies(new int[] {2,5}, 11);
		assertEquals(0, result);
	}

	@Test
	@DisplayName("candies = [1], k = 1 -> 1")
	void testMaximumCandies3() {
		MaximumCandiesAllocatedToKChildren parent = new MaximumCandiesAllocatedToKChildren();
		MaximumCandiesAllocatedToKChildren.Solution solution = parent.new Solution();
		int result = solution.maximumCandies(new int[] {1}, 1);
		assertEquals(1, result);
	}

	@Test
	@DisplayName("candies = [1000], k = 1 -> 1000")
	void testMaximumCandies4() {
		MaximumCandiesAllocatedToKChildren parent = new MaximumCandiesAllocatedToKChildren();
		MaximumCandiesAllocatedToKChildren.Solution solution = parent.new Solution();
		int result = solution.maximumCandies(new int[] {1000}, 1);
		assertEquals(1000, result);
	}
}
