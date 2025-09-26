package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindWordsContainingCharacterTest {
	@Test
	@DisplayName("words = [\"leet\",\"code\"], x = \"e\" -> [0,1]")
	void testSolutionFindWordsContaining1() {
		FindWordsContainingCharacter main = new FindWordsContainingCharacter();
		FindWordsContainingCharacter.Solution solution = main.new Solution();
		List<Integer> result = solution.findWordsContaining(
				new String[]{"leet","code"}, 'e');
		assertNotNull(result);
		assertEquals(2, result.size());
		assertTrue(Arrays.equals(new Integer[]{0,1}, result.toArray()));
	}

	@Test
	@DisplayName("words = [\"abc\",\"bcd\",\"aaaa\",\"cbc\"], x = \"a\" -> [0,2]")
	void testSolutionFindWordsContaining2() {
		FindWordsContainingCharacter main = new FindWordsContainingCharacter();
		FindWordsContainingCharacter.Solution solution = main.new Solution();
		List<Integer> result = solution.findWordsContaining(
				new String[]{"abc","bcd","aaaa","cbc"}, 'a');
		assertNotNull(result);
		assertEquals(2, result.size());
		assertTrue(Arrays.equals(new Integer[]{0,2}, result.toArray()));
	}

	@Test
	@DisplayName("words = [\"abc\",\"bcd\",\"aaaa\",\"cbc\"], x = \"z\" -> []")
	void testSolutionFindWordsContaining3() {
		FindWordsContainingCharacter main = new FindWordsContainingCharacter();
		FindWordsContainingCharacter.Solution solution = main.new Solution();
		List<Integer> result = solution.findWordsContaining(
				new String[]{"abc","bcd","aaaa","cbc"}, 'z');
		assertNotNull(result);
		assertEquals(0, result.size());
	}
}
