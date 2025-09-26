package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VowelsGameInStringTest {
	@Test
	@DisplayName("s = \"leetcoder\" -> true")
	void testSolutionDoesAliceWin1() {
		VowelsGameInString task = new VowelsGameInString();
		VowelsGameInString.Solution solution = task.new Solution();
		boolean result = solution.doesAliceWin("leetcoder");
		assertTrue(result);
	}

	@Test
	@DisplayName("s = \"bbcd\" -> false")
	void testSolutionDoesAliceWin2() {
		VowelsGameInString task = new VowelsGameInString();
		VowelsGameInString.Solution solution = task.new Solution();
		boolean result = solution.doesAliceWin("bbcd");
		assertFalse(result);
	}
}
