package com.hramn.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 3333. Find the Original Typed String II
 * https://leetcode.com/problems/find-the-original-typed-string-ii/description
 * 
 * Alice is attempting to type a specific string on her computer. However, she 
 * tends to be clumsy and may press a key for too long, resulting in 
 * a character being typed multiple times.
 * 
 * You are given a string word, which represents the final output displayed on 
 * Alice's screen. You are also given a positive integer k.
 * 
 * Return the total number of possible original strings that Alice might have 
 * intended to type, if she was trying to type a string of size at least k.
 * 
 * Since the answer may be very large, return it modulo 109 + 7.
 * 
 * Example 1:
 * Input: word = "aabbccdd", k = 7
 * Output: 5
 * Explanation:
 * The possible strings are: "aabbccdd", "aabbccd", "aabbcdd", "aabccdd", and "abbccdd".
 * 
 * Example 2:
 * Input: word = "aabbccdd", k = 8
 * Output: 1
 * Explanation:
 * The only possible string is "aabbccdd".
 * 
 * Example 3:
 * Input: word = "aaabbb", k = 3
 * Output: 8
 * 
 * Constraints:
 * 1 <= word.length <= 5 * 10^5
 * word consists only of lowercase English letters.
 * 1 <= k <= 2000
 * 
 * TAG: hard
 */
public class FindOriginalTypedStringII {
	class Solution {
		public int possibleStringCount(String word, int k) {
			int n = word.length();
			if (n == k) {
				return 1;
			}
			if (k > n) {
				return 0;
			}
			List<Integer> counters = new ArrayList<>();
			int c = 1;
			char prev = word.charAt(0);
			for (int i = 1; i < n; i++) {
				char ch = word.charAt(i);
				if (ch == prev) {
					c++;
				} else {
					if (c > 1) {
						counters.add(c-1);
						c = 1;
					}
					prev = ch;
				}
			}
			if (c > 1) {
				counters.add(c-1);
			}
			if (counters.size() == 0) {
				return 1;
			}
			int dif = n - k;
			return countWays(counters, dif);
		}

		private int countWays(List<Integer> counters, int k) {
			int MOD = 1_000_000_007;
			int n = counters.size();
			int[] prev = new int[k + 1];
			int[] curr = new int[k + 1];

			// Base case: if k == 0
			prev[0] = 1;

			for (int i = 0; i < n; i++) {
				int maxTake = counters.get(i);

				// Префиксные суммы для быстрого диапазонного сложения
				int[] prefix = new int[k + 1];
				prefix[0] = prev[0];
				for (int s = 1; s <= k; s++) {
					prefix[s] = (prefix[s - 1] + prev[s]) % MOD;
				}

				for (int s = 0; s <= k; s++) {
					int left = s - maxTake - 1;
					if (left >= 0) {
						curr[s] = prefix[s] - prefix[left];
						if (curr[s] < 0) curr[s] += MOD;
					} else {
						curr[s] = prefix[s];
					}
				}

				// Перекидываем массивы
				int[] temp = prev;
				prev = curr;
				curr = temp;
			}

			// Суммируем все варианты для сумм от 0 до k
			int totalWays = 0;
			for (int s = 0; s <= k; s++) {
				totalWays = (totalWays + prev[s]) % MOD;
			}
			return totalWays;
		}
	}
}
