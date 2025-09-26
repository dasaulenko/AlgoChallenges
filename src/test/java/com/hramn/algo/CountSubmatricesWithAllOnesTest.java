package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountSubmatricesWithAllOnesTest {
	@Test
	@DisplayName("mat = [[1,0,1],[1,1,0],[1,1,0]] -> 13")
	void testSolutionNumSubmat1() {
		CountSubmatricesWithAllOnes task = new CountSubmatricesWithAllOnes();
		CountSubmatricesWithAllOnes.Solution solution = task.new Solution();
		int result = solution.numSubmat(new int[][] {{1,0,1},{1,1,0},{1,1,0}});
		assertEquals(13, result);
	}

	@Test
	@DisplayName("mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]] -> 24")
	void testSolutionNumSubmat2() {
		CountSubmatricesWithAllOnes task = new CountSubmatricesWithAllOnes();
		CountSubmatricesWithAllOnes.Solution solution = task.new Solution();
		int result = solution.numSubmat(new int[][] {{0,1,1,0},{0,1,1,1},{1,1,1,0}});
		assertEquals(24, result);
	}
}
