package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LexicographicallyMinimumStringAfterRemovingStarsTest {
	@Test
	@DisplayName("s = \"aaba*\" -> \"aab\"")
	void testSolutionClearStars1() {
		LexicographicallyMinimumStringAfterRemovingStars task = new LexicographicallyMinimumStringAfterRemovingStars();
		LexicographicallyMinimumStringAfterRemovingStars.Solution solution = task.new Solution();
		String result = solution.clearStars("aaba*");
		assertNotNull(result);
		assertEquals("aab", result);
	}

	@Test
	@DisplayName("s = \"abc\" -> \"abc\"")
	void testSolutionClearStars2() {
		LexicographicallyMinimumStringAfterRemovingStars task = new LexicographicallyMinimumStringAfterRemovingStars();
		LexicographicallyMinimumStringAfterRemovingStars.Solution solution = task.new Solution();
		String result = solution.clearStars("abc");
		assertNotNull(result);
		assertEquals("abc", result);
	}
}
