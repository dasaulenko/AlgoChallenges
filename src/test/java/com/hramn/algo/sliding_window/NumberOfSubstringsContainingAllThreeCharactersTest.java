package com.hramn.algo.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberOfSubstringsContainingAllThreeCharactersTest {
	@Test
	@DisplayName("s = \"abcabc\" -> 10")
	void testNumberOfSubstrings1() {
		NumberOfSubstringsContainingAllThreeCharacters parent = new NumberOfSubstringsContainingAllThreeCharacters();
		NumberOfSubstringsContainingAllThreeCharacters.Solution solution = parent.new Solution();
		int result = solution.numberOfSubstrings("abcabc");
		assertEquals(10, result);
	}

	@Test
	@DisplayName("s = \"aaacb\" -> 3")
	void testNumberOfSubstrings2() {
		NumberOfSubstringsContainingAllThreeCharacters parent = new NumberOfSubstringsContainingAllThreeCharacters();
		NumberOfSubstringsContainingAllThreeCharacters.Solution solution = parent.new Solution();
		int result = solution.numberOfSubstrings("aaacb");
		assertEquals(3, result);
	}

	@Test
	@DisplayName("s = \"abc\" -> 1")
	void testNumberOfSubstrings3() {
		NumberOfSubstringsContainingAllThreeCharacters parent = new NumberOfSubstringsContainingAllThreeCharacters();
		NumberOfSubstringsContainingAllThreeCharacters.Solution solution = parent.new Solution();
		int result = solution.numberOfSubstrings("abc");
		assertEquals(1, result);
	}

	@Test
	@DisplayName("s = \"aaabbbccc\" -> 9")
	void testNumberOfSubstrings4() {
		NumberOfSubstringsContainingAllThreeCharacters parent = new NumberOfSubstringsContainingAllThreeCharacters();
		NumberOfSubstringsContainingAllThreeCharacters.Solution solution = parent.new Solution();
		int result = solution.numberOfSubstrings("aaabbbccc");
		assertEquals(9, result);
	}
}
