package com.hramn.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence
 * https://leetcode.com/problems/longest-harmonious-subsequence/description
 * 
 * We define a harmonious array as an array where the difference between its 
 * maximum value and its minimum value is exactly 1.
 * 
 * Given an integer array nums, return the length of its longest harmonious 
 * subsequence among all its possible subsequences.
 * 
 * Example 1:
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation:
 * The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 2
 * Explanation:
 * The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of 
 * which have a length of 2.
 * 
 * Example 3:
 * Input: nums = [1,1,1,1]
 * Output: 0
 * Explanation:
 * No harmonic subsequence exists.
 * 
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * TAG: 20250701
 * TAG: easy
 * TAG: sort
 * TAG: HashMap
 */
public class LongestHarmoniousSubsequence {
	class HashMapSolution { // O(N), O(N), N - nums.length
		public int findLHS(int[] nums) {    
			int n = nums.length;
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				map.put (nums[i], map.getOrDefault (nums[i], 0) + 1);
			}
			int max = 0;
			for (int key : map.keySet()) {
				int p = map.getOrDefault(key+1, 0);
				if (p != 0) {
					max = Math.max (max, map.get(key) + p);
				}
			}
			return max;
		}
	}

	class SortArraySolution { // O(N*log(N)), O(1)
		public int findLHS(int[] nums) {
			int n = nums.length;
			Arrays.sort (nums);
			int fCnt = -1;
			int fVal = -1;
			int sCnt = 1;
			int sVal = nums[0];
			int max = 0;
			for (int i = 1; i < n; i++) {
				if (nums[i] == sVal) {
					sCnt++;
				} else {
					if (fCnt > 0 && sVal - fVal == 1) {
						max = Math.max (max, fCnt + sCnt);
					}
					fCnt = sCnt;
					fVal = sVal;
					sCnt = 1;
					sVal = nums[i];
				}
			}
			if (fCnt > 0 && sVal - fVal == 1) {
				max = Math.max (max, fCnt + sCnt);
			}        
			return max;
		}
	}
}
