package com.hramn.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131. Longest Palindrome by Concatenating Two Letter Words
 * https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description
 * 
 * You are given an array of strings words. Each element of words consists of 
 * two lowercase English letters.
 * 
 * Create the longest possible palindrome by selecting some elements from words 
 * and concatenating them in any order. Each element can be selected at most 
 * once.
 * 
 * Return the length of the longest palindrome that you can create. If it is 
 * impossible to create any palindrome, return 0.
 * 
 * A palindrome is a string that reads the same forward and backward.
 * 
 * Example 1:
 * Input: words = ["lc","cl","gg"]
 * Output: 6
 * Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of 
 * length 6.
 * Note that "clgglc" is another longest palindrome that can be created.
 * 
 * Example 2:
 * Input: words = ["ab","ty","yt","lc","cl","ab"]
 * Output: 8
 * Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = 
 * "tylcclyt", of length 8.
 * Note that "lcyttycl" is another longest palindrome that can be created.
 * 
 * Example 3:
 * Input: words = ["cc","ll","xx"]
 * Output: 2
 * Explanation: One longest palindrome is "cc", of length 2.
 * Note that "ll" is another longest palindrome that can be created, and so is 
 * "xx".
 * 
 * Constraints:
 * 1 <= words.length <= 10^5
 * words[i].length == 2
 * words[i] consists of lowercase English letters.
 * 
 * TAG: 20250525
 * TAG: medium
 * TAG: string
 * TAG: hash_map
 * TAG: grid
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {
	class GridSolution { // O(N), O(1), N - words.length
		public int longestPalindrome(String[] words) {
			int[][] grid = new int[26][26];
			for (String word : words) {
				grid[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
			}
			int ans = 0;
			boolean isCentral = false;
			for (String word : words) {
				int i = word.charAt(0) - 'a';
				int j = word.charAt(1) - 'a';
				if (grid[j][i] > 0) {
					if (i == j) {
						ans += grid[i][j] / 2 * 4;
						if (!isCentral && grid[i][j] % 2 == 1) {
							ans += 2;
							isCentral = true;
						}
					} else {
						ans += Math.min(grid[j][i], grid[i][j]) * 4;
					}
					grid[i][j] = 0;
					grid[j][i] = 0;
				}
			}
			return ans;
		}
	}

	class HashMapSolution { // O(N), O(N), N - words.length
		public int longestPalindrome(String[] words) {
			int n = words.length;
			Map<String, Integer> map = new HashMap<>();
			boolean isCentre = false;
			for (int i = 0; i < n; i++) {
				map.put(words[i], map.getOrDefault(words[i], 0) + 1);
			}
			int ans = 0;
			for (String key : map.keySet()) {
				String pol = "" + key.charAt(1) + key.charAt(0);
				if (key.equals(pol)) {
					ans += map.get(key) / 2 * 4;
					if (!isCentre && map.get(key) % 2 == 1) {
						isCentre = true;
						ans += 2;
					}
				} else if (key.compareTo(pol) < 0 && map.containsKey(pol)) {
					ans += Math.min (map.get(key), map.get(pol)) * 4;
				}
			}
			return ans;
		}
	}

	class BruteforceSolution { // O(N^2), O(1), N - words.length
		public int longestPalindrome(String[] words) {
			int n = words.length;
			int ans = 0;
			boolean isCenter = false;
			for (int i = 0; i < n; i++) {
				if (words[i].length() == 2) {
					boolean isPair = false;
					for (int j = i+1; j < n; j++) {
						if (words[j].length() == 2 
								&& words[i].charAt(0) == words[j].charAt(1)
								&& words[i].charAt(1) == words[j].charAt(0)) {
							ans += 4;
							words[j] = "0";
							isPair = true;
							break;
						}
					}
					if (!isPair && !isCenter) {
						if (words[i].charAt(0) == words[i].charAt(1)) {
							ans += 2;
							isCenter = true;
						}
					}
				}
			}
			return ans;
		}
	}
}
