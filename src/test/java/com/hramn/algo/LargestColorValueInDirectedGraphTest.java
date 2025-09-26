package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LargestColorValueInDirectedGraphTest {
	@Test
	@DisplayName("colors = \"abaca\", edges = [[0,1],[0,2],[2,3],[3,4]] -> 3")
	void testSolutionLargestPathValue1() {
		LargestColorValueInDirectedGraph task = new LargestColorValueInDirectedGraph();
		LargestColorValueInDirectedGraph.Solution solution = task.new Solution();
		int result = solution.largestPathValue("abaca", new int[][] {{0,1},{0,2},{2,3},{3,4}});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("colors = \"a\", edges = [[0,0]] -> -1")
	void testSolutionLargestPathValue2() {
		LargestColorValueInDirectedGraph task = new LargestColorValueInDirectedGraph();
		LargestColorValueInDirectedGraph.Solution solution = task.new Solution();
		int result = solution.largestPathValue("a", new int[][] {{0,0}});
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("colors = \"abaca\", edges = [[0,1],[0,2],[2,3],[3,4]] -> 3")
	void testDfsSolutionLargestPathValue1() {
		LargestColorValueInDirectedGraph task = new LargestColorValueInDirectedGraph();
		LargestColorValueInDirectedGraph.DfsSolution solution = task.new DfsSolution();
		int result = solution.largestPathValue("abaca", new int[][] {{0,1},{0,2},{2,3},{3,4}});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("colors = \"a\", edges = [[0,0]] -> -1")
	void testDfsSolutionLargestPathValue2() {
		LargestColorValueInDirectedGraph task = new LargestColorValueInDirectedGraph();
		LargestColorValueInDirectedGraph.DfsSolution solution = task.new DfsSolution();
		int result = solution.largestPathValue("a", new int[][] {{0,0}});
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("colors = \"abaca\", edges = [[0,1],[0,2],[2,3],[3,4]] -> 3")
	void testReqSolutionLargestPathValue1() {
		LargestColorValueInDirectedGraph task = new LargestColorValueInDirectedGraph();
		LargestColorValueInDirectedGraph.ReqSolution solution = task.new ReqSolution();
		int result = solution.largestPathValue("abaca", new int[][] {{0,1},{0,2},{2,3},{3,4}});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("colors = \"a\", edges = [[0,0]] -> -1")
	void testReqSolutionLargestPathValue2() {
		LargestColorValueInDirectedGraph task = new LargestColorValueInDirectedGraph();
		LargestColorValueInDirectedGraph.ReqSolution solution = task.new ReqSolution();
		int result = solution.largestPathValue("a", new int[][] {{0,0}});
		assertEquals(-1, result);
	}
}
