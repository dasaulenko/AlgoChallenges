package com.hramn.algo;
/**
 * 1582. Special Positions in a Binary Matrix
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/description
 * 
 * Given an m x n binary matrix mat, return the number of special positions in 
 * mat.
 * 
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements 
 * in row i and column j are 0 (rows and columns are 0-indexed).
 * 
 * Example 1:
 * 
 * Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
 * Output: 1
 * Explanation: (1, 2) is a special position because mat[1][2] == 1 and all 
 * other elements in row 1 and column 2 are 0.
 * 
 * Example 2:
 * Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 * 
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * mat[i][j] is either 0 or 1.
 * 
 * TAG: easy
 */
public class SpecialPositionsInBinaryMatrix {
	class Solution {

		public int numSpecialSolution1(int[][] mat) {
			int m = mat.length;
			int n = mat[0].length;
			int[] rows = new int[m];
			int[] cols = new int[n];
			int result = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (mat[i][j] == 1) {
						rows[i]++;
						cols[j]++;
					}
				}
			}
			for (int i = 0; i < m; i++) {
				if (rows[i] != 1) continue;
				for (int j = 0; j < n; j++) {
					if (mat[i][j] == 1 && cols[j] == 1) {
						result++;
						break;
					}
				}
			}
			return result;
		}

		public int numSpecialSolution2(int[][] mat) {
			int result = 0;
			for (int i = 0; i < mat.length; i++) {
				int index = getSpecialIndexInRow(mat, i);
				if (index >= 0) {
					boolean b = getSpecialIndexInCol(mat, index);
					if (b) result++;
				}
			}
			return result;
		}

		private int getSpecialIndexInRow(int[][] mat, int index) {
			int pos = -1;
			for (int i = 0; i < mat[0].length; i++) {
				if (mat[index][i] == 1) {
					if (pos >= 0) return -1;
					pos = i;
				}
			}
			return pos;
		}

		private boolean getSpecialIndexInCol(int[][] mat, int index) {
			boolean res = false;
			for (int i = 0; i < mat.length; i++) {
				if (mat[i][index] == 1) {
					if (res) return false;
					res = true;
				}
			}
			return res;
		}

	}
}
