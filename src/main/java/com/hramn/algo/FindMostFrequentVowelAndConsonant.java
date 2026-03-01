package com.hramn.algo;
/**
 * 3541. Find Most Frequent Vowel and Consonant
 * https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description
 * 
 * You are given a string s consisting of lowercase English letters ('a' to 
 * 'z').
 * 
 * Your task is to:
 * - Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum 
 *   frequency.
 * - Find the consonant (all other letters excluding vowels) with the maximum 
 *   frequency.
 * 
 * Return the sum of the two frequencies.
 * 
 * Note: If multiple vowels or consonants have the same maximum frequency, you 
 * may choose any one of them. If there are no vowels or no consonants in 
 * the string, consider their frequency as 0.
 * 
 * The frequency of a letter x is the number of times it occurs in the string.
 * 
 * Example 1:
 * Input: s = "successes"
 * Output: 6
 * Explanation:
 * The vowels are: 'u' (frequency 1), 'e' (frequency 2). 
 * he maximum frequency is 2.
 * The consonants are: 's' (frequency 4), 'c' (frequency 2). 
 * The maximum frequency is 4.
 * The output is 2 + 4 = 6.
 * 
 * Example 2:
 * Input: s = "aeiaeia"
 * Output: 3
 * Explanation:
 * The vowels are: 'a' (frequency 3), 'e' ( frequency 2), 'i' (frequency 2). 
 * The maximum frequency is 3.
 * There are no consonants in s. Hence, maximum consonant frequency = 0.
 * The output is 3 + 0 = 3.
 * 
 * Constraints:
 * 1 <= s.length <= 100
 * s consists of lowercase English letters only.
 * 
 * TAG: easy
 * TAG: strings
 */
public class FindMostFrequentVowelAndConsonant {
	class Solution { // O(N), O(1) where N = s.length()
		public int maxFreqSum(String s) {
			char[] vowels = new char[] {'a','e','i','o','u'};
			int[] counter = new int[26];
			for (char ch : s.toCharArray()) {
				counter[ch-'a']++;
			}
			int index = 0;
			int maxVowel = 0;
			int maxCons = 0;
			for (int i = 0; i < 26; i++) {
				if (index < 5 && i == vowels[index]-'a') {
					index++;
					maxVowel = Math.max(maxVowel, counter[i]);
					continue;
				}
				maxCons = Math.max(maxCons, counter[i]);
			}
			return maxVowel + maxCons;
		}
	}
}
