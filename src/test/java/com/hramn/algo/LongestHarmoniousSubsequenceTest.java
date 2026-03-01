package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LongestHarmoniousSubsequenceTest {
	@Test
	@DisplayName("nums = [1,3,2,2,5,2,3,7] -> 5")
	void testHashMapSolutionFindLHS1() {
		LongestHarmoniousSubsequence task = new LongestHarmoniousSubsequence();
		LongestHarmoniousSubsequence.HashMapSolution solution = task.new HashMapSolution();
		int result = solution.findLHS(new int[] {1,3,2,2,5,2,3,7});
		assertEquals(5, result);
	}

	@Test
	@DisplayName("nums = [1,2,3,4] -> 2")
	void testHashMapSolutionFindLHS2() {
		LongestHarmoniousSubsequence task = new LongestHarmoniousSubsequence();
		LongestHarmoniousSubsequence.HashMapSolution solution = task.new HashMapSolution();
		int result = solution.findLHS(new int[] {1,2,3,4});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("nums = [1,1,1,1] -> 0")
	void testHashMapSolutionFindLHS3() {
		LongestHarmoniousSubsequence task = new LongestHarmoniousSubsequence();
		LongestHarmoniousSubsequence.HashMapSolution solution = task.new HashMapSolution();
		int result = solution.findLHS(new int[] {1,1,1,1});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("nums = [1,3,2,2,5,2,3,7] -> 5")
	void testSortArraySolutionSolutionFindLHS1() {
		LongestHarmoniousSubsequence task = new LongestHarmoniousSubsequence();
		LongestHarmoniousSubsequence.SortArraySolution solution = task.new SortArraySolution();
		int result = solution.findLHS(new int[] {1,3,2,2,5,2,3,7});
		assertEquals(5, result);
	}

	@Test
	@DisplayName("nums = [1,2,3,4] -> 2")
	void testSortArraySolutionSolutionFindLHS2() {
		LongestHarmoniousSubsequence task = new LongestHarmoniousSubsequence();
		LongestHarmoniousSubsequence.SortArraySolution solution = task.new SortArraySolution();
		int result = solution.findLHS(new int[] {1,2,3,4});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("nums = [1,1,1,1] -> 0")
	void testSortArraySolutionSolutionFindLHS3() {
		LongestHarmoniousSubsequence task = new LongestHarmoniousSubsequence();
		LongestHarmoniousSubsequence.SortArraySolution solution = task.new SortArraySolution();
		int result = solution.findLHS(new int[] {1,1,1,1});
		assertEquals(0, result);
	}
}
