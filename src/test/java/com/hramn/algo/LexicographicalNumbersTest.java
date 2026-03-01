package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LexicographicalNumbersTest {
	@Test
	@DisplayName("n = 13 -> [1,10,11,12,13,2,3,4,5,6,7,8,9]")
	void testSolutionLexicalOrder1() {
		LexicographicalNumbers task = new LexicographicalNumbers();
		LexicographicalNumbers.Solution solution = task.new Solution();
		List<Integer> result = solution.lexicalOrder(13);
		assertNotNull(result);
		assertEquals(13, result.size());
		assertTrue(Arrays.asList(1,10,11,12,13,2,3,4,5,6,7,8,9).equals(result));
	}

	@Test
	@DisplayName("n = 2 -> [1,2]")
	void testSolutionLexicalOrder2() {
		LexicographicalNumbers task = new LexicographicalNumbers();
		LexicographicalNumbers.Solution solution = task.new Solution();
		List<Integer> result = solution.lexicalOrder(2);
		assertNotNull(result);
		assertEquals(2, result.size());
		assertTrue(Arrays.asList(1,2).equals(result));
	}
}
