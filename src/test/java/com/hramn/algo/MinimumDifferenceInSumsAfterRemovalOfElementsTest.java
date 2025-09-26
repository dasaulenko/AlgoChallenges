package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumDifferenceInSumsAfterRemovalOfElementsTest {
	@Test
	@DisplayName("nums = [3,1,2] -> -1")
	void testSolutionMinimumDifference1() {
		MinimumDifferenceInSumsAfterRemovalOfElements task = new MinimumDifferenceInSumsAfterRemovalOfElements();
		MinimumDifferenceInSumsAfterRemovalOfElements.Solution solution = task.new Solution();
		long result = solution.minimumDifference(new int[] {3,1,2});
		assertEquals(result, -1);
	}

	@Test
	@DisplayName("nums = [7,9,5,8,1,3] -> 1")
	void testSolutionMinimumDifference2() {
		MinimumDifferenceInSumsAfterRemovalOfElements task = new MinimumDifferenceInSumsAfterRemovalOfElements();
		MinimumDifferenceInSumsAfterRemovalOfElements.Solution solution = task.new Solution();
		long result = solution.minimumDifference(new int[] {7,9,5,8,1,3});
		assertEquals(result, 1);
	}
}
