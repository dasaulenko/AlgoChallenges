package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumNumberOfEventsThatCanBeAttendedTest {
	@Test
	@DisplayName("events = [[1,2],[2,3],[3,4]] -> 3")
	void testSolutionMaxEvents1() {
		MaximumNumberOfEventsThatCanBeAttended task = new MaximumNumberOfEventsThatCanBeAttended();
		MaximumNumberOfEventsThatCanBeAttended.Solution solution = task.new Solution();
		int result = solution.maxEvents(new int[][] {{1,2},{2,3},{3,4}});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("events= [[1,2],[2,3],[3,4],[1,2]] -> 4")
	void testSolutionMaxEvents2() {
		MaximumNumberOfEventsThatCanBeAttended task = new MaximumNumberOfEventsThatCanBeAttended();
		MaximumNumberOfEventsThatCanBeAttended.Solution solution = task.new Solution();
		int result = solution.maxEvents(new int[][] {{1,2},{2,3},{3,4},{1,2}});
		assertEquals(4, result);
	}
}
