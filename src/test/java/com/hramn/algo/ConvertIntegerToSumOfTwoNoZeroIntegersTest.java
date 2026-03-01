package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertIntegerToSumOfTwoNoZeroIntegersTest {
	@Test
	@DisplayName("n = 2 -> [1,1]")
	void testSolution20250908GetNoZeroIntegers1() {
		ConvertIntegerToSumOfTwoNoZeroIntegers task = new ConvertIntegerToSumOfTwoNoZeroIntegers();
		ConvertIntegerToSumOfTwoNoZeroIntegers.Solution20250908 solution = task.new Solution20250908();
		int[] result = solution.getNoZeroIntegers(2);
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1,1}, result));
	}

	@Test
	@DisplayName("n = 2 -> [2,9]")
	void testSolution20250908GetNoZeroIntegers2() {
		ConvertIntegerToSumOfTwoNoZeroIntegers task = new ConvertIntegerToSumOfTwoNoZeroIntegers();
		ConvertIntegerToSumOfTwoNoZeroIntegers.Solution20250908 solution = task.new Solution20250908();
		int[] result = solution.getNoZeroIntegers(11);
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {2,9}, result));
	}
}
