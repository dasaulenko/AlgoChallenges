package com.hramn.algo;
/**
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/description
 * 
 * Given an integer n, return true if it is a power of two. Otherwise, return 
 * false.
 * 
 * An integer n is a power of two, if there exists an integer x such that 
 * n == 2x.
 * 
 * Example 1:
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 * 
 * Example 2:
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 * 
 * Example 3:
 * Input: n = 3
 * Output: false
 * 
 *  Constraints:
 * -2^31 <= n <= 2^31 - 1
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * TAG: 20250809
 * TAG: easy
 * TAG: bitwise
 */
public class PowerOfTwo {
	class Solution { // O(N), O(1) where N = sqrt(n)
		public boolean isPowerOfTwo(int n) {
			if (n < 1) {
				return false;
			}
			while (n % 2 == 0) {
				n /= 2;
			}
			return n == 1;
		}
	}

	class FollowUpSolution { // O(1), O(1)
		public boolean isPowerOfTwo(int n) {
			return Integer.bitCount(n) == 1 && n != Integer.MIN_VALUE;
		}
	}
}
