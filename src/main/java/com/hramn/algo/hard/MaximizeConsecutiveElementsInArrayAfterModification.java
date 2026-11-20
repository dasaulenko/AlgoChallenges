package com.hramn.algo.hard;

import java.util.Arrays;

/**
 * <strong>3041. Maximize Consecutive Elements in an Array After
 * Modification</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Hard
 * <br>
 * <strong>LeetCode:</strong> <a href=
 * "https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/">
 * 3041. Maximize Consecutive Elements in an Array After Modification</a>
 * <br>
 * <strong>Topic:</strong> array, sorting, dynamic programming
 *
 * <hr>
 *
 * <p>
 * You are given a 0-indexed array {@code nums} consisting of positive integers.
 *
 * <p>
 * Initially, you can increase the value of any element in the array by at most
 * {@code 1}.
 *
 * <p>
 * After that, you need to select one or more elements from the final array such
 * that those elements are consecutive when sorted in increasing order. For
 * example, the elements {@code [3, 4, 5]} are consecutive while
 * {@code [3, 4, 6]} and {@code [1, 1, 2, 3]} are not.
 *
 * <p>
 * Return the maximum number of elements that you can select.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code nums = [2,1,5,1,1]}
 * <p>
 * Output: {@code 3}
 * <p>
 * Explanation: We can increase the elements at indices {@code 0} and {@code 3}.
 * The resulting array is {@code nums = [3,1,5,2,1]}.
 * <br>
 * We select the elements {@code [3,1,5,2,1]} and we sort them to obtain
 * {@code [1,2,3]}, which are consecutive.
 * <br>
 * It can be shown that we cannot select more than {@code 3} consecutive
 * elements.
 *
 * <p>
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code nums = [1,4,7,10]}
 * <p>
 * Output: {@code 1}
 * <p>
 * Explanation: The maximum consecutive elements that we can select is
 * {@code 1}.
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>{@code 1 <= nums.length <= 10^5}</li>
 * <li>{@code 1 <= nums[i] <= 10^6}</li>
 * </ul>
 */
public class MaximizeConsecutiveElementsInArrayAfterModification {
	private MaximizeConsecutiveElementsInArrayAfterModification() {
		/* This utility class should not be instantiated */
	}

	static class Solution {
		public int maxSelectedElements(int[] nums) {
			int n = nums.length;
			Arrays.sort(nums);
			int result = 1;
			// int[][] dp = new int[n][2];
			// dp[0][0] = 1;
			// dp[0][1] = 1;
			int prevKeepCnt = 1;
			int prevAddCnt = 1;
			for (int i = 1; i < n; i++) {
				int dif = nums[i] - nums[i - 1];
				switch (dif) {
					case 0 ->
						// If the current element equals the previous one:
						// - Keep it unchanged: skip it and reuse the previous count.
						// - Increment it by 1: use the previous count + 1.
						// dp[i][0] = dp[i-1][0];
						// dp[i][1] = dp[i-1][0] + 1;
						prevAddCnt = prevKeepCnt + 1;
					case 1 -> {
						// dp[i][0] = dp[i-1][0] + 1;
						// dp[i][1] = dp[i-1][1] + 1;
						prevKeepCnt++;
						prevAddCnt++;
					}
					case 2 -> {
						// dp[i][0] = dp[i-1][1] + 1;
						// dp[i][1] = 1;
						prevKeepCnt = prevAddCnt + 1;
						prevAddCnt = 1;
					}
					default -> {
						// dp[i][0] = 1;
						// dp[i][1] = 1;
						prevKeepCnt = 1;
						prevAddCnt = 1;
					}
				}
				// result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
				result = Math.max(result, Math.max(prevKeepCnt, prevAddCnt));
			}
			return result;
		}
	}
}
