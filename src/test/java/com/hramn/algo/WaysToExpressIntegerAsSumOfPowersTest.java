package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WaysToExpressIntegerAsSumOfPowersTest {
	@Test
	@DisplayName("n = 10, x = 2 -> 1")
	void testSolutionNumberOfWays1() {
		WaysToExpressIntegerAsSumOfPowers task = new WaysToExpressIntegerAsSumOfPowers();
		WaysToExpressIntegerAsSumOfPowers.Solution solution = task.new Solution();
		int result = solution.numberOfWays(10, 2);
		assertEquals(result, 1);
	}

	@Test
	@DisplayName("n = 4, x = 1 -> 2")
	void testSolutionNumberOfWays2() {
		WaysToExpressIntegerAsSumOfPowers task = new WaysToExpressIntegerAsSumOfPowers();
		WaysToExpressIntegerAsSumOfPowers.Solution solution = task.new Solution();
		int result = solution.numberOfWays(4, 1);
		assertEquals(result, 2);
	}
}
