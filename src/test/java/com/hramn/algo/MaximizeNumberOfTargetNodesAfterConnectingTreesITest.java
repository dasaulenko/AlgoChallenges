package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximizeNumberOfTargetNodesAfterConnectingTreesITest {
	@Test
	@DisplayName("edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2 -> [9,7,9,8,8]")
	void testSolutionMaxTargetNodes1() {
		MaximizeNumberOfTargetNodesAfterConnectingTreesI task = new MaximizeNumberOfTargetNodesAfterConnectingTreesI();
		MaximizeNumberOfTargetNodesAfterConnectingTreesI.Solution solution = task.new Solution();
		int[] result = solution.maxTargetNodes(new int[][] {{0,1},{0,2},{2,3},{2,4}}, new int[][] {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}}, 2);
		assertNotNull(result);
		assertEquals(5, result.length);
		assertTrue(Arrays.equals(new int[] {9,7,9,8,8}, result));
	}

	@Test
	@DisplayName("edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]], k = 1 -> [6,3,3,3,3]")
	void testSolutionMaxTargetNodes2() {
		MaximizeNumberOfTargetNodesAfterConnectingTreesI task = new MaximizeNumberOfTargetNodesAfterConnectingTreesI();
		MaximizeNumberOfTargetNodesAfterConnectingTreesI.Solution solution = task.new Solution();
		int[] result = solution.maxTargetNodes(new int[][] {{0,1},{0,2},{0,3},{0,4}}, new int[][] {{0,1},{1,2},{2,3}}, 1);
		assertNotNull(result);
		assertEquals(5, result.length);
		assertTrue(Arrays.equals(new int[] {6,3,3,3,3}, result));
	}
}
