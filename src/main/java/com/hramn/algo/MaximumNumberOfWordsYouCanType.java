package com.hramn.algo;
/**
 * 1935. Maximum Number of Words You Can Type
 * https://leetcode.com/problems/maximum-number-of-words-you-can-type/description
 * 
 * There is a malfunctioning keyboard where some letter keys do not work. All 
 * other keys on the keyboard work properly.
 * 
 * Given a string text of words separated by a single space (no leading or 
 * trailing spaces) and a string brokenLetters of all distinct letter keys 
 * that are broken, return the number of words in text you can fully type using 
 * this keyboard.
 * 
 * Example 1:
 * Input: text = "hello world", brokenLetters = "ad"
 * Output: 1
 * Explanation: We cannot type "world" because the 'd' key is broken.
 * 
 * Example 2:
 * Input: text = "leet code", brokenLetters = "lt"
 * Output: 1
 * Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.
 * 
 * Example 3:
 * Input: text = "leet code", brokenLetters = "e"
 * Output: 0
 * Explanation: We cannot type either word because the 'e' key is broken.
 * 
 * Constraints:
 * 1 <= text.length <= 10^4
 * 0 <= brokenLetters.length <= 26
 * text consists of words separated by a single space without any leading or 
 * trailing spaces.
 * Each word only consists of lowercase English letters.
 * brokenLetters consists of distinct lowercase English letters.
 * 
 * TAG: easy
 * TAG: strings
 */
public class MaximumNumberOfWordsYouCanType {
	class Solution { // O(N), O(1) where N = text.length()
		public int canBeTypedWords(String text, String brokenLetters) {
			int counter = 0;
			boolean isBroken = false;
			for (int i = 0; i < text.length(); i++) {
				char ch = text.charAt(i);
				if (ch == ' ') {
					if (!isBroken) {
						counter++;
					}
					isBroken = false;
				} else if (!isBroken && brokenLetters.indexOf(ch) >= 0) {
					isBroken = true;
				}
			}
			return isBroken ? counter : counter + 1;
		}
	}
}
