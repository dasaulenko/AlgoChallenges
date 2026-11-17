package com.hramn.algo;

import java.util.List;

/**
 * <strong>3364. Minimum Positive Sum Subarray</strong>
 *
 * <p>
 * Difficulty: Easy
 * <br>
 * LeetCode:
 * <a href="https://leetcode.com/problems/minimum-positive-sum-subarray/">
 * 3364. Minimum Positive Sum Subarray</a>
 * <br>
 * Topic: array, sliding window, prefix sum
 *
 * <h3>Description</h3>
 *
 * <p>
 * You are given an integer array {@code nums} and two integers {@code l} and
 * {@code r}. Your task is to
 * find the minimum sum of a subarray whose size is between {@code l} and
 * {@code r} (inclusive)
 * and whose sum is greater than 0.
 *
 * <p>
 * Return the minimum sum of such a subarray. If no such subarray exists, return
 * -1.
 *
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * <h3>Examples</h3>
 *
 * <p>
 * <strong>Example 1:</strong>
 *
 * <pre>{@code
 * Input: nums = [3, -2, 1, 4], l = 2, r = 3
 * Output: 1
 * Explanation:
 * The subarrays of length between l = 2 and r = 3 where the sum is greater than
 * 0 are:
 * [3, -2] with a sum of 1
 * [1, 4] with a sum of 5
 * [3, -2, 1] with a sum of 2
 * [-2, 1, 4] with a sum of 3
 * Out of these, the subarray [3, -2] has a sum of 1, which is the smallest
 * positive sum. Hence, the answer is 1.
 * }</pre>
 *
 * <p>
 * <strong>Example 2:</strong>
 *
 * <pre>{@code
 * Input: nums = [-2, 2, -3, 1], l = 2, r = 3
 * Output: -1
 * Explanation:
 * There is no subarray of length between l and r that has a sum greater than 0.
 * So, the answer is -1.
 * }</pre>
 *
 * <p>
 * <strong>Example 3:</strong>
 *
 * <pre>{@code
 * Input: nums = [1, 2, 3, 4], l = 2, r = 4
 * Output: 3
 * Explanation:
 * The subarray [1, 2] has a length of 2 and the minimum sum greater than 0. So,
 * the answer is 3.
 * }</pre>
 *
 * <h3>Constraints</h3>
 *
 * <pre>{@code
 * 1 <= nums.length <= 100
 * 1 <= l <= r <= nums.length
 * -1000 <= nums[i] <= 1000
 * }</pre>
 */
public class MinimumPositiveSumSubarray {
	class Solution {
		public int minimumSumSubarray(List<Integer> nums, int l, int r) {
			int n = nums.size();
			int[] prefSum = new int[n + 1];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += nums.get(i);
				prefSum[i + 1] = sum;
			}

			sum = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = i + l - 1; j < n && j - i + 1 <= r; j++) {
					int s = prefSum[j + 1] - prefSum[i];
					if (s > 0)
						sum = Math.min(sum, s);
				}
			}

			return sum == Integer.MAX_VALUE ? -1 : sum;
		}
	}
}
