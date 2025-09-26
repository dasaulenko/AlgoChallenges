package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LexicographicallySmallestEquivalentStringTest {
	@Test
	@DisplayName("s1 = \"parker\", s2 = \"morris\", baseStr = \"parser\" -> \"makkek\"")
	void testSolutionSmallestEquivalentString1() {
		LexicographicallySmallestEquivalentString task = new LexicographicallySmallestEquivalentString();
		LexicographicallySmallestEquivalentString.Solution solution = task.new Solution();
		String result = solution.smallestEquivalentString("parker", "morris", "parser");
		assertNotNull(result);
		assertEquals("makkek", result);
	}

	@Test
	@DisplayName("s1 = \"hello\", s2 = \"world\", baseStr = \"hold\" -> \"hdld\"")
	void testSolutionSmallestEquivalentString2() {
		LexicographicallySmallestEquivalentString task = new LexicographicallySmallestEquivalentString();
		LexicographicallySmallestEquivalentString.Solution solution = task.new Solution();
		String result = solution.smallestEquivalentString("hello", "world", "hold");
		assertNotNull(result);
		assertEquals("hdld", result);
	}

	@Test
	@DisplayName("s1 = \"leetcode\", s2 = \"programs\", baseStr = \"sourcecode\" -> \"aauaaaaada\"")
	void testSolutionSmallestEquivalentString3() {
		LexicographicallySmallestEquivalentString task = new LexicographicallySmallestEquivalentString();
		LexicographicallySmallestEquivalentString.Solution solution = task.new Solution();
		String result = solution.smallestEquivalentString("leetcode", "programs", "sourcecode");
		assertNotNull(result);
		assertEquals("aauaaaaada", result);
	}
}
