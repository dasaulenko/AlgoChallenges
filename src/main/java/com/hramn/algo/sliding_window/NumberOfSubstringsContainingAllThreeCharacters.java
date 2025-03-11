package com.hramn.algo.sliding_window;
/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description
 * 
 * 1358. Number of Substrings Containing All Three Characters
 * 
 * Given a string s consisting only of characters a, b and c.
 * 
 * Return the number of substrings containing at least one occurrence of all 
 * these characters a, b and c.
 * 
 * Example 1:
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the 
 * characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", 
 * "bcabc", "cab", "cabc" and "abc" (again). 
 * 
 * Example 2:
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the 
 * characters a, b and c are "aaacb", "aacb" and "acb". 
 * 
 * Example 3:
 * Input: s = "abc"
 * Output: 1
 * 
 * Constraints:
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */
public class NumberOfSubstringsContainingAllThreeCharacters {
	class Solution { // O(N), O(1)
		// aaabbbccc
		// r = 0, a = 1
		// r = 1, a = 2
		// r = 2, a = 3
		// r = 3, b = 1
		// r = 4, b = 2
		// r = 5, b = 3
		// r = 6, c = 1, result = 3, a = 2, l = 1
		//               result = 6, a = 1, l = 2
		//               result = 9, a = 0, l = 3
		// r = 7, c = 2
		// r = 8, c = 3
		public int numberOfSubstrings(String s) {
			int result = 0;
			int[] chars = new int[128];
			for (int l = 0, r = 0; r < s.length(); r++) {
				char cr = s.charAt(r);
				chars[cr]++;
				while (chars['a'] > 0 && chars['b'] > 0 && chars['c'] > 0) {
					result += s.length() - r;
					chars[s.charAt(l)]--;
					l++;
				}
			}
			return result;
		}
	}
}
