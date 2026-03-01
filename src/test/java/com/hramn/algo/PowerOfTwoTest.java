package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PowerOfTwoTest {
	@Test
	@DisplayName("n = 1 -> true")
	void testSolutionIsPowerOfTwo1() {
		PowerOfTwo task = new PowerOfTwo();
		PowerOfTwo.Solution solution = task.new Solution();
		boolean result = solution.isPowerOfTwo(1);
		assertTrue(result);
	}
	
	@Test
	@DisplayName("n = 16 -> true")
	void testSolutionIsPowerOfTwo2() {
		PowerOfTwo task = new PowerOfTwo();
		PowerOfTwo.Solution solution = task.new Solution();
		boolean result = solution.isPowerOfTwo(16);
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 3 -> true")
	void testSolutionIsPowerOfTwo3() {
		PowerOfTwo task = new PowerOfTwo();
		PowerOfTwo.Solution solution = task.new Solution();
		boolean result = solution.isPowerOfTwo(3);
		assertFalse(result);
	}

	@Test
	@DisplayName("n = 1 -> true")
	void testFollowUpSolutionIsPowerOfTwo1() {
		PowerOfTwo task = new PowerOfTwo();
		PowerOfTwo.FollowUpSolution solution = task.new FollowUpSolution();
		boolean result = solution.isPowerOfTwo(1);
		assertTrue(result);
	}
	
	@Test
	@DisplayName("n = 16 -> true")
	void testFollowUpSolutionIsPowerOfTwo2() {
		PowerOfTwo task = new PowerOfTwo();
		PowerOfTwo.FollowUpSolution solution = task.new FollowUpSolution();
		boolean result = solution.isPowerOfTwo(16);
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 3 -> true")
	void testFollowUpSolutionIsPowerOfTwo3() {
		PowerOfTwo task = new PowerOfTwo();
		PowerOfTwo.FollowUpSolution solution = task.new FollowUpSolution();
		boolean result = solution.isPowerOfTwo(3);
		assertFalse(result);
	}
}
