package com.hramn.algo;
/**
 * 3403. Find the Lexicographically Largest String From the Box I
 * https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/description
 * 
 * You are given a string word, and an integer numFriends.
 * 
 * Alice is organizing a game for her numFriends friends. There are multiple 
 * rounds in the game, where in each round:
 * - word is split into numFriends non-empty strings, such that no previous 
 *   round has had the exact same split.
 * - All the split words are put into a box.
 * Find the lexicographically largest string from the box after all the rounds 
 * are finished.
 * 
 * Example 1:
 * Input: word = "dbca", numFriends = 2
 * Output: "dbc"
 * Explanation: 
 * All possible splits are:
 * - "d" and "bca".
 * - "db" and "ca".
 * - "dbc" and "a".
 * 
 * Example 2:
 * Input: word = "gggg", numFriends = 4
 * Output: "g"
 * Explanation: 
 * The only possible split is: "g", "g", "g", and "g".
 * 
 * Constraints:
 * 1 <= word.length <= 5 * 10^3
 * word consists only of lowercase English letters.
 * 1 <= numFriends <= word.length
 * 
 * TAGS: 20250604
 * TAGS: medium
 * TAGS: String
 * TAGS: sliding window
 */
public class FindLexicographicallyLargestStringFromBoxI {
	class Solution { // O(N), O(N - K), N - word.length(), K - numFriends
		public String answerString(String word, int numFriends) {
			if (numFriends == 1) {
				return word;
			}
			int n = word.length();
			int maxLength = n - numFriends + 1;
			int l = 0, r = maxLength;
			String result = word.substring(l, r);
			while (l < n-1 || r < n) {
				l++;
				if (r < n) {
					r++;
				}
				String newWord = word.substring(l, r);
				if (result.compareTo (newWord) < 0) {
					result = newWord;
				}
			}
			return result;
		}
	}
}
