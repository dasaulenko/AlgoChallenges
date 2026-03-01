package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PascalsTriangleTest {
	@Test
	@DisplayName("numRows = 5 -> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]")
	void testSolutionGenerate1() {
		PascalsTriangle task = new PascalsTriangle();
		PascalsTriangle.Solution solution = task.new Solution();
		List<List<Integer>> result = solution.generate(5);
		assertNotNull(result);
		assertTrue(List.of(List.of(1), List.of(1,1), List.of(1,2,1), List.of(1,3,3,1), List.of(1,4,6,4,1)).equals(result));
	}

	@Test
	@DisplayName("numRows = 1 -> [[1]]")
	void testSolutionGenerate2() {
		PascalsTriangle task = new PascalsTriangle();
		PascalsTriangle.Solution solution = task.new Solution();
		List<List<Integer>> result = solution.generate(1);
		assertNotNull(result);
		assertTrue(List.of(List.of(1)).equals(result));
	}
}
