package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteCharactersToMakeFancyStringTest {
	@Test
	@DisplayName("s = \"leeetcode\" -> \"leetcode\"")
	void testSolutionMakeFancyString1() {
		DeleteCharactersToMakeFancyString task = new DeleteCharactersToMakeFancyString();
		DeleteCharactersToMakeFancyString.Solution solution = task.new Solution();
		String result = solution.makeFancyString("leeetcode");
		assertEquals("leetcode", result);
	}

	@Test
	@DisplayName("s = \"aaabaaaa\" -> \"aabaa\"")
	void testSolutionMakeFancyString2() {
		DeleteCharactersToMakeFancyString task = new DeleteCharactersToMakeFancyString();
		DeleteCharactersToMakeFancyString.Solution solution = task.new Solution();
		String result = solution.makeFancyString("aaabaaaa");
		assertEquals("aabaa", result);
	}

	@Test
	@DisplayName("s = \"aab\" -> \"aab\"")
	void testSolutionMakeFancyString3() {
		DeleteCharactersToMakeFancyString task = new DeleteCharactersToMakeFancyString();
		DeleteCharactersToMakeFancyString.Solution solution = task.new Solution();
		String result = solution.makeFancyString("aab");
		assertEquals("aab", result);
	}
}
