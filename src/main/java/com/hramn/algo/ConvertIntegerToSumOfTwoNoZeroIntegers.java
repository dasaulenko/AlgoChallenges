package com.hramn.algo;
/**
 * 1317. Convert Integer to the Sum of Two No-Zero Integers
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description
 * 
 * No-Zero integer is a positive integer that does not contain any 0 in its 
 * decimal representation.
 * 
 * Given an integer n, return a list of two integers [a, b] where:
 * - a and b are No-Zero integers.
 * - a + b = n
 * 
 * The test cases are generated so that there is at least one valid solution. 
 * If there are many valid solutions, you can return any of them.
 * 
 * Example 1:
 * Input: n = 2
 * Output: [1,1]
 * Explanation: Let a = 1 and b = 1.
 * Both a and b are no-zero integers, and a + b = 2 = n.
 * 
 * Example 2:
 * Input: n = 11
 * Output: [2,9]Explanation: Let a = 2 and b = 9.
 * Both a and b are no-zero integers, and a + b = 11 = n.
 * Note that there are other valid answers as [8, 3] that can be accepted.
 * 
 * Constraints:
 * 2 <= n <= 10^4
 * 
 * TAG: easy
 * TAG: numbers
 */
public class ConvertIntegerToSumOfTwoNoZeroIntegers {
	class Solution20250908 { // O(1), O(1)
		public int[] getNoZeroIntegers(int n) {
			int[] result = new int[] {1, n-1};
			while (containsZero(result[0]) || containsZero(result[1])) {
				result[0]++;
				result[1]--;
			}
			return result;
		}

		private boolean containsZero(int num) {
			// return String.valueOf(num).contains("0");
			while (num > 0) {
				int rem = num % 10;
				if (rem == 0) return true;
				num /= 10;
			}
			return false;
		}
	}
}
