package com.hramn.algo.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsIITest {
	@Test
	@DisplayName("word = \"aeioqq\", k = 1 -> 0")
	void testCountOfSubstrings1() {
		CountOfSubstringsContainingEveryVowelAndKConsonantsII parent = 
				new CountOfSubstringsContainingEveryVowelAndKConsonantsII();
		CountOfSubstringsContainingEveryVowelAndKConsonantsII.Solution solution = 
				parent.new Solution();
		long result = solution.countOfSubstrings("aeioqq", 1);
		assertEquals(0, result);
	}

	@Test
	@DisplayName("word = \"aeiou\", k = 0 -> 1")
	void testCountOfSubstrings2() {
		CountOfSubstringsContainingEveryVowelAndKConsonantsII parent = 
				new CountOfSubstringsContainingEveryVowelAndKConsonantsII();
		CountOfSubstringsContainingEveryVowelAndKConsonantsII.Solution solution = 
				parent.new Solution();
		long result = solution.countOfSubstrings("aeiou", 0);
		assertEquals(1, result);
	}

	@Test
	@DisplayName("word = \"ieaouqqieaouqq\", k = 1 -> 3")
	void testCountOfSubstrings3() {
		CountOfSubstringsContainingEveryVowelAndKConsonantsII parent = 
				new CountOfSubstringsContainingEveryVowelAndKConsonantsII();
		CountOfSubstringsContainingEveryVowelAndKConsonantsII.Solution solution = 
				parent.new Solution();
		long result = solution.countOfSubstrings("ieaouqqieaouqq", 1);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("word = \"iqeaouqi\", k = 2 -> 3")
	void testCountOfSubstrings4() {
		CountOfSubstringsContainingEveryVowelAndKConsonantsII parent = 
				new CountOfSubstringsContainingEveryVowelAndKConsonantsII();
		CountOfSubstringsContainingEveryVowelAndKConsonantsII.Solution solution = 
				parent.new Solution();
		long result = solution.countOfSubstrings("iqeaouqi", 2);
		assertEquals(3, result);
	}
}
