package com.hramn.algo;
/**
 * <strong>3105. Longest Strictly Increasing or Strictly Decreasing Subarray</strong>
 * 
 * <p>Difficulty: Easy
 * <br>Topics: Mid Level, Array
 * 
 * <p>LeetCode: 
 * <a href="https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/">
 * Longest Strictly Increasing or Strictly Decreasing Subarray</a>
 * 
 * <h3>Problem Description</h3>
 * 
 * <p>You are given an array of integers {@code nums}. Return the length of 
 * the longest subarray of {@code nums} which is either strictly increasing or 
 * strictly decreasing.
 * 
 * <h3>Examples</h3>
 * 
 * <p><strong>Example 1:</strong>
 * <pre>{@code
 * Input: nums = [1,4,3,3,2]
 * Output: 2
 * Explanation:
 * The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and 
 * [1,4].
 * The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2] 
 * and [4,3].
 * Hence, we return 2.
 * }</pre>
 * 
 * <p><strong>Example 2:</strong>
 * <pre>{@code
 * Input: nums = [3,3,3,3]
 * Output: 1
 * Explanation:
 * The strictly increasing subarrays of nums are [3], [3], [3], and [3].
 * The strictly decreasing subarrays of nums are [3], [3], [3], and [3].
 * Hence, we return 1.
 * }</pre>
 * 
 * <p><strong>Example 3:</strong>
 * <pre>{@code
 * Input: nums = [3,2,1]
 * Output: 3
 * Explanation:
 * The strictly increasing subarrays of nums are [3], [2], and [1].
 * The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1] 
 * and [3,2,1].
 * Hence, we return 3.
 * }</pre>
 * 
 * <h3>Constraints:</h3>
 * <pre>{@code
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 * }</pre>
 */
public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
	class Solution {
		public int longestMonotonicSubarray(int[] nums) {
			int n = nums.length;
			int ileft = 0;
			int dleft = 0;
			int max = 1;
			for (int i = 1; i < n; i++) {
				if (nums[i-1] >= nums[i]) ileft = i;
				if (nums[i-1] <= nums[i]) dleft = i;
				max = Math.max(max, Math.max(i-ileft+1, i-dleft+1));
			}
			return max;
		}
	}
}