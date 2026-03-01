package com.hramn.algo.sliding_window;

/**
 * 424. Longest Repeating Character Replacement
 * 
 * You are given a string s and an integer k. You can choose any character of 
 * the string and change it to any other uppercase English character. You can 
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you 
 * can get after performing the above operations.
 * 
 * Example 1:
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * 
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 * 
 * Constraints:
 * 1 <= s.length <= 10**5
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */
public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		Solution solution = new Solution();
//		String s = "ABCAADAD"; int k = 3;
//		String s = "ABAB"; int k = 2;
		String s = "AABABBA"; int k = 1;
		
		System.out.println(solution.characterReplacement(s, k));

	}
	
	static class Solution {
		public int characterReplacement(String s, int k) {
			int result = 0;
			int[] letters = new int[26];
			int maxIndex = s.charAt(0) - 'A';
			int others = 0;
			int l = 0, r = 0;
			while (r < s.length()) {
				if (others > k) {
					int c = s.charAt(l) - 'A';
					letters[c]--;
					l++;
					if (c != maxIndex) {
						others--;
					} else {
						int tmp = 0;
						for (int i = 0; i < 26; i++) {
							if (letters[i] > letters[tmp]) {
								tmp = i;
							}
						}
						if (letters[maxIndex] < letters[tmp]) {
							others -= letters[tmp];
							others += letters[maxIndex];
							maxIndex = tmp;
						}
					}
				} else {
					int c = s.charAt(r) - 'A';
					letters[c]++;
					r++;
					if (c != maxIndex) {
						others++;
						if (letters[maxIndex] < letters[c]) {
							others -= letters[c];
							others += letters[maxIndex];
							maxIndex = c;
						}
					}
					if (others <= k) {
						result = Math.max(result, letters[maxIndex] + others);
					}
				}
			}
			return result;
		}
	}
	
//	s = "ABC"	k = 0	result = 1
//	0: result = 0; maxIndex = 0; others = 0; l = 0; r = 0;
//	1: letters[0] + 1 = 1; r + 1 = 1; result = 1;
//	2: letters[1] + 1 = 1; others + 1 = 1; 
//	3: letters[0] - 1 = 0; l + 1 = 1; 
	
//	s = "AABABBA"	k = 1	result = 4
//	0: result = 0; maxIndex = 0; others = 0; l = 0; r = 0;
//	1: letters[0] + 1 = 1; r + 1 = 1; result = 1;
//	2: letters[0] + 1 = 2; r + 1 = 2; result = 2;
//	3: letters[1] + 1 = 1; r + 1 = 3; others + 1 = 1;  result = 3;
//	4: letters[0] + 1 = 3; r + 1 = 4; result = 4;
//	5: letters[1] + 1 = 2; r + 1 = 5; others + 1 = 2;
//	6: letters[0] - 1 = 2; l + 1 = 1; 
//	7: letters[0] - 1 = 1; l + 1 = 2; others - 2 + 1 = 1; maxIndex = 1;
//	8: letters[1] + 1 = 3; r + 1 = 6; result = 4;
//	9: letters[0] + 1 = 2; r + 1 = 7; others + 1 = 2;
//	10: letters[1] - 1 = 2; l + 1 = 3;
//	11: letters[0] - 1 = 1; l + 1 = 4; others - 1 = 1;
	
	static class Solution_better {
		public int characterReplacement(String s, int k) {
			int result = 0;
			for (int i = 'A'; i <= 'Z'; i++) {
				int countI = 0, countOther = 0;
				int l = 0, r = 0;
				while (r < s.length()) {
					int c = s.charAt(r);
					if (c == i) {
						countI++;
						r++;
					} else {
						countOther++;
						if (countOther > k) {
							int t = s.charAt(l);
							if (t == i) {
								countI--;
							} else {
								countOther--;
							}
							l++;
						}
					}
					if (countOther <= k) {
						result = Math.max(result, countI + countOther);
					}
				}
			}
			return result;
		}
	}
}
