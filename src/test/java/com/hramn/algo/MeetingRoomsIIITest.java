package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MeetingRoomsIIITest {
	@Test
	@DisplayName("n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]] -> 0")
	void testSolutionMostBooked1() {
		MeetingRoomsIII task = new MeetingRoomsIII();
		MeetingRoomsIII.Solution solution = task.new Solution();
		int result = solution.mostBooked(2, new int[][] {{0,10},{1,5},{2,7},{3,4}});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]] -> 1")
	void testSolutionMostBooked2() {
		MeetingRoomsIII task = new MeetingRoomsIII();
		MeetingRoomsIII.Solution solution = task.new Solution();
		int result = solution.mostBooked(3, new int[][] {{1,20},{2,10},{3,5},{4,9},{6,8}});
		assertEquals(1, result);
	}

	@Test
	@DisplayName("n = 4, meetings = [[18,19],[3,12],[17,19],[2,13],[7,10]] -> 0")
	void testSolutionMostBooked3() {
		MeetingRoomsIII task = new MeetingRoomsIII();
		MeetingRoomsIII.Solution solution = task.new Solution();
		int result = solution.mostBooked(4, new int[][] {{18,19},{3,12},{17,19},{2,13},{7,10}});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]] -> 0")
	void testOptSolutionMostBooked1() {
		MeetingRoomsIII task = new MeetingRoomsIII();
		MeetingRoomsIII.OptSolution solution = task.new OptSolution();
		int result = solution.mostBooked(2, new int[][] {{0,10},{1,5},{2,7},{3,4}});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]] -> 1")
	void testOptSolutionMostBooked2() {
		MeetingRoomsIII task = new MeetingRoomsIII();
		MeetingRoomsIII.OptSolution solution = task.new OptSolution();
		int result = solution.mostBooked(3, new int[][] {{1,20},{2,10},{3,5},{4,9},{6,8}});
		assertEquals(1, result);
	}

	@Test
	@DisplayName("n = 4, meetings = [[18,19],[3,12],[17,19],[2,13],[7,10]] -> 0")
	void testOptSolutionMostBooked3() {
		MeetingRoomsIII task = new MeetingRoomsIII();
		MeetingRoomsIII.OptSolution solution = task.new OptSolution();
		int result = solution.mostBooked(4, new int[][] {{18,19},{3,12},{17,19},{2,13},{7,10}});
		assertEquals(0, result);
	}
}
