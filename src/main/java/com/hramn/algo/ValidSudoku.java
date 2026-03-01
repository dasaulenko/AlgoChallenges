package com.hramn.algo;

/**
 * Task
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be 
 * validated according to the following rules:
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 
 *    without repetition.
 *    
 * Note:
 * - A Sudoku board (partially filled) could be valid but is not necessarily 
 *   solvable.
 * - Only the filled cells need to be validated according to the mentioned 
 *   rules.
 *   
 * Example 1:
 * Input: board = 
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * 
 * Example 2:
 * Input: board = 
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner 
 * being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it 
 * is invalid.
 * 
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 * 
 * TAG: medium
 */

public class ValidSudoku {
	class Solution_20250904 {
		public boolean isValidSudoku(char[][] board) {	
			int[][] rows = new int[9][9];
			int[][] cols = new int[9][9];
			int[][] boxes = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					char ch = board[i][j];
					if (ch != '.') {
						int num = ch - '0';
						int index = i/3*3 + j/3;
						if (rows[i][num-1] + cols[j][num-1] + boxes[index][num-1] != 0) {
							return false;
						}
						rows[i][num-1]++;
						cols[j][num-1]++;
						boxes[index][num-1]++;
					}
				}
			}
			return true;
		}
	}

	class Solution_20250830 {
		public boolean isValidSudoku(char[][] board) {
			int m = board.length;
			int n = board[0].length;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					char ch = board[i][j];
					if (ch != '.') {
						for (int k = i+1; k < m; k++) {
							if (ch == board[k][j]) {
								return false;
							}
						}
						for (int k = j+1; k < n; k++) {
							if (ch == board[i][k]) {
								return false;
							}
						}
						int l = j+1;
						int k = i;
						while (k < i/3*3+3) {
							if (l < j/3*3+3) {
								if (ch == board[k][l]) {
									return false;
								}
								l++; 
							} else {
								k++;
								l = j/3*3;
							}
						}
					}
				}
			}
			return true;
		}
	}

	class Solution_20240504 { // O(9*9)
		public boolean isValidSudoku(char[][] board) {
			int[][] cch = new int[9][10];
			int[][] sch = new int[9][10];
			for (int i = 0; i < board.length; i++) {
				int[] lch = new int[10];
				for (int j = 0; j < board[i].length; j++) {
					int v = Character.getNumericValue(board[i][j]);
					int k;
					if (i < 3) {
						k = 0;
					} else if (i < 6) {
						k = 3;
					} else {
						k = 6;
					}
					if (j < 3) {
						k += 0;
					} else if (j < 6) {
						k += 1;
					} else {
						k += 2;
					}
					if (v > 0) {
						if (lch[v] != 0 || cch[j][v] != 0 || sch[k][v] != 0) {
							return false;
						}
						lch[v]++;
						cch[j][v]++;
						sch[k][v]++;
					}
				}
			}
			return true;
		}
	}
}
