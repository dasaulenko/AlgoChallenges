package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RangeProductQueriesOfPowersTest {
	@Test
	@DisplayName("n = 15, queries = [[0,1],[2,2],[0,3]] -> [2,4,64]")
	void testMySolutionProductQueries1() {
		RangeProductQueriesOfPowers task = new RangeProductQueriesOfPowers();
		RangeProductQueriesOfPowers.MySolution solution = task.new MySolution();
		int[] result = solution.productQueries(15, new int[][] {{0,1},{2,2},{0,3}});
		assertNotNull(result);
		assertTrue(Arrays.equals(result, new int[] {2,4,64}));
	}

	@Test
	@DisplayName("n = 2, queries = [[0,0]] -> [2]")
	void testMySolutionProductQueries2() {
		RangeProductQueriesOfPowers task = new RangeProductQueriesOfPowers();
		RangeProductQueriesOfPowers.MySolution solution = task.new MySolution();
		int[] result = solution.productQueries(2, new int[][] {{0,0}});
		assertNotNull(result);
		assertTrue(Arrays.equals(result, new int[] {2}));
	}

	@Test
	@DisplayName("n = 15, queries = [[0,1],[2,2],[0,3]] -> [2,4,64]")
	void testBestTimeSolutionProductQueries1() {
		RangeProductQueriesOfPowers task = new RangeProductQueriesOfPowers();
		RangeProductQueriesOfPowers.BestTimeSolution solution = task.new BestTimeSolution();
		int[] result = solution.productQueries(15, new int[][] {{0,1},{2,2},{0,3}});
		assertNotNull(result);
		assertTrue(Arrays.equals(result, new int[] {2,4,64}));
	}

	@Test
	@DisplayName("n = 2, queries = [[0,0]] -> [2]")
	void testBestTimeSolutionProductQueries2() {
		RangeProductQueriesOfPowers task = new RangeProductQueriesOfPowers();
		RangeProductQueriesOfPowers.BestTimeSolution solution = task.new BestTimeSolution();
		int[] result = solution.productQueries(2, new int[][] {{0,0}});
		assertNotNull(result);
		assertTrue(Arrays.equals(result, new int[] {2}));
	}
}
