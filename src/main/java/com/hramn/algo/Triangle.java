package com.hramn.algo;

import java.util.List;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/description
 * 
 * Given a triangle array, return the minimum path sum from top to bottom.
 * 
 * For each step, you may move to an adjacent number of the row below. More 
 * formally, if you are on index i on the current row, you may move to either 
 * index i or index i + 1 on the next row.
 * 
 * Example 1:
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined 
 * above).
 * 
 * Example 2:
 * Input: triangle = [[-10]]
 * Output: -10
 * 
 * Constraints:
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10^4 <= triangle[i][j] <= 10^4
 * 
 * Follow up: Could you do this using only O(n) extra space, where 
 * n is the total number of rows in the triangle?
 * 
 * TAG: medium
 * TAG: dp
 * TAG: arrays
 */
public class Triangle {

	class FirstSolution { // O(2^N) time, O(N) space, where N = triangle.size()
		public int minimumTotal(List<List<Integer>> triangle) {
			return dfs(0, 0, triangle);
		}

		private int dfs(int i, int j, List<List<Integer>> triangle) {
			int sum = triangle.get(i).get(j);
			if (triangle.size() == i + 1) return sum;
			int l = dfs(i+1, j, triangle);
			int r = dfs(i+1, j+1, triangle);
			return sum + Math.min(l, r);
		}
	}

	class FastestSolution { // O(N^2) time, O(N^2) space, where N = triangle.size()
		public int minimumTotal(List<List<Integer>> triangle) {
			int n = triangle.size();
			return dfsWithDp(0, 0, triangle, new Integer[n][n]);
		}

		private int dfsWithDp(int i, int j, List<List<Integer>> triangle, Integer[][] dp) {
			if (i == triangle.size()) return 0;
			if (dp[i][j] != null) return dp[i][j];
			int l = dfsWithDp(i+1, j, triangle, dp);
			int r = dfsWithDp(i+1, j+1, triangle, dp);
			dp[i][j] = triangle.get(i).get(j) + Math.min(l, r);
			return dp[i][j];
		}
	}

	class InPlaceSolution { // O(N^2) time, O(1) space, where N = triangle.size()
		public int minimumTotal(List<List<Integer>> triangle) {
			return dp1(triangle);
		}

		private int dp1(List<List<Integer>> triangle) {
			int n = triangle.size();
			List<Integer> row = triangle.get(n-1);
			for (int i = n-2; i >= 0; i--) {
				List<Integer> prevRow = row;
				row = triangle.get(i);
				for (int j = 0; j < row.size(); j++) {
					int l = prevRow.get(j);
					int r = prevRow.get(j+1);
					row.set(j, row.get(j) + Math.min(l, r));
				}
			}
			return row.get(0);
		}
	}

	class FollowUpSolution { // O(N^2) time, O(N) space, where N = triangle.size()
		public int minimumTotal(List<List<Integer>> triangle) {
			return dp2(triangle);
		}

		private int dp2(List<List<Integer>> triangle) {
			int n = triangle.size();
			int[] dp = new int[n];
			List<Integer> lastRow = triangle.get(n-1);
			for (int i = 0; i < n; i++) dp[i] = lastRow.get(i);
			for (int i = n-2; i >= 0; i--) {
				List<Integer> row = triangle.get(i);
				for (int j = 0; j < row.size(); j++) {
					dp[j] = row.get(j) + Math.min(dp[j], dp[j+1]);
				}
			}
			return dp[0];
		}
	}
}
