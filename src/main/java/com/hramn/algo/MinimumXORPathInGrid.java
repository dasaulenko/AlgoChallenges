package com.hramn.algo;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 3882. Minimum XOR Path in a Grid
 * 
 */
public class MinimumXORPathInGrid {

	class Solution {

		private static class Cell {
			int xor;
			int i;
			int j;

			public Cell (int xor, int i, int j) {
				this.xor = xor;
				this.i = i;
				this.j = j;
			}
		}

		public int minCost(int[][] grid) {
			int n = grid.length;
			int m = grid[0].length;
			int result = Integer.MAX_VALUE;

			Queue<Cell> queue = new ArrayDeque<>();

			if (m > 1) queue.offer(new Cell (grid[0][0], 0, 1));
			if (n > 1) queue.offer(new Cell (grid[0][0], 1, 0));

			while (!queue.isEmpty()) {
				Cell cell = queue.poll();
				int val = grid[cell.i][cell.j];

				if (cell.i == n-1 && cell.j == m-1) {
					result = Math.min (result, cell.xor ^ val);
					continue;
				}

				if (cell.i < n-1) queue.offer (new Cell (cell.xor ^ val, cell.i + 1, cell.j));
				if (cell.j < m-1) queue.offer (new Cell (cell.xor ^ val, cell.i, cell.j + 1));
			}

			return result;
		}
	}
}
