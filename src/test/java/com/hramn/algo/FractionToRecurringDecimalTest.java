package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FractionToRecurringDecimalTest {
	@Test
	@DisplayName("numerator = -1, denominator = -2147483648 -> \"0.0000000004656612873077392578125\"")
	void testSolutionFractionToDecimal1() {
		FractionToRecurringDecimal task = new FractionToRecurringDecimal();
		FractionToRecurringDecimal.Solution solution = task.new Solution();
		String result = solution.fractionToDecimal(-1, -2147483648);
		assertNotNull(result);
		assertEquals("0.0000000004656612873077392578125", result);
	}

	@Test
	@DisplayName("numerator = 2, denominator = 1 -> \"2\"")
	void testSolutionFractionToDecimal2() {
		FractionToRecurringDecimal task = new FractionToRecurringDecimal();
		FractionToRecurringDecimal.Solution solution = task.new Solution();
		String result = solution.fractionToDecimal(2, 1);
		assertNotNull(result);
		assertEquals("2", result);
	}

	@Test
	@DisplayName("numerator = 4, denominator = 333 -> \"0.(012)\"")
	void testSolutionFractionToDecimal3() {
		FractionToRecurringDecimal task = new FractionToRecurringDecimal();
		FractionToRecurringDecimal.Solution solution = task.new Solution();
		String result = solution.fractionToDecimal(4, 333);
		assertNotNull(result);
		assertEquals("0.(012)", result);
	}

	@Test
	@DisplayName("numerator = 1, denominator = 2 -> \"0.5\"")
	void testSolutionFractionToDecimal4() {
		FractionToRecurringDecimal task = new FractionToRecurringDecimal();
		FractionToRecurringDecimal.Solution solution = task.new Solution();
		String result = solution.fractionToDecimal(1, 2);
		assertNotNull(result);
		assertEquals("0.5", result);
	}

	@Test
	@DisplayName("numerator = 1, denominator = 6 -> \"0.1(6)\"")
	void testSolutionFractionToDecimal5() {
		FractionToRecurringDecimal task = new FractionToRecurringDecimal();
		FractionToRecurringDecimal.Solution solution = task.new Solution();
		String result = solution.fractionToDecimal(1, 6);
		assertNotNull(result);
		assertEquals("0.1(6)", result);
	}
}
