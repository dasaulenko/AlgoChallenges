package com.hramn.algo;
/**
 * 2840. Check if Strings Can be Made Equal With Operations II
 * https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/description
 * 
 * You are given two strings s1 and s2, both of length n, consisting of 
 * lowercase English letters.
 * 
 * You can apply the following operation on any of the two strings any number 
 * of times:
 * 
 * - Choose any two indices i and j such that i < j and the difference j - i is 
 *   even, then swap the two characters at those indices in the string.
 * 
 * Return true if you can make the strings s1 and s2 equal, and false otherwise.
 * 
 * Example 1:
 * Input: s1 = "abcdba", s2 = "cabdab"
 * Output: true
 * Explanation: We can apply the following operations on s1:
 * - Choose the indices i = 0, j = 2. The resulting string is s1 = "cbadba".
 * - Choose the indices i = 2, j = 4. The resulting string is s1 = "cbbdaa".
 * - Choose the indices i = 1, j = 5. The resulting string is s1 = "cabdab" = s2.
 * 
 * Example 2:
 * Input: s1 = "abe", s2 = "bea"
 * Output: false
 * Explanation: It is not possible to make the two strings equal.
 * 
 * Constraints:
 * n == s1.length == s2.length
 * 1 <= n <= 10^5
 * s1 and s2 consist only of lowercase English letters.
 * 
 * TAG: medium
 * TAG: chars
 * TAG: strings
 */
public class CheckIfStringsCanBeMadeEqualWithOperationsII {
	class Solution { // O(N), O(1) where N = s1.length()
		public boolean checkStrings(String s1, String s2) {
			int[][] charCounter = new int[26][2];
			for (int i = 0; i < s1.length(); i++) {
				int ch = s1.charAt(i) - 'a';
				charCounter[ch][i%2]++;
				ch = s2.charAt(i) - 'a';
				charCounter[ch][i%2]--;
			}
			for (int i = 0; i < 26; i++) {
				if (charCounter[i][0] != 0 || charCounter[i][1] != 0)
					return false;
			}
			return true;
		}
	}
}
