package com.hramn.algo.sliding_window;
/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * 
 * 209. Minimum Size Subarray Sum
 * 
 * Given an array of positive integers nums and a positive integer target, 
 * return the minimal length of a subarray whose sum is greater than or equal 
 * to target. If there is no such subarray, return 0 instead.
 * 
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem 
 * constraint.
 * 
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * 
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * Constraints:
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another 
 * solution of which the time complexity is O(n log(n)).
 */

// nums = [4,6,2,1,7,4]	target = 10	result = 2
// nums = [5]	target = 6	result = 0
// nums = [1, 2, 3, 4, 5]	target = 3	result = 1
public class MinimumSizeSubarraySum {
	
	class BruteforceSolution { // O(N^2), O(1)
		public int minSubArrayLen(int target, int[] nums) {
			int result = Integer.MAX_VALUE;
			boolean isResultExist = false;
			for (int i = 0; i < nums.length; i++) {
				int sum = 0;
				for (int k = i; k < nums.length; k++) {
					sum += nums[k];
					if (sum >= target) {
						isResultExist = true;
						result = Math.min(result, k - i + 1);
						break;
					}
 				}
			}
			return isResultExist ? result : 0;
		}
	}

	class SlidingWindowSolution_20250227 { // O(n), O(1)
		public int minSubArrayLen(int target, int[] nums) {
			int result = Integer.MAX_VALUE, l = 0, sum = 0;
			boolean isResultExist = false;
			for (int r = 0; r < nums.length; r++) {
				sum += nums[r];
				while (sum >= target) {
					isResultExist = true;
					result = Math.min (result, r - l + 1);
					sum -= nums[l];
					l++;
				}
			}
			return isResultExist ? result : 0;
		}
	}

	class SlidingWindowSolution { // O(n), O(1)
		public int minSubArrayLen(int target, int[] nums) {
			int result = Integer.MAX_VALUE;
			boolean isExist = false;
			int l = 0, r = 0;
			int sum = 0;
			while (r < nums.length || sum >= target) {
				if (sum >= target) {
					result = Math.min(result, r - l);
					isExist = true;
					sum -= nums[l];
					l++;
				} else {
					sum += nums[r];
					r++;
				}
			}
			return isExist ? result : 0;
		}	
	}
	
	class Solution_better { // O(n), O(1)
		public int minSubArrayLen(int target, int[] nums) {
	        int l = 0;
	        int r = 0;
	        int s = 0;
	        int ans = Integer.MAX_VALUE;
	        boolean is = false;
	        for (r = 0; r < nums.length; r++) {
	            s += nums[r];
	            while (s >= target) {
	            	ans = Math.min(ans, r - l + 1);
	            	is = true;
	            	s -= nums[l++];
	            }
	        }
	        return is ? ans : 0;
	    }
	}
}

//nums = [4,6,2,1,7,4]	target = 10	result = 2
//1: sum + 4 = 4; r + 1 = 1
//2: sum + 6 = 10; r + 1 = 2
//3: result = 2; sum - 4 = 6; l + 1 = 1
//4: sum + 2 = 8; r + 1 = 3
//5: sum + 1 = 9; r + 1 = 4
//6: sum + 7 = 16; r + 1 = 5
//7: result = 2; sum - 6 = 10; l + 1 = 2
//8: result = 2; sum - 2 = 8; l + 1 = 3
//9: sum + 4 = 12; r + 1 = 6
//10: result = 2