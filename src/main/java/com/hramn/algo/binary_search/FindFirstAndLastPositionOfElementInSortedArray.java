package com.hramn.algo.binary_search;
/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * 
 * 34. Find First and Last Position of Element in Sorted Array
 * 
 * Given an array of integers nums sorted in non-decreasing order, find the 
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * Constraints:
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
	class Solution {
		public int[] searchRange(int[] nums, int target) {
			int [] result = new int[2];
			int l = 0;
			int r = nums.length;
			while (r - l > 1) {
				int mid = l + (r - l) / 2;
				if (target >= nums[mid]) {
					l = mid;
				} else {
					r = mid;
				}
			}
			if (l == nums.length || nums[l] != target) {
				return new int[]{-1,-1};
			}
			result[1] = l;
			l = -1;
			r = nums.length - 1;
			while (r - l > 1) {
				int mid = l + (r - l) / 2;
				if (target <= nums[mid]) {
					r = mid;
				} else {
					l = mid;
				}
			}
			result[0] = r;
			return result;
		}
	}
}
