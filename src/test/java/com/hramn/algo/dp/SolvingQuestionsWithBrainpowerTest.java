package com.hramn.algo.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SolvingQuestionsWithBrainpowerTest {
	@Test
	@DisplayName("questions = [[3,2],[4,3],[4,4],[2,5]] -> 5")
	void testMostPoints1() {
		SolvingQuestionsWithBrainpower parent = new SolvingQuestionsWithBrainpower();
		SolvingQuestionsWithBrainpower.Solution solution = parent.new Solution();
		long result = solution.mostPoints(new int[][] {{3,2},{4,3},{4,4},{2,5}});
		assertEquals(5, result);
	}

	@Test
	@DisplayName("questions = [[1,1],[2,2],[3,3],[4,4],[5,5]] -> 7")
	void testMostPoints2() {
		SolvingQuestionsWithBrainpower parent = new SolvingQuestionsWithBrainpower();
		SolvingQuestionsWithBrainpower.Solution solution = parent.new Solution();
		long result = solution.mostPoints(new int[][] {{1,1},{2,2},{3,3},{4,4},{5,5}});
		assertEquals(7, result);
	}
}
