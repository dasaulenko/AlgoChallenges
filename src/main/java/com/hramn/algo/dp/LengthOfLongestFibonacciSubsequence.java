package com.hramn.algo.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/
 * 
 * 873. Length of Longest Fibonacci Subsequence
 * 
 * A sequence x1, x2, ..., xn is Fibonacci-like if:
 * - n >= 3
 * - x(i) + x(i+1) == x(i+2) for all i + 2 <= n
 * 
 * Given a strictly increasing array arr of positive integers forming a 
 * sequence, return the length of the longest Fibonacci-like subsequence of 
 * arr. If one does not exist, return 0.
 * 
 * A subsequence is derived from another sequence arr by deleting any number of 
 * elements (including none) from arr, without changing the order of the 
 * remaining elements. For example, [3, 5, 8] is a subsequence of 
 * [3, 4, 5, 6, 7, 8].
 * 
 * Example 1:
 * Input: arr = [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * 
 * Example 2:
 * Input: arr = [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation: The longest subsequence that is fibonacci-like: [1,11,12], 
 * [3,11,14] or [7,11,18].
 * 
 * Constraints:
 * 
 * 3 <= arr.length <= 1000
 * 1 <= arr[i] < arr[i + 1] <= 10^9
 */
public class LengthOfLongestFibonacciSubsequence {

	class DynamicProgrammingSolution2 { // O(N^2), O(N^2)
		public int lenLongestFibSubseq(int[] arr) {
			int maxLength = 0;
			int[][] dp = new int[arr.length][arr.length];
			for (int cur = 2; cur < arr.length; cur++) {
				int l = 0, r = cur - 1;
				while (l < r) {
					int sum = arr[l] + arr[r];
					if (sum > arr[cur]) {
						r--;
					} else if (sum < arr[cur]) {
						l++;
					} else {
						dp[r][cur] = dp[l][r] + 1;
						maxLength = Math.max(maxLength, dp[r][cur]);
						l++;
						r--;
					}
				}
			}
			return maxLength != 0 ? maxLength + 2 : 0;
		}
	}

	class DynamicProgrammingSolution1 { // O(N^2), O(N^2)
		public int lenLongestFibSubseq(int[] arr) {
			int maxLength = 0;
			Map<Integer, Integer> numToIndex = new HashMap<>();
			int[][] dp = new int[arr.length][arr.length];
			for (int cur = 0; cur < arr.length; cur++) {
				numToIndex.put(arr[cur], cur);
				for (int prev = 0; prev < cur; prev++) {
					int dif = arr[cur] - arr[prev];
					int index = numToIndex.getOrDefault(dif, -1);
					if (dif < arr[prev] && index >= 0) {
						dp[prev][cur] = dp[index][prev] + 1;
					} else {
						dp[prev][cur] = 2;
					}
					maxLength = Math.max(maxLength, dp[prev][cur]);
				}
			}
			return maxLength > 2 ? maxLength : 0;
		}
	}	
	
	class BruteforceSolution2 { // O(N^2 * log(M)), O(N) where M - max value in arr
		public int lenLongestFibSubseq(int[] arr) {
			int maxLength = 0;
			Set<Integer> nums = new HashSet<>();
			for (int num : arr) {
				nums.add(num);
			}
			
			for (int i = 0; i < arr.length - 2; i++) {
				for (int k = i+1; k < arr.length - 1; k++) {
					int firstNum = arr[i];
					int secondNum = arr[k], curLength = 2;
					while (nums.contains(firstNum + secondNum)) {
						int tmp = firstNum;
						firstNum = secondNum;
						secondNum = tmp + secondNum;
						curLength++;
					}
					maxLength = Math.max(maxLength, curLength);
				}
			}
			return maxLength > 2 ? maxLength : 0;
		}
	}

	class BruteforceSolution1 { // O(N^3), O(N^2)
		public int lenLongestFibSubseq(int[] arr) {
			int maxLength = 0;
			for (int i = 0; i < arr.length - 2; i++) {
				for (int k = i+1; k < arr.length - 1; k++) {
					List<Integer> list = new ArrayList<>();
					list.add(arr[i]);
					list.add(arr[k]);
					maxLength = Math.max(maxLength, req (arr, k, list));
				}
			}
			return maxLength > 2 ? maxLength : 0;
		}

		private int req (int[] arr, int index, List<Integer> result) {
			for (int i = index+1; i < arr.length; i++) {
				if (arr[i] == 
						result.get(result.size() - 2) + result.get(result.size() - 1)) {
					result.add(arr[i]);
				}
			}
			return result.size();
		}
	}
}
