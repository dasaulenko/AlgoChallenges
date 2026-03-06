package com.hramn.algo;
/**
 * 1784. Check if Binary String Has at Most One Segment of Ones
 * https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description
 * 
 * Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains 
 * at most one contiguous segment of ones. Otherwise, return false.
 * 
 * Example 1:
 * Input: s = "1001"
 * Output: false
 * Explanation: The ones do not form a contiguous segment.
 * 
 * Example 2:
 * Input: s = "110"
 * Output: true
 * 
 * Constraints:
 * 1 <= s.length <= 100
 * s[i]​​​​ is either '0' or '1'.
 * s[0] is '1'.
 * 
 * TAG: easy
 * TAG: bitwise
 */
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

	class Solution1 {
		public boolean checkOnesSegment(String s) {
			boolean isFound = false;
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == '0')  isFound = true;
				else if (isFound) return false;
			}
			return true;
		}
	}

	class Solution2 {
		public boolean checkOnesSegment(String s) {
			return !s.contains("01");
		}
	}

	class Solution3 {
		public boolean checkOnesSegment(String s) {
			int prev = 1;
			for (int i = 1; i < s.length(); i++) {
				int cur = s.charAt(i) & 1;
				if (prev == 0 && cur == 1) return false;
				prev = cur;
			}
			return true;
		}
	}
	
}
