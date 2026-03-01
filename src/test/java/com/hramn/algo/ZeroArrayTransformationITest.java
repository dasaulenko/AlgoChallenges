package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ZeroArrayTransformationITest {
	@Test
	@DisplayName("nums = [1,0,1], queries = [[0,2]] -> true")
	void testBruteforceSolutionIsZeroArray1() {
		ZeroArrayTransformationI main = new ZeroArrayTransformationI();
		ZeroArrayTransformationI.BruteforceSolution solution 
				= main.new BruteforceSolution();
		boolean result = solution.isZeroArray(new int[] {1,0,1}, new int[][] {{0,2}});
		assertTrue(result);
	}

	@Test
	@DisplayName("nums = [4,3,2,1], queries = [[1,3],[0,2]] -> false")
	void testBruteforceSolutionIsZeroArray2() {
		ZeroArrayTransformationI main = new ZeroArrayTransformationI();
		ZeroArrayTransformationI.BruteforceSolution solution = 
				main.new BruteforceSolution();
		boolean result = 
				solution.isZeroArray(new int[] {4,3,2,1}, new int[][] {{1,3},{0,2}});
		assertFalse(result);
	}

	@Test
	@DisplayName("nums = [1,0,1], queries = [[0,2]] -> true")
	void testDiffArrSolutionIsZeroArray1() {
		ZeroArrayTransformationI main = new ZeroArrayTransformationI();
		ZeroArrayTransformationI.DiffArrSolution solution 
				= main.new DiffArrSolution();
		boolean result = solution.isZeroArray(new int[] {1,0,1}, new int[][] {{0,2}});
		assertTrue(result);
	}

	@Test
	@DisplayName("nums = [4,3,2,1], queries = [[1,3],[0,2]] -> false")
	void testDiffArrSolutionIsZeroArray2() {
		ZeroArrayTransformationI main = new ZeroArrayTransformationI();
		ZeroArrayTransformationI.DiffArrSolution solution = 
				main.new DiffArrSolution();
		boolean result = 
				solution.isZeroArray(new int[] {4,3,2,1}, new int[][] {{1,3},{0,2}});
		assertFalse(result);
	}	
}
