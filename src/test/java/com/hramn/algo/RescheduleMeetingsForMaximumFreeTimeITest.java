package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RescheduleMeetingsForMaximumFreeTimeITest {
	@Test
	@DisplayName("eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5] -> 2")
	void testSolutionMaxFreeTime1() {
		RescheduleMeetingsForMaximumFreeTimeI task = new RescheduleMeetingsForMaximumFreeTimeI();
		RescheduleMeetingsForMaximumFreeTimeI.Solution solution = task.new Solution();
		int result = solution.maxFreeTime(5, 1, new int[] {1,3}, new int[] {2,5});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10] -> 6")
	void testSolutionMaxFreeTime2() {
		RescheduleMeetingsForMaximumFreeTimeI task = new RescheduleMeetingsForMaximumFreeTimeI();
		RescheduleMeetingsForMaximumFreeTimeI.Solution solution = task.new Solution();
		int result = solution.maxFreeTime(10, 1, new int[] {0,2,9}, new int[] {1,4,10});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5] -> 0")
	void testSolutionMaxFreeTime3() {
		RescheduleMeetingsForMaximumFreeTimeI task = new RescheduleMeetingsForMaximumFreeTimeI();
		RescheduleMeetingsForMaximumFreeTimeI.Solution solution = task.new Solution();
		int result = solution.maxFreeTime(5, 2, new int[] {0,1,2,3,4}, new int[] {1,2,3,4,5});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5] -> 2")
	void testOptSolutionMaxFreeTime1() {
		RescheduleMeetingsForMaximumFreeTimeI task = new RescheduleMeetingsForMaximumFreeTimeI();
		RescheduleMeetingsForMaximumFreeTimeI.OptSolution solution = task.new OptSolution();
		int result = solution.maxFreeTime(5, 1, new int[] {1,3}, new int[] {2,5});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10] -> 6")
	void testOptSolutionMaxFreeTime2() {
		RescheduleMeetingsForMaximumFreeTimeI task = new RescheduleMeetingsForMaximumFreeTimeI();
		RescheduleMeetingsForMaximumFreeTimeI.OptSolution solution = task.new OptSolution();
		int result = solution.maxFreeTime(10, 1, new int[] {0,2,9}, new int[] {1,4,10});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5] -> 0")
	void testOptSolutionMaxFreeTime3() {
		RescheduleMeetingsForMaximumFreeTimeI task = new RescheduleMeetingsForMaximumFreeTimeI();
		RescheduleMeetingsForMaximumFreeTimeI.OptSolution solution = task.new OptSolution();
		int result = solution.maxFreeTime(5, 2, new int[] {0,1,2,3,4}, new int[] {1,2,3,4,5});
		assertEquals(0, result);
	}
}
