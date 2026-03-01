package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Game24Test {
	@Test
	@DisplayName("cards = [4,1,8,7] -> true")
	void testSolutionJudgePoint24_1() {
		Game24 task = new Game24();
		Game24.Solution solution = task.new Solution();
		boolean result = solution.judgePoint24(new int[] {4,1,8,7});
		assertTrue(result);
	}

	@Test
	@DisplayName("cards = [1,2,1,2] -> false")
	void testSolutionJudgePoint24_2() {
		Game24 task = new Game24();
		Game24.Solution solution = task.new Solution();
		boolean result = solution.judgePoint24(new int[] {1,2,1,2});
		assertFalse(result);
	}
}
