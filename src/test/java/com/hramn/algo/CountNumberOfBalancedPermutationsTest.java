package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountNumberOfBalancedPermutationsTest {
	@Test
	@DisplayName("num = \"123\" -> 2")
	void testSolutionCountBalancedPermutations1() {
		CountNumberOfBalancedPermutations task = new CountNumberOfBalancedPermutations();
		CountNumberOfBalancedPermutations.Solution solution = task.new Solution();
		int result = solution.countBalancedPermutations("123");
		assertEquals(2, result);
	}

	@Test
	@DisplayName("num = \"112\" -> 1")
	void testSolutionCountBalancedPermutations2() {
		CountNumberOfBalancedPermutations task = new CountNumberOfBalancedPermutations();
		CountNumberOfBalancedPermutations.Solution solution = task.new Solution();
		int result = solution.countBalancedPermutations("112");
		assertEquals(1, result);
	}

	@Test
	@DisplayName("num = \"12345\" -> 0")
	void testSolutionCountBalancedPermutations3() {
		CountNumberOfBalancedPermutations task = new CountNumberOfBalancedPermutations();
		CountNumberOfBalancedPermutations.Solution solution = task.new Solution();
		int result = solution.countBalancedPermutations("12345");
		assertEquals(0, result);
	}
}
