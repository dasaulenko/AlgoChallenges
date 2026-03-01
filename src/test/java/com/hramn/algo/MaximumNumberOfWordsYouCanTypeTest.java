package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumNumberOfWordsYouCanTypeTest {
	@Test
	@DisplayName("text = \"hello world\", brokenLetters = \"ad\" -> 1")
	void testSolutionCanBeTypedWords1() {
		MaximumNumberOfWordsYouCanType task = new MaximumNumberOfWordsYouCanType();
		MaximumNumberOfWordsYouCanType.Solution solution = task.new Solution();
		int result = solution.canBeTypedWords("hello world", "ad");
		assertEquals(1, result);
	}

	@Test
	@DisplayName("text = \"leet code\", brokenLetters = \"lt\" -> 1")
	void testSolutionCanBeTypedWords2() {
		MaximumNumberOfWordsYouCanType task = new MaximumNumberOfWordsYouCanType();
		MaximumNumberOfWordsYouCanType.Solution solution = task.new Solution();
		int result = solution.canBeTypedWords("leet code", "lt");
		assertEquals(1, result);
	}

	@Test
	@DisplayName("text = \"leet code\", brokenLetters = \"e\" -> 0")
	void testSolutionCanBeTypedWords3() {
		MaximumNumberOfWordsYouCanType task = new MaximumNumberOfWordsYouCanType();
		MaximumNumberOfWordsYouCanType.Solution solution = task.new Solution();
		int result = solution.canBeTypedWords("leet code", "e");
		assertEquals(0, result);
	}
}
