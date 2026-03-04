package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SmallestMissingNonNegativeIntegerAfterOperationsTest {
	@Test
	@DisplayName("nums = [1,-10,7,13,6,8], value = 5 -> 4")
	void testSolutionFindSmallestInteger1() {
		SmallestMissingNonNegativeIntegerAfterOperations task = new SmallestMissingNonNegativeIntegerAfterOperations();
		SmallestMissingNonNegativeIntegerAfterOperations.Solution solution = task.new Solution();
		int result = solution.findSmallestInteger(new int[] {1,-10,7,13,6,8}, 5);
		assertEquals(4, result);
	}

	@Test
	@DisplayName("nums = [1,-10,7,13,6,8], value = 7 -> 2")
	void testSolutionFindSmallestInteger2() {
		SmallestMissingNonNegativeIntegerAfterOperations task = new SmallestMissingNonNegativeIntegerAfterOperations();
		SmallestMissingNonNegativeIntegerAfterOperations.Solution solution = task.new Solution();
		int result = solution.findSmallestInteger(new int[] {1,-10,7,13,6,8}, 7);
		assertEquals(2, result);
	}
}
