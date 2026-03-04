package com.hramn.algo;

import java.util.PriorityQueue;

/**
 * 407. Trapping Rain Water II
 * https://leetcode.com/problems/trapping-rain-water-ii/description
 * 
 * Given an m x n integer matrix heightMap representing the height of each unit 
 * cell in a 2D elevation map, return the volume of water it can trap after 
 * raining.
 * 
 * Example 1:
 * Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * Output: 4
 * Explanation: After the rain, water is trapped between the blocks.
 * We have two small ponds 1 and 3 units trapped.
 * The total volume of water trapped is 4.
 * 
 * Example 2:
 * Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * Output: 10
 * 
 * Constraints:
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 10^4
 * 
 * TAG: hard
 * TAG: heap
 */
public class TrappingRainWaterII {
	class Solution { // O(mn log(mn)), O(mn), where n = heightMap.length, m = heightMap[0].length
		public int trapRainWater(int[][] heightMap) {
			int n = heightMap.length;
			int m = heightMap[0].length;
			if (n < 3 || m < 3) return 0;
			PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
			int[][] visited = new int[n][m];
			for (int i = 0; i < n; i++) {
				heap.add(new int[] {heightMap[i][0], i, 0});
				visited[i][0] = 1;
				heap.add(new int[] {heightMap[i][m-1], i, m-1});
				visited[i][m-1] = 1;
			}
			for (int j = 1; j < m-1; j++) {
				heap.add(new int[] {heightMap[0][j], 0, j});
				visited[0][j] = 1;
				heap.add(new int[] {heightMap[n-1][j], n-1, j});
				visited[n-1][j] = 1;
			}
			int result = 0;
			int[][] dir = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
			while (!heap.isEmpty()) {
				int[] u = heap.poll();
				int h = u[0], i = u[1], j = u[2];
				for (int[] d : dir) {
					int ni = i + d[0], nj = j + d[1];
					if (ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj] == 1) 
						continue;
					int nh = heightMap[ni][nj];
					result += Math.max(0, h - nh);
					heap.add(new int[] {Math.max(h, nh), ni, nj});
					visited[ni][nj] = 1;
				}
			}
			return result;
		}
	}
}
