package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumNumberOfEventsThatCanBeAttendedIITest {
	@Test
	@DisplayName("events = [[1,2,4],[3,4,3],[2,3,1]], k = 2 -> 7")
	void testSolutionMaxValue1() {
		MaximumNumberOfEventsThatCanBeAttendedII task = new MaximumNumberOfEventsThatCanBeAttendedII();
		MaximumNumberOfEventsThatCanBeAttendedII.Solution solution = task.new Solution();
		int result = solution.maxValue(new int[][] {{1,2,4},{3,4,3},{2,3,1}}, 2);
		assertEquals(result, 7);
	}

	@Test
	@DisplayName("events = [[1,2,4],[3,4,3],[2,3,10]], k = 2 -> 10")
	void testSolutionMaxValue2() {
		MaximumNumberOfEventsThatCanBeAttendedII task = new MaximumNumberOfEventsThatCanBeAttendedII();
		MaximumNumberOfEventsThatCanBeAttendedII.Solution solution = task.new Solution();
		int result = solution.maxValue(new int[][] {{1,2,4},{3,4,3},{2,3,10}}, 2);
		assertEquals(result, 10);
	}

	@Test
	@DisplayName("events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3 -> 9")
	void testSolutionMaxValue3() {
		MaximumNumberOfEventsThatCanBeAttendedII task = new MaximumNumberOfEventsThatCanBeAttendedII();
		MaximumNumberOfEventsThatCanBeAttendedII.Solution solution = task.new Solution();
		int result = solution.maxValue(new int[][] {{1,1,1},{2,2,2},{3,3,3},{4,4,4}}, 3);
		assertEquals(result, 9);
	}
}
