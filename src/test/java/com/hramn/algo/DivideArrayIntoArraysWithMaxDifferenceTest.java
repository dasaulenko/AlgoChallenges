package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DivideArrayIntoArraysWithMaxDifferenceTest {
	@Test
	@DisplayName("nums = [1,3,4,8,7,9,3,5,1], k = 2 -> [[1,1,3],[3,4,5],[7,8,9]]")
	void testSolutionDivideArray1() {
		DivideArrayIntoArraysWithMaxDifference task = new DivideArrayIntoArraysWithMaxDifference();
		DivideArrayIntoArraysWithMaxDifference.Solution solution = task.new Solution();
		int[][] result = solution.divideArray(new int[] {1,3,4,8,7,9,3,5,1}, 2);
		assertNotNull(result);
		assertEquals(3, result.length);
		assertTrue(Arrays.deepEquals(new int[][] {{1,1,3},{3,4,5},{7,8,9}}, result));
	}

	@Test
	@DisplayName("nums = [2,4,2,2,5,2], k = 2 -> []")
	void testSolutionDivideArray2() {
		DivideArrayIntoArraysWithMaxDifference task = new DivideArrayIntoArraysWithMaxDifference();
		DivideArrayIntoArraysWithMaxDifference.Solution solution = task.new Solution();
		int[][] result = solution.divideArray(new int[] {2,4,2,2,5,2}, 2);
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	@Test
	@DisplayName("nums = [4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], k = 14 -> [[2,2,2],[4,5,5],[5,5,7],[7,8,8],[9,9,10],[11,12,12]]")
	void testSolutionDivideArray3() {
		DivideArrayIntoArraysWithMaxDifference task = new DivideArrayIntoArraysWithMaxDifference();
		DivideArrayIntoArraysWithMaxDifference.Solution solution = task.new Solution();
		int[][] result = solution.divideArray(new int[] {4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11}, 14);
		assertNotNull(result);
		assertEquals(6, result.length);
		assertTrue(Arrays.deepEquals(new int[][] {{2,2,2},{4,5,5},{5,5,7},{7,8,8},{9,9,10},{11,12,12}}, result));
	}
}
