package com.hramn.algo;

import java.util.Arrays;

/**
 * 3446. Sort Matrix by Diagonals
 * https://leetcode.com/problems/sort-matrix-by-diagonals/description
 * 
 * You are given an n x n square matrix of integers grid. Return the matrix 
 * such that:
 * - The diagonals in the bottom-left triangle (including the middle diagonal) 
 *   are sorted in non-increasing order.
 * - The diagonals in the top-right triangle are sorted in non-decreasing order.
 * 
 * Example 1:
 * Input: grid = [[1,7,3],[9,8,2],[4,5,6]]
 * Output: [[8,2,3],[9,6,7],[4,5,1]]
 * Explanation:
 * The diagonals in bottom-left triangle should be sorted in non-increasing 
 * order:
 * - [1, 8, 6] becomes [8, 6, 1].
 * - [9, 5] and [4] remain unchanged.
 * The diagonals in top-right triangle should be sorted in non-decreasing order:
 * - [7, 2] becomes [2, 7].
 * - [3] remains unchanged.
 * 
 * Example 2:
 * Input: grid = [[0,1],[1,2]]
 * Output: [[2,1],[1,0]]
 * Explanation:
 * The diagonals in bottom-left triangle must be non-increasing, 
 * so [0, 2] is changed to [2, 0]. 
 * The other diagonals are already in the correct order.
 * 
 * Example 3:
 * Input: grid = [[1]]
 * Output: [[1]]
 * Explanation:
 * Diagonals with exactly one element are already in order, 
 * so no changes are needed.
 * 
 * Constraints:
 * grid.length == grid[i].length == n
 * 1 <= n <= 10
 * -10^5 <= grid[i][j] <= 10^5
 * 
 * TAG: 20250828
 * TAG: medium
 * TAG: sorts
 * TAG: matrix
 */
public class SortMatrixByDiagonals {
	class Solution { // O(N^2 * log(N)), O(N) where N = grid.length
		public int[][] sortMatrix(int[][] grid) {
			int n = grid.length;
			for (int i = n-2; i >= 0; i--) {
				int[] arrT = new int[n-i];
				Integer[] arrB = new Integer[n-i];
				int x = i;
				for (int j = 0; j < arrB.length; j++, x++) {
					if (i != 0) {
						arrT[j] = grid[j][x];
					}
					arrB[j] = grid[x][j]; 
				}
				if (i != 0) {
					Arrays.sort(arrT);
				}
				Arrays.sort(arrB, (a,b) -> b-a);
				x = i;
				for (int j = 0; j < arrB.length; j++, x++) {
					if (i != 0) {
						grid[j][x] = arrT[j];
					}
					grid[x][j] = arrB[j]; 
				}
			}
			return grid;
		}
	}
}
