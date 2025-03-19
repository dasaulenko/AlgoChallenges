package com.hramn.algo.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneITest {
	@Test
	@DisplayName("nums = [0,1,1,1,0,0] -> 3")
	void testMinOperations1() {
		MinimumOperationsToMakeBinaryArrayElementsEqualToOneI parent = 
				new MinimumOperationsToMakeBinaryArrayElementsEqualToOneI();
		MinimumOperationsToMakeBinaryArrayElementsEqualToOneI.Solution solution = 
				parent.new Solution();
		int result = solution.minOperations(new int[] {0,1,1,1,0,0});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("nums = [0,1,1,1] -> -1")
	void testMinOperations2() {
		MinimumOperationsToMakeBinaryArrayElementsEqualToOneI parent = 
				new MinimumOperationsToMakeBinaryArrayElementsEqualToOneI();
		MinimumOperationsToMakeBinaryArrayElementsEqualToOneI.Solution solution = 
				parent.new Solution();
		int result = solution.minOperations(new int[] {0,1,1,1});
		assertEquals(-1, result);
	}
}
