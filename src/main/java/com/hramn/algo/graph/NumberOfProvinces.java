package com.hramn.algo.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 547. Number of Provinces
 * 
 * There are n cities. Some of them are connected, while some are not. If city 
 * a is connected directly with city b, and city b is connected directly with 
 * city c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no 
 * other cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the 
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0 
 * otherwise.
 * 
 * Return the total number of provinces.
 * 
 * Example 1:
 * 1 - 2
 *   3
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * 
 * Example 2:
 * 1   2
 *   3
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * 
 * Constraints:
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class NumberOfProvinces {

	public static void main(String[] args) {
		int[][] isConnected_v1 = {{1, 0, 0, 1},{0, 1, 1, 0},{0, 1, 1, 1},{1, 0, 1, 1}};
		Solution_v1 sv1 = new Solution_v1();
		int result_v1 = sv1.findCircleNum(isConnected_v1);
		System.out.println(result_v1);
		assert result_v1 == 1;
		int[][] isConnected_v2 = {{1, 0, 0, 1},{0, 1, 1, 0},{0, 1, 1, 1},{1, 0, 1, 1}};
		Solution_v2 sv2 = new Solution_v2();
		int result_v2 = sv2.findCircleNum(isConnected_v2);
		System.out.println(result_v2);
		assert result_v2 == 1;
		int[][] isConnected_v3 = {{1, 0, 0, 1},{0, 1, 1, 0},{0, 1, 1, 1},{1, 0, 1, 1}};
		Solution_v3 sv3 = new Solution_v3();
		int result_v3 = sv3.findCircleNum(isConnected_v3);
		System.out.println(result_v3);
		assert result_v3 == 1;
	}
	
	// we can process only a half of input array
	// we need to iterate every element
	// we will mark processed elements by 2 for example
	// we use a queue to process all the cities in one province

	// [
	// [2,0,0,2],
	// [0,2,2,0],
	// [0,2,2,2],
	// [2,0,2,2]
	// ]

	static class Solution_v1 {
		public int findCircleNum(int[][] isConnected) {
			int count = 0;
			for (int i = 0; i < isConnected.length; i++) {
				if (isConnected[i][i] == 1) {
					count++;
					process(i, isConnected);
				}
			}
			return count;
		}

		private void process(int city, int[][] isConnected) {
			List<Integer> queue = new LinkedList<>();
			queue.add(city);
			while (queue.size() > 0) {
				int i = queue.removeFirst();
				isConnected[i][i] = 2;
				for (int j = 0; j < isConnected[i].length; j++) {
					if (isConnected[i][j] == 1) {
						queue.add(j);
						isConnected[i][j] = 2;
						isConnected[j][i] = 2;
					}
				}
			}
		}
	}

	static class Solution_v2 {
		public int findCircleNum(int[][] isConnected) {
			int count = 0;
			for (int i = 0; i < isConnected.length; i++) {
				if (isConnected[i][i] == 1) {
					count++;
					dfs(i, isConnected);
				}
			}
			return count;
		}

		private void dfs(int i, int[][] isConnected) {
			isConnected[i][i] = 2;
			for (int j = 0; j < isConnected[i].length; j++) {
				if (isConnected[i][j] == 1) {
					isConnected[i][j] = 2;
					isConnected[j][i] = 2;
					dfs(j, isConnected);
				}
			}
		}
	}

	static class Solution_v3 {
		public int findCircleNum (int[][] isConnected) {
			int count = 0;
			boolean[] v = new boolean[isConnected.length];
			for (int i = 0; i < v.length; i++) {
				if (!v[i]) {
					count++;
					dfs(i, v, isConnected);
				}
			}
			return count;
		}

		private void dfs (int i, boolean[] v, int[][] isConnected) {
			v[i] = true;
			for (int j = 0; j < isConnected.length; j++) {
				if (isConnected[i][j] == 1 && !v[j]) {
					dfs (j, v, isConnected);
				}
			}
		}
	}
}
