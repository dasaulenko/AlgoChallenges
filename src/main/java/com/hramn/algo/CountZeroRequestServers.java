package com.hramn.algo;

import java.util.Arrays;

/**
 * <strong>2747. Count Zero Request Servers</strong>
 *
 * <p>
 * Difficulty: Medium
 * <br>
 * Topics: Staff, Array, Hash Table, Sliding Window, Sorting
 *
 * <p>
 * LeetCode:
 * <a href="https://leetcode.com/problems/count-zero-request-servers/">
 * Count Zero Request Servers</a>
 *
 * <h3>Problem Description</h3>
 *
 * <p>
 * You are given an integer n denoting the total number of servers and
 * a 2D 0-indexed integer array {@code logs}, where {@code logs[i] =
 * [server_id, time]} denotes that the server with id {@code server_id}
 * received a request at time {@code time}.
 *
 * <p>
 * You are also given an integer {@code x} and a 0-indexed integer array
 * {@code queries}.
 *
 * <p>
 * Return a 0-indexed integer array {@code arr} of length
 * {@code queries.length} where {@code arr[i]} represents the number of servers
 * that did not receive any requests during the time interval
 * {@code [queries[i] - x, queries[i]]}.
 *
 * <p>
 * Note that the time intervals are inclusive.
 *
 * <h3>Examples</h3>
 *
 * <p>
 * <strong>Example 1:</strong>
 *
 * <pre>{@code
 * Input: n = 3, logs = [[1,3],[2,6],[1,5]], x = 5, queries = [10,11]
 * Output: [1,2]
 * Explanation:
 * For queries[0]: The servers with ids 1 and 2 get requests in the duration of
 * [5, 10]. Hence, only server 3 gets zero requests.
 * For queries[1]: Only the server with id 2 gets a request in duration of
 * [6,11]. Hence, the servers with ids 1 and 3 are the only servers
 * that do not receive any requests during that time period.
 * }</pre>
 *
 * <p>
 * <strong>Example 2:</strong>
 *
 * <pre>{@code
 * Input: n = 3, logs = [[2,4],[2,1],[1,2],[3,1]], x = 2, queries = [3,4]
 * Output: [0,1]
 * Explanation:
 * For queries[0]: All servers get at least one request in the duration of
 * [1, 3].
 * For queries[1]: Only server with id 3 gets no request in the duration [2,4].
 * }</pre>
 *
 * <h3>Constraints:</h3>
 *
 * <pre>{@code
 * 1 <= n <= 10⁵
 * 1 <= logs.length <= 10⁵
 * 1 <= queries.length <= 10⁵
 * logs[i].length == 2
 * 1 <= logs[i][0] <= n
 * 1 <= logs[i][1] <= 10⁶
 * 1 <= x <= 10⁵
 * x < queries[i] <= 10⁶
 * }</pre>
 */
public class CountZeroRequestServers {
	class Solution {
		public int[] countServers(int n, int[][] logs, int x, int[] queries) {
			int ln = logs.length;
			int qn = queries.length;

			Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

			Integer[] ids = new Integer[qn];
			for (int i = 0; i < qn; i++)
				ids[i] = i;
			Arrays.sort(ids, (a, b) -> Integer.compare(queries[a], queries[b]));

			int[] result = new int[qn];
			int[] servers = new int[n];
			int busy = 0;

			int left = 0;
			int right = 0;
			for (int i = 0; i < qn; i++) {
				int index = ids[i];
				int start = queries[index] - x;
				int end = queries[index];
				while (right < ln && logs[right][1] <= end) {
					right++;
					int server = logs[right][0];
					if (servers[server]++ == 0)
						busy++;
				}
				while (left < ln && logs[left][1] < start) {
					left++;
					int server = logs[left][0];
					if (--servers[server] == 0)
						busy--;
				}
				result[index] = n - busy;
			}
			return result;
		}
	}
}
