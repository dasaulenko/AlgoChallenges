package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindTriangularSumOfArrayTest {
	@Test
	@DisplayName("nums = [1,2,3,4,5] -> 8")
	void testSolutionTriangularSum1() {
		FindTriangularSumOfArray task = new FindTriangularSumOfArray();
		FindTriangularSumOfArray.Solution solution = task.new Solution();
		int result = solution.triangularSum(new int[] {1,2,3,4,5});
		assertEquals(8, result);
	}

	@Test
	@DisplayName("nums = [5] -> 5")
	void testSolutionTriangularSum2() {
		FindTriangularSumOfArray task = new FindTriangularSumOfArray();
		FindTriangularSumOfArray.Solution solution = task.new Solution();
		int result = solution.triangularSum(new int[] {5});
		assertEquals(5, result);
	}
}
