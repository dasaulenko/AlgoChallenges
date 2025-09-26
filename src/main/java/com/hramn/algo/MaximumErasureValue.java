package com.hramn.algo;
/**
 * 1695. Maximum Erasure Value
 * https://leetcode.com/problems/maximum-erasure-value/description
 * 
 * You are given an array of positive integers nums and want to erase 
 * a subarray containing unique elements. The score you get by erasing 
 * the subarray is equal to the sum of its elements.
 * 
 * Return the maximum score you can get by erasing exactly one subarray.
 * 
 * An array b is called to be a subarray of a if it forms a contiguous 
 * subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] 
 * for some (l,r).
 * 
 * Example 1:
 * Input: nums = [4,2,4,5,6]
 * Output: 17
 * Explanation: The optimal subarray here is [2,4,5,6].
 * 
 * Example 2:
 * Input: nums = [5,2,1,2,5,2,1,2,5]
 * Output: 8
 * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * 
 * TAG: 20250722
 * TAG: medium
 * TAG: array
 */
public class MaximumErasureValue {
	class Solution {
		public int maximumUniqueSubarray(int[] nums) {
			int n = nums.length;
			if (n == 1) {
				return nums[0];
			}
			int[] prefSum = new int[n+1];
			int[] values = new int[10001];
			for (int i = 0; i < n; i++) {
				prefSum[i+1] = prefSum[i] + nums[i];
			}

			int l = 0;
			int sum = 0;
			for (int i = 1; i < n+1; i++) {
				int num = nums[i-1];
				if (values[num] != 0) {
					sum = Math.max (sum, prefSum[i-1] - prefSum[l]);
					for (int j = l; j < values[num]-1; j++) {
						values[nums[j]] = 0;
					}
					l = values[num];
				}
				values[num] = i;
			}
			sum = Math.max (sum, prefSum[n] - prefSum[l]);
			return sum;
		}
	}
}
