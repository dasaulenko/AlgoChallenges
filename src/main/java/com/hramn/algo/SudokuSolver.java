package com.hramn.algo;

/**
 * 37. Sudoku Solver
 * https://leetcode.com/problems/sudoku-solver/description
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * - Each of the digits 1-9 must occur exactly once in each row.
 * - Each of the digits 1-9 must occur exactly once in each column.
 * - Each of the digits 1-9 must occur exactly once in each of 
 *   the 9 3x3 sub-boxes of the grid.
 * 
 * The '.' character indicates empty cells.
 * 
 * Example 1:
 * Input: board = [["5","3",".",".","7",".",".",".","."],
 *                 ["6",".",".","1","9","5",".",".","."],
 *                 [".","9","8",".",".",".",".","6","."],
 *                 ["8",".",".",".","6",".",".",".","3"],
 *                 ["4",".",".","8",".","3",".",".","1"],
 *                 ["7",".",".",".","2",".",".",".","6"],
 *                 [".","6",".",".",".",".","2","8","."],
 *                 [".",".",".","4","1","9",".",".","5"],
 *                 [".",".",".",".","8",".",".","7","9"]]
 * Output: [["5","3","4","6","7","8","9","1","2"],
 *          ["6","7","2","1","9","5","3","4","8"],
 *          ["1","9","8","3","4","2","5","6","7"],
 *          ["8","5","9","7","6","1","4","2","3"],
 *          ["4","2","6","8","5","3","7","9","1"],
 *          ["7","1","3","9","2","4","8","5","6"],
 *          ["9","6","1","5","3","7","2","8","4"],
 *          ["2","8","7","4","1","9","6","3","5"],
 *          ["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is 
 * shown below.
 * 
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 * 
 * TAG: hard
 */
public class SudokuSolver {
	// 1. Collect information about occupaed numbers for every row, col and box.
	// 2. dfs for every cell
	class Solution { // O((9!)^9), O(9*9*3) / O((N!)^N), O(N^2)
		public void solveSudoku(char[][] board) {
			int[][] rows = new int[9][9];
			int[][] cols = new int[9][9];
			int[][] boxes = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					char ch = board[i][j];
					if (ch != '.') {
						int num = ch - '0';
						rows[i][num-1]++;
						cols[j][num-1]++;
						boxes[i/3*3 + j/3][num-1]++;
					}
				}
			}
			dfs (0, 0, board, rows, cols, boxes);
		}

		private boolean dfs (int row, int col, char[][] board, int[][] rows, int[][] cols, int[][] boxes) {
			int ch = board[row][col];
			int nextRow = nextRow(row,col);
			int nextCol = nextCol(row,col);
			if (ch == '.') {
				for (int num = 1; num <= 9; num++) {
					if (isNumFit(num, row, col, rows, cols, boxes)) {
						board[row][col] = (char)(num + '0');
						if (nextRow == 9) {
							return true;
						}
						rows[row][num-1]++;
						cols[col][num-1]++;
						boxes[row/3*3 + col/3][num-1]++;
						boolean res = dfs (nextRow, nextCol, board, rows, cols, boxes);
						if (res) {
							return true;
						}
						rows[row][num-1]--;
						cols[col][num-1]--;
						boxes[row/3*3 + col/3][num-1]--;
						board[row][col] = '.';
					}
				}
			} else {
				if (nextRow == 9) {
					return true;
				}
				return dfs (nextRow, nextCol, board, rows, cols, boxes);
			}
			return false;
		}

		private boolean isNumFit(int num, int row, int col, int[][] rows, int[][] cols, int[][] boxes) {
			return rows[row][num-1] + cols[col][num-1] + boxes[row/3*3 + col/3][num-1] == 0;
		}

		private int nextRow(int row, int col) {
			if (col == 8) {
				return ++row;
			}
			return row;
		}

		private int nextCol(int row, int col) {
			if (col == 8) {
				return 0;
			}
			return ++col;
		}
	}
}
