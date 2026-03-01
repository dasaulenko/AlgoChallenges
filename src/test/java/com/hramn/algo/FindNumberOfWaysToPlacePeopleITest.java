package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindNumberOfWaysToPlacePeopleITest {
	@Test
	@DisplayName("points = [[1,1],[2,2],[3,3]] -> 0")
	void testSolutionNumberOfPairs1() {
		FindNumberOfWaysToPlacePeopleI task = new FindNumberOfWaysToPlacePeopleI();
		FindNumberOfWaysToPlacePeopleI.Solution solution = task.new Solution();
		int result = solution.numberOfPairs(new int[][] {{1,1},{2,2},{3,3}});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("points = [[6,2],[4,4],[2,6]] -> 2")
	void testSolutionNumberOfPairs2() {
		FindNumberOfWaysToPlacePeopleI task = new FindNumberOfWaysToPlacePeopleI();
		FindNumberOfWaysToPlacePeopleI.Solution solution = task.new Solution();
		int result = solution.numberOfPairs(new int[][] {{6,2},{4,4},{2,6}});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("points = [[3,1],[1,3],[1,1]] -> 2")
	void testSolutionNumberOfPairs3() {
		FindNumberOfWaysToPlacePeopleI task = new FindNumberOfWaysToPlacePeopleI();
		FindNumberOfWaysToPlacePeopleI.Solution solution = task.new Solution();
		int result = solution.numberOfPairs(new int[][] {{3,1},{1,3},{1,1}});
		assertEquals(2, result);
	}
}
