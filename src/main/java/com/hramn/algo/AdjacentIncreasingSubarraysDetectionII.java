package com.hramn.algo;

import java.util.Iterator;
import java.util.List;

/**
 * 3350. Adjacent Increasing Subarrays Detection II
 * https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/description
 * 
 * Given an array nums of n integers, your task is to find the maximum value of 
 * k for which there exist two adjacent subarrays of length k each, such that 
 * both subarrays are strictly increasing. Specifically, check if there are two 
 * subarrays of length k starting at indices a and b (a < b), where:
 * 
 * - Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly 
 *   increasing.
 * - The subarrays must be adjacent, meaning b = a + k.
 * 
 * Return the maximum possible value of k.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Example 1:
 * Input: nums = [2,5,7,8,9,2,3,4,3,1]
 * Output: 3
 * Explanation:
 * - The subarray starting at index 2 is [7, 8, 9], which is strictly 
 *   increasing.
 * - The subarray starting at index 5 is [2, 3, 4], which is also strictly 
 *   increasing.
 * - These two subarrays are adjacent, and 3 is the maximum possible value of k 
 *   for which two such adjacent strictly increasing subarrays exist.
 * 
 * Example 2:
 * Input: nums = [1,2,3,4,4,4,4,5,6,7]
 * Output: 2
 * Explanation:
 * - The subarray starting at index 0 is [1, 2], which is strictly increasing.
 * - The subarray starting at index 2 is [3, 4], which is also strictly 
 *   increasing.
 * - These two subarrays are adjacent, and 2 is the maximum possible value of k 
 *   for which two such adjacent strictly increasing subarrays exist.
 * 
 * Constraints:
 * 2 <= nums.length <= 2 * 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 * TAG: medium
 * TAG: array
 */
public class AdjacentIncreasingSubarraysDetectionII {
	class Solution { // O(N), O(1), where N = nums.size()
		public int maxIncreasingSubarrays(List<Integer> nums) {
			Iterator<Integer> iterator = nums.iterator();
			int maxLength = 0;
			int curLength = 1;
			int prevLength = 0;
			int prevNum = iterator.next();
			while (iterator.hasNext()) {
				int num = iterator.next();
				if (num > prevNum) {
					curLength++;
				} else {
					maxLength = Math.max(maxLength, max(curLength, prevLength));
					prevLength = curLength;
					curLength = 1;
				}
				prevNum = num;
			}
			return Math.max(maxLength, max(curLength, prevLength));
		}

		private int max(int cur, int prev) {
			return Math.max(cur / 2, Math.min(prev, cur));
		}
	}
}
