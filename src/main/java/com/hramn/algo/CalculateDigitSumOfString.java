package com.hramn.algo;

/**
 * 2243. Calculate Digit Sum of a String
 *
 * <p>
 * <strong>Difficulty:</strong> Easy
 * <br>
 * <strong>LeetCode:</strong>
 * <a href="https://leetcode.com/problems/calculate-digit-sum-of-a-string/">
 * 2243. Calculate Digit Sum of a String</a>
 * <br>
 * <strong>Topic:</strong> string
 *
 * <hr>
 *
 * <p>
 * You are given a string {@code s} consisting of digits and an integer
 * {@code k}.
 *
 * <p>
 * A round can be completed if the length of {@code s} is greater than
 * {@code k}. In one round, do the following:
 * <ol>
 * <li>Divide {@code s} into consecutive groups of size {@code k} such that the
 * first {@code k} characters are in the first group, the next {@code k}
 * characters are in the second group, and so on. Note that the size of the last
 * group can be smaller than {@code k}.</li>
 * <li>Replace each group of {@code s} with a string representing the sum of all
 * its digits. For example, {@code "346"} is replaced with {@code "13"} because
 * {@code 3 + 4 + 6 = 13}./li>
 * <li>Merge consecutive groups together to form a new string. If the length of
 * the string is greater than {@code k}, repeat from step {@code 1}.</li>
 * </ol>
 *
 * <p>
 * Return s after all rounds have been completed.
 *
 * <p>
 * <strong>Example 1:</strong>
 *
 * <pre>{@code
 * Input: s = "11111222223", k = 3
 * Output: "135"
 * Explanation:
 * - For the first round, we divide s into groups of size 3: "111", "112",
 * "222", and "23".
 * ​​​​​Then we calculate the digit sum of each group: 1 + 1 + 1 = 3, 1 + 1 + 2
 * = 4, 2 + 2 + 2 = 6, and 2 + 3 = 5.
 * So, s becomes "3" + "4" + "6" + "5" = "3465" after the first round.
 * - For the second round, we divide s into "346" and "5".
 * Then we calculate the digit sum of each group: 3 + 4 + 6 = 13, 5 = 5.
 * So, s becomes "13" + "5" = "135" after second round.
 * Now, s.length <= k, so we return "135" as the answer.
 * }</pre>
 *
 * <p>
 * <strong>Example 2:</strong>
 *
 * <pre>{@code
 * Input: s = "00000000", k = 3
 * Output: "000"
 * Explanation:
 * We divide s into "000", "000", and "00".
 * Then we calculate the digit sum of each group: 0 + 0 + 0 = 0, 0 + 0 + 0 = 0,
 * and 0 + 0 = 0.
 * s becomes "0" + "0" + "0" = "000", whose length is equal to k, so we return
 * "000".
 * }</pre>
 *
 * <p>
 * <strong>Constraints:</strong>
 *
 * <pre>{@code
 * 1 <= s.length <= 100
 * 2 <= k <= 100
 * s consists of digits only.
 * }</pre>
 */
public class CalculateDigitSumOfString {
	class Solution {
		public String digitSum(String s, int k) {
			StringBuilder sb = new StringBuilder(s);
			while (sb.length() > k) {
				int num = 0;
				StringBuilder newSb = new StringBuilder();
				for (int i = 0; i < sb.length(); i++) {
					num += sb.charAt(i) - '0';
					if ((i + 1) % k == 0) {
						newSb.append(num);
						num = 0;
					}
				}
				if (sb.length() % k != 0) {
					newSb.append(num);
				}
				sb = newSb;
			}
			return sb.toString();
		}
	}
}
