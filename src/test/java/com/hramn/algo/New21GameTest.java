package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class New21GameTest {

	double eps = 1e-5;

	@Test
	@DisplayName("n = 10, k = 1, maxPts = 10 -> 1.00000")
	void testSolutionNew21Game1() {
		New21Game task = new New21Game();
		New21Game.Solution solution = task.new Solution();
		double result = solution.new21Game(10, 1, 10);
		assertTrue(Math.abs(1.00000 - result) < eps);
	}

	@Test
	@DisplayName("n = 6, k = 1, maxPts = 10 -> 0.60000")
	void testSolutionNew21Game2() {
		New21Game task = new New21Game();
		New21Game.Solution solution = task.new Solution();
		double result = solution.new21Game(6, 1, 10);
		assertTrue(Math.abs(0.60000 - result) < eps);
	}

	@Test
	@DisplayName("n = 21, k = 17, maxPts = 10 -> 0.73278")
	void testSolutionNew21Game3() {
		New21Game task = new New21Game();
		New21Game.Solution solution = task.new Solution();
		double result = solution.new21Game(21, 17, 10);
		assertTrue(Math.abs(0.73278 - result) < eps);
	}
}
