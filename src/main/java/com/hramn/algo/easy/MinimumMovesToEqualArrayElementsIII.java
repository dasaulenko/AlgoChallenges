package com.hramn.algo.easy;

/**
 * <strong>3736. Minimum Moves to Equal Array Elements III</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Easy
 * <br>
 * <strong>LeetCode:</strong> <a href=
 * "https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/">
 * 3736. Minimum Moves to Equal Array Elements III</a>
 * <br>
 * <strong>Topic:</strong> array, math
 *
 * <hr>
 *
 * <p>
 * You are given an integer array {@code nums}.
 *
 * <p>
 * In one move, you may increase the value of any single element {@code nums[i]}
 * by 1.
 *
 * <p>
 * Return the minimum total number of moves required so that all elements in
 * {@code nums} become equal.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code nums = [2,1,3]}
 * <p>
 * Output: {@code 3}
 * <p>
 * Explanation:
 * <p>
 * To make all elements equal:
 * <ul>
 * <li>Increase {@code nums[0] = 2} by 1 to make it 3.</li>
 * <li>Increase {@code nums[1] = 1} by 1 to make it 2.</li>
 * <li>Increase the updated {@code nums[1] = 2} by 1 to make it 3.</li>
 * </ul>
 * <p>
 * Now, all elements of {@code nums} are equal to 3. The minimum total moves is
 * 3.
 *
 * <p>
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code nums = [4,4,5]}
 * <p>
 * Output: {@code 2}
 * <p>
 * Explanation:
 * <p>
 * To make all elements equal:
 * <ul>
 * <li>Increase {@code nums[0] = 4} by 1 to make it 5.</li>
 * <li>Increase {@code nums[1] = 4} by 1 to make it 5.</li>
 * </ul>
 * <p>
 * Now, all elements of {@code nums} are equal to 5. The minimum total moves is
 * 2.
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>{@code 1 <= nums.length <= 100}</li>
 * <li>{@code 1 <= nums[i] <= 100}</li>
 * </ul>
 */
public class MinimumMovesToEqualArrayElementsIII {
	private MinimumMovesToEqualArrayElementsIII() {
		/* This utility class should not be instantiated */
	}

	static class Solution {
		public int minMoves(int[] nums) {
			int n = nums.length;
			int max = 0;
			int sum = 0;

			for (int num : nums) {
				max = Math.max(max, num);
				sum += num;
			}

			return max * n - sum;
		}
	}
}
