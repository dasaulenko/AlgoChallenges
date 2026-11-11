package com.hramn.algo.challenging;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * SubarraysDistinctElementSumOfSquaresII
 * 
 * <p>You are given a 0-indexed integer array nums.
 * 
 * <p>The distinct count of a subarray of nums is defined as:
 * <ul>
 *   <li>Let nums[i..j] be a subarray of nums consisting of all the indices 
 *       from i to j such that 0 <= i <= j < nums.length. Then the number of 
 *       distinct values in nums[i..j] is called the distinct count of 
 *       nums[i..j].</li>
 * </ul>
 * 
 * <p>Return the sum of the squares of distinct counts of all subarrays of nums.
 * 
 * <p>Since the answer may be very large, return it modulo 10⁹ + 7.
 * 
 * <p>A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * <p>Example 1:
 * <pre>
 * Input: nums = [1,2,1]
 * Output: 15
 * Explanation: Six possible subarrays are:
 * [1]: 1 distinct value
 * [2]: 1 distinct value
 * [1]: 1 distinct value
 * [1,2]: 2 distinct values
 * [2,1]: 2 distinct values
 * [1,2,1]: 2 distinct values
 * The sum of the squares of the distinct counts in all subarrays is equal to 
 * 1² + 1² + 1² + 2² + 2² + 2² = 15.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: nums = [2,2]
 * Output: 3
 * Explanation: Three possible subarrays are:
 * [2]: 1 distinct value
 * [2]: 1 distinct value
 * [2,2]: 1 distinct value
 * The sum of the squares of the distinct counts in all subarrays is equal to 
 * 1² + 1² + 1² = 3.
 * </pre>
 * 
 * <p>Constraints:
 * <pre>
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁵
 * </pre>
 * 
 * @see <a href="https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii">
 * 		Link to Leetcode
 * </a>
 */
public class SubarraysDistinctElementSumOfSquaresII {

	/**
	 * Brute Force Solution
	 * 
	 * <p>Complexity
	 * <pre>
	 * Time: O(n²)
	 * Space: O(n)
	 * </pre>
	 * 
	 */
	class SolutionBruteForce {

		public int sumCounts(int[] nums) {
			final int MOD = 1_000_000_007;
			long result = 0;

			for (int left = 0; left < nums.length; left++) {
				Set<Integer> distinct = new HashSet<>();

				for (int right = left; right < nums.length; right++) {
					distinct.add(nums[right]);
					long count = distinct.size();
					result = (result + count * count) % MOD;
				}
			}

			return (int) result;
		}
	}

	/**
	 * Segment Tree + Lazy Propagation
	 * 
	 * <p>Complexity
	 * <pre>
	 * Time: O(n log n)
	 * Space: O(n)
	 * </pre>
	 */
	class Solution {

		private static final long MOD = 1_000_000_007L;

		public int sumCounts(int[] nums) {
			int n = nums.length;
			SegmentTree tree = new SegmentTree(n);

			int[] lastIndex = new int[100_001];
			Arrays.fill(lastIndex, -1);
			long result = 0;

			for (int right = 0; right < n; right++) {
				int value = nums[right];
				int left = lastIndex[value] + 1;

				// Increase distinct counts for all affected subarrays.
				tree.add(left, right, 1);

				// Sum of squared distinct counts for subarrays
				// ending at the current position.
				result = (result + tree.sumSquares()) % MOD;

				lastIndex[value] = right;
			}
			return (int) result;
		}

		private static class SegmentTree {
			private final int n;
			private final long[] sum;
			private final long[] sumSquares;
			private final long[] lazy;

			SegmentTree(int n) {
				this.n = n;
				sum = new long[4 * n];
				sumSquares = new long[4 * n];
				lazy = new long[4 * n];
			}

			public void add(int left, int right, long delta) {
				update(1, 0, n - 1, left, right, delta);
			}

			public long sumSquares() {
				return sumSquares[1];
			}

			private void apply(int node, int length, long delta) {
				sumSquares[node] = (
								sumSquares[node]
								+ 2 * delta * sum[node]
								+ delta * delta % MOD * length
				) % MOD;

				sum[node] = (sum[node] + delta * length) % MOD;

				lazy[node] = (lazy[node] + delta) % MOD;
			}

			private void push(int node, int left, int right) {
				if (lazy[node] == 0 || left == right) return;

				int mid = left + (right - left) / 2;
				
				apply(node * 2, mid - left + 1, lazy[node]);

				apply(node * 2 + 1, right - mid, lazy[node]);

				lazy[node] = 0;
			}

			private void update(
							int node,
							int left,
							int right,
							int queryLeft,
							int queryRight,
							long delta) {

				// No overlap.
				if (queryRight < left || right < queryLeft) return;

				// Complete overlap.
				if (queryLeft <= left && right <= queryRight) {
					apply(node, right - left + 1, delta);
					return;
				}

				// Partial overlap.
				push(node, left, right);

				int mid = left + (right - left) / 2;

				update(
								node * 2,
								left,
								mid,
								queryLeft,
								queryRight,
								delta);

				update(
								node * 2 + 1,
								mid + 1,
								right,
								queryLeft,
								queryRight,
								delta);

				sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

				sumSquares[node] = (
								sumSquares[node * 2]
								+ sumSquares[node * 2 + 1]
				) % MOD;
			}
		}
	}
}
