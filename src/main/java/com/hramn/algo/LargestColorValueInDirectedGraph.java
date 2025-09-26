package com.hramn.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 1857. Largest Color Value in a Directed Graph
 * https://leetcode.com/problems/largest-color-value-in-a-directed-graph/description
 * 
 * There is a directed graph of n colored nodes and m edges. The nodes are 
 * numbered from 0 to n - 1.
 * 
 * You are given a string colors where colors[i] is a lowercase English letter 
 * representing the color of the ith node in this graph (0-indexed). You are 
 * also given a 2D array edges where edges[j] = [aj, bj] indicates that there 
 * is a directed edge from node aj to node bj.
 * 
 * A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk 
 * such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The 
 * color value of the path is the number of nodes that are colored the most 
 * frequently occurring color along that path.
 * 
 * Return the largest color value of any valid path in the given graph, or -1 
 * if the graph contains a cycle.
 * 
 * Example 1:
 * 1 <- 0 -> 2 -> 3 -> 4
 * Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" 
 * (red in the above image).
 * 
 * Example 2:
 * 0 -> 0
 * Input: colors = "a", edges = [[0,0]]
 * Output: -1
 * Explanation: There is a cycle from 0 to 0.
 * 
 * Constraints:
 * n == colors.length
 * m == edges.length
 * 1 <= n <= 10^5
 * 0 <= m <= 10^5
 * colors consists of lowercase English letters.
 * 0 <= aj, bj < n
 * 
 * TAG: 20250526
 * TAG: hard
 * TAG: directed_graph
 */
public class LargestColorValueInDirectedGraph {
	class Solution { // O(N + M), O(N + M), N - colors.length(), M - edges.length
		public int largestPathValue(String colors, int[][] edges) {
			int n = colors.length();
			List<List<Integer>> adj = new ArrayList<>();
			int[] indegree = new int[n];

			for (int i = 0; i < n; i++) {
				adj.add(new ArrayList<>());
			}

			for (int[] edge : edges) {
				int from = edge[0];
				int to = edge[1];
				adj.get(from).add(to);
				indegree[to]++;
			}

			int[][] dp = new int[n][26];
			List<Integer> queue = new LinkedList<>();

			for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
			int color = colors.charAt(i) - 'a';
				dp[i][color] = 1;
			}

			int visited = 0;
			int max = 0;

			while (!queue.isEmpty()) {
				int node = queue.removeFirst();
				visited++;

				for (int next : adj.get(node)) {
					int color = colors.charAt(next) - 'a';
					for (int i = 0; i < 26; i++) {
						int inc = color == i ? 1 : 0;
						dp[next][i] = Math.max (dp[next][i], dp[node][i] + inc);
					}
					indegree[next]--;
					if (indegree[next] == 0) {
						queue.add(next);
					}
				}

				for (int i : dp[node]) {
					max = Math.max (max, i);
				}
			}

			return visited == n ? max : -1;
		}
	}

	class DfsSolution { // O(N * (N + M)), O(N + M), N - colors.length(), M - edges.length
		public int largestPathValue(String colors, int[][] edges) {
			int n = colors.length();
			int m = edges.length;
			if (m == 0 && n > 0) {
				return 1;
			}
			Map<Integer, List<Integer>> graph = new HashMap<>();
			Set<Integer> froms = new HashSet<>();
			Set<Integer> tos = new HashSet<>();
			createGraph(edges, graph, froms, tos);
			List<Integer> roots = findRoots (froms, tos);
			int max = -1;
			for (int root : roots) {
				int res = dfs (root, graph, colors);
				if (res < 0) {
					return res;
				}
				max = Math.max(max, res);
			}
			return max;
		}

		int dfs (int root, Map<Integer, List<Integer>> graph, String colors) {
			List<Integer> stack = new LinkedList<>();
			Set<Integer> visited = new HashSet<>();
			int[] counter = new int[26];
			stack.add(root);
			int max = 0;
			while (!stack.isEmpty()) {
				int node = stack.getLast();
				int color = colors.charAt(node) - 'a';
				if (visited.contains(node)) {
					visited.remove(node);
					counter[color]--;
					stack.removeLast();
				} else {
					visited.add(node);
					counter[color]++;
					List<Integer> tos = graph.get(node);
					if (tos == null) {
						for (int i = 0; i < 26; i++) {
							max = Math.max(max, counter[i]);
						}
					} else {
						for (int i : tos) {
							if (visited.contains(i)) {
								return -1;
							} else {
								stack.add(i);
							}
						}
					}
				}
			}
			return max;
		}
	}

	class ReqSolution { // O(N!), O(N + M), N - colors.length(), M - edges.length
		public int largestPathValue(String colors, int[][] edges) {
			int n = colors.length();
			int m = edges.length;
			if (m == 0 && n > 0) {
				return 1;
			}
			Map<Integer, List<Integer>> graph = new HashMap<>();
			Set<Integer> froms = new HashSet<>();
			Set<Integer> tos = new HashSet<>();
			createGraph(edges, graph, froms, tos);
			List<Integer> roots = findRoots (froms, tos);
 
			int max = -1;
			for (int root : roots) {
				int res = req (root, new HashSet<>(), graph, colors, new int[26]);
				if (res < 0) {
					return res;
				}
				max = Math.max(max, res);
			}
			return max;
		}

		int req (int node, Set<Integer> visited, Map<Integer, List<Integer>> graph, String colors, int[] counter) {
			if (visited.contains(node)) {
				return -1;
			}
			visited.add(node);
			int color = colors.charAt(node) - 'a';
			counter[color]++;
			List<Integer> tos = graph.get(node);
			int max = 0;
			if (tos == null) {
				for (int i = 0; i < 26; i++) {
					max = Math.max(max, counter[i]);
				}
			} else {
				for (int i : tos) {
					int res = req (i, visited, graph, colors, counter);
					if (res < 0) {
						return res;
					} else {
						max = Math.max(max, res);
					}
				}
			}
			counter[color]--;
			visited.remove(node);
			return max;
		}
	}

	void createGraph(int[][] edges, Map<Integer, List<Integer>> graph, Set<Integer> froms, Set<Integer> tos) {
		for (int i = 0; i < edges.length; i++) {
			int from = edges[i][0];
			int to = edges[i][1];
			froms.add(from);
			tos.add(to);
			List<Integer> list = 
					graph.getOrDefault(from, new ArrayList<Integer>());
			list.add(to);
			graph.put(from, list);
		}
	}

	List<Integer> findRoots (Set<Integer> froms, Set<Integer> tos) {
		List<Integer> roots = new ArrayList<>();
		for (int from : froms) {
			if (!tos.contains(from)) {
				roots.add(from);
			}
		}
		return roots;
	}
}
