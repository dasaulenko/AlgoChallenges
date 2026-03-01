package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumCandiesYouCanGetFromBoxesTest {
	@Test
	@DisplayName("status = [1,0,1,0], candies = [7,5,4,100], keys = [[],[],[1],[]], containedBoxes = [[1,2],[3],[],[]], initialBoxes = [0] -> 16")
	void testSolutionMaxCandies1() {
		MaximumCandiesYouCanGetFromBoxes task = new MaximumCandiesYouCanGetFromBoxes();
		MaximumCandiesYouCanGetFromBoxes.Solution solution = task.new Solution();
		int result = solution.maxCandies(
				new int[] {1,0,1,0}, 
				new int[] {7,5,4,100}, 
				new int[][] {{},{},{1},{}},
				new int[][] {{1,2},{3},{},{}},
				new int[] {0}
		);
		assertEquals(16, result);
	}

	@Test
	@DisplayName("status = [1,0,0,0,0,0], candies = [1,1,1,1,1,1], keys = [[1,2,3,4,5],[],[],[],[],[]], containedBoxes = [[1,2,3,4,5],[],[],[],[],[]], initialBoxes = [0] -> 6")
	void testSolutionMaxCandies2() {
		MaximumCandiesYouCanGetFromBoxes task = new MaximumCandiesYouCanGetFromBoxes();
		MaximumCandiesYouCanGetFromBoxes.Solution solution = task.new Solution();
		int result = solution.maxCandies(
				new int[] {1,0,0,0,0,0}, 
				new int[] {1,1,1,1,1,1}, 
				new int[][] {{1,2,3,4,5},{},{},{},{},{}},
				new int[][] {{1,2,3,4,5},{},{},{},{},{}},
				new int[] {0}
		);
		assertEquals(6, result);
	}
}
