package com.hramn.algo.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MergeTwo2DArraysBySummingValuesTest {
	@Test
	@DisplayName("nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]] -> [[1,6],[2,3],[3,2],[4,6]]")
	void testTwoPointersSolutionMergeArrays1() {
		MergeTwo2DArraysBySummingValues parent = 
				new MergeTwo2DArraysBySummingValues();
		MergeTwo2DArraysBySummingValues.TwoPointersSolution solution = 
				parent.new TwoPointersSolution();
		int[][] result = solution.mergeArrays(
			new int[][] {{1,2},{2,3},{4,5}}, new int[][] {{1,4},{3,2},{4,1}});
		assertNotNull(result);
		assertEquals(4, result.length);
		assertTrue(
				Arrays.deepEquals(result, new int[][] {{1,6},{2,3},{3,2},{4,6}}));
	}

	@Test
	@DisplayName("nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]] -> [[1,3],[2,4],[3,6],[4,3],[5,5]]")
	void testTwoPointersSolutionMergeArrays2() {
		MergeTwo2DArraysBySummingValues parent = 
				new MergeTwo2DArraysBySummingValues();
		MergeTwo2DArraysBySummingValues.TwoPointersSolution solution = 
				parent.new TwoPointersSolution();
		int[][] result = solution.mergeArrays(
			new int[][] {{2,4},{3,6},{5,5}}, new int[][] {{1,3},{4,3}});
		assertNotNull(result);
		assertEquals(5, result.length);
		assertTrue(
				Arrays.deepEquals(result, new int[][] {{1,3},{2,4},{3,6},{4,3},{5,5}}));
	}

	@Test
	@DisplayName("nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]] -> [[1,6],[2,3],[3,2],[4,6]]")
	void testTreeMapSolutionMergeArrays1() {
		MergeTwo2DArraysBySummingValues parent = 
				new MergeTwo2DArraysBySummingValues();
		MergeTwo2DArraysBySummingValues.TreeMapSolution solution = 
				parent.new TreeMapSolution();
		int[][] result = solution.mergeArrays(
			new int[][] {{1,2},{2,3},{4,5}}, new int[][] {{1,4},{3,2},{4,1}});
		assertNotNull(result);
		assertEquals(4, result.length);
		assertTrue(
				Arrays.deepEquals(result, new int[][] {{1,6},{2,3},{3,2},{4,6}}));
	}

	@Test
	@DisplayName("nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]] -> [[1,3],[2,4],[3,6],[4,3],[5,5]]")
	void testTreeMapSolutionMergeArrays2() {
		MergeTwo2DArraysBySummingValues parent = 
				new MergeTwo2DArraysBySummingValues();
		MergeTwo2DArraysBySummingValues.TreeMapSolution solution = 
				parent.new TreeMapSolution();
		int[][] result = solution.mergeArrays(
			new int[][] {{2,4},{3,6},{5,5}}, new int[][] {{1,3},{4,3}});
		assertNotNull(result);
		assertEquals(5, result.length);
		assertTrue(
				Arrays.deepEquals(result, new int[][] {{1,3},{2,4},{3,6},{4,3},{5,5}}));
	}	
}
