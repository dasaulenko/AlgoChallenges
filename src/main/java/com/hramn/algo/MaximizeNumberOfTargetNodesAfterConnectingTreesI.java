package com.hramn.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 3372. Maximize the Number of Target Nodes After Connecting Trees I
 * https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/description
 * 
 * There exist two undirected trees with n and m nodes, with distinct labels in 
 * ranges [0, n - 1] and [0, m - 1], respectively.
 * 
 * You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and 
 * m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an 
 * edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] 
 * indicates that there is an edge between nodes ui and vi in the second tree. 
 * You are also given an integer k.
 * 
 * Node u is target to node v if the number of edges on the path from u to v is 
 * less than or equal to k. Note that a node is always target to itself.
 * 
 * Return an array of n integers answer, where answer[i] is the maximum 
 * possible number of nodes target to node i of the first tree if you have to 
 * connect one node from the first tree to another node in the second tree.
 * 
 * Note that queries are independent from each other. That is, for every query 
 * you will remove the added edge before proceeding to the next query.
 * 
 * Example 1:
 * Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2
 * Output: [9,7,9,8,8]
 * Explanation:
 * - For i = 0, connect node 0 from the first tree to node 0 from the second 
 *   tree.
 * - For i = 1, connect node 1 from the first tree to node 0 from the second 
 *   tree.
 * - For i = 2, connect node 2 from the first tree to node 4 from the second 
 *   tree.
 * - For i = 3, connect node 3 from the first tree to node 4 from the second 
 *   tree.
 * - For i = 4, connect node 4 from the first tree to node 4 from the second 
 *   tree.
 *   0          0 - 1 - 4
 *  / \        / \     / \
 * 1   2      2   3   5   6
 *    / \    /
 *   3   4  7
 * 
 * Example 2:
 * Input: edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]], k = 1
 * Output: [6,3,3,3,3]
 * Explanation:
 * For every i, connect node i of the first tree with any node of the second 
 * tree.
 *     0      0 - 1 - 2 - 3
 *  / / \ \
 * 1 2   3 4
 * 
 * Constraints:
 * 2 <= n, m <= 1000
 * edges1.length == n - 1
 * edges2.length == m - 1
 * edges1[i].length == edges2[i].length == 2
 * edges1[i] = [ai, bi]
 * 0 <= ai, bi < n
 * edges2[i] = [ui, vi]
 * 0 <= ui, vi < m
 * The input is generated such that edges1 and edges2 represent valid trees.
 * 0 <= k <= 1000
 * 
 * TAG: 20250528
 * TAG: medium
 * TAG: graph
 * TAG: dfs
 */
public class MaximizeNumberOfTargetNodesAfterConnectingTreesI {
	class Pair {
		private int key;
		private int val;
		public Pair(int key, int val) {
			this.key = key;
			this.val = val;
		}
		public int getKey() {
			return key;
		}
		public int getValue() {
			return val;
		}
	}
	class Solution {
		public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
			Map<Integer, List<Integer>> graph1 = createGraph(edges1);
			Map<Integer, List<Integer>> graph2 = createGraph(edges2);
			int[] result = new int[graph1.size()];
			int maxAdd = 0;
			for (int key : graph2.keySet()) {
				maxAdd = Math.max(maxAdd, dfs(key, graph2, k-1));
			}
			for (int key : graph1.keySet()) {
				int maxCount = dfs (key, graph1, k);
				result[key] = maxCount + maxAdd;
			}
			return result;
		}

		Map<Integer, List<Integer>> createGraph(int[][] edges) {
			Map<Integer, List<Integer>> graph = new HashMap<>();
			for (int[] tos : edges) {
				List<Integer> list = graph.getOrDefault(tos[0], new ArrayList<>());
				list.add(tos[1]);
				graph.put(tos[0], list);
				list = graph.getOrDefault(tos[1], new ArrayList<>());
				list.add(tos[0]);
				graph.put(tos[1], list);
			}
			return graph;
		}

		int dfs (int node, Map<Integer, List<Integer>> graph, int k) {
			Set<Integer> visited = new HashSet<>();
			List<Pair> stack = new LinkedList<>();
			if (k < 0) {
				return 0;
			}
			int result = 1;
			if (k > 0) {
				stack.add(new Pair(node, 0));
			}
			while(!stack.isEmpty()) {
				Pair pair = stack.removeLast();
				int curNode = pair.getKey();
				int path = pair.getValue();
				visited.add(curNode);
				List<Integer> neigh = graph.get(curNode);
				for (int nextNode : neigh) {
					if (!visited.contains(nextNode)) {
						result++;
						if (path < k-1) {
							stack.add(new Pair(nextNode, path + 1));
						}
					}
				}
			}
			return result;
		}
	}
}
