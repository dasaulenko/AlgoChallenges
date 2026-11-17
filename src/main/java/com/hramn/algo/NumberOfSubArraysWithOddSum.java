package com.hramn.algo;

/**
 * <strong>1524. Number of Sub-arrays With Odd Sum</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Medium
 * <br>
 * <strong>LeetCode:</strong>
 * <a href="https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/">
 * 1524. Number of Sub-arrays With Odd Sum</a>
 * <br>
 * <strong>Topic:</strong> array, math, prefix sum
 * <hr>
 * <p>
 * Given an array of integers {@code arr}, return the number of subarrays with
 * an odd
 * sum.
 *
 * <p>
 * Since the answer can be very large, return it modulo {@code 10^9 + 7}.
 *
 * <p>
 * <strong>Example 1:</strong>
 *
 * <pre>{@code
 * Input: arr = [1,3,5]
 * Output: 4
 * Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
 * All sub-arrays sum are [1,4,9,3,8,5].
 * Odd sums are [1,9,3,5] so the answer is 4.
 * }</pre>
 *
 * <p>
 * <strong>Example 2:</strong>
 *
 * <pre>{@code
 * Input: arr = [2,4,6]
 * Output: 0
 * Explanation: All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
 * All sub-arrays sum are [2,6,12,4,10,6].
 * All sub-arrays have even sum and the answer is 0.
 * }</pre>
 *
 * <p>
 * <strong>Example 3:</strong>
 *
 * <pre>{@code
 * Input: arr = [1,2,3,4,5,6,7]
 * Output: 16
 * }</pre>
 *
 * <p>
 * <strong>Constraints:</strong>
 *
 * <pre>{@code
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 100
 * }</pre>
 */
public class NumberOfSubArraysWithOddSum {

}
