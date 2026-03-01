package com.hramn.algo;
/**
 * 3355. Zero Array Transformation I
 * https://leetcode.com/problems/zero-array-transformation-i/description
 * 
 * You are given an integer array nums of length n and a 2D array queries, 
 * where queries[i] = [l(i), r(i)].
 * 
 * For each queries[i]:
 * 
 * Select a subset of indices within the range [l(i), r(i)] in nums.
 * Decrement the values at the selected indices by 1.
 * A Zero Array is an array where all elements are equal to 0.
 * 
 * Return true if it is possible to transform nums into a Zero Array after 
 * processing all the queries sequentially, otherwise return false.
 * 
 * Example 1:
 * Input: nums = [1,0,1], queries = [[0,2]]
 * Output: true
 * Explanation:
 * - For i = 0:
 *   - Select the subset of indices as [0, 2] and decrement the values at these 
 *     indices by 1.
 *   - The array will become [0, 0, 0], which is a Zero Array.
 * 
 * Example 2:
 * Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]
 * Output: false
 * Explanation:
 * - For i = 0:
 *   - Select the subset of indices as [1, 2, 3] and decrement the values at 
 *     these indices by 1.
 *   - The array will become [4, 2, 1, 0].
 * - For i = 1:
 *   - Select the subset of indices as [0, 1, 2] and decrement the values at 
 *     these indices by 1.
 *   - The array will become [3, 1, 0, 0], which is not a Zero Array.
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 * 1 <= queries.length <= 10^5
 * queries[i].length == 2
 * 0 <= l(i) <= r(i) < nums.length
 * 
 * TAG: 20250520
 * TAG: medium
 * TAG: difference_array
 */
public class ZeroArrayTransformationI {

	class BruteforceSolution {
		public boolean isZeroArray(int[] nums, int[][] queries) {
			int n = nums.length;
			int m = queries.length;
			for (int i = 0; i < m; i++) {
				int l = queries[i][0];
				int r = queries[i][1];
				while (l <= r) {
					nums[l++]--;
				}
			}
			for (int i = 0; i < n; i++) {
				if (nums[i] > 0) {
					return false;
				}
			}
			return true;
		}
	}

	class DiffArrSolution {
		public boolean isZeroArray(int[] nums, int[][] queries) {
			int n = nums.length;
			int m = queries.length;
			int[] dif = new int[n + 1];
			for (int i = 0; i < m; i++) {
				int l = queries[i][0];
				int r = queries[i][1];
				dif[l]++;
				dif[r+1]--;
			}
			int dec = 0;
			for (int i = 0; i < n; i++) {
				dec += dif[i];
				if (nums[i] > dec) {
					return false;
				}
			}
			return true;
		}
	}
}
