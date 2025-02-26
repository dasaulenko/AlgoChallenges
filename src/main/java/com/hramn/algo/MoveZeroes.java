package com.hramn.algo;

/**
 * Task
 * Given an integer array nums, move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * Constraints:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * 
 * Follow up: Could you minimize the total number of operations done?
 */

public class MoveZeroes {

	public static void main(String[] args) {
		
	}
	
	static class Solution_my {
		static void moveZeroes(int[] nums) {
			int i = 0;
			int di = -1;
	        while (i < nums.length) {
	        	if (nums[i] != 0) {
	        		if (i > di+1) {
	        			nums[di+1] = nums[i];
	        			nums[i] = 0;
	        			di++;
	        		} else {
	        			di = i;
	        		}
	        	}
	        }
	    }
	}
	
}
