package com.hramn.algo;
/**
 * 3202. Find the Maximum Length of Valid Subsequence II
 * https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/description
 * 
 * You are given an integer array nums and a positive integer k.
 * 
 * A subsequence sub of nums with length x is called valid if it satisfies:
 * - (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... 
 * == (sub[x - 2] + sub[x - 1]) % k.
 * 
 * Return the length of the longest valid subsequence of nums.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4,5], k = 2
 * Output: 5
 * Explanation:
 * The longest valid subsequence is [1, 2, 3, 4, 5].
 * 
 * Example 2:
 * Input: nums = [1,4,2,3,1,4], k = 3
 * Output: 4
 * Explanation:
 * The longest valid subsequence is [1, 4, 1, 4].
 * 
 * Constraints:
 * 2 <= nums.length <= 10^3
 * 1 <= nums[i] <= 10^7
 * 1 <= k <= 10^3
 * 
 * TAG: 20250717
 * TAG: medium
 * TAG: array
 * TAG: subsequence
 */
public class FindMaximumLengthOfValidSubsequenceII {
	class Solution { // O(N^2), O(N * K)
		public int maximumLength(int[] nums, int k) {
			int[][] counter = new int[nums.length][k];
			int max = 0;
			for (int i = 0; i < nums.length-1; i++) {
				for (int j = i+1; j < nums.length; j++) {
					int rem = (nums[i] + nums[j]) % k;
					counter[j][rem] = counter[i][rem] + 1;
					max = Math.max (max, counter[j][rem]);
				}
			}
			return max + 1;
		}
	}

	class BestSolution { // O(N * K), O(N + K)
		public int maximumLength(int[] nums, int k) {
			int length = nums.length;
			if (k == 1) {
				return length;
			}
			int res = 2;
			int[] arr = new int[length];
			for (int i = 0; i < length; i++) {
				arr[i] = nums[i] % k;
			}
			for (int i = 0; i < k; i++) {
				int[] dp = new int[k];
				for (int j = 0; j < length; j++) {
					dp[arr[j]] = dp[(i - arr[j] + k) % k] + 1;
					res = Math.max(res, dp[arr[j]]);
				}
			}
			return res;
		}
	}
}
