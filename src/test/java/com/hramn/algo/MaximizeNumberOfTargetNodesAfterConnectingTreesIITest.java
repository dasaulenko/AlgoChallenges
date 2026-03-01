package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximizeNumberOfTargetNodesAfterConnectingTreesIITest {
	@Test
	@DisplayName("edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]] -> [8,7,7,8,8]")
	void testSolutionMaxTargetNodes1() {
		MaximizeNumberOfTargetNodesAfterConnectingTreesII task = new MaximizeNumberOfTargetNodesAfterConnectingTreesII();
		MaximizeNumberOfTargetNodesAfterConnectingTreesII.Solution solution = task.new Solution();
		int[] result = solution.maxTargetNodes(new int[][] {{0,1},{0,2},{2,3},{2,4}}, new int[][] {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}});
		assertNotNull(result);
		assertEquals(5, result.length);
		assertTrue(Arrays.equals (new int[] {8,7,7,8,8}, result));
	}

	@Test
	@DisplayName("edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]] -> [3,6,6,6,6]")
	void testSolutionMaxTargetNodes2() {
		MaximizeNumberOfTargetNodesAfterConnectingTreesII task = new MaximizeNumberOfTargetNodesAfterConnectingTreesII();
		MaximizeNumberOfTargetNodesAfterConnectingTreesII.Solution solution = task.new Solution();
		int[] result = solution.maxTargetNodes(new int[][] {{0,1},{0,2},{0,3},{0,4}}, new int[][] {{0,1},{1,2},{2,3}});
		assertNotNull(result);
		assertEquals(5, result.length);
		assertTrue(Arrays.equals (new int[] {3,6,6,6,6}, result));
	}
}
