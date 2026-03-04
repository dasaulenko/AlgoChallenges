package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialPositionsInBinaryMatrixTest {

	@Test
	@DisplayName("mat = [[1,0,0],[0,0,1],[1,0,0]] -> 1")
	void testNumSpecialSolution11() {
		SpecialPositionsInBinaryMatrix task = new SpecialPositionsInBinaryMatrix();
		SpecialPositionsInBinaryMatrix.Solution solution = task.new Solution();
		int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};
		int expected = 1;
		int actual = solution.numSpecialSolution1(mat);
		assert expected == actual;
	}

	@Test
	@DisplayName("mat = [[1,0,0],[0,1,0],[0,0,1]] -> 3")
	void testNumSpecialSolution12() {
		SpecialPositionsInBinaryMatrix task = new SpecialPositionsInBinaryMatrix();
		SpecialPositionsInBinaryMatrix.Solution solution = task.new Solution();
		int[][] mat = {{1,0,0},{0,1,0},{0,0,1}};
		int expected = 3;
		int actual = solution.numSpecialSolution1(mat);
		assert expected == actual;
	}

	@Test
	@DisplayName("mat = [[1,0,0],[0,1,0],[0,0,1]] -> 3")
	void testNumSpecialSolution13() {
		SpecialPositionsInBinaryMatrix task = new SpecialPositionsInBinaryMatrix();
		SpecialPositionsInBinaryMatrix.Solution solution = task.new Solution();
		int[][] mat = {{1,0,0},{0,1,0},{0,0,1}};
		int expected = 3;
		int actual = solution.numSpecialSolution1(mat);
		assert expected == actual;
	}

	@Test
	@DisplayName("mat = [[1,0,0],[0,0,1],[1,0,0]] -> 1")
	void testNumSpecialSolution21() {
		SpecialPositionsInBinaryMatrix task = new SpecialPositionsInBinaryMatrix();
		SpecialPositionsInBinaryMatrix.Solution solution = task.new Solution();
		int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};
		int expected = 1;
		int actual = solution.numSpecialSolution2(mat);
		assert expected == actual;
	}

	@Test
	@DisplayName("mat = [[1,0,0],[0,1,0],[0,0,1]] -> 3")
	void testNumSpecialSolution22() {
		SpecialPositionsInBinaryMatrix task = new SpecialPositionsInBinaryMatrix();
		SpecialPositionsInBinaryMatrix.Solution solution = task.new Solution();
		int[][] mat = {{1,0,0},{0,1,0},{0,0,1}};
		int expected = 3;
		int actual = solution.numSpecialSolution2(mat);
		assert expected == actual;
	}

	@Test
	@DisplayName("mat = [[1,0,0],[0,1,0],[0,0,1]] -> 3")
	void testNumSpecialSolution23() {
		SpecialPositionsInBinaryMatrix task = new SpecialPositionsInBinaryMatrix();
		SpecialPositionsInBinaryMatrix.Solution solution = task.new Solution();
		int[][] mat = {{1,0,0},{0,1,0},{0,0,1}};
		int expected = 3;
		int actual = solution.numSpecialSolution2(mat);
		assert expected == actual;
	}
}
