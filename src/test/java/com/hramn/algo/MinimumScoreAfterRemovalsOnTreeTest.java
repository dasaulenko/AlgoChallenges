package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumScoreAfterRemovalsOnTreeTest {
	@Test
	@DisplayName("nums = [1,5,5,4,11], edges = [[0,1],[1,2],[1,3],[3,4]] -> 9")
	void testSolutionMinimumScore1() {
		MinimumScoreAfterRemovalsOnTree task = new MinimumScoreAfterRemovalsOnTree();
		MinimumScoreAfterRemovalsOnTree.Solution solution = task.new Solution();
		int result = solution.minimumScore(new int[] {1,5,5,4,11}, new int[][] {{0,1},{1,2},{1,3},{3,4}});
		assertEquals(9, result);
	}

	@Test
	@DisplayName("nums = [5,5,2,4,4,2], edges = [[0,1],[1,2],[5,2],[4,3],[1,3]] -> 0")
	void testSolutionMinimumScore2() {
		MinimumScoreAfterRemovalsOnTree task = new MinimumScoreAfterRemovalsOnTree();
		MinimumScoreAfterRemovalsOnTree.Solution solution = task.new Solution();
		int result = solution.minimumScore(new int[] {5,5,2,4,4,2}, new int[][] {{0,1},{1,2},{5,2},{4,3},{1,3}});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("nums = [9,14,2,1] edges = [[2,3],[3,0],[3,1]] -> 11")
	void testSolutionMinimumScore3() {
		MinimumScoreAfterRemovalsOnTree task = new MinimumScoreAfterRemovalsOnTree();
		MinimumScoreAfterRemovalsOnTree.Solution solution = task.new Solution();
		int result = solution.minimumScore(new int[] {9,14,2,1}, new int[][] {{2,3},{3,0},{3,1}});
		assertEquals(11, result);
	}
}
