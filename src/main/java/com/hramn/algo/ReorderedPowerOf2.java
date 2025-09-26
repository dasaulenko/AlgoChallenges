package com.hramn.algo;

import java.util.Arrays;

/**
 * 869. Reordered Power of 2
 * https://leetcode.com/problems/reordered-power-of-2/description
 * 
 * You are given an integer n. We reorder the digits in any order (including 
 * the original order) such that the leading digit is not zero.
 * 
 * Return true if and only if we can do this so that the resulting number is 
 * a power of two.
 * 
 * Example 1:
 * Input: n = 1
 * Output: true
 * 
 * Example 2:
 * Input: n = 10
 * Output: false
 * 
 * Constraints:
 * 1 <= n <= 10^9
 * 
 * TAG: 20250810
 * TAG: medium
 * TAG: numbers
 */
public class ReorderedPowerOf2 {
	class Solution { // O(1), O(1)
		public boolean reorderedPowerOf2(int n) {
			if (n == 1) {
				return true;
			}
			char[] numbers = String.valueOf(n).toCharArray();
			Arrays.sort(numbers);
			int x = 1;
			boolean result = false;
			for (int i = 1; i < 32; i++) {
				x *= 2;
				char[] tmp = String.valueOf(x).toCharArray();
				if (numbers.length == tmp.length) {
					Arrays.sort(tmp);
					int j = 0;
					for (; j < numbers.length; j++) {
						if (numbers[j] != tmp[j]) {
							break;
						}
					}
					if (j == numbers.length) {
						result = true;
						break;
					}
				} else if (numbers.length < tmp.length) {
					break;
				}
			}
			return result;
    }
	}
}
