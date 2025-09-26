package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMostFrequentVowelAndConsonantTest {
	@Test
	@DisplayName("s = \"successes\" -> 6")
	void testSolutionMaxFreqSum1() {
		FindMostFrequentVowelAndConsonant task = new FindMostFrequentVowelAndConsonant();
		FindMostFrequentVowelAndConsonant.Solution solution = task.new Solution();
		int result = solution.maxFreqSum("successes");
		assertEquals(6, result);
	}

	@Test
	@DisplayName("s = \"aeiaeia\" -> 3")
	void testSolutionMaxFreqSum2() {
		FindMostFrequentVowelAndConsonant task = new FindMostFrequentVowelAndConsonant();
		FindMostFrequentVowelAndConsonant.Solution solution = task.new Solution();
		int result = solution.maxFreqSum("aeiaeia");
		assertEquals(3, result);
	}
}
