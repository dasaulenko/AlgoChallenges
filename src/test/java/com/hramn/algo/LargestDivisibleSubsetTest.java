package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LargestDivisibleSubsetTest {
	@Test
	@DisplayName("nums = [1,2,3] -> [1,2]")
	void testSolutionLargestDivisibleSubset1() {
		LargestDivisibleSubset main = new LargestDivisibleSubset();
		LargestDivisibleSubset.Solution solution = main.new Solution();
		List<Integer> result = solution.largestDivisibleSubset(new int[] {1,2,3});
		assertNotNull(result);
		assertEquals(2, result.size());
		assertTrue(List.of(2,1).equals(result));
	}

	@Test
	@DisplayName("nums = [1,2,4,8] -> [1,2,4,8]")
	void testSolutionLargestDivisibleSubset2() {
		LargestDivisibleSubset main = new LargestDivisibleSubset();
		LargestDivisibleSubset.Solution solution = main.new Solution();
		List<Integer> result = solution.largestDivisibleSubset(new int[] {1,2,4,8});
		assertNotNull(result);
		assertEquals(4, result.size());
		assertTrue(List.of(8,4,2,1).equals(result));
	}
}
