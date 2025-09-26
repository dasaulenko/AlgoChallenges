package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PowerOfFourTest {
	@Test
	@DisplayName("n = 16 -> true")
	void testSolutionIsPowerOfFour1() {
		PowerOfFour task = new PowerOfFour();
		PowerOfFour.Solution solution = task.new Solution();
		boolean result = solution.isPowerOfFour(16);
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 5 -> false")
	void testSolutionIsPowerOfFour2() {
		PowerOfFour task = new PowerOfFour();
		PowerOfFour.Solution solution = task.new Solution();
		boolean result = solution.isPowerOfFour(5);
		assertFalse(result);
	}

	@Test
	@DisplayName("n = 1 -> true")
	void testSolutionIsPowerOfFour3() {
		PowerOfFour task = new PowerOfFour();
		PowerOfFour.Solution solution = task.new Solution();
		boolean result = solution.isPowerOfFour(1);
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 16 -> true")
	void testFollowUpSolutionIsPowerOfFour1() {
		PowerOfFour task = new PowerOfFour();
		PowerOfFour.FollowUpSolution solution = task.new FollowUpSolution();
		boolean result = solution.isPowerOfFour(16);
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 5 -> false")
	void testFollowUpSolutionIsPowerOfFour2() {
		PowerOfFour task = new PowerOfFour();
		PowerOfFour.FollowUpSolution solution = task.new FollowUpSolution();
		boolean result = solution.isPowerOfFour(5);
		assertFalse(result);
	}

	@Test
	@DisplayName("n = 1 -> true")
	void testFollowUpSolutionIsPowerOfFour3() {
		PowerOfFour task = new PowerOfFour();
		PowerOfFour.FollowUpSolution solution = task.new FollowUpSolution();
		boolean result = solution.isPowerOfFour(1);
		assertTrue(result);
	}
}
