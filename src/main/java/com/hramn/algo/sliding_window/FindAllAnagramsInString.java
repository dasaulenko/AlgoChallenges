package com.hramn.algo.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * 
 * 438. Find All Anagrams in a String
 * 
 * Given two strings s and p, return an array of all the start indices of p's 
 * anagrams in s. You may return the answer in any order.
 * 
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * Example 2:
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * Constraints:
 * 1 <= s.length, p.length <= 3 * 10^4
 * s and p consist of lowercase English letters.
 */
public class FindAllAnagramsInString {
	
	class SortingSolution { // O(N * M * log(M))
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> indexes = new ArrayList<>();
			String sortP = sort(p);

			for (int i = 0; i < s.length() - p.length()+1; i++) {
				String substr = s.substring(i, i + p.length());
				if (sortP.equals(sort(substr))) {
					indexes.add(i);
				}
			}
			return indexes;
		}

		private String sort(String str) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		}		
	}

	class BruteforceSolution { // O(N * M)
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> indexes = new ArrayList<>();
			Map<Character, Integer> pMap = countChars(p);
			for (int i = 0; i < s.length() - p.length() + 1; i++) {
				Map<Character, Integer> substringMap = 
						countChars(s.substring(i, i + p.length()));
				if (compareMap(pMap, substringMap)) {
					indexes.add(i);
				}
			}
			return indexes;
		}

		private Map<Character, Integer> countChars (String str) {
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < str.length(); i++) {
				map.put(str.charAt(i), map.getOrDefault(
						str.charAt(i), 0) + 1);
			}
			return map;
		}

		private boolean compareMap (
				Map<Character, Integer> map1, Map<Character, Integer> map2) {
			for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
				if (map2.getOrDefault(entry.getKey(), 0) != entry.getValue()) {
					return false;
				}
			}
			for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
				if (map1.getOrDefault(entry.getKey(), 0) != entry.getValue()) {
					return false;
				}
			}
			return true;
		}
	}

	class SlidingWindowSolution1 { // O(N)
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> indexes = new ArrayList<>();
			int[] charsCounter = new int[26];
			int l = 0;
			for (int i = 0; i < s.length(); i++) {
				charsCounter[s.charAt(i) - 'a']++;
				if (i > p.length() - 1) {
					charsCounter[s.charAt(l) - 'a']--;
					l++;
				} else {
					charsCounter[p.charAt(i) - 'a']--;
				}
				if (i >= p.length() - 1) {
					if (isAllElemZero(charsCounter)) {
						indexes.add(l);
					}
				}
			}
			return indexes;
		}

		private boolean isAllElemZero (int[] counter) {
			for (int i = 0; i < counter.length; i++) {
				if (counter[i] != 0) {
					return false;
				}
			}
			return true;
		}
	}

	class SlidingWindowSolution2 { // O(N)
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> indexes = new ArrayList<>();
			int[] counterS = new int[26];
			int[] counterP = new int[26];
			int l = 0;
			for (int i = 0; i < p.length(); i++) {
				counterP[p.charAt(i) - 'a']++;
				counterS[s.charAt(i) - 'a']++;
			}
			if (Arrays.equals(counterP, counterS)) {
				indexes.add(0);
			}
			for (int i = p.length(); i < s.length(); i++) {
				counterS[s.charAt(i) - 'a']++;
				counterS[s.charAt(l) - 'a']--;
				l++;
				if (Arrays.equals(counterP, counterS)) {
					indexes.add(l);
				}
			}
			return indexes;
		}
	}

}
