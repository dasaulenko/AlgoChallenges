package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMinimumAreaToCoverAllOnesITest {
	@Test
	@DisplayName("grid = [[0,1,0],[1,0,1]] -> 6")
	void testSolutionMinimumArea1() {
		FindMinimumAreaToCoverAllOnesI task = new FindMinimumAreaToCoverAllOnesI();
		FindMinimumAreaToCoverAllOnesI.Solution solution = task.new Solution();
		int result = solution.minimumArea(new int[][] {{0,1,0},{1,0,1}});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("grid = [[1,0],[0,0]] -> 1")
	void testSolutionMinimumArea2() {
		FindMinimumAreaToCoverAllOnesI task = new FindMinimumAreaToCoverAllOnesI();
		FindMinimumAreaToCoverAllOnesI.Solution solution = task.new Solution();
		int result = solution.minimumArea(new int[][] {{1,0},{0,0}});
		assertEquals(1, result);
	}
}
