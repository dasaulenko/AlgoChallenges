package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumNumberOfPeopleToTeachTest {
	// @Test
	@DisplayName("n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]] -> 1")
	void testSolutionMinimumTeachings1() {
		MinimumNumberOfPeopleToTeach task = new MinimumNumberOfPeopleToTeach();
		MinimumNumberOfPeopleToTeach.Solution solution = task.new Solution();
		int result = solution.minimumTeachings(2, new int[][] {{1},{2},{1,2}}, new int[][] {{1,2},{1,3},{2,3}});
		assertEquals(1, result);
	}

	// @Test
	@DisplayName("n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],[2,3]] -> 2")
	void testSolutionMinimumTeachings2() {
		MinimumNumberOfPeopleToTeach task = new MinimumNumberOfPeopleToTeach();
		MinimumNumberOfPeopleToTeach.Solution solution = task.new Solution();
		int result = solution.minimumTeachings(2, new int[][] {{2},{1,3},{1,2},{3}}, new int[][] {{1,4},{1,2},{3,4},{2,3}});
		assertEquals(2, result);
	}
}
