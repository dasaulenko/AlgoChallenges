package com.hramn.algo.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumCountOfPositiveIntegerAndNegativeIntegerTest {
	@Test
	@DisplayName("nums = [-2,-1,-1,1,2,3] -> 3")
	void testMaximumCount1() {
		MaximumCountOfPositiveIntegerAndNegativeInteger parent = new MaximumCountOfPositiveIntegerAndNegativeInteger();
		MaximumCountOfPositiveIntegerAndNegativeInteger.Solution solution = parent.new Solution();
		int result = solution.maximumCount(new int[]{-2,-1,-1,1,2,3});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("nums = [-3,-2,-1,0,0,1,2] -> 3")
	void testMaximumCount2() {
		MaximumCountOfPositiveIntegerAndNegativeInteger parent = new MaximumCountOfPositiveIntegerAndNegativeInteger();
		MaximumCountOfPositiveIntegerAndNegativeInteger.Solution solution = parent.new Solution();
		int result = solution.maximumCount(new int[]{-3,-2,-1,0,0,1,2});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("nums = [5,20,66,1314] -> 4")
	void testMaximumCount3() {
		MaximumCountOfPositiveIntegerAndNegativeInteger parent = new MaximumCountOfPositiveIntegerAndNegativeInteger();
		MaximumCountOfPositiveIntegerAndNegativeInteger.Solution solution = parent.new Solution();
		int result = solution.maximumCount(new int[]{-2,-1,-1,1,2,3});
		assertEquals(3, result);
	}
}
