package com.hramn.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description
 * 
 * Given two integers representing the numerator and denominator of a fraction, 
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in 
 * parentheses.
 * 
 * If multiple answers are possible, return any of them.
 * 
 * It is guaranteed that the length of the answer string is less than 104 for 
 * all the given inputs.
 * 
 * Example 1:
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * 
 * Example 2:
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * 
 * Example 3:
 * Input: numerator = 4, denominator = 333
 * Output: "0.(012)"
 * 
 * Constraints:
 * -2^31 <= numerator, denominator <= 2^31 - 1
 * denominator != 0
 * 
 * TAG: medium
 * TAG: numbers
 */
public class FractionToRecurringDecimal {
	class Solution { // O(N) time, O(N) space, where N = denominator
		public String fractionToDecimal(int numerator, int denominator) {

			if (numerator == 0) return "0";
			
			StringBuffer result = new StringBuffer();

			if (numerator < 0 ^ denominator < 0) 
				result.append("-");

			long num = Math.abs((long)numerator);
			long den = Math.abs((long)denominator);

			result.append(num / den);

			long rem = num % den;
			if (rem == 0) return result.toString();
			result.append(".");

			Map<Long, Integer> remPos = new HashMap<>();
			while (rem != 0 && result.length() <= 10000) {
				if (remPos.containsKey(rem)) {
					result.insert(remPos.get(rem), "(");
					result.append(")");
					break; 
				}
				remPos.put(rem, result.length());
				rem *= 10;
				result.append(rem / den);
				rem %= den;
			}

			return result.toString();
		}
	}
}
