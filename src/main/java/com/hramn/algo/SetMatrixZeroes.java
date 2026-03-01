package com.hramn.algo;
/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/description
 * 
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row 
 * and column to 0's.
 * 
 * You must do it in place.
 * 
 * Example 1:
 * 1 1 1    1 0 1
 * 1 0 1 -> 0 0 0
 * 1 1 1    1 0 1
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * Example 2:
 * 0 1 2 0    0 0 0 0
 * 3 4 5 2 -> 0 4 5 0
 * 1 3 1 5    0 3 1 0
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 * 
 * Follow up:
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 
 * TAG: 20250521
 * TAG: medium
 * TAG: matrix
 * TAG: constant_space
 */
public class SetMatrixZeroes {
	class Solution { // O(N * M), O(1), N - matrix.length, M - matrix[0].length
		public void setZeroes(int[][] matrix) {
			int n = matrix.length;
			int m = matrix[0].length;
			boolean z = false;
			for (int i = 0; i < n; i++) {
				if (matrix[i][0] == 0) {
					z = true;
				}
				for (int j = 1; j < m; j++) {
					if (matrix[i][j] == 0) {
						matrix[i][0] = 0;
						matrix[0][j] = 0;
					}
				}
			}
			for (int i = n - 1; i >= 0; i--) {
				for (int j = m - 1; j >= 1; j--) {
					if (matrix[i][0] == 0 || matrix[0][j] == 0) {
						matrix[i][j] = 0;
					}
				}
				if (z) {
					matrix[i][0] = 0;
				}
			}
		}
	}
}
