package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumDeletionsToMakeStringKSpecialTest {
	@Test
	@DisplayName("word = \"aabcaba\", k = 0 -> 3")
	void testSolutionMinimumDeletions1() {
		MinimumDeletionsToMakeStringKSpecial task = new MinimumDeletionsToMakeStringKSpecial();
		MinimumDeletionsToMakeStringKSpecial.Solution solution = task.new Solution();
		int result = solution.minimumDeletions("aabcaba", 0);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("word = \"dabdcbdcdcd\", k = 2 -> 2")
	void testSolutionMinimumDeletions2() {
		MinimumDeletionsToMakeStringKSpecial task = new MinimumDeletionsToMakeStringKSpecial();
		MinimumDeletionsToMakeStringKSpecial.Solution solution = task.new Solution();
		int result = solution.minimumDeletions("dabdcbdcdcd", 2);
		assertEquals(2, result);
	}

	@Test
	@DisplayName("word = \"aaabaaa\", k = 2 -> 1")
	void testSolutionMinimumDeletions3() {
		MinimumDeletionsToMakeStringKSpecial task = new MinimumDeletionsToMakeStringKSpecial();
		MinimumDeletionsToMakeStringKSpecial.Solution solution = task.new Solution();
		int result = solution.minimumDeletions("aaabaaa", 2);
		assertEquals(1, result);
	}
}
