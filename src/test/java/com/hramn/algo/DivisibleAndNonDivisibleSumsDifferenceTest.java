package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DivisibleAndNonDivisibleSumsDifferenceTest {
	@Test
	@DisplayName("n = 10, m = 3 -> 19")
	void testSolutionDifferenceOfSums1() {
		DivisibleAndNonDivisibleSumsDifference task = new DivisibleAndNonDivisibleSumsDifference();
		DivisibleAndNonDivisibleSumsDifference.Solution solution = task.new Solution();
		int result = solution.differenceOfSums(10, 3);
		assertEquals(19, result);
	}

	@Test
	@DisplayName("n = 5, m = 6 -> 15")
	void testSolutionDifferenceOfSums2() {
		DivisibleAndNonDivisibleSumsDifference task = new DivisibleAndNonDivisibleSumsDifference();
		DivisibleAndNonDivisibleSumsDifference.Solution solution = task.new Solution();
		int result = solution.differenceOfSums(5, 6);
		assertEquals(15, result);
	}

	@Test
	@DisplayName("n = 5, m = 1 -> -15")
	void testSolutionDifferenceOfSums3() {
		DivisibleAndNonDivisibleSumsDifference task = new DivisibleAndNonDivisibleSumsDifference();
		DivisibleAndNonDivisibleSumsDifference.Solution solution = task.new Solution();
		int result = solution.differenceOfSums(5, 1);
		assertEquals(-15, result);
	}
}
