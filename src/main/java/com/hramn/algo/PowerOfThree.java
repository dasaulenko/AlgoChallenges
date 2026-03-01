package com.hramn.algo;
/**
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/description
 * 
 * Given an integer n, return true if it is a power of three. Otherwise, return 
 * false.
 * 
 * An integer n is a power of three, if there exists an integer x such that 
 * n == 3x.
 * 
 * Example 1:
 * Input: n = 27
 * Output: true
 * Explanation: 27 = 3^3
 * 
 * Example 2:
 * Input: n = 0
 * Output: false
 * Explanation: There is no x where 3x = 0.
 * 
 * Example 3:
 * Input: n = -1
 * Output: false
 * Explanation: There is no x where 3x = (-1).
 * 
 *  Constraints:
 * -2^31 <= n <= 2^31 - 1
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * TAG: 20250813
 * TAG: easy
 * TAG: powerof
 */

public class PowerOfThree {
	class Solution { // O(1), O(1)
		public boolean isPowerOfThree(int n) {
			if (n <= 0) return false;
			while (n % 3 == 0) {
				n /= 3;
			}
			return n == 1;
		}
	}

	class FollowUpSolution { // O(1), O(1)
		public boolean isPowerOfThree(int n) {
			int max = 1162261467; // 3^19 is max value power of three for integer type
			return n > 0 && max % n == 0;
		}
	}
}
