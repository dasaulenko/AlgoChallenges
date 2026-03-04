package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidTriangleNumberTest {
	@Test
	@DisplayName("nums = [2,2,3,4] -> 3")
	void testSolutionTriangleNumber1() {
		ValidTriangleNumber task = new ValidTriangleNumber();
		ValidTriangleNumber.Solution solution = task.new Solution();
		int result = solution.triangleNumber(new int[] {2,2,3,4});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("nums = [4,2,3,4] -> 4")
	void testSolutionTriangleNumber2() {
		ValidTriangleNumber task = new ValidTriangleNumber();
		ValidTriangleNumber.Solution solution = task.new Solution();
		int result = solution.triangleNumber(new int[] {4,2,3,4});
		assertEquals(4, result);
	}
}
