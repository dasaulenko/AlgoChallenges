package com.hramn.algo;

import java.util.HashSet;
import java.util.Set;

/*
 * 2359. Find Closest Node to Given Two Nodes
 * https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description
 * 
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where 
 * each node has at most one outgoing edge.
 * 
 * The graph is represented with a given 0-indexed array edges of size n, 
 * indicating that there is a directed edge from node i to node edges[i]. If 
 * there is no outgoing edge from i, then edges[i] == -1.
 * 
 * You are also given two integers node1 and node2.
 * 
 * Return the index of the node that can be reached from both node1 and node2, 
 * such that the maximum between the distance from node1 to that node, and from 
 * node2 to that node is minimized. If there are multiple answers, return the 
 * node with the smallest index, and if no possible answer exists, return -1.
 * 
 * Note that edges may contain cycles.
 * 
 * Example 1:
 * 1 > 2 < 0
 *     ^
 *     3
 * Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
 * Output: 2
 * Explanation: The distance from node 0 to node 2 is 1, and the distance from 
 * node 1 to node 2 is 1.
 * The maximum of those two distances is 1. It can be proven that we cannot get 
 * a node with a smaller maximum distance than 1, so we return node 2.
 * 
 * Example 2:
 * 0 > 1 > 2
 * Input: edges = [1,2,-1], node1 = 0, node2 = 2
 * Output: 2
 * Explanation: The distance from node 0 to node 2 is 2, and the distance from 
 * node 2 to itself is 0.
 * The maximum of those two distances is 2. It can be proven that we cannot get 
 * a node with a smaller maximum distance than 2, so we return node 2.
 * 
 * Constraints:
 * n == edges.length
 * 2 <= n <= 10^5
 * -1 <= edges[i] < n
 * edges[i] != i
 * 0 <= node1, node2 < n
 * 
 * TAG: 20250530
 * TAG: medium
 * TAG: directed_graph
 */
public class FindClosestNodeToGivenTwoNodes {
	class Solution { // O(N), O(N), N - edges.length
		public int closestMeetingNode(int[] edges, int node1, int node2) {
			Set<Integer> fromN1 = new HashSet<>();
			Set<Integer> fromN2 = new HashSet<>();
			int result = -1;
			int nextFromN1 = node1;
			int nextFromN2 = node2;
			while ((nextFromN1 >= 0 || nextFromN2 >= 0) && result < 0) {
				if (nextFromN1 >= 0) {
					if (fromN1.contains(nextFromN1)) {
						nextFromN1 = -1;
					} else {
						fromN1.add(nextFromN1);
						if (fromN2.contains(nextFromN1)) {
							result = nextFromN1;
						}
						nextFromN1 = edges[nextFromN1];
					}
				}
				if (nextFromN2 >= 0) {
					if (fromN2.contains(nextFromN2)) {
						nextFromN2 = -1;
					} else {
						fromN2.add(nextFromN2);
						if (fromN1.contains(nextFromN2)) {
							if (result >= 0) {
								result = Math.min(result, nextFromN2);
							} else {
								result = nextFromN2;
							}
						}
						nextFromN2 = edges[nextFromN2];
					}
				}  
			}
			return result;
		}
	}
}
