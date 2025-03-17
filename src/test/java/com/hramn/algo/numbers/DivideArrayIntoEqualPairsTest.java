package com.hramn.algo.numbers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DivideArrayIntoEqualPairsTest {
	@Test
	@DisplayName("nums = [3,2,3,2,2,2] -> true")
	void testSolution1DivideArray1() {
		DivideArrayIntoEqualPairs parent = new DivideArrayIntoEqualPairs();
		DivideArrayIntoEqualPairs.Solution1 solution = parent.new Solution1();
		boolean result = solution.divideArray(new int[] {3,2,3,2,2,2});
		assertTrue(result);
	}

	@Test
	@DisplayName("nums = [1,2,3,4] -> false")
	void testSolution1DivideArray2() {
		DivideArrayIntoEqualPairs parent = new DivideArrayIntoEqualPairs();
		DivideArrayIntoEqualPairs.Solution1 solution = parent.new Solution1();
		boolean result = solution.divideArray(new int[] {1,2,3,4});
		assertFalse(result);
	}

	@Test
	@DisplayName("nums = [3,2,3,2,2,2] -> true")
	void testSolution2DivideArray1() {
		DivideArrayIntoEqualPairs parent = new DivideArrayIntoEqualPairs();
		DivideArrayIntoEqualPairs.Solution2 solution = parent.new Solution2();
		boolean result = solution.divideArray(new int[] {3,2,3,2,2,2});
		assertTrue(result);
	}

	@Test
	@DisplayName("nums = [1,2,3,4] -> false")
	void testSolution2DivideArray2() {
		DivideArrayIntoEqualPairs parent = new DivideArrayIntoEqualPairs();
		DivideArrayIntoEqualPairs.Solution2 solution = parent.new Solution2();
		boolean result = solution.divideArray(new int[] {1,2,3,4});
		assertFalse(result);
	}
}
