package com.hramn.algo;

import java.util.LinkedList;
import java.util.List;

/**
 * 3459. Length of Longest V-Shaped Diagonal Segment
 * https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/description
 * 
 * You are given a 2D integer matrix grid of size n x m, where each element is 
 * either 0, 1, or 2.
 * 
 * A V-shaped diagonal segment is defined as:
 * - The segment starts with 1.
 * - The subsequent elements follow this infinite sequence: 2, 0, 2, 0, ....
 * - The segment:
 *   - Starts along a diagonal direction (top-left to bottom-right, 
 *     bottom-right to top-left, top-right to bottom-left, or bottom-left to 
 *     top-right).
 *   - Continues the sequence in the same diagonal direction.
 *   - Makes at most one clockwise 90-degree turn to another diagonal direction 
 *     while maintaining the sequence.
 * 
 * Return the length of the longest V-shaped diagonal segment. If no valid 
 * segment exists, return 0.
 * 
 * Example 1:
 * Input: grid = [[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]
 * Output: 5
 * Explanation:
 * The longest V-shaped diagonal segment has a length of 5 and follows these 
 * coordinates: (0,2) → (1,3) → (2,4), takes a 90-degree clockwise turn 
 * at (2,4), and continues as (3,3) → (4,2).
 * 
 * Example 2:
 * Input: grid = [[2,2,2,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]
 * Output: 4
 * Explanation:
 * The longest V-shaped diagonal segment has a length of 4 and follows these 
 * coordinates: (2,3) → (3,2), takes a 90-degree clockwise turn at (3,2), and 
 * continues as (2,1) → (1,0).
 * 
 * Example 3:
 * Input: grid = [[1,2,2,2,2],[2,2,2,2,0],[2,0,0,0,0],[0,0,2,2,2],[2,0,0,2,0]]
 * Output: 5
 * Explanation:
 * The longest V-shaped diagonal segment has a length of 5 and follows these 
 * coordinates: (0,0) → (1,1) → (2,2) → (3,3) → (4,4).
 * 
 * Example 4:
 * Input: grid = [[1]]
 * Output: 1
 * Explanation:
 * The longest V-shaped diagonal segment has a length of 1 and follows these 
 * coordinates: (0,0).
 * 
 * Constraints:
 * n == grid.length
 * m == grid[i].length
 * 1 <= n, m <= 500
 * grid[i][j] is either 0, 1 or 2.
 * 
 * TAG: hard
 * TAG: grid
 * TAG: dfs
 * TAG: memorising
 */
public class LengthOfLongestVShapedDiagonalSegment {
	// 1. We go through all elements of the grid one by one.
	// 2. If value == 1 then use dfs to find the longest diagonal segment in 4 
	//    directions. Also we use cache and on backtracking we save results to 
	//	  cache.
	// 3. In any cell we add it to the queue and use dfs to find diagonals for 
	//    every cell in the queue and cache results too.
	// 4. After all we search the longest V-diagonal segment for this cell and 
	//    continue cicle in the first point.
	// 5. return result in the end
	class Solution20250904 { // O(M * N), O(M * N) where M = grid.length, N = grid[0].length
		public int lenOfVDiagonal(int[][] grid) {
			int m = grid.length;
			int n = grid[0].length;
			Integer[][][] cache = new Integer[m][n][4];
			int max = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 1) {
						max = Math.max(max, oneStep(i, j, new int[] {1,1}, grid, cache)+1);
						max = Math.max(max, oneStep(i, j, new int[] {1,-1}, grid, cache)+1);
						max = Math.max(max, oneStep(i, j, new int[] {-1,-1}, grid, cache)+1);
						max = Math.max(max, oneStep(i, j, new int[] {-1,1}, grid, cache)+1);
					}
				}
			}
			return max;
		}

		private int oneStep (int row, int col, int[] inc, int[][] grid, Integer[][][] cache) {
			int max = 0;
			List<int[]> queue = new LinkedList<>();
			int res = dfs(row + inc[0], col + inc[1], 1, inc, grid, cache, queue);
			int[] vinc = turn(inc);
			while(!queue.isEmpty()) {
				int[] v = queue.removeFirst();
				int vres = dfs(v[0] + vinc[0], v[1] + vinc[1], grid[v[0]][v[1]], vinc, grid, cache, null);
				max = Math.max(max, vres+res-cache[v[0]][v[1]][cacheIndex(inc)]);
			}
			return max;
		}

		private int dfs(int row, int col, int prev, int[] inc, int[][] grid, Integer[][][] cache, List<int[]> queue) {
			if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return 0;
			int num = grid[row][col];
			if (prev == 1 && num != 2) return 0;
			if (num == 1 || num == prev) return 0;
			if (queue != null) {
				queue.add(new int[] {row, col});
			} else {
				Integer c = cache[row][col][cacheIndex(inc)];
				if (c != null) return c+1;
			}
			int res = dfs(row + inc[0], col + inc[1], num, inc, grid, cache, queue);
			cache[row][col][cacheIndex(inc)] = res;
			return res + 1;
		}

		private int cacheIndex(int[] inc) {
			return (inc[0]+1) + ((inc[1]+1)/2);
		}

		private int[] turn(int[] inc) {
			int[] res = new int[] {inc[0], inc[1]};
			if (inc[0] == 1 && inc[1] == 1) {
				res[1] = -1;
			} else if (inc[0] == 1 && inc[1] == -1) {
				res[0] = -1;
			} else if (inc[0] == -1 && inc[1] == -1) {
				res[1] = 1;
			} else {
				res[0] = 1;
			}
			return res;
		}
	}
}
