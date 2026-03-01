package com.hramn.algo.sorting;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 179. Largest Number
 * 
 * Given a list of non-negative integers nums, arrange them such that they form 
 * the largest number and return it.
 * 
 * Since the result may be very large, so you need to return a string instead 
 * of an integer.
 * 
 * Example 1:
 * Input: nums = [10,2]
 * Output: "210"
 * 
 * Example 2:
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * 
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 10**9
 */
public class LargestNumber {

	public static void main(String[] args) {
		int[] nums = {1, 56, 945, 2534, 478, 99};
//		int[] nums = {432,43243}; // 43243 432
		Solution solution = new Solution();
		System.out.println(solution.largestNumber(nums));
	}
	
	static class Solution {
		public String largestNumber(int[] nums) {
			String[] arr = new String[nums.length];
			for (int i = 0; i < nums.length; i++) {
				arr[i] = String.valueOf(nums[i]);
			}
			Arrays.sort(arr, new Comparator<>() {
				public int compare(String s1, String s2) {
					return (s2+s1).compareTo(s1+s2);
				}
			});
	        if (Integer.valueOf(arr[0]) == 0) {
	            return "0";
	        } 
			StringBuilder sb = new StringBuilder();
			for (String str : arr) {
				sb.append(str);
			}
			return sb.toString();
		}
	}
	
	static class Solution_best_memory {
		public String largestNumber(int[] nums) {
	        int n = nums.length;
	        Integer[] arrayNum = new Integer[n];
	        for(int i = 0; i < n; i++){
	            arrayNum[i] = nums[i];
	        }
	        Arrays.sort(arrayNum, (x, y) ->{
	            long sx = 10, sy = 10;
	            while (sx <= x) {
	                sx *= 10;
	            }
	            while (sy <= y) {
	                sy *= 10;
	            }
	            return (int) ((sx * y + x) - (sy * x + y));
	        });
	        //If the result is positive, x should appear after y.
	        //If negative, x should appear before y.
	        //If zero, their order doesn't matter.
	        if (arrayNum[0] == 0) {
	            return "0";
	        }
	        StringBuilder sb = new StringBuilder();
	        for(int i : arrayNum){
	            sb.append(i);
	        }
	        return sb.toString();
	    }
	}

}
