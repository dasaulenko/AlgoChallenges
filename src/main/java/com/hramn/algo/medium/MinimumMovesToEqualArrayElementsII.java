package com.hramn.algo.medium;

import java.util.Arrays;

/**
 * <strong>462. Minimum Moves to Equal Array Elements II</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Medium
 * <br>
 * <strong>LeetCode:</strong> <a href=
 * "https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/">
 * 462. Minimum Moves to Equal Array Elements II</a>
 * <br>
 * <strong>Topic:</strong> array, sorting, math, two pointers
 *
 * <hr>
 *
 * <p>
 * Given an integer array {@code nums} of size {@code n}, return the minimum
 * number of moves required to make all array elements equal.
 *
 * <p>
 * In one move, you can increment or decrement an element of the array by
 * {@code 1}.
 *
 * <p>
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code nums = [1,2,3]}
 * <p>
 * Output: {@code 2}
 * <p>
 * Explanation:
 * <br>
 * Only two moves are needed (remember each move increments or decrements one
 * element):
 * <br>
 * {@code [1,2,3]  =>  [2,2,3]  =>  [2,2,2]}
 *
 * <p>
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code nums = [1,10,2,9]}
 * <p>
 * Output: {@code 16}
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>{@code n == nums.length}</li>
 * <li>{@code 1 <= nums.length <= 10^5}</li>
 * <li>{@code -10^9 <= nums[i] <= 10^9}</li>
 * </ul>
 */
public class MinimumMovesToEqualArrayElementsII {
	private MinimumMovesToEqualArrayElementsII() {
		/* This utility class should not be instantiated */
	}

	static class MedianSolution {
		public int minMoves2(int[] nums) {
			Arrays.sort(nums);
			int med = nums[nums.length / 2];
			int cnt = 0;
			for (int num : nums) {
				cnt += Math.abs(num - med);
			}
			return cnt;
		}
	}

	static class TwoPointersSolution {
		public int minMoves2(int[] nums) {
			Arrays.sort(nums);
			int cnt = 0;
			int l = 0;
			int r = nums.length - 1;
			while (l < r) {
				cnt += nums[r--] - nums[l++];
			}
			return cnt;
		}
	}
}
