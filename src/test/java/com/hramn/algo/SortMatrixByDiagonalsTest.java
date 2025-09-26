package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortMatrixByDiagonalsTest {
	@Test
	@DisplayName("grid = [[1,7,3],[9,8,2],[4,5,6]] -> [[8,2,3],[9,6,7],[4,5,1]]")
	void testSolutionSortMatrix1() {
		SortMatrixByDiagonals task = new SortMatrixByDiagonals();
		SortMatrixByDiagonals.Solution solution = task.new Solution();
		int[][] result = solution.sortMatrix(new int[][] {{1,7,3},{9,8,2},{4,5,6}});
		assertNotNull(result);
		assertTrue(Arrays.deepEquals(new int[][] {{8,2,3},{9,6,7},{4,5,1}}, result));
	}

	@Test
	@DisplayName("grid = [[0,1],[1,2]] -> [[2,1],[1,0]]")
	void testSolutionSortMatrix2() {
		SortMatrixByDiagonals task = new SortMatrixByDiagonals();
		SortMatrixByDiagonals.Solution solution = task.new Solution();
		int[][] result = solution.sortMatrix(new int[][] {{0,1},{1,2}});
		assertNotNull(result);
		assertTrue(Arrays.deepEquals(new int[][] {{2,1},{1,0}}, result));
	}

	@Test
	@DisplayName("grid = [[1]] -> [[1]]")
	void testSolutionSortMatrix3() {
		SortMatrixByDiagonals task = new SortMatrixByDiagonals();
		SortMatrixByDiagonals.Solution solution = task.new Solution();
		int[][] result = solution.sortMatrix(new int[][] {{1}});
		assertNotNull(result);
		assertTrue(Arrays.deepEquals(new int[][] {{1}}, result));
	}
}
