package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SnakesAndLaddersTest {
	@Test
	@DisplayName("board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]] -> 4")
	void testSolutionSnakesAndLadders1() {
		SnakesAndLadders task = new SnakesAndLadders();
		SnakesAndLadders.Solution solution = task.new Solution();
		int result = solution.snakesAndLadders(new int[][] {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}});
		assertEquals(4, result);
	}

	@Test
	@DisplayName("board = [[-1,-1],[-1,3]] -> 1")
	void testSolutionSnakesAndLadders2() {
		SnakesAndLadders task = new SnakesAndLadders();
		SnakesAndLadders.Solution solution = task.new Solution();
		int result = solution.snakesAndLadders(new int[][] {{-1,-1},{-1,3}});
		assertEquals(1, result);
	}
}
