package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumDifferenceByRemappingDigitTest {
	@Test
	@DisplayName("num = 11891 -> 99009")
	void testSolutionMinMaxDifference1() {
		MaximumDifferenceByRemappingDigit task = new MaximumDifferenceByRemappingDigit();
		MaximumDifferenceByRemappingDigit.Solution solution = task.new Solution();
		int result = solution.minMaxDifference(11891);
		assertEquals(99009, result);
	}

	@Test
	@DisplayName("num = 90 -> 99")
	void testSolutionMinMaxDifference2() {
		MaximumDifferenceByRemappingDigit task = new MaximumDifferenceByRemappingDigit();
		MaximumDifferenceByRemappingDigit.Solution solution = task.new Solution();
		int result = solution.minMaxDifference(90);
		assertEquals(99, result);
	}
}
