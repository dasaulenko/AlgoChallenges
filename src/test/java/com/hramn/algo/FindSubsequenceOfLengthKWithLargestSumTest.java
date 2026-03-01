package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindSubsequenceOfLengthKWithLargestSumTest {
	@Test
	@DisplayName("nums = [2,1,3,3], k = 2 -> [3,3]")
	void testSolution1MaxSubsequence1() {
		FindSubsequenceOfLengthKWithLargestSum task = new FindSubsequenceOfLengthKWithLargestSum();
		FindSubsequenceOfLengthKWithLargestSum.Solution1 solution = task.new Solution1();
		int[] result = solution.maxSubsequence(new int[] {2,1,3,3}, 2);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertTrue(Arrays.equals(new int[] {3,3}, result));
	}

	@Test
	@DisplayName("nums = [-1,-2,3,4], k = 3 -> [-1,3,4]")
	void testSolution1MaxSubsequence2() {
		FindSubsequenceOfLengthKWithLargestSum task = new FindSubsequenceOfLengthKWithLargestSum();
		FindSubsequenceOfLengthKWithLargestSum.Solution1 solution = task.new Solution1();
		int[] result = solution.maxSubsequence(new int[] {-1,-2,3,4}, 3);
		assertNotNull(result);
		assertEquals(3, result.length);
		assertTrue(Arrays.equals(new int[] {-1,3,4}, result));
	}

	@Test
	@DisplayName("nums = [3,4,3,3], k = 2 -> [3,4]")
	void testSolution1MaxSubsequence3() {
		FindSubsequenceOfLengthKWithLargestSum task = new FindSubsequenceOfLengthKWithLargestSum();
		FindSubsequenceOfLengthKWithLargestSum.Solution1 solution = task.new Solution1();
		int[] result = solution.maxSubsequence(new int[] {3,4,3,3}, 2);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertTrue(Arrays.equals(new int[] {3,4}, result));
	}

	@Test
	@DisplayName("nums = [2,1,3,3], k = 2 -> [3,3]")
	void testSolution2MaxSubsequence1() {
		FindSubsequenceOfLengthKWithLargestSum task = new FindSubsequenceOfLengthKWithLargestSum();
		FindSubsequenceOfLengthKWithLargestSum.Solution2 solution = task.new Solution2();
		int[] result = solution.maxSubsequence(new int[] {2,1,3,3}, 2);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertTrue(Arrays.equals(new int[] {3,3}, result));
	}

	@Test
	@DisplayName("nums = [-1,-2,3,4], k = 3 -> [-1,3,4]")
	void testSolution2MaxSubsequence2() {
		FindSubsequenceOfLengthKWithLargestSum task = new FindSubsequenceOfLengthKWithLargestSum();
		FindSubsequenceOfLengthKWithLargestSum.Solution2 solution = task.new Solution2();
		int[] result = solution.maxSubsequence(new int[] {-1,-2,3,4}, 3);
		assertNotNull(result);
		assertEquals(3, result.length);
		assertTrue(Arrays.equals(new int[] {-1,3,4}, result));
	}

	@Test
	@DisplayName("nums = [3,4,3,3], k = 2 -> [3,4]")
	void testSolution2MaxSubsequence3() {
		FindSubsequenceOfLengthKWithLargestSum task = new FindSubsequenceOfLengthKWithLargestSum();
		FindSubsequenceOfLengthKWithLargestSum.Solution2 solution = task.new Solution2();
		int[] result = solution.maxSubsequence(new int[] {3,4,3,3}, 2);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertTrue(Arrays.equals(new int[] {3,4}, result));
	}

	@Test
	@DisplayName("nums = [2,1,3,3], k = 2 -> [3,3]")
	void testSolution3MaxSubsequence1() {
		FindSubsequenceOfLengthKWithLargestSum task = new FindSubsequenceOfLengthKWithLargestSum();
		FindSubsequenceOfLengthKWithLargestSum.Solution3 solution = task.new Solution3();
		int[] result = solution.maxSubsequence(new int[] {2,1,3,3}, 2);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertTrue(Arrays.equals(new int[] {3,3}, result));
	}

	@Test
	@DisplayName("nums = [-1,-2,3,4], k = 3 -> [-1,3,4]")
	void testSolution3MaxSubsequence2() {
		FindSubsequenceOfLengthKWithLargestSum task = new FindSubsequenceOfLengthKWithLargestSum();
		FindSubsequenceOfLengthKWithLargestSum.Solution3 solution = task.new Solution3();
		int[] result = solution.maxSubsequence(new int[] {-1,-2,3,4}, 3);
		assertNotNull(result);
		assertEquals(3, result.length);
		assertTrue(Arrays.equals(new int[] {-1,3,4}, result));
	}

	@Test
	@DisplayName("nums = [3,4,3,3], k = 2 -> [3,4]")
	void testSolution3MaxSubsequence3() {
		FindSubsequenceOfLengthKWithLargestSum task = new FindSubsequenceOfLengthKWithLargestSum();
		FindSubsequenceOfLengthKWithLargestSum.Solution3 solution = task.new Solution3();
		int[] result = solution.maxSubsequence(new int[] {3,4,3,3}, 2);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertTrue(Arrays.equals(new int[] {3,4}, result));
	}
}
