package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LargestTriangleAreaTest {
	@Test
	@DisplayName("points = [[0,0],[0,1],[1,0],[0,2],[2,0]] -> 2.00000")
	void testSolutionLargestTriangleArea1() {
		LargestTriangleArea task = new LargestTriangleArea();
		LargestTriangleArea.Solution solution = task.new Solution();
		int[][] points = new int[][] {{0,0},{0,1},{1,0},{0,2},{2,0}};
		double result = solution.largestTriangleArea(points);
		assertEquals(2, result);
	}

	@Test
	@DisplayName("points = [[1,0],[0,0],[0,1]] -> 0.50000")
	void testSolutionLargestTriangleArea2() {
		LargestTriangleArea task = new LargestTriangleArea();
		LargestTriangleArea.Solution solution = task.new Solution();
		int[][] points = new int[][] {{1,0},{0,0},{0,1}};
		double result = solution.largestTriangleArea(points);
		assertEquals(0.5, result);
	}
}
