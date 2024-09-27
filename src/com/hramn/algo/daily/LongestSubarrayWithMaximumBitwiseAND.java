package com.hramn.algo.daily;

import java.util.Arrays;

/**
 * Task
 * You are given an integer array nums of size n.
 * 
 * Consider a non-empty subarray from nums that has the maximum possible 
 * bitwise AND.
 * 
 * In other words, let k be the maximum value of the bitwise AND of any 
 * subarray of nums. Then, only subarrays with a bitwise AND equal to k should 
 * be considered.
 * 
 * Return the length of the longest such subarray.
 * 
 * The bitwise AND of an array is the bitwise AND of all the numbers in it.
 * 
 * A subarray is a contiguous sequence of elements within an array.
 * 
 * Example 1:
 * Input: nums = [1,2,3,3,2,2]
 * Output: 2
 * Explanation:
 * The maximum possible bitwise AND of a subarray is 3.
 * The longest subarray with that value is [3,3], so we return 2.
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 1
 * Explanation:
 * The maximum possible bitwise AND of a subarray is 4.
 * The longest subarray with that value is [4], so we return 1.
 * 
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class LongestSubarrayWithMaximumBitwiseAND {
	
	class Solution {
	    public int longestSubarray(int[] nums) {
	    	int total_max = 0;
	    	int total_count = 0;
	    	int max = nums[0];
	        int count = 1;
	    	for (int i = 1; i < nums.length; i++) {
	        	if (nums[i] == max) {
	        		count++;
	        	} else if (nums[i] > max) {
	        		max = nums[i];
	        		count = 1;
	        	} else {
	        		if (max > total_max) {
	        			total_max = max;
	        			total_count = count;
	        		} else if (max == total_max && count > total_count) {
	        			total_count = count;
	        		}
	        		count = 0;
	        	}
	        }
	    	if (max > total_max) {
    			total_max = max;
    			total_count = count;
    		} else if (max == total_max && count > total_count) {
    			total_count = count;
    		}
	    	return total_count;
	    }
	}
	
	class Solution_best_memory {
	    public int longestSubarray(int[] nums) {
	        int max = getMaxInt(nums);
	        int maxSeq = 1;
	        int i = 0;
	        for(i=0; i<nums.length; i++){
	            int count = 0;
	            if(nums[i] == max){
	                count++;
	                i++;
	                while(i<nums.length && nums[i] == max){
	                    count++;
	                    i++;
	                }
	            }
	            if(maxSeq < count){
	                maxSeq = count;
	            }
	        }
	        return maxSeq;
	    }

	    public int getMaxInt(int[] nums){
	        return Arrays.stream(nums).max().orElseGet(()->0);
	    }
	}
}