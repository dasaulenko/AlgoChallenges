package com.hramn.algo.easy;

/**
 * <strong>2965. Find Missing and Repeated Values</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Easy
 * <br>
 * <strong>LeetCode:</strong>
 * <a href="https://leetcode.com/problems/find-missing-and-repeated-values/">
 * 2965. Find Missing and Repeated Values</a>
 * <br>
 * <strong>Topic:</strong> array, greed, iterating, in-place
 *
 * <hr>
 *
 * <p>
 * You are given a 0-indexed 2D integer matrix {@code grid} of size
 * {@code n * n} with values in the range {@code [1, n^2]}. Each integer appears
 * exactly once except {@code a} which appears twice and {@code b} which is
 * missing. The task is to find the repeating and missing numbers {@code a} and
 * {@code b}.
 *
 * <p>
 * Return a 0-indexed integer array {@code ans} of size {@code 2} where
 * {@code ans[0]} equals to {@code a} and {@code ans[1]} equals to {@code b}.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code grid = [[1,3],[2,2]]}
 * <p>
 * Output: {@code [2,4]}
 * <p>
 * Explanation:
 * {@code Number 2 is repeated and number 4 is missing so the answer is [2,4].}
 *
 * <p>
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code grid = [[9,1,7],[8,9,2],[3,4,6]]}
 * <p>
 * Output: {@code [9,5]}
 * <p>
 * Explanation:
 * {@code Number 9 is repeated and number 5 is missing so the answer is [9,5].}
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>{@code 2 <= n == grid.length == grid[i].length <= 50}</li>
 * <li>{@code 1 <= grid[i][j] <= n * n}</li>
 * <li>For all {@code x} that {@code 1 <= x <= n * n} there is exactly one
 * {@code x} that is not equal to any of the grid members.</li>
 * <li>For all {@code x} that {@code 1 <= x <= n * n} there is exactly one
 * {@code x} that is equal to exactly two of the grid members.</li>
 * <li>For all {@code x} that {@code 1 <= x <= n * n} except two of them there
 * is exatly one pair of {@code i, j} that {@code 0 <= i, j <= n - 1} and
 * {@code grid[i][j] == x}.</li>
 * </ul>
 */
public class FindMissingAndRepeatedValues {
	private FindMissingAndRepeatedValues() {
		/* This utility class should not be instantiated */
	}

	static class SimpleSolution {
		public int[] findMissingAndRepeatedValues(int[][] grid) {
			int n = grid.length;
			int[] arr = new int[n * n];
			for (int[] nums : grid) {
				for (int num : nums) {
					arr[num - 1]++;
				}
			}
			int[] res = new int[2];
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 2)
					res[0] = i + 1;
				else if (arr[i] == 0)
					res[1] = i + 1;
			}
			return res;
		}
	}

	static class InPlaceSolution {
		public int[] findMissingAndRepeatedValues(int[][] grid) {
			int repeated = findRepeated(grid);
			int missing = findMissing(grid);

			return new int[] { repeated, missing };
		}

		private int findRepeated(int[][] grid) {
			int n = grid.length;
			int repeated = -1;

			for (int[] row : grid) {
				for (int value : row) {
					int v = Math.abs(value);
					int index = v - 1;

					int i = index / n;
					int j = index % n;

					if (grid[i][j] < 0) {
						repeated = v;
					} else {
						grid[i][j] = -grid[i][j];
					}
				}
			}

			return repeated;
		}

		private int findMissing(int[][] grid) {
			int n = grid.length;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] > 0) {
						return i * n + j + 1;
					}
				}
			}

			return -1;
		}
	}
}
