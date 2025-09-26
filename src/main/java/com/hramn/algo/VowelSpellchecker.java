package com.hramn.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 966. Vowel Spellchecker
 * https://leetcode.com/problems/vowel-spellchecker/description
 * 
 * Given a wordlist, we want to implement a spellchecker that converts 
 * a query word into a correct word.
 * 
 * For a given query word, the spell checker handles two categories of spelling 
 * mistakes:
 * - Capitalization: If the query matches a word in the wordlist 
 *   (case-insensitive), then the query word is returned with the same case as 
 *   the case in the wordlist.
 *   - Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
 *   - Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
 *   - Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
 * - Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of 
 *   the query word with any vowel individually, it matches a word in 
 *   the wordlist (case-insensitive), then the query word is returned with 
 *   the same case as the match in the wordlist.
 *   - Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
 *   - Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
 *   - Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
 * 
 * In addition, the spell checker operates under the following precedence rules:
 * - When the query exactly matches a word in the wordlist (case-sensitive), 
 *   you should return the same word back.
 * - When the query matches a word up to capitlization, you should return 
 *   the first such match in the wordlist.
 * - When the query matches a word up to vowel errors, you should return 
 *   the first such match in the wordlist.
 * - If the query has no matches in the wordlist, you should return the empty 
 *   string.
 * 
 * Given some queries, return a list of words answer, where answer[i] is 
 * the correct word for query = queries[i].
 * 
 * Example 1:
 * Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
 * Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
 * 
 * Example 2:
 * Input: wordlist = ["yellow"], queries = ["YellOw"]
 * Output: ["yellow"]
 * 
 * Constraints:
 * 1 <= wordlist.length, queries.length <= 5000
 * 1 <= wordlist[i].length, queries[i].length <= 7
 * wordlist[i] and queries[i] consist only of only English letters.
 * 
 * TAG: medium
 * TAG: strings
 */
public class VowelSpellchecker {
	class Solution { // O(N + M), O(N) where N = wordlist.length(), M = queries.length()
		public String[] spellchecker(String[] wordlist, String[] queries) {
			Set<String> exactlyWords = new HashSet<>(List.of(wordlist));
			Map<String, String> capitalWords = new HashMap<>();
			Map<String, String> vowelWords = new HashMap<>();
			for (String word : wordlist) {
				String lcWord = word.toLowerCase();
				capitalWords.putIfAbsent(lcWord, word);
				vowelWords.putIfAbsent(replaceVowels(lcWord), word);
			}
			int n = queries.length;
			String[] result = new String[n];
			for (int i = 0; i < n; i++) {
				String query = queries[i];
				if (exactlyWords.contains(query)) {
					result[i] = query;
					continue;
				}
				String lcQuery = query.toLowerCase();
				String word = capitalWords.get(lcQuery);
				if (word != null) {
					result[i] = word;
					continue;
				}
				String vQuery = replaceVowels(lcQuery);
				word = vowelWords.get(vQuery);
				if (word != null) {
					result[i] = word;
					continue;
				}
				result[i] = "";
			}
			return result;
		}

		private String replaceVowels(String word) {
			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (isVowel(arr[i])) {
					arr[i] = 'a';
				}
			}
			return new String(arr);
		}

		private boolean isVowel(char ch) {
			return "aeiou".indexOf(Character.toLowerCase(ch)) >= 0;
		}
	}
}
