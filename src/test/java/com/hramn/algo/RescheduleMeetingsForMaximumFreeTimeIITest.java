package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RescheduleMeetingsForMaximumFreeTimeIITest {
	@Test
	@DisplayName("eventTime = 5, startTime = [1,3], endTime = [2,5] -> 2")
	void testSolutionMaxFreeTime1() {
		RescheduleMeetingsForMaximumFreeTimeII task = new RescheduleMeetingsForMaximumFreeTimeII();
		RescheduleMeetingsForMaximumFreeTimeII.Solution solution = task.new Solution();
		int result = solution.maxFreeTime(5, new int[] {1, 3}, new int[] {2, 5});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("eventTime = 10, startTime = [0,7,9], endTime = [1,8,10] -> 7")
	void testSolutionMaxFreeTime2() {
		RescheduleMeetingsForMaximumFreeTimeII task = new RescheduleMeetingsForMaximumFreeTimeII();
		RescheduleMeetingsForMaximumFreeTimeII.Solution solution = task.new Solution();
		int result = solution.maxFreeTime(10, new int[] {0, 7, 9}, new int[] {1, 8, 10});
		assertEquals(7, result);
	}

	@Test
	@DisplayName("eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10] -> 6")
	void testSolutionMaxFreeTime3() {
		RescheduleMeetingsForMaximumFreeTimeII task = new RescheduleMeetingsForMaximumFreeTimeII();
		RescheduleMeetingsForMaximumFreeTimeII.Solution solution = task.new Solution();
		int result = solution.maxFreeTime(10, new int[] {0, 3, 7, 9}, new int[] {1, 4, 8, 10});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5] -> 0")
	void testSolutionMaxFreeTime4() {
		RescheduleMeetingsForMaximumFreeTimeII task = new RescheduleMeetingsForMaximumFreeTimeII();
		RescheduleMeetingsForMaximumFreeTimeII.Solution solution = task.new Solution();
		int result = solution.maxFreeTime(5, new int[] {0,1,2,3,4}, new int[] {1,2,3,4,5});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("eventTime = 5, startTime = [1,3], endTime = [2,5] -> 2")
	void testOptSolutionMaxFreeTime1() {
		RescheduleMeetingsForMaximumFreeTimeII task = new RescheduleMeetingsForMaximumFreeTimeII();
		RescheduleMeetingsForMaximumFreeTimeII.OptSolution solution = task.new OptSolution();
		int result = solution.maxFreeTime(5, new int[] {1,3}, new int[] {2,5});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("eventTime = 10, startTime = [0,7,9], endTime = [1,8,10] -> 7")
	void testOptSolutionMaxFreeTime2() {
		RescheduleMeetingsForMaximumFreeTimeII task = new RescheduleMeetingsForMaximumFreeTimeII();
		RescheduleMeetingsForMaximumFreeTimeII.OptSolution solution = task.new OptSolution();
		int result = solution.maxFreeTime(10, new int[] {0,7,9}, new int[] {1,8,10});
		assertEquals(7, result);
	}

	@Test
	@DisplayName("eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10] -> 6")
	void testOptSolutionMaxFreeTime3() {
		RescheduleMeetingsForMaximumFreeTimeII task = new RescheduleMeetingsForMaximumFreeTimeII();
		RescheduleMeetingsForMaximumFreeTimeII.OptSolution solution = task.new OptSolution();
		int result = solution.maxFreeTime(10, new int[] {0,3,7,9}, new int[] {1,4,8,10});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5] -> 0")
	void testOptSolutionMaxFreeTime4() {
		RescheduleMeetingsForMaximumFreeTimeII task = new RescheduleMeetingsForMaximumFreeTimeII();
		RescheduleMeetingsForMaximumFreeTimeII.OptSolution solution = task.new OptSolution();
		int result = solution.maxFreeTime(5, new int[] {0,1,2,3,4}, new int[] {1,2,3,4,5});
		assertEquals(0, result);
	}
}
