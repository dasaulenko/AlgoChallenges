package com.hramn.algo;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task
 * Given two integer arrays nums1 and nums2, return an array of their 
 * intersection. Each element in the result must appear as many times as it 
 * shows in both arrays and you may return the result in any order.
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * 
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * 
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * 
 * Follow up:
 * - What if the given array is already sorted? How would you optimize your 
 *   algorithm?
 * - What if nums1's size is small compared to nums2's size? Which algorithm is 
 *   better?
 * - What if elements of nums2 are stored on disk, and the memory is limited 
 *   such that you cannot load all elements into the memory at once?
 */

public class IntersectionOfTwoArraysII {
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,2,2,1};
		int[] nums2 = new int[] {2, 2};
		System.out.println(Arrays.stream(Solution_1.intersect(nums1, nums2)).boxed()
				.collect(Collectors.toList()));
		System.out.println(Arrays.stream(Solution_my.intersect(nums1, nums2)).boxed()
				.collect(Collectors.toList()));
	}
	
	// Best soluton
	static class Solution_1 {
		static int[] intersect(int[] nums1, int[] nums2) {
			int[] count = new int[1001];
			int[] result = new int[1001];
			
			for (int num : nums1) {
				count[num]++;
			}
			
			int i = 0;
			for (int num : nums2) {
				if (count[num] > 0) {
					result[i++] = num;
					count[num]--;
				}
			}
			
			return Arrays.copyOfRange(result, 0, i);
		}
	}
	
	// if the given array is already sorted
	static class Solution_2 {
		static int[] intersect(int[] nums1, int[] nums2) {
			int[] result = new int[1001];
			
	        int c1 = 0;
	        int c2 = 0;
			int i = 0;
			while(c1 < nums1.length && nums2.length < c2) {
	            if (nums1[c1] == nums2[c2]) {
	                result[i++] = nums1[c1];
	                c1++;
	                c2++;
	            } else if (nums1[c1] > nums2[c2]) {
	                c2++;
	            } else {
	                c1++;
	            }
			}
			
			return Arrays.copyOfRange(result, 0, i);
		}
	}
	
	// My solution
	static class Solution_my {
		static int[] intersect(int[] nums1, int[] nums2) {
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        int c1 = 0;
	        int c2 = 0;
	        int[] result = new int[nums1.length >= nums2.length ? nums1.length : nums2.length];
	        int cr = 0;
	        while(c1 < nums1.length && c2 <nums2.length) {
	            if (nums1[c1] == nums2[c2]) {
	                result[cr++] = nums1[c1];
	                c1++;
	                c2++;
	            } else if (nums1[c1] > nums2[c2]) {
	                c2++;
	            } else {
	                c1++;
	            }
	        }
	        return Arrays.copyOfRange(result, 0, cr);
		}
	}

}
