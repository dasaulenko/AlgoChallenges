package com.hramn.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 * https://leetcode.com/problems/largest-divisible-subset/description
 * 
 * Given a set of distinct positive integers nums, return the largest subset 
 * answer such that every pair (answer[i], answer[j]) of elements in this 
 * subset satisfies:
 * - answer[i] % answer[j] == 0, or
 * - answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 * 
 * Example 2:
 * Input: nums = [1,2,4,8]
 * Output: [1,2,4,8]
 * 
 * Constraints:
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 10^9
 * All the integers in nums are unique.
 * 
 * TAGS: 20250406
 * TAGS: medium
 * TAGS: DP
 */
public class LargestDivisibleSubset {
	class Solution { // O(N^2), O(N), N - nums.length
		public List<Integer> largestDivisibleSubset(int[] nums) {
			int n = nums.length;
			Arrays.sort(nums);
			int[] dp = new int[n];
			Arrays.fill (dp, 1);
			int[] prev = new int[n];
			Arrays.fill (prev, -1);
			int iMax = 0;
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						prev[i] = j;
					}
				}
				if (dp[i] > dp[iMax]) {
					iMax = i;
				}
			}
			List<Integer> list = new ArrayList<>();
			for (int i = iMax; i >= 0; i = prev[i]) {
				list.add(nums[i]);
			}
			return list;
		}
	}
}
