package com.hramn.algo.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <strong>3331. Find Subtree Sizes After Changes</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Medium
 * <br>
 * <strong>LeetCode:</strong>
 * <a href="https://leetcode.com/problems/find-subtree-sizes-after-changes/">
 * 3331. Find Subtree Sizes After Changes</a>
 * <br>
 * <strong>Topic:</strong> array, hash table, string, tree, dfs
 *
 * <hr>
 *
 * <p>
 * You are given a tree rooted at node 0 that consists of {@code n} nodes
 * numbered from {@code 0} to {@code n - 1}. The tree is represented by an array
 * parent of size {@code n}, where {@code parent[i]} is the parent of node
 * {@code i}. Since node {@code 0} is the root, {@code parent[0] == -1}.
 *
 * <p>
 * You are also given a string {@code s} of length {@code n}, where {@code s[i]}
 * is the character assigned to node {@code i}.
 *
 * <p>
 * We make the following changes on the tree one time simultaneously for all
 * nodes {@code x} from {@code 1} to {@code n - 1}:
 * <ul>
 * <li>Find the closest node {@code y} to node {@code x} such that {@code y} is
 * an ancestor of {@code x}, and {@code s[x] == s[y]}.</li>
 * <li>If node {@code y} does not exist, do nothing.</li>
 * <li>Otherwise, remove the edge between {@code x} and its current parent and
 * make node {@code y} the new parent of {@code x} by adding an edge between
 * them.</li>
 * </ul>
 *
 * <p>
 * Return an array {@code answer} of size {@code n} where {@code answer[i]} is
 * the size of the subtree rooted at node {@code i} in the final tree.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code parent = [-1,0,0,1,1,1], s = "abaabc"}
 * <p>
 * Output: {@code [6,3,1,1,1,1]}
 * <p>
 * Explanation:
 * <br>
 * The parent of node 3 will change from node 1 to node 0.
 *
 * <p>
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code parent = [-1,0,4,0,1], s = "abbba"}
 * <p>
 * Output: {@code [5,2,1,1,1]}
 * <p>
 * Explanation:
 * <br>
 * The following changes will happen at the same time:
 * <ul>
 * <li>The parent of node 4 will change from node 1 to node 0.</li>
 * <li>The parent of node 2 will change from node 4 to node 1.</li>
 * </ul>
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>{@code n == parent.length == s.length}</li>
 * <li>{@code 1 <= n <= 10^5}</li>
 * <li>{@code 0 <= parent[i] <= n - 1} for all {@code i >= 1}.</li>
 * <li>{@code parent[0] == -1}</li>
 * <li>parent represents a valid tree.</li>
 * <li>{@code s} consists only of lowercase English letters.</li>
 * </ul>
 */
public class FindSubtreeSizesAfterChanges {
	private FindSubtreeSizesAfterChanges() {
		/* This utility class should not be instantiated */
	}

	static class Solution {
		public int[] findSubtreeSizes(int[] parent, String s) {
			int n = parent.length;
			List<List<Integer>> childrens = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				childrens.add(new ArrayList<>());
			}
			for (int i = 1; i < n; i++) {
				childrens.get(parent[i]).add(i);
			}
			List<LinkedList<Integer>> stacks = new ArrayList<>(26);
			for (int i = 0; i < 26; i++)
				stacks.add(new LinkedList<>());
			Map<Integer, List<Integer>> changes = new HashMap<>();
			int[] result = new int[n];
			dfs(childrens, 0, s, stacks, changes, result);
			return result;
		}

		private boolean dfs(
				List<List<Integer>> childrens,
				int root,
				String s,
				List<LinkedList<Integer>> stacks,
				Map<Integer, List<Integer>> changes,
				int[] nodes) {
			int ch = s.charAt(root) - 'a';
			LinkedList<Integer> stack = stacks.get(ch);
			boolean result = true;
			if (!stack.isEmpty()) {
				changes.computeIfAbsent(stack.getLast(), k -> new ArrayList<>()).add(root);
				result = false;
			}
			stacks.get(ch).add(root);
			int cnt = 1;
			List<Integer> children = childrens.get(root);
			for (int child : children) {
				boolean isParent = dfs(childrens, child, s, stacks, changes, nodes);
				if (isParent)
					cnt += nodes[child];
			}
			stacks.get(ch).removeLast();
			if (changes.containsKey(root)) {
				for (int ext : changes.get(root))
					cnt += nodes[ext];
			}

			nodes[root] = cnt;
			return result;
		}
	}
}
