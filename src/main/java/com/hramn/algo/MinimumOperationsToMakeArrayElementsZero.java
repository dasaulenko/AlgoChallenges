package com.hramn.algo;

/**
 * 3495. Minimum Operations to Make Array Elements Zero
 * https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/description
 * 
 * You are given a 2D array queries, where queries[i] is of the form [l, r]. 
 * Each queries[i] defines an array of integers nums consisting of elements 
 * ranging from l to r, both inclusive.
 * 
 * In one operation, you can:
 * - Select two integers a and b from the array.
 * - Replace them with floor(a / 4) and floor(b / 4).
 * 
 * Your task is to determine the minimum number of operations required to 
 * reduce all elements of the array to zero for each query. Return the sum of 
 * the results for all queries.
 * 
 * Example 1:
 * Input: queries = [[1,2],[2,4]]
 * Output: 3
 * Explanation:
 * For queries[0]:
 * - The initial array is nums = [1, 2].
 * - In the first operation, select nums[0] and nums[1]. The array becomes 
 *   [0, 0].
 * The minimum number of operations required is 1.
 * For queries[1]:
 * - The initial array is nums = [2, 3, 4].
 * - In the first operation, select nums[0] and nums[2]. The array becomes 
 *   [0, 3, 1].
 * - In the second operation, select nums[1] and nums[2]. The array becomes 
 *   [0, 0, 0].
 * The minimum number of operations required is 2.
 * The output is 1 + 2 = 3.
 * 
 * Example 2:
 * Input: queries = [[2,6]]
 * Output: 4
 * Explanation:
 * For queries[0]:
 * - The initial array is nums = [2, 3, 4, 5, 6].
 * - In the first operation, select nums[0] and nums[3]. The array becomes 
 *   [0, 3, 4, 1, 6].
 * - In the second operation, select nums[2] and nums[4]. The array becomes 
 *   [0, 3, 1, 1, 1].
 * - In the third operation, select nums[1] and nums[2]. The array becomes 
 *   [0, 0, 0, 1, 1].
 * - In the fourth operation, select nums[3] and nums[4]. The array becomes 
 *   [0, 0, 0, 0, 0].
 * The minimum number of operations required is 4.
 * The output is 4.
 * 
 * Constraints:
 * 1 <= queries.length <= 10^5
 * queries[i].length == 2
 * queries[i] == [l, r]
 * 1 <= l < r <= 10^9
 * 
 * TAG: hard
 * TAG: numbers
 */
public class MinimumOperationsToMakeArrayElementsZero {
	class Solution20250906 { // O(N), O(1)
		public long minOperations(int[][] queries) {
			long res = 0;
			for (int[] query : queries) {
				long cnt = step(query);
				res += cnt / 2 + (cnt % 2 == 0 ? 0 : 1);
			}
			return res;
		}

		// private void fill(List<int[]> limPow4) {
		// 	int c = 1_000_000_000;
		// 	int cnt = 0;
		// 	int cur = 1;
		// 	while (cur < c) {
		// 		cur *= 4;
		// 		cnt++;
		// 		limPow4.add(new int[] {cur - 1, cnt});
		// 	}
		// }

		private long step (int[] query) {
			int lim = 1;
			int op = 0;
			long counter = 0;
			while (lim <= query[0]) {
				lim *= 4;
				op++;
			}
			int cur = query[0];
			while (query[1] >= lim) {
				counter += 1L * (lim - cur) * op;
				cur = lim;
				lim *= 4;
				op++;
			}
			counter += 1L * (query[1] - cur + 1) * op;
			return counter;
		}

		// private long step (int[] query, List<int[]> lims) {
		// 	int min = query[0];
		// 	int max = query[1];
		// 	int cur = min;
		// 	long counter = 0;
		// 	for (int[] lim : lims) {
		// 		if (cur <= lim[0]) {
		// 			if (max > lim[0]) {
		// 				counter += 1L * (lim[0] - cur + 1) * lim[1];
		// 				cur = lim[0]+1;
		// 			} else {
		// 				counter += 1L * (max - cur + 1) * lim[1];
		// 				break;
		// 			}
		// 		}
		// 	}
		// 	return counter;
		// }
	}
}
