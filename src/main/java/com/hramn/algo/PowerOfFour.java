package com.hramn.algo;
/**
 * 342. Power of Four
 * https://leetcode.com/problems/power-of-four/description
 * 
 * Given an integer n, return true if it is a power of four. Otherwise, return 
 * false.
 * 
 * An integer n is a power of four, if there exists an integer x such that 
 * n == 4x.
 * 
 * Example 1:
 * Input: n = 16
 * Output: true
 * 
 * Example 2:
 * Input: n = 5
 * Output: false
 * 
 * Example 3:
 * Input: n = 1
 * Output: true
 * 
 * Constraints:
 * -2^31 <= n <= 2^31 - 1
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * TAG: 20250815
 * TAG: easy
 * TAG: powerof
 */
public class PowerOfFour {
	class Solution { // O(log4(N)), O(1) where N = n
		public boolean isPowerOfFour(int n) {
			if (n < 1) {
				return false;
			}
			while (n % 4 == 0) {
				n /= 4;
			}
			return n == 1;
		}
	}

	class FollowUpSolution { // O(1), O(1)
		public boolean isPowerOfFour(int n) {
			return (n & (n - 1)) == 0 && n % 3 == 1;
		}
	}
}
