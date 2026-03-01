package com.hramn.algo.sliding_window;
/**
 * https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description
 * 
 * 2379. Minimum Recolors to Get K Consecutive Black Blocks
 * 
 * You are given a 0-indexed string blocks of length n, where blocks[i] is 
 * either 'W' or 'B', representing the color of the ith block. The characters 
 * 'W' and 'B' denote the colors white and black, respectively.
 * 
 * You are also given an integer k, which is the desired number of consecutive 
 * black blocks.
 * 
 * In one operation, you can recolor a white block such that it becomes a black 
 * block.
 * 
 * Return the minimum number of operations needed such that there is at least 
 * one occurrence of k consecutive black blocks.
 * 
 * Example 1:
 * Input: blocks = "WBBWWBBWBW", k = 7
 * Output: 3
 * Explanation:
 * One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, 
 * and 4th blocks so that blocks = "BBBBBBBWBW". 
 * It can be shown that there is no way to achieve 7 consecutive black blocks 
 * in less than 3 operations.
 * Therefore, we return 3.
 * 
 * Example 2:
 * Input: blocks = "WBWBBBW", k = 2
 * Output: 0
 * Explanation:
 * No changes need to be made, since 2 consecutive black blocks already exist.
 * Therefore, we return 0.
 * 
 * Constraints:
 * n == blocks.length
 * 1 <= n <= 100
 * blocks[i] is either 'W' or 'B'.
 * 1 <= k <= n
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
	class Solution { // O(N), O(1)
		// r = 0, l = 0, curW = 1, r = 1
		// r = 2
		// r = 3
		// curW = 2, r = 4
		// curW = 3, r = 5
		// r = 6
		// min = 3, curW = 2, l = 1, r = 7
		// curW = 3, min = 3, l = 2, r = 8
		// min = 3, l = 3, r = 9
		// curW = 4, min = 3, curW = 3, r = 10
		public int minimumRecolors(String blocks, int k) {
			int l = 0, r = 0, curW = 0, min = Integer.MAX_VALUE;
			while(r < blocks.length()) {
				if (blocks.charAt(r) == 'W') {
					curW++;
				}
				if (r+1 >= k) {
					min = Math.min(min, curW);
					if (blocks.charAt(l) == 'W') {
						curW--;
					}
					l++;
				}
				r++;
			}
			return min;
		}
	}
}
