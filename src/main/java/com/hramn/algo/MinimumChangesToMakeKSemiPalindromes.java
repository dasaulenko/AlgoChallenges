package com.hramn.algo;

import java.util.Arrays;

/**
 * <strong>2911. Minimum Changes to Make K Semi-palindromes</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Hard
 * <br>
 * <strong>LeetCode:</strong> <a href=
 * "https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/">
 * 2911. Minimum Changes to Make K Semi-palindromes</a>
 * <br>
 * <strong>Topic:</strong> string, two pointers, dynamic programming
 *
 * <hr>
 *
 * <p>
 * Given a string {@code s} and an integer {@code k}, partition {@code s} into
 * {@code k} substrings such that the letter changes needed to make each
 * substring a semi-palindrome are minimized.
 *
 * <p>
 * Return the minimum number of letter changes required.
 *
 * <p>
 * A semi-palindrome is a special type of string that can be divided into
 * palindromes based on a repeating pattern. To check if a string is a
 * semi-palindrome:​
 *
 * <ol>
 * <li>Choose a positive divisor d of the string's length. d can range from 1 up
 * to,
 * but not including, the string's length. For a string of length 1, it does not
 * have a valid divisor as per this definition, since the only divisor is its
 * length, which is not allowed.</li>
 *
 * <li>For a given divisor d, divide the string into groups where each group
 * contains characters from the string that follow a repeating pattern of length
 * d. Specifically, the first group consists of characters at positions 1, 1 +
 * d, 1 + 2d, and so on; the second group includes characters at positions 2, 2
 * + d, 2 + 2d, etc.</li>
 *
 * <li>The string is considered a semi-palindrome if each of these groups forms
 * a
 * palindrome.</li>
 * </ol>
 *
 * <p>
 * Consider the string "abcabc":
 * <ul>
 * <li>The length of "abcabc" is 6. Valid divisors are 1, 2, and 3.</li>
 * <li>For d = 1: The entire string "abcabc" forms one group. Not a
 * palindrome.</li>
 * <li>For d = 2:
 * <ul>
 * <li>Group 1 (positions 1, 3, 5): "acb"</li>
 * <li>Group 2 (positions 2, 4, 6): "bac"</li>
 * <li>Neither group forms a palindrome.</li>
 * </ul>
 * </li>
 * <li>For d = 3:
 * <ul>
 * <li>Group 1 (positions 1, 4): "aa"</li>
 * <li>Group 2 (positions 2, 5): "bb"</li>
 * <li>Group 3 (positions 3, 6): "cc"</li>
 * <li>All groups form palindromes. Therefore, "abcabc" is a
 * semi-palindrome.</li>
 * </ul>
 * </li>
 * </ul>
 *
 * <p>
 * <strong>Example 1:</strong>
 *
 * <pre>{@code
 * Input: s = "abcac", k = 2
 * Output: 1
 * Explanation: Divide s into "ab" and "cac". "cac" is already semi-palindrome.
 * Change "ab" to "aa", it becomes semi-palindrome with d = 1.
 * }</pre>
 *
 * <p>
 * <strong>Example 2:</strong>
 *
 * <pre>{@code
 * Input: s = "abcdef", k = 2
 * Output: 2
 * Explanation: Divide s into substrings "abc" and "def". Each needs one change
 * to become semi-palindrome.
 * }</pre>
 *
 * <p>
 * <strong>Example 3:</strong>
 *
 * <pre>{@code
 * Input: s = "aabbaa", k = 3
 * Output: 0
 * Explanation: Divide s into substrings "aa", "bb" and "aa". All are already
 * semi-palindromes.
 * }</pre>
 *
 * <p>
 * <strong>Constraints:</strong>
 *
 * <pre>{@code
 * 2 <= s.length <= 200
 * 1 <= k <= s.length / 2
 * s contains only lowercase English letters.
 * }</pre>
 */
public class MinimumChangesToMakeKSemiPalindromes {
	private MinimumChangesToMakeKSemiPalindromes() {
		/* This utility class should not be instantiated */
	}

	static class Solution {
		public int minimumChanges(String s, int k) {
			char[] chars = s.toCharArray();
			int n = chars.length;
			int[][] changes = new int[n][n];
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					changes[i][j] = changes(chars, i, j);
				}
			}
			return dp(changes, k);
		}

		private int changes(char[] chars, int i, int j) {
			int len = j - i + 1;
			int res = len;
			for (int d = 1; d * 2 <= len; d++) {
				if (len % d != 0)
					continue;
				int changes = 0;
				for (int p = 0; p < d; p++) {
					int l = i + p;
					int r = j - d + 1 + p;
					while (l < r) {
						if (chars[l] != chars[r])
							changes++;
						l += d;
						r -= d;
					}
				}
				res = Math.min(res, changes);
			}
			return res;
		}

		private int dp(int[][] changes, int k) {
			int n = changes.length;

			int[][] dp = new int[k + 1][n + 1];
			final int INF = Integer.MAX_VALUE / 2;
			for (int[] row : dp) {
				Arrays.fill(row, INF);
			}

			dp[0][0] = 0;

			for (int parts = 1; parts <= k; parts++) {
				for (int end = 2 * parts; end <= n; end++) {
					for (int start = 2 * (parts - 1); start <= end - 2; start++) {
						dp[parts][end] = Math.min(dp[parts][end], dp[parts - 1][start] + changes[start][end - 1]);
					}
				}
			}
			return dp[k][n];
		}
	}
}
