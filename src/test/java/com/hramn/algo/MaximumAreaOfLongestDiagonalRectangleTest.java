package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumAreaOfLongestDiagonalRectangleTest {
	@Test
	@DisplayName("dimensions = [[9,3],[8,6]] -> 48")
	void testSolutionAreaOfMaxDiagonal1() {
		MaximumAreaOfLongestDiagonalRectangle task = new MaximumAreaOfLongestDiagonalRectangle();
		MaximumAreaOfLongestDiagonalRectangle.Solution solution = task.new Solution();
		int result = solution.areaOfMaxDiagonal(new int[][] {{9,3},{8,6}});
		assertEquals(48, result);
	}

	@Test
	@DisplayName("dimensions = [[3,4],[4,3]] -> 12")
	void testSolutionAreaOfMaxDiagonal2() {
		MaximumAreaOfLongestDiagonalRectangle task = new MaximumAreaOfLongestDiagonalRectangle();
		MaximumAreaOfLongestDiagonalRectangle.Solution solution = task.new Solution();
		int result = solution.areaOfMaxDiagonal(new int[][] {{3,4},{4,3}});
		assertEquals(12, result);
	}
}
