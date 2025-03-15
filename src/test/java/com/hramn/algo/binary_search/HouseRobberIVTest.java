package com.hramn.algo.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HouseRobberIVTest {
	@Test
	@DisplayName("nums = [2,3,5,9], k = 2 -> 5")
	void testMinCapability1() {
		HouseRobberIV parent = new HouseRobberIV();
		HouseRobberIV.Solution solution = parent.new Solution();
		int result = solution.minCapability(new int[] {2,3,5,9}, 2);
		assertEquals(5, result);
	}

	@Test
	@DisplayName("nums = [2,7,9,3,1], k = 2 -> 2")
	void testMinCapability2() {
		HouseRobberIV parent = new HouseRobberIV();
		HouseRobberIV.Solution solution = parent.new Solution();
		int result = solution.minCapability(new int[] {2,7,9,3,1}, 2);
		assertEquals(2, result);
	}
}
