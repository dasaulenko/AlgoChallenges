package com.hramn.algo.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShortestCommonSupersequenceTest {
	@Test
	@DisplayName("str1 = \"abac\", str2 = \"cab\" -> \"cabac\"")
	void testDPSolutionShortestCommonSupersequence1() {
		ShortestCommonSupersequence shortestCommonSupersequence = 
				new ShortestCommonSupersequence();
		ShortestCommonSupersequence.DPSolution solution = 
				shortestCommonSupersequence.new DPSolution();
		String result = 
				solution.shortestCommonSupersequence("abac", "cab");
		assertNotNull(result);
		assertEquals("cabac", result);
	}

	@Test
	@DisplayName("str1 = \"aaaaaaaa\", str2 = \"aaaaaaaa\" -> \"aaaaaaaa\"")
	void testDPSolutionShortestCommonSupersequence2() {
		ShortestCommonSupersequence shortestCommonSupersequence = 
				new ShortestCommonSupersequence();
		ShortestCommonSupersequence.DPSolution solution = 
				shortestCommonSupersequence.new DPSolution();
		String result = 
				solution.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa");
		assertNotNull(result);
		assertEquals("aaaaaaaa", result);
	}
}
