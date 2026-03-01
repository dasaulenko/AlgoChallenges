package com.hramn.algo.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * 1209. Remove All Adjacent Duplicates in String II
 * 
 * You are given a string s and an integer k, a k duplicate removal consists of 
 * choosing k adjacent and equal letters from s and removing them, causing the 
 * left and the right side of the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It 
 * is guaranteed that the answer is unique.
 * 
 * Example 1:
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * 
 * Example 2:
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation: 
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * 
 * Example 3:
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 * 
 * Constraints:
 * 1 <= s.length <= 10**5
 * 2 <= k <= 10**4
 * s only contains lowercase English letters.
 */
public class RemoveAllAdjacentDuplicatesInStringII {

	public static void main(String[] args) {
		String s = "deeedbbcccbdaa";
		int k = 3;
		Solution solution = new Solution();
		String result = solution.removeDuplicates(s, k);
		System.out.println(result);
		assert result.equals("aa");
	}
	
	static class Solution {
		private class Pair {
			public int count;
			public char c;
			public Pair(char c, int count) {
				this.c = c;
				this.count = count;
			}
		}

		public String removeDuplicates (String s, int k) {
			if (s == null) {
				return null;
			}
			if (k < 2 || s.length() < k) {
				return s;
			}
			List<Pair> stack = new LinkedList<>();
			for (char c : s.toCharArray()) {
				if (stack.size() > 0 && stack.getLast().c == c) {
					if (stack.getLast().count + 1 == k) {
						stack.removeLast();
					} else {
						stack.getLast().count++;
					}
				} else {
					stack.add(new Pair(c, 1));
				}
			}
			if (stack.size() == 0) {
				return "";
			}
			StringBuilder sb = new StringBuilder();
			for (Pair p : stack) {
				for (int i = 0; i < p.count; i++) {
					sb.append(p.c);
				}
			}
			return sb.toString();
		}
	}
}
