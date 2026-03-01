package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidWordTest {
	@Test
	@DisplayName("word = \"234Adas\" -> true")
	void testSolutionIsValid1() {
		ValidWord task = new ValidWord();
		ValidWord.Solution solution = task.new Solution();
		boolean result = solution.isValid("234Adas");
		assertTrue(result);
	}

	@Test
	@DisplayName("word = \"b3\" -> false")
	void testSolutionIsValid2() {
		ValidWord task = new ValidWord();
		ValidWord.Solution solution = task.new Solution();
		boolean result = solution.isValid("b3");
		assertFalse(result);
	}

	@Test
	@DisplayName("word = \"a3$e\" -> false")
	void testSolutionIsValid3() {
		ValidWord task = new ValidWord();
		ValidWord.Solution solution = task.new Solution();
		boolean result = solution.isValid("a3$e");
		assertFalse(result);
	}
}
