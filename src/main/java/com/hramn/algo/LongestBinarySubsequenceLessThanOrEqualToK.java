package com.hramn.algo;
/**
 * 2311. Longest Binary Subsequence Less Than or Equal to K
 * https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/description
 * 
 * You are given a binary string s and a positive integer k.
 * 
 * Return the length of the longest subsequence of s that makes up a binary 
 * number less than or equal to k.
 * 
 * Note:
 * - The subsequence can contain leading zeroes.
 * - The empty string is considered to be equal to 0.
 * 
 * A subsequence is a string that can be derived from another string by 
 * deleting some or no characters without changing the order of the remaining 
 * characters.
 * 
 * Example 1:
 * Input: s = "1001010", k = 5
 * Output: 5
 * Explanation: The longest subsequence of s that makes up a binary number less 
 * than or equal to 5 is "00010", as this number is equal to 2 in decimal.
 * Note that "00100" and "00101" are also possible, which are equal to 4 and 5 
 * in decimal, respectively.
 * The length of this subsequence is 5, so 5 is returned.
 * 
 * Example 2:
 * Input: s = "00101001", k = 1
 * Output: 6
 * Explanation: "000001" is the longest subsequence of s that makes up a binary 
 * number less than or equal to 1, as this number is equal to 1 in decimal.
 * The length of this subsequence is 6, so 6 is returned.
 * 
 * Constraints:
 * 1 <= s.length <= 1000
 * s[i] is either '0' or '1'.
 * 1 <= k <= 10^9
 * 
 * TAG: 20250626
 * TAG: medium
 * TAG: string
 * TAG: base2
 */
public class LongestBinarySubsequenceLessThanOrEqualToK {
	class Solution { // O(N * M), O(M), N - s.lenght(), M - k 
		public int longestSubsequence(String s, int k) {
			int n = s.length();
			String str2 = Integer.toString (k, 2);
			int b2length = str2.length();
			char[] chr = new char[b2length];
			int chrIndex = b2length;
			int counter = 0;
			for (int i = n-1; i >= 0; i--) {
				char ch = s.charAt(i);
				if (chrIndex > 0) {
					chrIndex--;
					chr[chrIndex] = ch;
				}
				if (chrIndex == 0) {
					int num = Integer.parseInt(new String(chr), 2);
					if (num > k) {
						chrIndex = b2length-1;
						for (int j = b2length-1; j >= 0; j--) {
							if (chrIndex == j) {
								if (chr[j] != 1) {
									chrIndex--;
								}
							} else {
								chr[chrIndex--] = chr[j];
								chr[j] = 0;
							}
						}
						chrIndex = 1;
					} else {
						chrIndex = -1;
					}
				} else if (chrIndex == -1) {
					if (ch == '0') {
						counter++;
					}
				}
			}
			return counter + b2length - (chrIndex > 0 ? chrIndex : 0);
		}
	}
}
