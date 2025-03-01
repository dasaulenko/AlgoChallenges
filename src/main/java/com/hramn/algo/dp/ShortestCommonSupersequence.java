package com.hramn.algo.dp;
/*
 * https://leetcode.com/problems/shortest-common-supersequence/description/
 * 
 * 1092. Shortest Common Supersequence 
 * 
 * Given two strings str1 and str2, return the shortest string that has both 
 * str1 and str2 as subsequences. If there are multiple valid strings, return 
 * any of them.
 * 
 * A string s is a subsequence of string t if deleting some number of 
 * characters from t (possibly 0) results in the string s.
 * 
 * Example 1:
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation: 
 * str1 = "abac" is a subsequence of "cabac" because we can delete the 
 * first "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the 
 * last "ac".
 * The answer provided is the shortest such string that satisfies these 
 * properties.
 * 
 * Example 2:
 * Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
 * Output: "aaaaaaaa"
 * 
 * Constraints:
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of lowercase English letters.
 */

// str1 = "abcde"
// str2 = "ace"
//   0 1 2 3
// 0 0 0 0 0
// 1 0 1 1 1
// 2 0 1 1 1
// 3 0 1 2 2
// 4 0 1 2 2
// 5 0 1 2 3
// i = 5, j = 3, e
// i = 4, j = 2, ed
// i = 3, j = 2, edc
// i = 2, j = 1, edcb
// i = 1, j = 1, edcba
// abcde
public class ShortestCommonSupersequence {
	class DPSolution { // O(N^2), O(N^2)
		public String shortestCommonSupersequence(String str1, String str2) {
			// Find the longest common subsequence using dynamic programming
			int[][] dp = new int[str1.length() + 1][str2.length() + 1];
			for (int i = 1; i <= str1.length(); i++) {
				for (int j = 1; j <= str2.length(); j++) {
					if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
						dp[i][j] = 1 + dp[i - 1][j - 1];
					} else {
						dp[i][j] = Math.max (dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			int i = str1.length(), j = str2.length();
			while (i > 0 && j > 0) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					sb.append(str1.charAt(i - 1));
					i--;
					j--;
				} else if (dp[i - 1][j] > dp[i][j - 1]) {
					sb.append(str1.charAt(i - 1));
					i--;
				} else {
					sb.append(str2.charAt(j - 1));
					j--;
				}
			}

			while (i > 0) {
				sb.append(str1.charAt(i - 1));
				i--;
			}

			while (j > 0) {
				sb.append(str2.charAt(j - 1));
				j--;
			}

			return sb.reverse().toString();
		}
	}
}
