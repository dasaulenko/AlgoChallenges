package com.hramn.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2099. Find Subsequence of Length K With the Largest Sum
 * https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description
 * 
 * You are given an integer array nums and an integer k. You want to find 
 * a subsequence of nums of length k that has the largest sum.
 * 
 * Return any such subsequence as an integer array of length k.
 * 
 * A subsequence is an array that can be derived from another array by deleting 
 * some or no elements without changing the order of the remaining elements.
 * 
 * Example 1:
 * Input: nums = [2,1,3,3], k = 2
 * Output: [3,3]
 * Explanation:
 * The subsequence has the largest sum of 3 + 3 = 6.
 * 
 * Example 2:
 * Input: nums = [-1,-2,3,4], k = 3
 * Output: [-1,3,4]
 * Explanation: 
 * The subsequence has the largest sum of -1 + 3 + 4 = 6.
 * 
 * Example 3:
 * Input: nums = [3,4,3,3], k = 2
 * Output: [3,4]
 * Explanation:
 * The subsequence has the largest sum of 3 + 4 = 7. 
 * Another possible subsequence is [4, 3].
 * 
 * Constraints:
 * 1 <= nums.length <= 1000
 * -10^5 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * 
 * TAG: 20250628
 * TAG: easy
 * TAG: array
 */
public class FindSubsequenceOfLengthKWithLargestSum {
	class Solution1 {
		public int[] maxSubsequence(int[] nums, int k) {
			int n = nums.length;
			List<Integer> res = new LinkedList<>();
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int i = 0; i < n; i++) {
				if (i < k) {
					res.add (nums[i]);
					if (nums[i] < min) {
						min = nums[i];
						minIndex = i;
					}
				} else {
					if (nums[i] > min) {
						res.remove (minIndex);
						res.add (nums[i]);
						min = res.get(0);
						minIndex = 0;
						int index = 0;
						for (int num : res) {
							if (num < min) {
								min = num;
								minIndex = index;
							}
							index++;
						}
					}
				}
			}
			return res.stream().mapToInt(i->i).toArray();
		}
	}

	class Solution2 {
		public int[] maxSubsequence(int[] nums, int k) {
			int n = nums.length;
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				arr[i][0] = nums[i];
				arr[i][1] = i;
			}
			Arrays.sort (arr, (a,b) -> b[0] - a[0]);
			int[][] arr2 = new int[k][2];
			for (int i = 0; i < k; i++) {
				arr2[i][0] = arr[i][0];
				arr2[i][1] = arr[i][1];
			}
			Arrays.sort (arr2, (a,b) -> a[1] - b[1]);
			int[] res = new int[k];
			for (int i = 0; i < k; i++) {
				res[i] = arr2[i][0];
			}
			return res;
		}
	}

	class Solution3 {
		public int[] maxSubsequence(int[] nums, int k) {
			int n = nums.length;
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nums[i];
			}
			Arrays.sort (arr);
			int min = arr[n-k];
			int minCnt = 1;
			int index = n-k+1;
			while (index < n && arr[index] == min) {
				minCnt++;
				index++;
			}
			int[] res = new int[k];
			index = 0;
			for (int i = 0; i < n; i++) {
				if (nums[i] > min) {
					res[index] = nums[i];
					index++;
				} else if (nums[i] == min && minCnt != 0) {
					res[index] = nums[i];
					minCnt--;
					index++;
				}
			}
			return res;
		}        
	}
}
