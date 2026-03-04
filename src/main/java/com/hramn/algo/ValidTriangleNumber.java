package com.hramn.algo;

import java.util.Arrays;

/**
 * 611. Valid Triangle Number
 * https://leetcode.com/problems/valid-triangle-number/description
 * 
 * Given an integer array nums, return the number of triplets chosen from 
 * the array that can make triangles if we take them as side lengths of 
 * a triangle.
 * 
 * Example 1:
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are: 
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * 
 * Example 2:
 * Input: nums = [4,2,3,4]
 * Output: 4
 * 
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * 
 * TAG: medium
 * TAG: sliding window
 * TAG: sort
 * TAG: arrays
 */
public class ValidTriangleNumber {
	class Solution { // O(N^2), O(1) where N = nums.length
		public int triangleNumber(int[] nums) {
			int n = nums.length;
			if (n < 3) return 0;
			Arrays.sort(nums);
			int result = 0;
			for (int i = n-1; i >= 2; i--) {
				int l = 0;
				int r = i-1;
				while (l < r) {
					if (nums[l] + nums[r] > nums[i]) {
						result += r - l;
						r--;
					} else {
						l++;
					}
				}
			}
			return result;
		}
	}
}
