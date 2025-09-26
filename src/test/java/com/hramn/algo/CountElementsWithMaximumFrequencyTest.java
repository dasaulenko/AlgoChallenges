package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountElementsWithMaximumFrequencyTest {
	@Test
	@DisplayName("nums = [1,2,2,3,1,4] -> 4")
	void testSolutionMaxFrequencyElements1() {
		CountElementsWithMaximumFrequency task = new CountElementsWithMaximumFrequency();
		CountElementsWithMaximumFrequency.Solution solution = task.new Solution();
		int result = solution.maxFrequencyElements(new int[] {1,2,2,3,1,4});
		assertEquals(4, result);
	}

	@Test
	@DisplayName("nums = [1,2,3,4,5] -> 5")
	void testSolutionMaxFrequencyElements2() {
		CountElementsWithMaximumFrequency task = new CountElementsWithMaximumFrequency();
		CountElementsWithMaximumFrequency.Solution solution = task.new Solution();
		int result = solution.maxFrequencyElements(new int[] {1,2,3,4,5});
		assertEquals(5, result);
	}
}
