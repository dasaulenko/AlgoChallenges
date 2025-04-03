package com.hramn.algo.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumNumberOfPointsFromGridQueriesTest {
	@Test
	@DisplayName("grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2] -> [5,8,1]")
	void testBruteforceSolutionMaxPoints1() {
		MaximumNumberOfPointsFromGridQueries parent = new MaximumNumberOfPointsFromGridQueries();
		MaximumNumberOfPointsFromGridQueries.BruteforceSolution solution = parent.new BruteforceSolution();
		int[] result = solution.maxPoints(new int[][] {{1,2,3},{2,5,7},{3,5,1}}, new int[] {5,6,2});
		assertNotNull(result);
		assertEquals(3, result.length);
		assertTrue(Arrays.equals(new int[] {5,8,1}, result));
	}

	@Test
	@DisplayName("grid = [[5,2,1],[1,1,2]], queries = [3] -> [0]")
	void testBruteforceSolutionMaxPoints2() {
		MaximumNumberOfPointsFromGridQueries parent = new MaximumNumberOfPointsFromGridQueries();
		MaximumNumberOfPointsFromGridQueries.BruteforceSolution solution = parent.new BruteforceSolution();
		int[] result = solution.maxPoints(new int[][] {{5,2,1},{1,1,2}}, new int[] {3});
		assertNotNull(result);
		assertEquals(1, result.length);
		assertTrue(Arrays.equals(new int[] {0}, result));
	}
}
