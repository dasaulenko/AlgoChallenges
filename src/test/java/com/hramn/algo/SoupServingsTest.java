package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SoupServingsTest {
	@Test
	@DisplayName("n = 50 -> 0.62500")
	void testSolutionSoupServings1() {
		SoupServings task = new SoupServings();
		SoupServings.Solution solution = task.new Solution();
		double result = solution.soupServings(50);
		assertEquals(result, 0.62500);
	}

	@Test
	@DisplayName("n = 100 -> 0.71875")
	void testSolutionSoupServings2() {
		SoupServings task = new SoupServings();
		SoupServings.Solution solution = task.new Solution();
		double result = solution.soupServings(100);
		assertEquals(result, 0.71875);
	}
}
