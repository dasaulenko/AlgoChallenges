package com.hramn.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * 898. Bitwise ORs of Subarrays
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/description
 * 
 * Given an integer array arr, return the number of distinct bitwise ORs of all 
 * the non-empty subarrays of arr.
 * 
 * The bitwise OR of a subarray is the bitwise OR of each integer in 
 * the subarray. The bitwise OR of a subarray of one integer is that integer.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Example 1:
 * Input: arr = [0]
 * Output: 1
 * Explanation: There is only one possible result: 0.
 * 
 * Example 2:
 * Input: arr = [1,1,2]
 * Output: 3
 * Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], 
 * [1, 1, 2].
 * These yield the results 1, 1, 2, 1, 3, 3.
 * There are 3 unique values, so the answer is 3.
 * 
 * Example 3:
 * Input: arr = [1,2,4]
 * Output: 6
 * Explanation: The possible results are 1, 2, 3, 4, 6, and 7.
 * 
 * Constraints:
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] <= 10^9
 * 
 * TAG: 20250731
 * TAG: medium
 * TAG: bitwise
 * TAG: array
 * TAG: subarray
 */
public class BitwiseORsOfSubarrays {
	class Solution { // O(N), O(N)
		public int subarrayBitwiseORs(int[] arr) {
			int n = arr.length;
			Set<Integer> set = new HashSet<>();
			Set<Integer> prevSet = new HashSet<>();
			for (int i = n-1; i >=0 ; i--) {
				Set<Integer> curSet = new HashSet<>();
				curSet.add(arr[i]);
				for (int num : prevSet) {
					curSet.add(arr[i] | num);
				}
				set.addAll(curSet);
				prevSet = curSet;
			}
			return set.size();
		}
	}
}
