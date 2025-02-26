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
 */

public class ValidSudoku {
	static class Solution_my {
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
