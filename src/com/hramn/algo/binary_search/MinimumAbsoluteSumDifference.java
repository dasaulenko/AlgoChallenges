package com.hramn.algo.binary_search;

import java.util.Arrays;

/**
 * 1818. Minimum Absolute Sum Difference
 * 
 * You are given two positive integer arrays nums1 and nums2, both of length n.
 * 
 * The absolute sum difference of arrays nums1 and nums2 is defined as the sum 
 * of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).
 * 
 * You can replace at most one element of nums1 with any other element in nums1 
 * to minimize the absolute sum difference.
 * 
 * Return the minimum absolute sum difference after replacing at most one 
 * element in the array nums1. Since the answer may be large, return it modulo 
 * 10**9 + 7.
 * 
 * |x| is defined as:
 * 
 * x if x >= 0, or
 * -x if x < 0.
 * 
 * Example 1:
 * Input: nums1 = [1,7,5], nums2 = [2,3,5]
 * Output: 3
 * Explanation: There are two possible optimal solutions:
 * - Replace the second element with the first: [1,7,5] => [1,1,5], or
 * - Replace the second element with the third: [1,7,5] => [1,5,5].
 * Both will yield an absolute sum difference of |1-2| + (|1-3| or |5-3|) + 
 * |5-5| = 3.
 * 
 * Example 2:
 * Input: nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * Output: 0
 * Explanation: nums1 is equal to nums2 so no replacement is needed. This will 
 * result in an absolute sum difference of 0.
 * 
 * Example 3:
 * Input: nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * Output: 20
 * Explanation: Replace the first element with the second: [1,10,4,4,2,7] => [10,10,4,4,2,7].
 * This yields an absolute sum difference of |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 * 
 * Constraints:
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 10**5
 * 1 <= nums1[i], nums2[i] <= 10**5
 */
public class MinimumAbsoluteSumDifference {

	public static void main(String[] args) {
		int[] nums1 = {1,10,4,4,2,7};
		int[] nums2 = {9,3,5,1,7,4};
		Solution solution = new Solution();
		int result = solution.minAbsoluteSumDiff(nums1, nums2);
		System.out.println(result);
		assert result == 20;
	}
	
	static class Solution {
	    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
	        int mod = (int)1e9+7;
	        int n = nums1.length;

	        if (n == 1) {
	            return Math.abs(nums1[0] - nums2[0]) % mod;
	        }

	        int[] sorted = nums1.clone();
	        Arrays.sort(sorted); // nlogn

	        int i_replaced = -1;
	        int replacement = -1;
	        int best_dif = 0;
	        int sum = 0;
	        for (int i = 0; i < n; i++) {
		        int dif = Math.abs(nums1[i] - nums2[i]);
		        int l = 0, r = n;
		        while(r - l > 1) {
		            int mid = l + (r - l) / 2;
		            if (nums2[i] >= sorted[mid]) {
		                l = mid;
	                } else {
		                r = mid;
	                }
	            }
	            int newDif = dif - Math.abs(sorted[l] - nums2[i]);
	            if (best_dif < newDif) {
		            best_dif = newDif;
		            i_replaced = i;
		            replacement = sorted[l];
	            }
	            l = -1; r = n-1;
	            while(r - l > 1) {
		            int mid = l + (r - l) / 2;
		            if (nums2[i] <= sorted[mid]) {
		                r = mid;
	                } else {
		                l = mid;
	                }
	            }
	            newDif = dif - Math.abs(sorted[r] - nums2[i]);
	            if (best_dif < newDif) {
		            best_dif = newDif;
		            i_replaced = i;
		            replacement = sorted[r];
	            }
	        }
	        for (int i = 0; i < n; i++) {
	            if (i == i_replaced && best_dif != 0) {
	                sum = (sum + Math.abs(replacement - nums2[i])) % mod;
	            } else {
	                sum = (sum + Math.abs(nums1[i] - nums2[i])) % mod;
	            }
	        }
	        return sum;
	    }
	}
	
	static class Solution_best_time {
	    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
	        int mod = (int) 1e9 + 7;
	        int replace = 0;
	        int save;
	        int currDiff;
	        int sumDiff = 0;
	        for (int i = 0; i < nums1.length; i++) {
	            currDiff = Math.abs(nums1[i] - nums2[i]);
	            sumDiff = (sumDiff + currDiff) % mod;
	            if (replace < currDiff) {
	                for (int j : nums1) {
	                    save = currDiff - Math.abs(j - nums2[i]);
	                    if (save > replace) {
	                        replace = save;
	                    }
	                    if (replace == currDiff) {
	                        break;
	                    }
	                }
	            }
	        }
	        return (sumDiff - replace + mod) % mod;
	    }
	}
	

}
