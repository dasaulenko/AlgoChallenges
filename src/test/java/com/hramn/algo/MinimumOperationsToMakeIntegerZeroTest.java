package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumOperationsToMakeIntegerZeroTest {
	@Test
	@DisplayName("num1 = 3, num2 = -2 -> 3")
	void testSolution20250905MakeTheIntegerZero1() {
		MinimumOperationsToMakeIntegerZero task = new MinimumOperationsToMakeIntegerZero();
		MinimumOperationsToMakeIntegerZero.Solution20250905 solution = task.new Solution20250905();
		int result = solution.makeTheIntegerZero(3, -2);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("num1 = 5, num2 = 7 -> -1")
	void testSolution20250905MakeTheIntegerZero2() {
		MinimumOperationsToMakeIntegerZero task = new MinimumOperationsToMakeIntegerZero();
		MinimumOperationsToMakeIntegerZero.Solution20250905 solution = task.new Solution20250905();
		int result = solution.makeTheIntegerZero(5, 7);
		assertEquals(-1, result);
	}
}
