package com.hramn.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 3841. Palindromic Path Queries in a Tree
 */
public class PalindromicPathQueriesInTree {

	class Solution {

		public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
			List<Boolean> result = new ArrayList<>();
			List<List<Integer>> tree = buildTree (n, edges);
			char[] chars = s.toCharArray();
			for (String query : queries) {
				int[] q = parseQuery (query);
				if (q[0] == 0) {
					chars[q[1]] = (char)(q[2] + 'a');
				} else {
					List<Integer> route = dfs (tree, q[1], q[2]);
					result.add (isPalindrome (chars, route));
				}
			}
			return result;
		}

		// int[0] - 0 - query 1 | 1 - query 2
		// int[1] - index for query 1 | startIndex for query 2
		// int[2] = char - 'a' for query 1 | targetIndex for query 2
		private int[] parseQuery (String query) {
			int[] res = new int[3];
			String[] arr = query.split(" ");
			if (arr[0].charAt(0) == 'u') {
				res[1] = Integer.parseInt(arr[1]);
				res[2] = arr[2].charAt(0) - 'a';
			} else {
				res[0] = 1;
				res[1] = Integer.parseInt(arr[1]);
				res[2] = Integer.parseInt(arr[2]);
			}
			return res;
		}

		private boolean isPalindrome (char[] chars, List<Integer> route) {
			int[] letters = new int[26];
			for (int i : route) {
				letters[chars[i] - 'a']++;
			}
			int count = 0;
			for (int i : letters) count += i % 2;
			return count < 2;
		}

		private List<Integer> dfs (List<List<Integer>> tree, int startNode, int targetNode) {
			LinkedList<Integer> stack = new LinkedList<>();
			LinkedList<Integer> route = new LinkedList<>();
			boolean[] visited = new boolean[tree.size()];
			stack.add(startNode);

			while (!stack.isEmpty()) {
				int node = stack.getLast();
				if (visited[node]) {
					stack.removeLast();
					route.removeLast();
					continue;
				}
				route.add(node);
				visited[node] = true;
				for (int nextNode : tree.get(node)) {
					if (visited[nextNode]) continue;
					if (nextNode == targetNode) {
						route.add(nextNode);
						return route;
					}
					stack.add(nextNode);
				}
			}
			return null;
		}

		private List<List<Integer>> buildTree (int n, int[][] edges) {
			List<List<Integer>> adjacencyList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				adjacencyList.add(new ArrayList<>());
			}
			for (int[] edge : edges) {
				adjacencyList.get(edge[0]).add(edge[1]);
				adjacencyList.get(edge[1]).add(edge[0]);
			}
			return adjacencyList;
		}
	}
}
