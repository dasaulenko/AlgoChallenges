package com.hramn.algo;

/**
 * 2914. Minimum Number of Changes to Make Binary String Beautiful
 *
 * <p>
 * <strong>Difficulty:</strong> Medium
 * <br>
 * <strong>LeetCode:</strong> <a href=
 * "https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/">
 * 2914. Minimum Number of Changes to Make Binary String Beautiful</a>
 * <br>
 * <strong>Topic:</strong> string
 *
 * <hr>
 *
 * <p>
 * You are given a 0-indexed binary string {@code s} having an even length.
 *
 * <p>
 * A string is beautiful if it's possible to partition it into one or more
 * substrings such that:
 * <ul>
 * <li>Each substring has an even length.</li>
 * <li>Each substring contains only {@code 1}'s or only {@code 0}'s.</li>
 * </ul>
 * <p>
 * You can change any character in {@code s} to {@code 0} or {@code 1}.
 *
 * <p>
 * Return the minimum number of changes required to make the string {@code s}
 * beautiful.
 *
 * <p>
 * <strong>Example 1:</strong>
 *
 * <pre>{@code
 * Input: s = "1001"
 * Output: 2
 * Explanation: We change s[1] to 1 and s[3] to 0 to get string "1100".
 * It can be seen that the string "1100" is beautiful because we can partition
 * it into "11|00".
 * It can be proven that 2 is the minimum number of changes needed to make the
 * string beautiful.
 * }</pre>
 *
 * <p>
 * <strong>Example 2:</strong>
 *
 * <pre>{@code
 * Input: s = "10"
 * Output: 1
 * Explanation: We change s[1] to 1 to get string "11".
 * It can be seen that the string "11" is beautiful because we can partition it
 * into "11".
 * It can be proven that 1 is the minimum number of changes needed to make the
 * string beautiful.
 * }</pre>
 *
 * <p>
 * <strong>Example 3:</strong>
 *
 * <pre>{@code
 * Input: s = "0000"
 * Output: 0
 * Explanation: We don't need to make any changes as the string "0000" is
 * beautiful already.
 * }</pre>
 *
 * <p>
 * <strong>Constraints:</strong>
 *
 * <pre>{@code
 * 2 <= s.length <= 10^5
 * s has an even length.
 * s[i] is either '0' or '1'.
 * }</pre>
 */
public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
	private MinimumNumberOfChangesToMakeBinaryStringBeautiful() {
		/* This utility class should not be instantiated */
	}

	static class GoodSolution {
		public int minChanges(String s) {
			int cnt = 0;
			for (int i = 0; i < s.length(); i += 2) {
				cnt += s.charAt(i) == s.charAt(i + 1) ? 0 : 1;
			}
			return cnt;
		}
	}

	static class BadSolution {
		public int minChanges(String s) {
			int n = s.length();
			char[] chars = s.toCharArray();
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= n / 2; i++) {
				if (n % i != 0 || (n / i) % 2 != 0)
					continue;
				int gLength = n / i;

				int[] cnt = new int[2];
				int changes = 0;
				for (int j = 0; j < n; j++) {
					cnt[chars[j] - '0']++;
					if ((j + 1) % gLength == 0) {
						changes += Math.min(cnt[0], cnt[1]);
						cnt[0] = 0;
						cnt[1] = 0;
					}
				}
				min = Math.min(min, changes);
			}
			return min;
		}
	}
}
