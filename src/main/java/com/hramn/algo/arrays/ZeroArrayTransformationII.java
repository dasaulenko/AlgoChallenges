package com.hramn.algo.arrays;
/**
 * https://leetcode.com/problems/zero-array-transformation-ii/description
 * 
 * 3356. Zero Array Transformation II
 * 
 * You are given an integer array nums of length n and a 2D array queries where 
 * queries[i] = [l(i), r(i), val(i)].
 * 
 * Each queries[i] represents the following action on nums:
 * 
 * - Decrement the value at each index in the range [li, ri] in nums by at most 
 *   val(i).
 * - The amount by which each value is decremented can be chosen independently 
 *   for each index.
 * 
 * A Zero Array is an array with all its elements equal to 0.
 * 
 * Return the minimum possible non-negative value of k, such that after 
 * processing the first k queries in sequence, nums becomes a Zero Array. If no 
 * such k exists, return -1.
 * 
 * Example 1:
 * Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
 * Output: 2
 * Explanation:
 * For i = 0 (l = 0, r = 2, val = 1):
 * Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
 * The array will become [1, 0, 1].
 * For i = 1 (l = 0, r = 2, val = 1):
 * Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
 * The array will become [0, 0, 0], which is a Zero Array. Therefore, the 
 * minimum value of k is 2.
 * 
 * Example 2:
 * Input: nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]
 * Output: -1
 * Explanation:
 * For i = 0 (l = 1, r = 3, val = 2):
 * Decrement values at indices [1, 2, 3] by [2, 2, 1] respectively.
 * The array will become [4, 1, 0, 0].
 * For i = 1 (l = 0, r = 2, val = 1):
 * Decrement values at indices [0, 1, 2] by [1, 1, 0] respectively.
 * The array will become [3, 0, 0, 0], which is not a Zero Array.
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 5 * 10^5
 * 1 <= queries.length <= 10^5
 * queries[i].length == 3
 * 0 <= l(i) <= r(i) < nums.length
 * 1 <= val(i) <= 5
 */
public class ZeroArrayTransformationII {

	class PrefixSumSolution { // O(N + Q), O(N)
		public int minZeroArray(int[] nums, int[][] queries) {
			int j = 0, val = 0;
			int[] diff = new int[nums.length + 1];

			for (int i = 0; i < nums.length; i++) {
				val += diff[i];
				while (nums[i] > val) {
					if (j == queries.length) {
						return -1;
					}
					int l = queries[j][0];
					int r = queries[j][1];
					int v = queries[j][2];
					if (i >= l && i <= r) {
						val += v;
					}
					diff[l] += v;
					diff[r + 1] -= v; 
					j++;
				}
			}
			return j;
		}
	}

	class BinarySearchSolution { // O((N+Q)*log(Q)), O(N)
		public int minZeroArray(int[] nums, int[][] queries) {
			int zeroCount = 0, l = 1, r = queries.length;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0) {
					zeroCount++;
				}
			}
			if (zeroCount == nums.length) {
				return 0;
			}
			if (!canMakeZeroArray(queries.length, nums, queries)) {
				return -1;
			}
			while (l < r) {
				int mid = l + (r - l) / 2;
				if (canMakeZeroArray(mid, nums, queries)) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			return l;
		}

		private boolean canMakeZeroArray(int index, int[] arr, int[][] queries) {
			int[] diff = new int[arr.length + 1];
			for (int i = 0; i < index; i++) {
				diff[queries[i][0]] += queries[i][2];
				diff[queries[i][1] + 1] -= queries[i][2];
			}
			int val = 0;
			for (int i = 0; i < arr.length; i++) {
				val += diff[i];
				if (val < arr[i]) {
					return false;
				}
			}
			return true;
		}
	}

	class BruteforceSolution { // O(N * Q), O(1)
		public int minZeroArray(int[] nums, int[][] queries) {
			int notZeroCount = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > 0) {
					notZeroCount++;
				}
			}
			if (notZeroCount == 0) {
				return 0;
			}
			for (int i = 0; i < queries.length; i++) {
				for (int j = queries[i][0]; j <= queries[i][1]; j++) {
					if (nums[j] > 0) {
						if (nums[j] <= queries[i][2]) {
							nums[j] = 0;
							notZeroCount--;
						} else {
							nums[j] -= queries[i][2];
						}
					}
					if (notZeroCount == 0) {
						return i+1;
					}
				}
			}
			return -1;
		}
	}
}
