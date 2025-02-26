package com.hramn.algo.graph;
/**
 * 200. Number of Islands
 * 
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's 
 * (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands 
 * horizontally or vertically. You may assume all four edges of the grid are 
 * all surrounded by water.
 * 
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * 
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * 
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = {
				{'1', '1', '1', '0', '0'}, 
				{'1', '1', '0', '0', '0'},
				{'1', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}};
		Solution solution = new Solution();
		int result = solution.numIslands(grid);
		System.out.println(result);
		assert result == 3;
	}
	
	// [1, 1, 1, 0, 0]
	// [1, 1, 0, 0, 0]
	// [1, 0, 1, 0, 0]
	// [0, 0, 0, 1, 1]

	// 1. we go through the whole array 1 by 1
	// 2. we mark elements that we processed by 2
	// 3. for each element we iteratively call function for every neighbor

	static class Solution {
		public int numIslands (char[][] grid) {
			int count = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j] == '1') {
						count++;
						procIsland(i, j, grid);
					}
				}
			}
			return count;
		}

		private void procIsland (int i, int j, char[][] grid) {
			if (grid[i][j] == '1') {
				grid[i][j] = '2';
				if (i + 1 < grid.length) {
					procIsland (i + 1, j, grid);
				}
				if (i - 1 >= 0) {
					procIsland (i - 1, j, grid);
				}
				if (j + 1 < grid[i].length) {
					procIsland (i, j + 1, grid);
				}
				if (j - 1 >= 0) {
					procIsland (i, j - 1, grid);
				}
			}
		}
	}
}
