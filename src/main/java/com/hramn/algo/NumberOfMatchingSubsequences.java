package com.hramn.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 792. Number of Matching Subsequences
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 * 
 * Given a string s and an array of strings words, return the number of 
 * words[i] that is a subsequence of s.
 * 
 * A subsequence of a string is a new string generated from the original string 
 * with some characters (can be none) deleted without changing the relative 
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * 
 * Example 1:
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of 
 * s: "a", "acd", "ace".
 * 
 * Example 2:
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 * 
 * Constraints:
 * 1 <= s.length <= 5 * 10^4
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * s and words[i] consist of only lowercase English letters.
 * 
 * TAG: 20250807
 * TAG: medium
 * TAG: string
 */
public class NumberOfMatchingSubsequences {
	class Solution { // O(N*M), O(N+M) where N - words.length, M - s.length()
		public int numMatchingSubseq(String s, String[] words) {
			Map<String, Integer> wCounter = new HashMap<>();
			for (String w : words) {
				wCounter.put(w, wCounter.getOrDefault(w, 0) + 1);
			}
			int result = 0;
			if (wCounter.get("") != null) {
				result = wCounter.remove("");
			}
			char[] chars = s.toCharArray();
			for (String key : wCounter.keySet()) {
				int keyLength = key.length();
				int index = 0;
				for (char ch : chars) {
					if (key.charAt(index) == ch) {
						index++;
						if (index == keyLength) {
							result += wCounter.get(key);
							break;
						}
					}
				}
			}
			return result;
		}
	}
}
