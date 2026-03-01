package com.hramn.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3170. Lexicographically Minimum String After Removing Stars
 * https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description
 * 
 * You are given a string s. It may contain any number of '*' characters. Your 
 * task is to remove all '*' characters.
 * 
 * While there is a '*', do the following operation:
 * - Delete the leftmost '*' and the smallest non-'*' character to its left. If 
 *   there are several smallest characters, you can delete any of them.
 * 
 * Return the lexicographically smallest resulting string after removing all 
 * '*' characters.
 * 
 * Example 1:
 * Input: s = "aaba*"
 * Output: "aab"
 * Explanation:
 * We should delete one of the 'a' characters with '*'. If we choose s[3], s 
 * becomes the lexicographically smallest.
 * 
 * Example 2:
 * Input: s = "abc"
 * Output: "abc"
 * Explanation:
 * There is no '*' in the string.
 * 
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists only of lowercase English letters and '*'.
 * The input is generated such that it is possible to delete all '*' characters.
 * 
 * TAG: 20250607
 * TAG: medium
 * TAG: heap
 * TAG: PriorityQueue
 */
public class LexicographicallyMinimumStringAfterRemovingStars {
	class Solution { // O(N * log(N)), O(N), N - s.length()
		public String clearStars(String s) {
			int n = s.length();
			PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
					public int compare(int[] a1, int[] a2) {
						int r = a1[0] - a2[0];
						if (r == 0) {
            	r = a2[1] - a1[1];
						}
						return r;
					}
      });
			int[] changes = new int[n];
			char[] chars = s.toCharArray();
			for (int i = 0; i < n; i++) {
				if (chars[i] == '*') {
					changes[i] = 1;
					int[] arr = heap.poll();
					changes[arr[1]] = 1;
				} else {
					heap.add (new int[] {chars[i], i});
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				if (changes[i] == 0) {
					sb.append(chars[i]);
				}
			}
			return sb.toString();
		}
	}
}
