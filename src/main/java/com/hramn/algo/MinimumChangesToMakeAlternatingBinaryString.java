package com.hramn.algo;
/**
 * 1758. Minimum Changes To Make Alternating Binary String
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description
 * 
 * You are given a string s consisting only of the characters '0' and '1'. In 
 * one operation, you can change any '0' to '1' or vice versa.
 * 
 * The string is called alternating if no two adjacent characters are equal. 
 * For example, the string "010" is alternating, while the string "0100" is not.
 * 
 * Return the minimum number of operations needed to make s alternating.
 * 
 * Example 1:
 * Input: s = "0100"
 * Output: 1
 * Explanation: If you change the last character to '1', s will be "0101", 
 * which is alternating.
 * 
 * Example 2:
 * Input: s = "10"
 * Output: 0
 * Explanation: s is already alternating.
 * 
 * Example 3:
 * Input: s = "1111"
 * Output: 2
 * Explanation: You need two operations to reach "0101" or "1010".
 * 
 * Constraints:
 * 1 <= s.length <= 10^4
 * s[i] is either '0' or '1'.
 * 
 * TAG: easy
 * TAG: bitwise
 */
public class MinimumChangesToMakeAlternatingBinaryString {

	class Solution1 {
		public int minOperations(String s) {
			int n = s.length();
			int cntOdd = n/2;
			int[] cnt1 = new int[2];
			for (int i = 0; i < n; i++) {
				cnt1[i%2] += s.charAt(i) - '0';
			}
			int cntEven0 = (n-cntOdd)-cnt1[0];
			int cntOdd0 = cntOdd-cnt1[1];
			return n - Math.max(cnt1[0] + cntOdd0, cnt1[1] + cntEven0);
		}
	}

	class Solution2 {
		public int minOperations(String s) {
			int cnt = 0;
			int n = s.length();
			for (int i = 0; i < n; i++) {
				// if (s.charAt(i) - '0' != i%2) cnt++;
				cnt += ((s.charAt(i) - '0') + i)%2;
			}
			return Math.min(cnt, n-cnt);
		}
	}

}
