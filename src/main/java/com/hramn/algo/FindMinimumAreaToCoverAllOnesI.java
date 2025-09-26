package com.hramn.algo;
/**
 * 3195. Find the Minimum Area to Cover All Ones I
 * https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description
 * 
 * You are given a 2D binary array grid. Find a rectangle with horizontal and 
 * vertical sides with the smallest area, such that all the 1's in grid lie 
 * inside this rectangle.
 * 
 * Return the minimum possible area of the rectangle.
 * 
 * Example 1:
 * Input: grid = [[0,1,0],[1,0,1]]
 * Output: 6
 * Explanation:
 * The smallest rectangle has a height of 2 and a width of 3, so it has an area 
 * of 2 * 3 = 6.
 * 
 * Example 2:
 * Input: grid = [[1,0],[0,0]]
 * Output: 1
 * Explanation:
 * The smallest rectangle has both height and width 1, so its area is 1 * 1 = 1.
 * 
 * Constraints:
 * 1 <= grid.length, grid[i].length <= 1000
 * grid[i][j] is either 0 or 1.
 * The input is generated such that there is at least one 1 in grid.
 * 
 * TAG: 20250822
 * TAG: medium
 * TAG: arrays
 */
public class FindMinimumAreaToCoverAllOnesI {
	class Solution { // O(N*M), O(1) where N = grid.length, M = grid[0].length
		public int minimumArea(int[][] grid) {
			int xMin = Integer.MAX_VALUE;
			int xMax = 0;
			int yMin = Integer.MAX_VALUE;
			int yMax = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] == 1) {
						xMin = Math.min(xMin, j);
						xMax = Math.max(xMax, j);
						yMin = Math.min(yMin, i);
						yMax = Math.max(yMax, i);
					}
				}
			}
			return (xMax-xMin+1) * (yMax-yMin+1);
		}
	}
}
