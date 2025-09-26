package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindLexicographicallyLargestStringFromBoxITest {
	@Test
	@DisplayName("word = \"dbca\", numFriends = 2 -> \"dbc\"")
	void testSolutionAnswerString1() {
		FindLexicographicallyLargestStringFromBoxI main = new FindLexicographicallyLargestStringFromBoxI();
		FindLexicographicallyLargestStringFromBoxI.Solution solution = main.new Solution();
		String result = solution.answerString("dbca", 2);
		assertNotNull(result);
		assertEquals("dbc", result);
	}

	@Test
	@DisplayName("word = \"gggg\", numFriends = 4 -> \"g\"")
	void testSolutionAnswerString2() {
		FindLexicographicallyLargestStringFromBoxI main = new FindLexicographicallyLargestStringFromBoxI();
		FindLexicographicallyLargestStringFromBoxI.Solution solution = main.new Solution();
		String result = solution.answerString("gggg", 4);
		assertNotNull(result);
		assertEquals("g", result);
	}

	@Test
	@DisplayName("word = \"bif\", numFriends = 2 -> \"if\"")
	void testSolutionAnswerString3() {
		FindLexicographicallyLargestStringFromBoxI main = new FindLexicographicallyLargestStringFromBoxI();
		FindLexicographicallyLargestStringFromBoxI.Solution solution = main.new Solution();
		String result = solution.answerString("bif", 2);
		assertNotNull(result);
		assertEquals("if", result);
	}
}
