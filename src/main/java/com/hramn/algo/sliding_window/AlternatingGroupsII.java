package com.hramn.algo.sliding_window;
/**
 * https://leetcode.com/problems/alternating-groups-ii/description
 * 
 * 3208. Alternating Groups II
 * 
 * There is a circle of red and blue tiles. You are given an array of integers 
 * colors and an integer k. The color of tile i is represented by colors[i]:
 * - colors[i] == 0 means that tile i is red.
 * - colors[i] == 1 means that tile i is blue.
 * 
 * An alternating group is every k contiguous tiles in the circle with 
 * alternating colors (each tile in the group except the first and last one has 
 * a different color from its left and right tiles).
 * 
 * Return the number of alternating groups.
 * 
 * Note that since colors represents a circle, the first and the last tiles are 
 * considered to be next to each other.
 * 
 * Example 1:
 * Input: colors = [0,1,0,1,0], k = 3
 * Output: 3
 * 
 * Example 2:
 * Input: colors = [0,1,0,0,1,0,1], k = 6
 * Output: 2
 * 
 * Example 3:
 * Input: colors = [1,1,0,1], k = 4
 * Output: 0
 * 
 * Constraints:
 * 3 <= colors.length <= 10^5
 * 0 <= colors[i] <= 1
 * 3 <= k <= colors.length
 */
public class AlternatingGroupsII {
	class OptimizedSolution { // O(N + K), O(1)
		public int numberOfAlternatingGroups(int[] colors, int k) {
			int l = 0, groups = 0, n = colors.length;
			for (int r = 1; r < n + k - 1; r++) {
				if (colors[r % n] == colors[(r - 1) % n]) {
					l = r;
				}
				if (r - l + 1 >= k) {
					groups++;
				}
			}
			return groups;
		}
	}

	class Solution { // O(N + K), O(1)
		// colors = [0,1,0,1,0], k = 3, l = 0, r = 1, groups = 0, prev = 0
		// prev = 1, r = 2
		// prev = 0, groups = 1, l = 1, r = 3
		// prev = 1, groups = 2, l = 2, r = 4
		// prev = 0, groups = 3, l = 3, r = 5
		// l = 5, prev = 0, r = 6
		// colors = [0,1,0,0,1,0,1], k = 6, l = 0, r = 1, groups = 0, prev = 0
		// prev = 1, r = 2
		// prev = 0, r = 3
		// l = 3, prev = 0, r = 4
		// prev = 1, r = 5
		// prev = 0, r = 6
		// prev = 1, r = 7
		// prev = 0, r = 8
		// prev = 1, groups = 1, l = 4, r = 9
		// prev = 0, groups = 2, l = 5, r = 10
		// l = 10, prev = 0, r = 11
		public int numberOfAlternatingGroups(int[] colors, int k) {
			int l = 0, r = 1, groups = 0, prev = colors[0];
			while(l < colors.length) {
				if (r < colors.length) {
					if (colors[r] == prev) {
						l = r;
					}
					prev = colors[r];
				} else {
					if (colors[r-colors.length] == prev) {
						l = r;
					}
					prev = colors[r-colors.length];
				}
				if (r-l+1 == k) {
					groups++;
					l++;
				}
				r++;
			}
			return groups;
		}
	}
}
