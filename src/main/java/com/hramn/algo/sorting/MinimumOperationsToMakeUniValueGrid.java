package com.hramn.algo.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description
 * 
 * 2033. Minimum Operations to Make a Uni-Value Grid
 * You are given a 2D integer grid of size m x n and an integer x. In one 
 * operation, you can add x to or subtract x from any element in the grid.
 * 
 * A uni-value grid is a grid where all the elements of it are equal.
 * 
 * Return the minimum number of operations to make the grid uni-value. If it is 
 * not possible, return -1.
 * 
 * Example 1:
 * 2 4
 * 6 8
 * Input: grid = [[2,4],[6,8]], x = 2
 * Output: 4
 * Explanation: We can make every element equal to 4 by doing the following: 
 * - Add x to 2 once.
 * - Subtract x from 6 once.
 * - Subtract x from 8 twice.
 * A total of 4 operations were used.
 * 
 * Example 2:
 * 1 5
 * 2 3
 * Input: grid = [[1,5],[2,3]], x = 1
 * Output: 5
 * Explanation: We can make every element equal to 3.
 * 
 * Example 3:
 * 1 2
 * 3 4
 * Input: grid = [[1,2],[3,4]], x = 2
 * Output: -1
 * Explanation: It is impossible to make every element equal.
 * 
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10^5
 * 1 <= m * n <= 10^5
 * 1 <= x, grid[i][j] <= 10^4
 */
public class MinimumOperationsToMakeUniValueGrid {
	class Solution { // O(N * M * log(N * M)), O(N * M)
		public int minOperations(int[][] grid, int x) {
			List<Integer> numbers = new ArrayList<>();
			for (int[] row : grid) {
				for (int number : row) {
					numbers.add(number);
				}
			}
			Collections.sort(numbers);
			for (int number : numbers) {
				if ((number - numbers.get(0)) % x != 0) {
					return -1;
				}
			}
			int median = numbers.get(numbers.size() / 2);
			int counter = 0;
			for (int number : numbers) {
				counter += Math.abs(number - median) / x;
			}
			return counter;
		}
	}
}
