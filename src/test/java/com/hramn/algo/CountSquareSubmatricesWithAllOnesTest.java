package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountSquareSubmatricesWithAllOnesTest {
	@Test
	@DisplayName("matrix = [[0,1,1,1],[1,1,1,1],[0,1,1,1]] -> 15")
	void testSolutionCountSquares1() {
		CountSquareSubmatricesWithAllOnes task = new CountSquareSubmatricesWithAllOnes();
		CountSquareSubmatricesWithAllOnes.Solution solution = task.new Solution();
		int result = solution.countSquares(new int[][] {{0,1,1,1},{1,1,1,1},{0,1,1,1}});
		assertEquals(15, result);
	}

	@Test
	@DisplayName("matrix = [[1,0,1],[1,1,0],[1,1,0]] -> 7")
	void testSolutionCountSquares2() {
		CountSquareSubmatricesWithAllOnes task = new CountSquareSubmatricesWithAllOnes();
		CountSquareSubmatricesWithAllOnes.Solution solution = task.new Solution();
		int result = solution.countSquares(new int[][] {{1,0,1},{1,1,0},{1,1,0}});
		assertEquals(7, result);
	}
}
