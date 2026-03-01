package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SetMatrixZeroesTest {
	@Test
	@DisplayName("matrix = [[1,1,1],[1,0,1],[1,1,1]] -> [[1,0,1],[0,0,0],[1,0,1]]")
	void testSolutionSetZeroes1() {
		SetMatrixZeroes main = new SetMatrixZeroes();
		SetMatrixZeroes.Solution solution = main.new Solution();
		int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
		solution.setZeroes(matrix);
		assertTrue(Arrays.deepEquals(matrix, new int[][] {{1,0,1},{0,0,0},{1,0,1}}));
	}

	@Test
	@DisplayName("matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]] -> [[0,0,0,0],[0,4,5,0],[0,3,1,0]]")
	void testSolutionSetZeroes2() {
		SetMatrixZeroes main = new SetMatrixZeroes();
		SetMatrixZeroes.Solution solution = main.new Solution();
		int[][] matrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		solution.setZeroes(matrix);
		assertTrue(Arrays.deepEquals(matrix, new int[][] {{0,0,0,0},{0,4,5,0},{0,3,1,0}}));
	}
}
