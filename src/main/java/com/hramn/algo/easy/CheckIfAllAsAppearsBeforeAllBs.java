package com.hramn.algo.easy;

/**
 * 2124. Check if All A's Appears Before All B's
 *
 * <p>
 * <strong>Difficulty:</strong> Easy
 * <br>
 * <strong>LeetCode:</strong> <a href=
 * "https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/">
 * 2124. Check if All A's Appears Before All B's</a>
 * <br>
 * <strong>Topic:</strong> string
 *
 * <hr>
 *
 * <p>
 * Given a string {@code s} consisting of only the characters {@code 'a'} and
 * {@code 'b'}, return {@code true} if every {@code 'a'} appears before every
 * {@code 'b'} in the string. Otherwise, return {@code false}.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code s = "aaabbb"}
 * <p>
 * Output: {@code true}
 * <p>
 * Explanation:
 * <br>
 * The 'a's are at indices 0, 1, and 2, while the 'b's are at indices 3, 4, and
 * 5.
 * <br>
 * Hence, every 'a' appears before every 'b' and we return true.
 *
 * <p>
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code s = "abab"}
 * <p>
 * Output: {@code false}
 * <p>
 * Explanation:
 * <br>
 * There is an 'a' at index 2 and a 'b' at index 1.
 * <br>
 * Hence, not every 'a' appears before every 'b' and we return false.
 *
 * <p>
 * <strong>Example 3:</strong>
 * <p>
 * Input: {@code s = "bbb"}
 * <p>
 * Output: {@code true}
 * <p>
 * Explanation:
 * <br>
 * There are no 'a's, hence, every 'a' appears before every 'b' and we return
 * true.
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>{@code 1 <= s.length <= 100}</li>
 * <li>{@code s[i]} is either {@code 'a'} or {@code 'b'}.
 * </ul>
 */
public class CheckIfAllAsAppearsBeforeAllBs {
	private CheckIfAllAsAppearsBeforeAllBs() {
		/* This utility class should not be instantiated */
	}

	static class IteratingSolution {
		public boolean checkString(String s) {
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i - 1) > s.charAt(i))
					return false;
			}
			return true;
		}
	}

	static class IndexOfSolution {
		public boolean checkString(String s) {
			int ai = s.lastIndexOf('a');
			int bi = s.indexOf('b');
			return bi == -1 || ai < bi;
		}
	}
}
