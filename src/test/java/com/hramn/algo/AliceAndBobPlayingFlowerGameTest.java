package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AliceAndBobPlayingFlowerGameTest {
	@Test
	@DisplayName("n = 3, m = 2 -> 3")
	void testSolutionFlowerGame1() {
		AliceAndBobPlayingFlowerGame task = new AliceAndBobPlayingFlowerGame();
		AliceAndBobPlayingFlowerGame.Solution solution = task.new Solution();
		long result = solution.flowerGame(3, 2);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("n = 1, m = 1 -> 0")
	void testSolutionFlowerGame2() {
		AliceAndBobPlayingFlowerGame task = new AliceAndBobPlayingFlowerGame();
		AliceAndBobPlayingFlowerGame.Solution solution = task.new Solution();
		long result = solution.flowerGame(1, 1);
		assertEquals(0, result);
	}

	@Test
	@DisplayName("n = 3, m = 2 -> 3")
	void testBestSolutionFlowerGame1() {
		AliceAndBobPlayingFlowerGame task = new AliceAndBobPlayingFlowerGame();
		AliceAndBobPlayingFlowerGame.BestSolution solution = task.new BestSolution();
		long result = solution.flowerGame(3, 2);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("n = 1, m = 1 -> 0")
	void testBestSolutionFlowerGame2() {
		AliceAndBobPlayingFlowerGame task = new AliceAndBobPlayingFlowerGame();
		AliceAndBobPlayingFlowerGame.BestSolution solution = task.new BestSolution();
		long result = solution.flowerGame(1, 1);
		assertEquals(0, result);
	}
}
