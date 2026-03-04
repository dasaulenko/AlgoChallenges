package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PacificAtlanticWaterFlowTest {
	@Test
	@DisplayName("heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]] -> [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]")
	void testSolutionPacificAtlantic1() {
		PacificAtlanticWaterFlow task = new PacificAtlanticWaterFlow();
		PacificAtlanticWaterFlow.Solution solution = task.new Solution();
		List<List<Integer>> result = solution.pacificAtlantic(new int[][] {
			{1,2,2,3,5},
			{3,2,3,4,4},
			{2,4,5,3,1},
			{6,7,1,4,5},
			{5,1,1,2,4}
		});
		assertEquals(List.of(
			List.of(0,4),
			List.of(1,3),
			List.of(1,4),
			List.of(2,2),
			List.of(3,0),
			List.of(3,1),
			List.of(4,0)), result);
	}

	@Test
	@DisplayName("heights = [[1]] -> [[0,0]]")
	void testSolutionPacificAtlantic2() {
		PacificAtlanticWaterFlow task = new PacificAtlanticWaterFlow();
		PacificAtlanticWaterFlow.Solution solution = task.new Solution();
		List<List<Integer>> result = solution.pacificAtlantic(new int[][] {{1}});
		assertEquals(List.of(List.of(0,0)), result);
	}
}
