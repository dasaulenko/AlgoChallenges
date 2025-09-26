package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumErasureValueTest {
	@Test
	@DisplayName("nums = [4,2,4,5,6] -> 17")
	void testSolutionMaximumUniqueSubarray1() {
		MaximumErasureValue task = new MaximumErasureValue();
		MaximumErasureValue.Solution solution = task.new Solution();
		int result = solution.maximumUniqueSubarray(new int[] {4,2,4,5,6});
		assertEquals(17, result);
	}

	@Test
	@DisplayName("nums = [5,2,1,2,5,2,1,2,5] -> 8")
	void testSolutionMaximumUniqueSubarray2() {
		MaximumErasureValue task = new MaximumErasureValue();
		MaximumErasureValue.Solution solution = task.new Solution();
		int result = solution.maximumUniqueSubarray(new int[] {5,2,1,2,5,2,1,2,5});
		assertEquals(8, result);
	}
}
