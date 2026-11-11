package com.hramn.example;

public class PascalsTriangleExample {

	/**
	 * Build Pascal's Triangle
	 * <p>Complexity:
	 * <pre>
	 * Time: O(n²)
	 * Space: O(n²)
	 * </pre>
	 * @param n
	 * @return
	 */
	public static long[][] buildCombinations(int n) {
		long[][] combinations = new long[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			combinations[i][0] = 1;
			combinations[i][i] = 1;

			for (int j = 1; j < i; j++) {
				combinations[i][j] =
								combinations[i - 1][j - 1]
								+ combinations[i - 1][j];
			}
		}
		return combinations;
	}
}
