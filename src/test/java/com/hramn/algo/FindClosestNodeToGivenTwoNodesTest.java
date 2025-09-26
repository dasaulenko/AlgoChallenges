package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindClosestNodeToGivenTwoNodesTest {
	@Test
	@DisplayName("edges = [2,2,3,-1], node1 = 0, node2 = 1 -> 2")
	void testSourceClosestMeetingNode1() {
		FindClosestNodeToGivenTwoNodes task = new FindClosestNodeToGivenTwoNodes();
		FindClosestNodeToGivenTwoNodes.Solution solution = task.new Solution();
		int result = solution.closestMeetingNode(new int[] {2,2,3,-1}, 0, 1);
		assertEquals(2, result);
	}

	@Test
	@DisplayName("edges = [1,2,-1], node1 = 0, node2 = 2 -> 2")
	void testSourceClosestMeetingNode2() {
		FindClosestNodeToGivenTwoNodes task = new FindClosestNodeToGivenTwoNodes();
		FindClosestNodeToGivenTwoNodes.Solution solution = task.new Solution();
		int result = solution.closestMeetingNode(new int[] {1,2,-1}, 0, 2);
		assertEquals(2, result);
	}
}
