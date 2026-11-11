package com.hramn.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 1569. Number of Ways to Reorder Array to Get Same BST
 * 
 * <p>Given an array nums that represents a permutation of integers from 1 to n. 
 * We are going to construct a binary search tree (BST) by inserting 
 * the elements of nums in order into an initially empty BST. Find the number 
 * of different ways to reorder nums so that the constructed BST is identical 
 * to that formed from the original array nums.
 * 
 * <ul>
 * <li>For example, given nums = [2,1,3], we will have 2 as the root, 1 as 
 * a left child, and 3 as a right child. The array [2,3,1] also yields 
 * the same BST but [3,2,1] yields a different BST.</li>
 * </ul>
 * 
 * <p>Return the number of ways to reorder nums such that the BST formed is 
 * identical to the original BST formed from nums.
 * 
 * <p>Since the answer may be very large, return it modulo 109 + 7.
 * 
 * <p>Example 1:
 * <pre>
 *   2
 *  / \
 * 1   3
 * Input: nums = [2,1,3]
 * Output: 1
 * Explanation: We can reorder nums to be [2,3,1] which will yield the same 
 * BST. There are no other ways to reorder nums which will yield the same BST.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 *     3
 *    / \
 *   1   4
 *    \   \ 
 *     2   5
 * Input: nums = [3,4,5,1,2]
 * Output: 5
 * Explanation: The following 5 arrays will yield the same BST: 
 * [3,1,2,4,5]
 * [3,1,4,2,5]
 * [3,1,4,5,2]
 * [3,4,1,2,5]
 * [3,4,1,5,2]
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * 1
 *  \
 *   2
 *    \
 *     3
 * Input: nums = [1,2,3]
 * Output: 0
 * Explanation: There are no other orderings of nums that will yield the same 
 * BST.
 * </pre>
 * 
 * <p>Constraints:
 * <pre>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= nums.length
 * All integers in nums are distinct.
 * </pre>
 * 
 * @see <a href="https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst">
 * 		Link to source
 * </a>
 */
public class NumberOfWaysToReorderArrayToGetSameBST {

	class Solution {

		private static final long MOD = 1_000_000_007L;

		private long[][] combinations;

		public int numOfWays(int[] nums) {
			int n = nums.length;

			// Precompute combinations using Pascal's triangle
			buildCombinations(n);

			List<Integer> list = new ArrayList<>();

			for (int num : nums) {
				list.add(num);
			}

			// Exclude the original ordering
			return (int) ((dfs(list) - 1 + MOD) % MOD);
		}

		private long dfs(List<Integer> nums) {
			int n = nums.size();

			if (n <= 2) {
				return 1;
			}

			int root = nums.get(0);

			List<Integer> left = new ArrayList<>();
			List<Integer> right = new ArrayList<>();

			// Split elements into left and right subtrees
			for (int i = 1; i < n; i++) {
				int num = nums.get(i);

				if (num < root) {
					left.add(num);
				} else {
					right.add(num);
				}
			}

			// Count valid reorderings of each subtree
			long leftWays = dfs(left);
			long rightWays = dfs(right);

			// Count ways to interleave left and right elements
			long interleavings = combinations[n - 1][left.size()];

			// Combine all independent choices
			long result = interleavings * leftWays % MOD;
			result = result * rightWays % MOD;

			return result;
		}

		private void buildCombinations(int n) {
			combinations = new long[n + 1][n + 1];

			for (int i = 0; i <= n; i++) {
				combinations[i][0] = 1;
				combinations[i][i] = 1;

				for (int j = 1; j < i; j++) {
					combinations[i][j] =
									(combinations[i - 1][j - 1]
									+ combinations[i - 1][j]) % MOD;
				}
			}
		}
	}
}