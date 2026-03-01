package com.hramn.algo;
/*
 * https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description
 * 
 * 1780. Check if Number is a Sum of Powers of Three
 * 
 * Given an integer n, return true if it is possible to represent n as the sum 
 * of distinct powers of three. Otherwise, return false.
 * 
 * An integer y is a power of three if there exists an integer x such that 
 * y == 3x.
 * 
 * Example 1:
 * Input: n = 12
 * Output: true
 * Explanation: 12 = 31 + 32
 * 
 * Example 2:
 * Input: n = 91
 * Output: true
 * Explanation: 91 = 30 + 32 + 34
 * 
 * Example 3:
 * Input: n = 21
 * Output: false
 * 
 * Constraints:
 * 1 <= n <= 10^7
 */
public class CheckIfNumberIsSumOfPowersOfThree {
	// 0: 1
	// 1: 3, 4
	// 2: 9, 10, 12, 13
	// 3: 27, 28, 30, 31, 36, 37, 39, 40
	// 4: 81, 82, 84, 85, 90, 91, 93, 94, 108, 109, 111, 112, 117, 118, 120, 121 
	class Solution {
		public boolean checkPowersOfThree(int n) {
			int r = 0;
			int val = 1;
			while (val < n) {
				val *= 3;
				r++;
			}
			if (val == n) {
				return true;
			}
			r--;
			val /= 3;
			while (r > 0) {
				r--;
				int add = (int) Math.pow(3,r);
				if (val + add == n) {
					return true;
				} else if (val + add < n) {
					val += add;
				}
			}
			return false;
		}
	}
}
