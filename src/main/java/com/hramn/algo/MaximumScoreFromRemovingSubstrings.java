package com.hramn.algo;
/**
 * 1717. Maximum Score From Removing Substrings
 * https://leetcode.com/problems/maximum-score-from-removing-substrings/description
 * 
 * You are given a string s and two integers x and y. You can perform two types 
 * of operations any number of times.
 * 
 * - Remove substring "ab" and gain x points.
 *   - For example, when removing "ab" from "cabxbae" it becomes "cxbae".
 * 
 * - Remove substring "ba" and gain y points.
 *   - For example, when removing "ba" from "cabxbae" it becomes "cabxe".
 * 
 * Return the maximum points you can gain after applying the above operations 
 * on s.
 * 
 * Example 1:
 * Input: s = "cdbcbbaaabab", x = 4, y = 5
 * Output: 19
 * Explanation:
 * - Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 
 *   5 points are added to the score.
 * - Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 
 *   4 points are added to the score.
 * - Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 
 *   5 points are added to the score.
 * - Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 
 *   5 points are added to the score.
 * Total score = 5 + 4 + 5 + 5 = 19.
 * 
 * Example 2:
 * Input: s = "aabbaaxybbaabb", x = 5, y = 4
 * Output: 20
 * 
 *  Constraints:
 * 1 <= s.length <= 10^5
 * 1 <= x, y <= 10^4
 * s consists of lowercase English letters.
 * 
 * TAG: 20250723
 * TAG: medium
 * TAG: string
 */
public class MaximumScoreFromRemovingSubstrings {
	class Solution {
		public int maximumGain(String s, int x, int y) {
			char[] arr = s.toCharArray();
			int n = arr.length;
			char[] pair = new char[2];
			int[] counter = new int[2];
			int max = 0;
			int min = 0;
			if (x > y) {
				pair[0] = 'a';
				pair[1] = 'b';
				max = x;
				min = y;
			} else {
				pair[0] = 'b';
				pair[1] = 'a';
				max = y;
				min = x;
			}
			int score = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] == pair[1]) {
					if (counter[0] > 0) {
						counter[0]--;
						score += max;
					} else {
						counter[1]++;
					}
				} else if (arr[i] == pair[0]) {
					counter[0]++;
				} else {
					score += Math.min(counter[0], counter[1]) * min;
					counter[0] = 0;
					counter[1] = 0;
				}
			}
			score += Math.min(counter[0], counter[1]) * min;
			return score;
		}
	}
}