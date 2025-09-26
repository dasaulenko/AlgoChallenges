package com.hramn.algo;
/**
 * 3304. Find the K-th Character in String Game I
 * https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description
 * 
 * Alice and Bob are playing a game. Initially, Alice has a string word = "a".
 * 
 * You are given a positive integer k.
 * 
 * Now Bob will ask Alice to perform the following operation forever:
 * - Generate a new string by changing each character in word to its next 
 *   character in the English alphabet, and append it to the original word.
 * 
 * For example, performing the operation on "c" generates "cd" and performing 
 * the operation on "zb" generates "zbac".
 * 
 * Return the value of the kth character in word, after enough operations have 
 * been done for word to have at least k characters.
 * 
 * Example 1:
 * Input: k = 5
 * Output: "b"
 * Explanation:
 * Initially, word = "a". We need to do the operation three times:
 * - Generated string is "b", word becomes "ab".
 * - Generated string is "bc", word becomes "abbc".
 * - Generated string is "bccd", word becomes "abbcbccd".
 * 
 * Example 2:
 * Input: k = 10
 * Output: "c"
 * 
 * Constraints:
 * 1 <= k <= 500
 * 
 * TAG: 20250703
 * TAG: easy
 * TAG: StringBuilder
 * TAG: base2
 */
public class FindKthCharacterInStringGameI {
	class Solution { // O(N), O(N), N - k
		public char kthCharacter(int k) {
			String s = "a";
			while (s.length() < k) {
				StringBuilder sb = new StringBuilder();
				sb.append(s);
				for (int i = 0; i < s.length(); i++) {
					char ch = s.charAt(i);
					if (ch - 'a' == 25) {
						sb.append('a');
					} else {
						sb.append((char)(ch + 1));
					}
				}
				s = sb.toString();
			}
			return s.charAt(k-1);
		}
	}

	class BestSolution { // O(1), O(1)
		public char kthCharacter(int k) {
			return (char) ('a' + Integer.bitCount(k - 1));
		}
	}
}
