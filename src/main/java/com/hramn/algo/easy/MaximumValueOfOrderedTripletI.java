package com.hramn.algo.easy;

/**
 * <strong>2873. Maximum Value of an Ordered Triplet I</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Easy
 * <br>
 * <strong>LeetCode:</strong> <a href=
 * "https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/">
 * 2873. Maximum Value of an Ordered Triplet I</a>
 * <br>
 * <strong>Topic:</strong> array, math, prefix sum
 *
 * <hr>
 *
 * <p>
 * You are given a 0-indexed integer array {@code nums}.
 *
 * <p>
 * Return the maximum value over all triplets of indices {@code (i, j, k)} such
 * that {@code i < j < k}. If all such triplets have a negative value, return
 * {@code 0}.
 *
 * <p>
 * The value of a triplet of indices {@code (i, j, k)} is equal to
 * {@code (nums[i] - nums[j]) * nums[k]}.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code nums = [12,6,1,2,7]}
 * <p>
 * Output: {@code 77}
 * <p>
 * Explanation: The value of the triplet {@code (0, 2, 4)} is
 * {@code (nums[0] - nums[2]) * nums[4] = 77}.
 * <br>
 * It can be shown that there are no ordered triplets of indices with a value
 * greater than {@code 77}.
 *
 * <p>
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code nums = [1,10,3,4,19]}
 * <p>
 * Output: {@code 133}
 * <p>
 * Explanation: The value of the triplet {@code (1, 2, 4)} is
 * {@code (nums[1] - nums[2]) * nums[4] = 133}.
 * <br>
 * It can be shown that there are no ordered triplets of indices with a value
 * greater than {@code 133}.
 *
 * <p>
 * <strong>Example 3:</strong>
 * <p>
 * Input: {@code nums = [1,2,3]}
 * <p>
 * Output: {@code 0}
 * <p>
 * Explanation: The only ordered triplet of indices {@code (0, 1, 2)} has a
 * negative value of {@code (nums[0] - nums[1]) * nums[2] = -3}. Hence, the
 * answer would be {@code 0}.
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>{@code 3 <= nums.length <= 100}</li>
 * <li>{@code 1 <= nums[i] <= 10^6}</li>
 * </ul>
 */
public class MaximumValueOfOrderedTripletI {
	private MaximumValueOfOrderedTripletI() {
		/* This utility class should not be instantiated */
	}

	// Time: O(n)
	// Space: O(1)
	static class Solution {
		public long maximumTripletValue(int[] nums) {
			long result = 0;
			int iMax = 0;
			int difMax = 0;
			for (int num : nums) {
				result = Math.max(result, (long) difMax * num);
				difMax = Math.max(difMax, iMax - num);
				iMax = Math.max(iMax, num);
			}
			return result;
		}
	}
}
