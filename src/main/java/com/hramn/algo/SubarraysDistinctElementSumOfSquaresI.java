package com.hramn.algo;

import java.util.List;

/**
 * 2913. Subarrays Distinct Element Sum of Squares I
 * 
 * <p>You are given a 0-indexed integer array nums.
 * 
 * <p>The distinct count of a subarray of nums is defined as:
 * <ul>
 * 	<li>Let nums[i..j] be a subarray of nums consisting of all the indices from i to 
 * 	j such that 0 <= i <= j < nums.length. Then the number of distinct values in 
 * 	nums[i..j] is called the distinct count of nums[i..j].</li>
 * </ul>
 * 
 * <p>Return the sum of the squares of distinct counts of all subarrays of nums.
 * 
 * <p>A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * <p>Example 1:
 * <pre>
 * Input: nums = [1,2,1]
 * Output: 15
 * Explanation: Six possible subarrays are:
 * [1]: 1 distinct value
 * [2]: 1 distinct value
 * [1]: 1 distinct value
 * [1,2]: 2 distinct values
 * [2,1]: 2 distinct values
 * [1,2,1]: 2 distinct values
 * The sum of the squares of the distinct counts in all subarrays is equal to 
 * 12 + 12 + 12 + 22 + 22 + 22 = 15.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: nums = [1,1]
 * Output: 3
 * Explanation: Three possible subarrays are:
 * [1]: 1 distinct value
 * [1]: 1 distinct value
 * [1,1]: 1 distinct value
 * The sum of the squares of the distinct counts in all subarrays is equal to 
 * 12 + 12 + 12 = 3.
 * </pre>
 * 
 * <p>Constraints:
 * <pre>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * </pre>
 * 
 * @see <a href="https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i">
 * 		2913. Subarrays Distinct Element Sum of Squares I
 * </a>
 */
public class SubarraysDistinctElementSumOfSquaresI {
	class Solution {
		public int sumCounts(List<Integer> nums) {
			int n = nums.size();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				int distCount = 0;
				boolean[] isExist = new boolean[101];
				for (int j = i; j < n; j++) {
					int num = nums.get(j);
					if (!isExist[num]) {
						isExist[num] = true;
						distCount++;
					}
					sum += distCount * distCount;
				}
			}
			return sum;
		}
	}
}
