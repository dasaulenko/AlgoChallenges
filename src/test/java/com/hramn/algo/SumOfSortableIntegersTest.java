package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SumOfSortableIntegersTest {

	@Test
	@DisplayName("nums = [2,1,3,4] -> 2")
	void testSolutionSumOfSortableIntegers() {
		SumOfSortableIntegers task = new SumOfSortableIntegers();
		SumOfSortableIntegers.Solution solution = task.new Solution();
		int[] nums = new int[] {2,1,3,4};
		int expected = 2;
		int result = solution.sortableIntegers(nums);
		assertEquals(expected, result);
	}
}
