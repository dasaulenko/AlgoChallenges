package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMinimumTimeToReachLastRoomITest {
	@Test
	@DisplayName("moveTime = [[0,4],[4,4]] -> 6")
	void testDijkstraSolutionMinTimeToReach1() {
		FindMinimumTimeToReachLastRoomI main 
				= new FindMinimumTimeToReachLastRoomI();
		FindMinimumTimeToReachLastRoomI.DijkstraSolution solution 
				= main.new DijkstraSolution();
		int result = solution.minTimeToReach(new int[][] {{0,4},{4,4}});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("moveTime = [[0,0,0],[0,0,0]] -> 3")
	void testDijkstraSolutionMinTimeToReach2() {
		FindMinimumTimeToReachLastRoomI main 
				= new FindMinimumTimeToReachLastRoomI();
		FindMinimumTimeToReachLastRoomI.DijkstraSolution solution 
				= main.new DijkstraSolution();
		int result = solution.minTimeToReach(new int[][] {{0,0,0},{0,0,0}});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("moveTime = [[0,1],[1,2]] -> 3")
	void testDijkstraSolutionMinTimeToReach3() {
		FindMinimumTimeToReachLastRoomI main 
				= new FindMinimumTimeToReachLastRoomI();
		FindMinimumTimeToReachLastRoomI.DijkstraSolution solution 
				= main.new DijkstraSolution();
		int result = solution.minTimeToReach(new int[][] {{0,1},{1,2}});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("moveTime = [[0,4],[4,4]] -> 6")
	void testRecursiveDFSSolutionMinTimeToReach1() {
		FindMinimumTimeToReachLastRoomI main 
				= new FindMinimumTimeToReachLastRoomI();
		FindMinimumTimeToReachLastRoomI.RecursiveDFSSolution solution 
				= main.new RecursiveDFSSolution();
		int result = solution.minTimeToReach(new int[][] {{0,4},{4,4}});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("moveTime = [[0,0,0],[0,0,0]] -> 3")
	void testRecursiveDFSSolutionMinTimeToReach2() {
		FindMinimumTimeToReachLastRoomI main 
				= new FindMinimumTimeToReachLastRoomI();
		FindMinimumTimeToReachLastRoomI.RecursiveDFSSolution solution 
				= main.new RecursiveDFSSolution();
		int result = solution.minTimeToReach(new int[][] {{0,0,0},{0,0,0}});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("moveTime = [[0,1],[1,2]] -> 3")
	void testRecursiveDFSSolutionMinTimeToReach3() {
		FindMinimumTimeToReachLastRoomI main 
				= new FindMinimumTimeToReachLastRoomI();
		FindMinimumTimeToReachLastRoomI.RecursiveDFSSolution solution 
				= main.new RecursiveDFSSolution();
		int result = solution.minTimeToReach(new int[][] {{0,1},{1,2}});
		assertEquals(3, result);
	}
}
