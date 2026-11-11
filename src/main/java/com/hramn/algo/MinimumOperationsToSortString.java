package com.hramn.algo;
/**
 * 3863. Minimum Operations to Sort a String
 * 
 * <p>You are given a string s consisting of lowercase English letters.
 * 
 * <p>In one operation, you can select any substring of s that is not 
 * the entire string and sort it in non-descending alphabetical order.
 * 
 * <p>Return the minimum number of operations required to make s sorted in 
 * non-descending order. If it is not possible, return -1.
 * 
 * <p>Example 1:
 * <pre>
 * Input: s = "dog"
 * Output: 1
 * Explanation:​​​​​​​
 * - Sort substring "og" to "go".
 * - Now, s = "dgo", which is sorted in ascending order. Thus, the answer is 1.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: s = "card"
 * Output: 2
 * Explanation:
 * - Sort substring "car" to "acr", so s = "acrd".
 * - Sort substring "rd" to "dr", making s = "acdr", which is sorted in 
 *   ascending order. Thus, the answer is 2.
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: s = "gf"
 * Output: -1
 * Explanation:
 * - It is impossible to sort s under the given constraints. Thus, 
 *   the answer is -1.
 * </pre>
 * 
 * <p>Constraints:
 * <pre>
 * 1 <= s.length <= 10⁵
 * s consists of only lowercase English letters.
 * </pre>
 * 
 * @see <a href="https://leetcode.com/problems/minimum-operations-to-sort-a-string">
 * 		Link to Leetcode
 * </a>
 */
public class MinimumOperationsToSortString {

	class Solution {

		public int minOperations(String s) {
        // length = 1 -> 0
        // length = 2 -> s.charAt(0) > s.charAt(1) ? -1 : 0;
        // length > 2 -> already sorted -> 0
				//            -> maxI == 0 && minI == n-1 -> 3
				//            -> minI == 0 || maxI == n-1 -> 1
				//            -> minI != 0 && maxI != n-1 -> 2
        // 
        int n = s.length();

        if (n == 1) return 0;
        if (n == 2) return s.charAt(0) > s.charAt(1) ? -1 : 0;

        int minIndex = 0;
        int maxIndex = 0;
        char min = s.charAt(0);
        char max = s.charAt(0);
        boolean isSorted = true;
        char prev = s.charAt(0);
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (prev > ch) isSorted = false;
            if (min > ch) {
                min = ch;
                minIndex = i;
            }
            if (max <= ch) {
                max = ch;
                maxIndex = i;
            }
            prev = ch;
        }

        if (isSorted) return 0;
        if (minIndex == n-1 && maxIndex == 0) return 3;
        if (minIndex == 0 || maxIndex == n-1) return 1;
        return 2;
    }
}
}
