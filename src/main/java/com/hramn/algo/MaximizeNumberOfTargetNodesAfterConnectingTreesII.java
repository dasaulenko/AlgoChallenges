package com.hramn.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 3373. Maximize the Number of Target Nodes After Connecting Trees II
 * https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/description
 * 
 * There exist two undirected trees with n and m nodes, labeled from [0, n - 1] 
 * and [0, m - 1], respectively.
 * 
 * You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and 
 * m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is 
 * an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] 
 * indicates that there is an edge between nodes ui and vi in the second tree.
 * 
 * Node u is target to node v if the number of edges on the path from u to v is 
 * even. Note that a node is always target to itself.
 * 
 * Return an array of n integers answer, where answer[i] is the maximum 
 * possible number of nodes that are target to node i of the first tree if you 
 * had to connect one node from the first tree to another node in the second 
 * tree.
 * 
 * Note that queries are independent from each other. That is, for every query 
 * you will remove the added edge before proceeding to the next query.
 * 
 * Example 1:
 * Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], 
 *        edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]
 * Output: [8,7,7,8,8]
 * Explanation:
 * - For i = 0, connect node 0 from the first tree to node 0 from the second 
 *   tree.
 * - For i = 1, connect node 1 from the first tree to node 4 from the second 
 *   tree.
 * - For i = 2, connect node 2 from the first tree to node 7 from the second 
 *   tree.
 * - For i = 3, connect node 3 from the first tree to node 0 from the second 
 *   tree.
 * - For i = 4, connect node 4 from the first tree to node 4 from the second 
 *   tree.
 * 
 *   0           0 - 1 - 4
 *  / \         / \     / \
 * 1   2       2   3   5   6
 *    / \     /
 *   3   4   7
 * 
 * Example 2:
 * Input: edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]]
 * Output: [3,6,6,6,6]
 * Explanation:
 * For every i, connect node i of the first tree with any node of the second 
 * tree.
 * 
 *     0       0 - 1 - 2 - 3
 *  / / \ \
 * 1 2   3 4
 * 
 * Constraints:
 * 2 <= n, m <= 10^5
 * edges1.length == n - 1
 * edges2.length == m - 1
 * edges1[i].length == edges2[i].length == 2
 * edges1[i] = [ai, bi]
 * 0 <= ai, bi < n
 * edges2[i] = [ui, vi]
 * 0 <= ui, vi < m
 * The input is generated such that edges1 and edges2 represent valid trees.
 * 
 * TAG: 20250529
 * TAG: hard
 * TAG: graph
 * TAG: undirected_tree
 * TAG: dfs
 */
public class MaximizeNumberOfTargetNodesAfterConnectingTreesII {
	class Solution {
		int even1 = 0, odd1 = 0, even2 = 0, odd2 = 0;
		public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
			Map<Integer, List<Integer>> graph1 = createGraph (edges1);
			Map<Integer, List<Integer>> graph2 = createGraph (edges2);
			int n = graph1.keySet().size();
			int m = graph2.keySet().size();
			int[] colors1 = new int[n];
			int[] colors2 = new int[m];
			dfs (0, graph1, colors1, true);
			dfs (0, graph2, colors2, false);
			int maxAdd = Math.max(even2, odd2);
			int[] result = new int[n];
			for (int i = 0; i < n; i++) {
				result[i] = (colors1[i] == 0 ? even1 : odd1) + maxAdd;
			}
			return result;
		}

		class Pair {
			private int key;
			private int val;
			public Pair (int key, int val) {
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

		Map<Integer, List<Integer>> createGraph (int[][] edges) {
			Map<Integer, List<Integer>> graph = new HashMap<>();
			for (int[] e : edges) {
				List<Integer> list = graph.getOrDefault(e[0], new ArrayList<>());
				list.add(e[1]);
				graph.put(e[0], list);
				list = graph.getOrDefault(e[1], new ArrayList<>());
				list.add(e[0]);
				graph.put(e[1], list);
			}
			return graph;
		}

		void dfs (int root, Map<Integer, List<Integer>> graph, int[] colors, boolean is1) {
			List<Pair> stack = new LinkedList<>();
			Set<Integer> visited = new HashSet<>();
			stack.add (new Pair(root, 0));
			colors[0] = 0;
			if (is1) {
				even1++;
			} else {
				even2++;
			}
			while (!stack.isEmpty()) {
				Pair pair = stack.removeLast();
				int node = pair.getKey();
				int color = pair.getValue();
				visited.add(node);
				List<Integer> list = graph.get(node);
				int nextColor = (color + 1) % 2;
				for (int n : list) {
					if (!visited.contains(n)) {
						colors[n] = nextColor;
						if (nextColor == 0) {
							if (is1) {
								even1++;
							} else {
								even2++;
							}
						} else {
							if (is1) {
								odd1++;
							} else {
								odd2++;
							}
						}
						stack.add(new Pair(n, nextColor));
					}
				}
			}
    }
	}
}
