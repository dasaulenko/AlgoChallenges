package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReorderedPowerOf2Test {
	@Test
	@DisplayName("n = 1 -> true")
	void testSolutionReorderedPowerOf21() {
		ReorderedPowerOf2 task = new ReorderedPowerOf2();
		ReorderedPowerOf2.Solution solution = task.new Solution();
		boolean result = solution.reorderedPowerOf2(1);
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 10 -> false")
	void testSolutionReorderedPowerOf22() {
		ReorderedPowerOf2 task = new ReorderedPowerOf2();
		ReorderedPowerOf2.Solution solution = task.new Solution();
		boolean result = solution.reorderedPowerOf2(10);
		assertFalse(result);
	}
}
