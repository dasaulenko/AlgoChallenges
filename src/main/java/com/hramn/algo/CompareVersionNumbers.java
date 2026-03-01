package com.hramn.algo;
/**
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/description
 * 
 * Given two version strings, version1 and version2, compare them. A version 
 * string consists of revisions separated by dots '.'. The value of 
 * the revision is its integer conversion ignoring leading zeros.
 * 
 * To compare version strings, compare their revision values in left-to-right 
 * order. If one of the version strings has fewer revisions, treat the missing 
 * revision values as 0.
 * 
 * Return the following:
 * - If version1 < version2, return -1.
 * - If version1 > version2, return 1.
 * - Otherwise, return 0.
 * 
 * Example 1:
 * Input: version1 = "1.2", version2 = "1.10"
 * Output: -1
 * Explanation:
 * version1's second revision is "2" and version2's second revision is "10": 
 * 2 < 10, so version1 < version2.
 * 
 * Example 2:
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation:
 * Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
 * 
 * Example 3:
 * Input: version1 = "1.0", version2 = "1.0.0.0"
 * Output: 0
 * Explanation:
 * version1 has less revisions, which means every missing revision are treated 
 * as "0".
 * 
 * Constraints:
 * 1 <= version1.length, version2.length <= 500
 * version1 and version2 only contain digits and '.'.
 * version1 and version2 are valid version numbers.
 * All the given revisions in version1 and version2 can be stored in a 32-bit 
 * integer.
 * 
 * TAG: medium
 * TAG: strings
 */
public class CompareVersionNumbers {
	class Solution2025092301 { // O(N + M), O(N + M) where N = version1.length(), M = version2.length()
		public int compareVersion(String version1, String version2) {
			String[] revs1 = version1.split("\\.");
			String[] revs2 = version2.split("\\.");
			for (int i = 0; i < revs1.length || i < revs2.length; i++) {
				int rev1 = i < revs1.length ? 
					Integer.parseInt(revs1[i]) : 0;
				int rev2 = i < revs2.length ? 
					Integer.parseInt(revs2[i]) : 0;
				if (rev1 < rev2) return -1;
				if (rev1 > rev2) return 1;
			}
			return 0;
		}
	}

	class Solution2025092302 { // O(N + M), O(1) where N = version1.length(), M = version2.length()
		public int compareVersion(String version1, String version2) {
			int n = version1.length(), m = version2.length();
			int i = 0, j = 0;

			while (i < n || j < m) {
				int num1 = 0;
				while (i < n && version1.charAt(i) != '.') {
					num1 = num1 * 10 + (version1.charAt(i++) - '0');
				}
				int num2 = 0;
				while (j < m && version2.charAt(j) != '.') {
					num2 = num2 * 10 + (version2.charAt(j++) - '0');
				}
				if (num1 < num2) return -1;
				if (num1 > num2) return 1;
				i++;
				j++;
			}
			return 0;
		}
	}
}
