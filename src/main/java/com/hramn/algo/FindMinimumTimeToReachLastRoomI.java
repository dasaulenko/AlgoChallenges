package com.hramn.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3341. Find Minimum Time to Reach Last Room I
 * https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/description
 * 
 * There is a dungeon with n x m rooms arranged as a grid.
 * 
 * You are given a 2D array moveTime of size n x m, where moveTime[i][j] 
 * represents the minimum time in seconds after which the room opens and can be 
 * moved to. You start from the room (0, 0) at time t = 0 and can move to 
 * an adjacent room. Moving between adjacent rooms takes exactly one second.
 * 
 * Return the minimum time to reach the room (n - 1, m - 1).
 * 
 * Two rooms are adjacent if they share a common wall, either horizontally or 
 * vertically.
 * 
 * Example 1:
 * Input: moveTime = [[0,4],[4,4]]
 * Output: 6
 * Explanation:
 * The minimum time required is 6 seconds.
 * At time t == 4, move from room (0, 0) to room (1, 0) in one second.
 * At time t == 5, move from room (1, 0) to room (1, 1) in one second.
 * 
 * Example 2:
 * Input: moveTime = [[0,0,0],[0,0,0]]
 * Output: 3
 * Explanation:
 * The minimum time required is 3 seconds.
 * At time t == 0, move from room (0, 0) to room (1, 0) in one second.
 * At time t == 1, move from room (1, 0) to room (1, 1) in one second.
 * At time t == 2, move from room (1, 1) to room (1, 2) in one second.
 * 
 * Example 3:
 * Input: moveTime = [[0,1],[1,2]]
 * Output: 3
 * 
 * Constraints:
 * 2 <= n == moveTime.length <= 50
 * 2 <= m == moveTime[i].length <= 50
 * 0 <= moveTime[i][j] <= 10^9
 * 
 * TAGS: 20250507
 * TAGS: medium
 * TAGS: recursion
 * TAGS: dfs
 * TAGS: heap
 * TAGS: PriorityQueue
 */
public class FindMinimumTimeToReachLastRoomI {
	class DijkstraSolution { // O(N * M * log(N * M)), O(N * M), 
													 // N - moveTime.length, M - moveTime[0].length
		public int minTimeToReach(int[][] moveTime) {
			int n = moveTime.length;
			int m = moveTime[0].length;
			int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
			int dp[][] = new int[n][m];
			for (int[] arr : dp) {
				Arrays.fill(arr, Integer.MAX_VALUE);
			}
			PriorityQueue<int[]> heap = new PriorityQueue<>(
					Comparator.comparingInt(a -> a[0]));
			heap.add(new int[] {0, 0, 0});
			moveTime[0][0] = 0;
			while (!heap.isEmpty()) {
				int[] cur = heap.poll();
				int curTime = cur[0];
				int curRow = cur[1];
				int curCol = cur[2];
				if (curTime >= dp[curRow][curCol]) {
					continue;
				}
				if (curRow == n - 1 && curCol == m - 1) {
					return curTime;
				}
				dp[curRow][curCol] = curTime;
				for (int[] dir : directions) {
					int nextRow = curRow + dir[0];
					int nextCol = curCol + dir[1];
					if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m 
							&& dp[nextRow][nextCol] == Integer.MAX_VALUE) {
						int nextTime = Math.max (moveTime[nextRow][nextCol], curTime) + 1;
						heap.add (new int[] {nextTime, nextRow, nextCol});
					}
				}
			}
			return -1;
		}
	}

	class RecursiveDFSSolution { // O(2 ^ (N + M)), O(N + M), 
															 // N - moveTime.length, M - moveTime[0].length
		public int minTimeToReach(int[][] moveTime) {
			return Math.min(
				route (moveTime, 0, 1, 0),
				route (moveTime, 0, 0, 1)
			);
		}

		int route (int[][] moveTime, int time, int i, int j) {
			if (moveTime[i][j] <= time) {
				time++;
			} else {
				time = moveTime[i][j] + 1;
			}
			int ir = -1, jr = -1;
			if (i < moveTime.length - 1) {
				ir = route(moveTime, time, i+1, j);
			}
			if (j < moveTime[0].length - 1) {
				jr = route(moveTime, time, i, j+1);
			}
			if (ir > 0) {
				if (jr > 0) {
					time = Math.min(ir, jr);
				} else {
					time = ir;
				}
			} else if (jr > 0) {
				time = jr;
			}
			return time;
		}
	}
}
