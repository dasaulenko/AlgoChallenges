package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberOfMatchingSubsequencesTest {
	@Test
	@DisplayName("s = \"abcde\", words = [\"a\",\"bb\",\"acd\",\"ace\"] -> 3")
	void testSolutionNumMatchingSubseq1() {
		NumberOfMatchingSubsequences task = new NumberOfMatchingSubsequences();
		NumberOfMatchingSubsequences.Solution solution = task.new Solution();
		int result = solution.numMatchingSubseq("abcde", new String[] {"a","bb","acd","ace"});
		assertEquals(result, 3);
	}

	@Test
	@DisplayName("s = \"dsahjpjauf\", words = [\"ahjpjau\",\"ja\",\"ahbwzgqnuk\",\"tnmlanowax\"] -> 2")
	void testSolutionNumMatchingSubseq2() {
		NumberOfMatchingSubsequences task = new NumberOfMatchingSubsequences();
		NumberOfMatchingSubsequences.Solution solution = task.new Solution();
		int result = solution.numMatchingSubseq("dsahjpjauf", new String[] {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"});
		assertEquals(result, 2);
	}
}
