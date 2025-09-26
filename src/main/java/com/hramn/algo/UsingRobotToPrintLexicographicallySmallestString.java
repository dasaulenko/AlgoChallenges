package com.hramn.algo;

import java.util.LinkedList;
import java.util.List;

/**
 * 2434. Using a Robot to Print the Lexicographically Smallest String
 * https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description
 * 
 * You are given a string s and a robot that currently holds an empty string t. 
 * Apply one of the following operations until s and t are both empty:
 * - Remove the first character of a string s and give it to the robot. 
 *   The robot will append this character to the string t.
 * - Remove the last character of a string t and give it to the robot. 
 *   The robot will write this character on paper.
 * 
 * Return the lexicographically smallest string that can be written on 
 * the paper.
 * 
 * Example 1:
 * Input: s = "zza"
 * Output: "azz"
 * Explanation: Let p denote the written string.
 * Initially p="", s="zza", t="".
 * Perform first operation three times p="", s="", t="zza".
 * Perform second operation three times p="azz", s="", t="".
 * 
 * Example 2:
 * Input: s = "bac"
 * Output: "abc"
 * Explanation: Let p denote the written string.
 * Perform first operation twice p="", s="c", t="ba". 
 * Perform second operation twice p="ab", s="c", t="". 
 * Perform first operation p="ab", s="", t="c". 
 * Perform second operation p="abc", s="", t="".
 * 
 * Example 3:
 * Input: s = "bdda"
 * Output: "addb"
 * Explanation: Let p denote the written string.
 * Initially p="", s="bdda", t="".
 * Perform first operation four times p="", s="", t="bdda".
 * Perform second operation four times p="addb", s="", t="".
 * 
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of only English lowercase letters.
 * 
 * TAG: 20250606
 * TAG: medium
 * TAG: string
 */
public class UsingRobotToPrintLexicographicallySmallestString {
	class Solution { // O(N), O(N), N - s.length()
		public String robotWithString(String s) {
			int n = s.length();
			char[] arr = s.toCharArray();
			int[] counterStr = new int[26];
			for (char ch : arr) {
				counterStr[ch - 'a']++;
			}
			int iStr = 0, iCnt = 0;
			List<Character> stack = new LinkedList<>();
			StringBuilder sb = new StringBuilder();
			while (iStr < n && iCnt < 26) {
				if (counterStr[iCnt] == 0) {
					iCnt++;
					continue;
				}
				if (!stack.isEmpty() && stack.getLast() <= iCnt + 'a') {
					sb.append(stack.removeLast());
					continue;
				}
				for (int i = iStr; i < n; i++) {
					if (iCnt + 'a' == arr[i]) {
						sb.append(arr[i]);
						counterStr[iCnt]--;
						iStr = i+1;
						break;
					} else {
						stack.add(arr[i]);
						counterStr[arr[i] - 'a']--;
					}
				}
			}
			while(!stack.isEmpty()) {
				sb.append(stack.removeLast());
			}
			return sb.toString();
		}
	}
}
