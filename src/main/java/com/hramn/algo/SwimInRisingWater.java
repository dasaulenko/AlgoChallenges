package com.hramn.algo;

import java.util.PriorityQueue;

/**
 * 778. Swim in Rising Water
 * https://leetcode.com/problems/swim-in-rising-water/description
 * 
 * You are given an n x n integer matrix grid where each value grid[i][j] 
 * represents the elevation at that point (i, j).
 * 
 * It starts raining, and water gradually rises over time. At time t, the water 
 * level is t, meaning any cell with elevation less than equal to t is 
 * submerged or reachable.
 * 
 * You can swim from a square to another 4-directionally adjacent square if and 
 * only if the elevation of both squares individually are at most t. You can 
 * swim infinite distances in zero time. Of course, you must stay within 
 * the boundaries of the grid during your swim.
 * 
 * Return the minimum time until you can reach the bottom right square 
 * (n - 1, n - 1) if you start at the top left square (0, 0).
 * 
 * Example 1:
 * Input: grid = [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have 
 * a higher elevation than t = 0.
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 * 
 * Example 2:
 * Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],
 * [10,9,8,7,6]]
 * Output: 16
 * Explanation: The final route is shown.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 * 
 * Constraints:
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] < n2
 * Each value grid[i][j] is unique.
 * 
 * TAG: hard
 * TAG: heap
 */
public class SwimInRisingWater {
	class Solution { // O(n^2 log n), O(n^2), where n = grid.length
		public int swimInWater(int[][] grid) {
			int n = grid.length;
			boolean[][] visited = new boolean[n][n];
			PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
			heap.add(new int[] {grid[n-1][n-1], n-1, n-1});
			int[][] dir = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
			int max = 0;
			while (!heap.isEmpty()) {
				int[] u = heap.poll();
				visited[u[1]][u[2]] = true;
				max = Math.max(max, u[0]);
				if (u[1] == 0 && u[2] == 0) break;
				for (int[] d : dir) {
					int i = u[1] + d[0];
					int j = u[2] + d[1];
					if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j]) continue;
					heap.add(new int[] {grid[i][j], i, j});
				}
			}
			return max;
		}
	}
}
