package com.hramn.algo;

import java.util.Arrays;

/**
 * 498. Diagonal Traverse
 * 
 * Given an m x n matrix mat, return an array of all the elements of the array 
 * in a diagonal order.
 * 
 * [
 *   [1,2,6],
 *   [3,5,7], -> [1,2,3,4,5,6,7,8,9]
 *   [4,8,9]
 * ]
 * 
 * Example 1:
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * 
 * Example 2:
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 * 
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * -10^5 <= mat[i][j] <= 10^5
 * 
 * TAG: 20250825
 * TAG: medium
 * TAG: arrays
 */
public class DiagonalTraverse {

	public static void main(String[] args) {
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		DiagonalTraverse task = new DiagonalTraverse();
		OldSolution solution = task.new OldSolution();
		System.out.println(Arrays.toString(solution.findDiagonalOrder(mat)));
	}

	class BestSolution_20250825 {
		public int[] findDiagonalOrder(int[][] mat) {
			int m = mat.length;
			
			if (m == 1) {
				return mat[0];
			}

			int n = mat[0].length;
			int[] result = new int[n*m];
			result[0] = mat[0][0];

			if (n == 1) {
				for (int i = 1; i < m; i++) {
					result[i] = mat[i][0];
				}
				return result;
			}
			
			int index = 1, i = 0, j = 1;
			boolean isDown = true;
			while (index < result.length) {
				if (isDown) {
					while (i < m-1 && j > 0) {
						result[index++] = mat[i][j];
						i++; j--;
					}
					result[index++] = mat[i][j];
					if (i < m-1) {
						i++;
					} else {
						j++;
					}
					isDown = false; 
				} else {
					while (i > 0 && j < n-1) {
						result[index++] = mat[i][j];
						i--; j++;
					}
					result[index++] = mat[i][j];
					if (j < n-1) {
						j++;
					} else {
						i++;
					}
					isDown = true; 
				}
			}
			return result;
		}
	}

	class Solution_20250825_2 { // O(M*N), O(1) where M = mat.length, N = mat[0].length
		public int[] findDiagonalOrder(int[][] mat) {
			int n = mat.length;
			int m = mat[0].length;
			int[] result = new int[n * m];
			int i = 0, j = 0;
			int index = 0;
			int iIncr = -1;
			int jIncr = 1;
			while (index < result.length) {
				boolean isCh = false;
				result[index++] = mat[i][j];
				if (i == 0 && iIncr == -1) {
					if (j == m-1) {
						i++;
					} else {
						j++;
					}
					isCh = true;
				} else if (j == 0 && jIncr == -1) {
					if (i == n-1) {
						j++;
					} else {
						i++;
					}
					isCh = true;
				} else if (i == n-1 && iIncr == 1) {
					j++;
					isCh = true;                
				} else if (j == m-1 && jIncr == 1) {
					i++;
					isCh = true;
				}
				if (isCh) {
					iIncr *= -1;
					jIncr *= -1;
				} else {
					i += iIncr;
					j += jIncr;
				}
			}
			result[result.length-1] = mat[n-1][m-1];
			return result;
		}
	}

	class Solution_20250825_1 { // O(M*N), O(1) where M = mat.length, N = mat[0].length
		public int[] findDiagonalOrder(int[][] mat) {
			int n = mat.length;
			int m = mat[0].length;
			int[] result = new int[n * m];
			int i = 0, j = 0;
			int index = 0;
			int iIncr = -1;
			int jIncr = 1;
			while (index < result.length) {
				boolean isCh = false;
				if (i < 0) {
					i += 1;
					if (j >= m) {
						i += 1;
						j -= 1;
					}
					isCh = true;
				} else if (j < 0) {
					j += 1;
					if (i >= n) {
						i -= 1;
						j += 1;
					}
					isCh = true;
				} else if (i >= n) {
					i -= 1;
					j += 2;
					isCh = true;                
				} else if (j >= m) {
					i += 2;
					j -= 1;
					isCh = true;
				}
				if (isCh) {
					iIncr *= -1;
					jIncr *= -1;
				}
				result[index++] = mat[i][j];
				i += iIncr;
				j += jIncr;
			}
			result[result.length-1] = mat[n-1][m-1];
			return result;			
		}
	}

	public class OldSolution { // O(M*N), O(1) where M = mat.length, N = mat[0].length
		public int[] findDiagonalOrder(int[][] mat) {
			int length = mat.length * mat[0].length;
			int[] result = new int[length];
			int i = 0, r = 0, c = 0, inc = 1;
			while (i < length)  {
				while (r >= 0 && r < mat.length && c >=0 && c < mat[0].length) {
					result[i++] = mat[r][c];
					r = r - inc;
					c = c + inc;
				}
				if (r == mat.length) {
					r--;
					c += 2;
				} else if (c == mat[0].length) {
					c--;
					r += 2;
				} else if (r == -1) {
					r++;
				} else if (c == -1) {
					c++;
				}
				inc *= -1;
			}
			return result;
		}
	}
}
