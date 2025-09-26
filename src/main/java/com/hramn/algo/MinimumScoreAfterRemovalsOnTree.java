package com.hramn.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 2322. Minimum Score After Removals on a Tree
 * https://leetcode.com/problems/minimum-score-after-removals-on-a-tree/description
 * 
 * There is an undirected connected tree with n nodes labeled from 0 to n - 1 
 * and n - 1 edges.
 * 
 * You are given a 0-indexed integer array nums of length n where nums[i] 
 * represents the value of the ith node. You are also given a 2D integer array 
 * edges of length n - 1 where edges[i] = [ai, bi] indicates that there is 
 * an edge between nodes ai and bi in the tree.
 * 
 * Remove two distinct edges of the tree to form three connected components. 
 * For a pair of removed edges, the following steps are defined:
 * - Get the XOR of all the values of the nodes for each of the three 
 *   components respectively.
 * - The difference between the largest XOR value and the smallest XOR value is 
 *   the score of the pair.
 * - For example, say the three components have the node values: [4,5,7], [1,9], 
 *   and [3,3,3]. The three XOR values are 4 ^ 5 ^ 7 = 6, 1 ^ 9 = 8, 
 *   and 3 ^ 3 ^ 3 = 3. The largest XOR value is 8 and the smallest XOR value 
 *   is 3. The score is then 8 - 3 = 5.
 * 
 * Return the minimum score of any possible pair of edge removals on the given 
 * tree.
 * 
 * Example 1:
 * Input: nums = [1,5,5,4,11], edges = [[0,1],[1,2],[1,3],[3,4]]
 * Output: 9
 * Explanation: The diagram above shows a way to make a pair of removals.
 * - The 1st component has nodes [1,3,4] with values [5,4,11]. Its XOR value is 
 *   5 ^ 4 ^ 11 = 10.
 * - The 2nd component has node [0] with value [1]. Its XOR value is 1 = 1.
 * - The 3rd component has node [2] with value [5]. Its XOR value is 5 = 5.
 * The score is the difference between the largest and smallest XOR value 
 * which is 10 - 1 = 9.
 * It can be shown that no other pair of removals will obtain a smaller score 
 * than 9.
 * 
 * Example 2:
 * Input: nums = [5,5,2,4,4,2], edges = [[0,1],[1,2],[5,2],[4,3],[1,3]]
 * Output: 0
 * Explanation: The diagram above shows a way to make a pair of removals.
 * - The 1st component has nodes [3,4] with values [4,4]. Its XOR 
 *   value is 4 ^ 4 = 0.
 * - The 2nd component has nodes [1,0] with values [5,5]. Its XOR 
 *   value is 5 ^ 5 = 0.
 * - The 3rd component has nodes [2,5] with values [2,2]. Its XOR 
 *   value is 2 ^ 2 = 0.
 * The score is the difference between the largest and smallest XOR value 
 * which is 0 - 0 = 0.
 * We cannot obtain a smaller score than 0.
 * 
 * Constraints:
 * n == nums.length
 * 3 <= n <= 1000
 * 1 <= nums[i] <= 108
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges represents a valid tree.
 * 
 * TAG: 20250725
 * TAG: hard
 * TAG: xor
 * TAG: graph
 * TAG: tree
 * TAG: dfs
 */
public class MinimumScoreAfterRemovalsOnTree {
	public static void main (String[] args) {
		MinimumScoreAfterRemovalsOnTree task = new MinimumScoreAfterRemovalsOnTree();
		MinimumScoreAfterRemovalsOnTree.Solution solution = task.new Solution();
		System.out.println(solution.minimumScore(new int[] {9,14,2,1}, new int[][] {{2,3},{3,0},{3,1}}));
	}

	class Solution { // O(N^2), O(N^2)
		public int minimumScore(int[] nums, int[][] edges) {
			int n = nums.length;
			int result = Integer.MAX_VALUE;
			if (n == 3) {
				return getResult (nums[0], nums[1], nums[2]);
			}
			List<Integer>[] graph = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int[] e : edges) {
				graph[e[0]].add(e[1]);
				graph[e[1]].add(e[0]);
			}
			// System.out.println(Arrays.deepToString(graph));
			int[] pref = new int[n];
			Set<Integer>[] desc = new HashSet[n];
			for (int i = 0; i < n; i++) {
				desc[i] = new HashSet<>();
			}
			recDfs (graph, 0, -1, nums, pref, desc);
			// stackDfs (graph, 0, nums, pref, desc);
			// System.out.println(Arrays.toString(pref));
			// System.out.println(Arrays.deepToString(desc));
			for (int i = 1; i < n; i++) {
				int xorI = pref[i];
				for (int j = i+1; j < n; j++) {
					int xorJ = pref[j];
					int xor1 = 0;
					int xor2 = 0;
					int xor3 = 0;
					if (desc[i].contains(j)) {
						xor1 = xorJ;
						xor2 = xorI ^ xorJ;
						xor3 = pref[0] ^ xorI;
					} else if (desc[j].contains(i)) {
						xor1 = xorI;
						xor2 = xorJ ^ xorI;
						xor3 = pref[0] ^ xorJ;
					} else {
						xor1 = xorI;
						xor2 = xorJ;
						xor3 = pref[0] ^ xorI ^ xorJ;
					}
					// System.out.println(xor1 + " " + xor2 + " " + xor3 + " | " + getResult(xor1, xor2, xor3));
					result = Math.min (result, getResult(xor1, xor2, xor3));
				}
			}
			return result;
		}

		int getResult(int xor1, int xor2, int xor3) {
			int xorMax = Math.max (Math.max (xor1, xor2), xor3);
			int xorMin = Math.min (Math.min (xor1, xor2), xor3);
			return xorMax - xorMin;
		}

		void recDfs (List<Integer>[] graph, int start, int parent, int[] nums, int[] pref, Set<Integer>[] desc) {
			pref[start] = nums[start];
			desc[start].add(start);
			List<Integer> children = graph[start];
			for (int child : children) {
				if (child != parent) {
					recDfs (graph, child, start, nums, pref, desc);
					pref[start] ^= pref[child];
					desc[start].addAll(desc[child]);
				}
			}
		}

		void stackDfs (List<Integer>[] graph, int start, int[] nums, int[] pref, Set<Integer>[] desc) {
			List<Integer> stack = new LinkedList<>();
			int[] parents = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				parents[i] = -1;
			}
			int[] visited = new int[nums.length];
			stack.addFirst(start);
			while (!stack.isEmpty()) {
				int node = stack.getFirst();
				if (visited[node] == 0) {
					pref[node] = nums[node];
					desc[node].add(node);
					List<Integer> rel = graph[node];
					for (int n : rel) {
						if (visited[n] == -1) {
							stack.addFirst(n);
							parents[n] = node;
						}
					}
				} else {
					stack.removeFirst();
					List<Integer> rel = graph[node];
					for (int n : rel) {
						if (n != parents[n]) {
							pref[node] ^= pref[n];
							desc[node].addAll(desc[n]);
						}
					}
				}
				visited[node]++;
			}
		}
	}
}
