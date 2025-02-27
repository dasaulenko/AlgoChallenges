package com.hramn.algo.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * 
 * 448. Find All Numbers Disappeared in an Array
 * 
 * Given an array nums of n integers where nums[i] is in the range [1, n], 
 * return an array of all the integers in the range [1, n] that do not appear 
 * in nums.
 * 
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * 
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 * 
 * Constraints:
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * 
 * Follow up: Could you do it without extra space and in O(n) runtime? You may 
 * assume the returned list does not count as extra space.
 */
public class FindAllNumbersDisappearedInArray {
	class Solution { // O(N), O(1)
		public List<Integer> findDisappearedNumbers(int[] nums) {
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				int index = (nums[i] > 0 ? nums[i] : nums[i] * -1) - 1;
				if (nums[index] > 0) {
					nums[index] *= -1;
				}
			}
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > 0) {
					result.add(i+1);
				}
			}
			return result;
		}
	}

	class BruteforceSolution { // O(N), O(N)
		public List<Integer> findDisappearedNumbers(int[] nums) {
			List<Integer> result = new ArrayList<>();
			boolean[] existedNumbers = new boolean[nums.length];
			for (int i = 0; i < nums.length; i++) {
				existedNumbers[nums[i] - 1] = true;
			}
			for (int i = 0; i < nums.length; i++) {
				if (!existedNumbers[i]) {
					result.add(i+1);
				}
			}
			return result;
		}
	}
}
