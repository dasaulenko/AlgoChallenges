package com.hramn.algo;
/**
 * 3201. Find the Maximum Length of Valid Subsequence I
 * https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/description
 * 
 * You are given an integer array nums.
 * 
 * A subsequence sub of nums with length x is called valid if it satisfies:
 * - (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... 
 * == (sub[x - 2] + sub[x - 1]) % 2.
 * 
 * Return the length of the longest valid subsequence of nums.
 * 
 * A subsequence is an array that can be derived from another array by deleting 
 * some or no elements without changing the order of the remaining elements.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: 4
 * Explanation:
 * The longest valid subsequence is [1, 2, 3, 4].
 * 
 * Example 2:
 * Input: nums = [1,2,1,1,2,1,2]
 * Output: 6
 * Explanation:
 * The longest valid subsequence is [1, 2, 1, 2, 1, 2].
 * 
 * Example 3:
 * Input: nums = [1,3]
 * Output: 2
 * Explanation:
 * The longest valid subsequence is [1, 3].
 * 
 * Constraints:
 * 2 <= nums.length <= 2 * 10^5
 * 1 <= nums[i] <= 10^7
 * 
 * TAG: 20250716
 * TAG: medium
 * TAG: array
 * TAG: subsequence
 */
public class FindMaximumLengthOfValidSubsequenceI {
	class Solution { // O(N), O(1)
		public int maximumLength(int[] nums) {
			int n = nums.length;
			int oddCount = 0;
			int evenCount = 0;
			int seqCount = 1;
			boolean oddLast = false;
			if (nums[0] % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
				oddLast = true;
			}
			for (int i = 1; i < n; i++) {
				if (nums[i] % 2 == 0) {
					evenCount++;
					if (oddLast) {
						seqCount++;
						oddLast = false;
					}
				} else {
					oddCount++;
					if (!oddLast) {
						seqCount++;
						oddLast = true;
					}
				}
			}
			return Math.max (seqCount, Math.max (evenCount, oddCount));
		}
	}

	class BestSolution { // O(N), O(1)
		public int maximumLength(int[] nums) {
			int[] oddEvenCounter = new int[2];
			int[] seqCounter = new int[2];
			for (int num : nums) {
				int rem = num % 2;
				oddEvenCounter[rem]++;
				seqCounter[rem] = seqCounter[1 - rem] + 1;
			}
			return Math.max (
					Math.max(oddEvenCounter[0], oddEvenCounter[1]),
					Math.max(seqCounter[0], seqCounter[1]));
		}
	}
}
