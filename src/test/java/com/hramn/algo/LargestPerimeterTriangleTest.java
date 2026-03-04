package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LargestPerimeterTriangleTest {
	@Test
	@DisplayName("nums = [2,1,2] -> 5")
	void testSolutionLargestPerimeter1() {
		LargestPerimeterTriangle task = new LargestPerimeterTriangle();
		LargestPerimeterTriangle.Solution solution = task.new Solution();
		int[] nums = {2,1,2};
		int expected = 5;
		int result = solution.largestPerimeter(nums);
		assertEquals(expected, result);
	}

	@Test
	@DisplayName("nums = [1,2,1,10] -> 0")
	void testSolutionLargestPerimeter2() {
		LargestPerimeterTriangle task = new LargestPerimeterTriangle();
		LargestPerimeterTriangle.Solution solution = task.new Solution();
		int[] nums = {1,2,1,10};
		int expected = 0;
		int result = solution.largestPerimeter(nums);
		assertEquals(expected, result);
	}
}
