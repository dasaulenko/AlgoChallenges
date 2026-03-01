package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumMatchingOfPlayersWithTrainersTest {
	@Test
	@DisplayName("players = [4,7,9], trainers = [8,2,5,8] -> 2")
	void testSolutionMatchPlayersAndTrainers1() {
		MaximumMatchingOfPlayersWithTrainers task = new MaximumMatchingOfPlayersWithTrainers();
		MaximumMatchingOfPlayersWithTrainers.Solution solution = task.new Solution();
		int result = solution.matchPlayersAndTrainers(new int[] {4,7,9}, new int[] {8,2,5,8});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("players = [1,1,1], trainers = [10] -> 1")
	void testSolutionMatchPlayersAndTrainers2() {
		MaximumMatchingOfPlayersWithTrainers task = new MaximumMatchingOfPlayersWithTrainers();
		MaximumMatchingOfPlayersWithTrainers.Solution solution = task.new Solution();
		int result = solution.matchPlayersAndTrainers(new int[] {1,1,1}, new int[] {10});
		assertEquals(1, result);
	}
}
