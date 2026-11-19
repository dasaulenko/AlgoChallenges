package com.hramn.algo.hard;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * <strong>3505. Minimum Operations to Make Elements Within K Subarrays
 * Equal</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Hard
 * <br>
 * <strong>LeetCode:</strong> <a href=
 * "https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/">
 * 3505. Minimum Operations to Make Elements Within K Subarrays Equal</a>
 * <br>
 * <strong>Topic:</strong> array, hash table, math, dynamic programming, sliding
 * window, heap
 *
 * <hr>
 *
 * <p>
 * You are given an integer array {@code nums} and two integers, {@code x} and
 * {@code k}. You can perform the following operation any number of times
 * (including zero):
 * <ul>
 * <li>Increase or decrease any element of nums by 1.</li>
 * </ul>
 * <p>
 * Return the minimum number of operations needed to have at least {@code k}
 * non-overlapping subarrays of size exactly {@code x} in {@code nums}, where
 * all elements within each subarray are equal.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code nums = [5,-2,1,3,7,3,6,4,-1], x = 3, k = 2}
 * <p>
 * Output: {@code 8}
 * <p>
 * Explanation:
 * <ul>
 * <li>Use 3 operations to add 3 to {@code nums[1]} and use 2 operations to
 * subtract 2 from {@code nums[3]}. The resulting array is
 * {@code [5, 1, 1, 1, 7, 3, 6, 4, -1]}.</li>
 * <li>Use 1 operation to add 1 to {@code nums[5]} and use 2 operations to
 * subtract 2 from {@code nums[6]}. The resulting array is
 * {@code [5, 1, 1, 1, 7, 4, 4, 4, -1]}.</li>
 * <li>Now, all elements within each subarray {@code [1, 1, 1]} (from indices 1
 * to 3) and {@code [4, 4, 4]} (from indices 5 to 7) are equal. Since 8 total
 * operations were used, 8 is the output.</li>
 * </ul>
 *
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code nums = [9,-2,-2,-2,1,5], x = 2, k = 2}
 * <p>
 * Output: {@code 3}
 * <p>
 * Explanation:
 * <ul>
 * <li>Use 3 operations to subtract 3 from {@code nums[4]}. The resulting array
 * is {@code [9, -2, -2, -2, -2, 5]}.</li>
 * <li>Now, all elements within each subarray {@code [-2, -2]} (from indices 1
 * to 2) and {@code [-2, -2]} (from indices 3 to 4) are equal. Since 3
 * operations were used, 3 is the output.</li>
 * </ul>
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>2 <= nums.length <= 10^5</li>
 * <li>-10^6 <= nums[i] <= 10^6</li>
 * <li>2 <= x <= nums.length</li>
 * <li>1 <= k <= 15</li>
 * <li>2 <= k * x <= nums.length</li>
 * </ul>
 */
public class MinimumOperationsToMakeElementsWithinKSubarraysEqual {
	private MinimumOperationsToMakeElementsWithinKSubarraysEqual() {
		/* This utility class should not be instantiated */
	}

	// Time: O(nx log x + nk)
	// Space: O(n)
	// Time Limit Exceeded
	static class SortSolution {
		public long minOperations(int[] nums, int x, int k) {
			int n = nums.length;
			long[] cost = new long[n - x + 1];

			for (int i = 0; i + x <= n; i++) {
				int[] window = Arrays.copyOfRange(nums, i, i + x);
				Arrays.sort(window);

				int median = window[x / 2];
				long operations = 0;

				for (int value : window) {
					operations += Math.abs((long) value - median);
				}

				cost[i] = operations;
			}

			final long INF = Long.MAX_VALUE / 4;
			long[] prev = new long[n + 1];
			Arrays.fill(prev, 0);

			for (int count = 1; count <= k; count++) {
				long[] curr = new long[n + 1];
				Arrays.fill(curr, INF);

				for (int i = 1; i <= n; i++) {
					curr[i] = curr[i - 1];

					if (i >= x && prev[i - x] != INF)
						curr[i] = Math.min(curr[i], prev[i - x] + cost[i - x]);
				}

				prev = curr;
			}
			return prev[n];
		}
	}

	// Time: O(n log x + nk)
	// Space: O(n)
	static class TreeMapSolution {
		public long minOperations(int[] nums, int x, int k) {
			int n = nums.length;

			// 1. Стоимость выравнивания каждого окна длины x
			// Time: O(n log x)
			// Space: O(x)
			long[] cost = new long[n - x + 1];
			MedianWindow window = new MedianWindow();

			for (int i = 0; i < n; i++) {
				window.add(nums[i]);

				if (i >= x) {
					window.remove(nums[i - x]);
				}

				if (i >= x - 1) {
					cost[i - x + 1] = window.cost();
				}
			}

			// 2. DP: выбираем k непересекающихся окон
			// Time: O(nk)
			// Space: O(n)
			final long INF = Long.MAX_VALUE / 4;

			long[] prev = new long[n + 1];

			for (int count = 1; count <= k; count++) {
				long[] curr = new long[n + 1];
				Arrays.fill(curr, INF);

				for (int i = x; i <= n; i++) {
					// Не выбираем окно, заканчивающееся в i - 1
					curr[i] = curr[i - 1];

					// Выбираем окно [i - x, i - 1]
					if (prev[i - x] != INF) {
						curr[i] = Math.min(
								curr[i],
								prev[i - x] + cost[i - x]);
					}
				}

				prev = curr;
			}

			return prev[n];

		}

		private static class MedianWindow {
			private final TreeMap<Integer, Integer> low = new TreeMap<>();
			private final TreeMap<Integer, Integer> high = new TreeMap<>();

			private int lowSize = 0;
			private int highSize = 0;

			private long lowSum = 0;
			private long highSum = 0;

			public void add(int value) {
				if (low.isEmpty() || value <= low.lastKey()) {
					insertLow(value);
				} else {
					insertHigh(value);
				}

				rebalance();
			}

			public void remove(int value) {
				if (low.containsKey(value)) {
					erase(low, value);
					lowSize--;
					lowSum -= value;
				} else {
					erase(high, value);
					highSize--;
					highSum -= value;
				}

				rebalance();
			}

			public long cost() {
				long median = low.lastKey();

				long leftCost = median * lowSize - lowSum;
				long rightCost = highSum - median * highSize;

				return leftCost + rightCost;
			}

			private void rebalance() {
				// low должен содержать столько же элементов,
				// сколько high, или на один больше.
				while (lowSize > highSize + 1) {
					int value = low.lastKey();

					erase(low, value);
					lowSize--;
					lowSum -= value;

					insertHigh(value);
				}

				while (lowSize < highSize) {
					int value = high.firstKey();

					erase(high, value);
					highSize--;
					highSum -= value;

					insertLow(value);
				}
			}

			private void insertLow(int value) {
				low.merge(value, 1, Integer::sum);
				lowSize++;
				lowSum += value;
			}

			private void insertHigh(int value) {
				high.merge(value, 1, Integer::sum);
				highSize++;
				highSum += value;
			}

			private void erase(TreeMap<Integer, Integer> map, int value) {
				int count = map.get(value);

				if (count == 1) {
					map.remove(value);
				} else {
					map.put(value, count - 1);
				}
			}

		}
	}
}
