package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumDifferenceBetweenEvenAndOddFrequencyITest {
	@Test
	@DisplayName("s = \"aaaaabbc\" -> 3")
	void testSolutionMaxDifference1() {
		MaximumDifferenceBetweenEvenAndOddFrequencyI task = new MaximumDifferenceBetweenEvenAndOddFrequencyI();
		MaximumDifferenceBetweenEvenAndOddFrequencyI.Solution solution = task.new Solution();
		int result = solution.maxDifference("aaaaabbc");
		assertEquals(3, result);
	}

	@Test
	@DisplayName("s = \"abcabcab\" -> 1")
	void testSolutionMaxDifference2() {
		MaximumDifferenceBetweenEvenAndOddFrequencyI task = new MaximumDifferenceBetweenEvenAndOddFrequencyI();
		MaximumDifferenceBetweenEvenAndOddFrequencyI.Solution solution = task.new Solution();
		int result = solution.maxDifference("abcabcab");
		assertEquals(1, result);
	}
}
