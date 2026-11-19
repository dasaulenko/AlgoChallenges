package com.hramn.algo.medium;

import java.util.Arrays;

/**
 * <strong>2567. Minimum Score by Changing Two Elements</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Medium
 * <br>
 * <strong>LeetCode:</strong> <a href=
 * "https://leetcode.com/problems/minimum-score-by-changing-two-elements/">
 * 2567. Minimum Score by Changing Two Elements</a>
 * <br>
 * <strong>Topic:</strong> array, sorting, iterating
 *
 * <hr>
 *
 * <p>
 * You are given an integer array {@code nums}.
 * <ul>
 * <li>The low score of {@code nums} is the minimum absolute difference between
 * any two integers.</li>
 * <li>The high score of {@code nums} is the maximum absolute difference between
 * any two integers.</li>
 * <li>The score of {@code nums} is the sum of the high and low scores.
 * </ul>
 *
 * <p>
 * Return the minimum score after changing two elements of {@code nums}.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code nums = [1,4,7,8,5]}
 * <p>
 * Output: {@code 3}
 * <p>
 * Explanation:
 * <ul>
 * <li>Change {@code nums[0]} and {@code nums[1]} to be 6 so that {@code nums}
 * becomes [6,6,7,8,5].</li>
 * <li>The low score is the minimum absolute difference: |6 - 6| = 0.</li>
 * <li>The high score is the maximum absolute difference: |8 - 5| = 3.</li>
 * <li>The sum of high and low score is 3.</li>
 * </ul>
 *
 * <p>
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code nums = [1,4,3]}
 * <p>
 * Output: {@code 0}
 * <p>
 * Explanation:
 * <ul>
 * <li>Change nums[1] and nums[2] to 1 so that nums becomes [1,1,1].</li>
 * <li>The sum of maximum absolute difference and minimum absolute difference is
 * 0.</li>
 * </ul>
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>3 <= nums.length <= 10^5</li>
 * <li>1 <= nums[i] <= 10^9</li>
 * </ul>
 */
public class MinimumScoreByChangingTwoElements {
	private MinimumScoreByChangingTwoElements() {
		/* This utility class should not be instantiated */
	}

	static class SortSolution {
		public int minimizeSum(int[] nums) {
			int n = nums.length;
			Arrays.sort(nums);
			return Math.min(
					nums[n - 1] - nums[2],
					Math.min(nums[n - 2] - nums[1], nums[n - 3] - nums[0]));
		}
	}

	static class IteratingSolution {
		public int minimizeSum(int[] nums) {
			int[] small = new int[3];
			int[] neg = new int[3];
			Arrays.fill(small, Integer.MAX_VALUE);
			Arrays.fill(neg, Integer.MAX_VALUE);
			for (int x : nums) {
				keep(small, x);
				keep(neg, -x);
			}
			return Math.min(
					-neg[0] - small[2],
					Math.min(-neg[1] - small[1], -neg[2] - small[0]));
		}

		private void keep(int[] three, int x) {
			if (x >= three[2])
				return;
			int i = 2;
			for (; i > 0 && three[i - 1] > x; i--)
				three[i] = three[i - 1];
			three[i] = x;
		}
	}
}
