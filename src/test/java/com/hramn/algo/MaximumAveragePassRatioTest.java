package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumAveragePassRatioTest {

	double eps = 1e-5;

	@Test
	@DisplayName("classes = [[1,2],[3,5],[2,2]], extraStudents = 2 -> 0.78333")
	void testSolutionMaxAverageRatio1() {
		MaximumAveragePassRatio task = new MaximumAveragePassRatio();
		MaximumAveragePassRatio.Solution solution = task.new Solution();
		double result = solution.maxAverageRatio(new int[][] {{1,2},{3,5},{2,2}}, 2);
		// assertEquals(0.78333, result);
		assertTrue(Math.abs(0.78333 - result) < eps);
	}

	@Test
	@DisplayName("classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4 -> 0.53485")
	void testSolutionMaxAverageRatio2() {
		MaximumAveragePassRatio task = new MaximumAveragePassRatio();
		MaximumAveragePassRatio.Solution solution = task.new Solution();
		double result = solution.maxAverageRatio(new int[][] {{2,4},{3,9},{4,5},{2,10}}, 4);
		// assertEquals(0.53485, result);
		assertTrue(Math.abs(0.53485 - result) < eps);
	}
}
