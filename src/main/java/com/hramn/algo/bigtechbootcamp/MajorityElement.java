package com.hramn.algo.bigtechbootcamp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Task
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. 
 * You may assume that the majority element always exists in the array.
 * 
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * Constraints:
 * 
 * n == nums.length
 * 1 <= n <= 5 * 10**4
 * -10**9 <= nums[i] <= 10**9
 * 
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {
	class Solution_Onlogn_runtime {
	    public int majorityElement(int[] nums) {
	        Arrays.sort(nums);
	        int current = nums[0];
	        int counter = 1;
	        int limit = nums.length/2;
	    	for (int i = 1; i < nums.length; i++) {
	        	if (current == nums[i]) {
	        		counter++;
	        		if (counter > limit) {
	        			break;
	        		}
	        	} else {
	        		current = nums[i];
	        		counter = 1;
	        	}
	        }
	    	return current;
	    }
	}
	
	class Solution_On_runtime {
	    public int majorityElement(int[] nums) {
	        Map<Integer, Integer> map = new HashMap<>();
	        int limit = nums.length/2;
	        Integer count = null;
	        for (int num : nums) {
	        	count = map.get(num);
	        	if (count == null) {
	        		count = 0;
	        		map.put(num, count);
	        	}
	        	count++;
	        	if (count > limit) {
	        		break;
	        	}
	        }
	    	return count;
	    }
	}
	
	class Solution_On_runtime_O1_memory {
	    public int majorityElement(int[] nums) {
	        int count = 0;
	        int candidate = 0;
	        
	        for (int num : nums) {
	            if (count == 0) {
	                candidate = num;
	            }
	            
	            if (num == candidate) {
	                count++;
	            } else {
	                count--;
	            }
	        }
	        
	        return candidate;
	    }
	}
}
