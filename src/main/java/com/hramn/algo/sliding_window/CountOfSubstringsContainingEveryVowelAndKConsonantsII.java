package com.hramn.algo.sliding_window;
/**
 * https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description
 * 
 * 3306. Count of Substrings Containing Every Vowel and K Consonants II
 * 
 * You are given a string word and a non-negative integer k.
 * 
 * Return the total number of substrings of word that contain every vowel ('a', 
 * 'e', 'i', 'o', and 'u') at least once and exactly k consonants.
 * 
 * Example 1:
 * Input: word = "aeioqq", k = 1
 * Output: 0
 * Explanation:
 * There is no substring with every vowel.
 * 
 * Example 2:
 * Input: word = "aeiou", k = 0
 * Output: 1
 * Explanation:
 * The only substring with every vowel and zero consonants is word[0..4], which 
 * is "aeiou".
 * 
 * Example 3:
 * Input: word = "ieaouqqieaouqq", k = 1
 * Output: 3
 * Explanation:
 * The substrings with every vowel and one consonant are:
 * word[0..5], which is "ieaouq".
 * word[6..11], which is "qieaou".
 * word[7..12], which is "ieaouq".
 * 
 * Constraints:
 * 5 <= word.length <= 2 * 10^5
 * word consists only of lowercase English letters.
 * 0 <= k <= word.length - 5
 */
public class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
	class Solution { // O(N), O(1)
		public long countOfSubstrings(String word, int k) {
			int l = 0, cons = 0, vows = 0, extra = 0;
			long result = 0;
			int[][] chars = new int[2][128];
			chars[0]['a'] = 1;
			chars[0]['e'] = 1;
			chars[0]['i'] = 1;
			chars[0]['o'] = 1;
			chars[0]['u'] = 1;
			for (int r = 0; r < word.length(); r++) {
				char c = word.charAt(r);
				if (chars[0][c] == 1) {
					if (chars[1][c] == 0) {
						vows++;
					}
					chars[1][c]++;
				} else {
					cons++;
					while(cons > k) {
						char cl = word.charAt(l);
						if (chars[0][cl] == 1) {
							chars[1][cl]--;
							if (chars[1][cl] == 0) {
								vows--;
							}
						} else {
							cons--;
						}
						l++;
						extra = 0;
					}
				}

				while (vows == 5 && cons == k && l < r && chars[0][word.charAt(l)] == 1 
						&& chars[1][word.charAt(l)] > 1) {
					extra++;
					chars[1][word.charAt(l)]--;
					l++;
				}

				if (cons == k && vows == 5) {
					result += (1 + extra);
				}
			}
			return result;
		}
	}
}
