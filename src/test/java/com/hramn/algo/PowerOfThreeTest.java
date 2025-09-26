package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PowerOfThreeTest {
	@Test
	@DisplayName("n = 27 -> true")
	void testSolutionIsPowerOfThree1() {
		PowerOfThree task = new PowerOfThree();
		PowerOfThree.Solution solution = task.new Solution();
		boolean result = solution.isPowerOfThree(27);
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 0 -> false")
	void testSolutionIsPowerOfThree2() {
		PowerOfThree task = new PowerOfThree();
		PowerOfThree.Solution solution = task.new Solution();
		boolean result = solution.isPowerOfThree(0);
		assertFalse(result);
	}

	@Test
	@DisplayName("n = -1 -> false")
	void testSolutionIsPowerOfThree3() {
		PowerOfThree task = new PowerOfThree();
		PowerOfThree.Solution solution = task.new Solution();
		boolean result = solution.isPowerOfThree(-1);
		assertFalse(result);
	}

	@Test
	@DisplayName("n = 27 -> true")
	void testFollowUpSolutionIsPowerOfThree1() {
		PowerOfThree task = new PowerOfThree();
		PowerOfThree.FollowUpSolution solution = task.new FollowUpSolution();
		boolean result = solution.isPowerOfThree(27);
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 0 -> false")
	void testFollowUpSolutionIsPowerOfThree2() {
		PowerOfThree task = new PowerOfThree();
		PowerOfThree.FollowUpSolution solution = task.new FollowUpSolution();
		boolean result = solution.isPowerOfThree(0);
		assertFalse(result);
	}

	@Test
	@DisplayName("n = -1 -> false")
	void testFollowUpSolutionIsPowerOfThree3() {
		PowerOfThree task = new PowerOfThree();
		PowerOfThree.FollowUpSolution solution = task.new FollowUpSolution();
		boolean result = solution.isPowerOfThree(-1);
		assertFalse(result);
	}
}
