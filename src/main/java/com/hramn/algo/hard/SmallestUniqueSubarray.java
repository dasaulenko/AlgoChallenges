package com.hramn.algo.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <strong>3934. Smallest Unique Subarray</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Hard
 * <br>
 * <strong>LeetCode:</strong>
 * <a href="https://leetcode.com/problems/smallest-unique-subarray/">
 * 3934. Smallest Unique Subarray</a>
 * <br>
 * <strong>Topic:</strong> array, hash table, binary search, rolling hash,
 * suffix array, hash function, doubling technique, lcp, counting sort
 *
 * <hr>
 *
 * <p>
 * You are given an integer array {@code nums}.
 *
 * <p>
 * Find the minimum length of a subarray that is not identical to any other
 * subarray in {@code nums}.
 *
 * <p>
 * Return an integer denoting the minimum possible length of such a subarray.
 *
 * <p>
 * Two subarrays are considered identical if they have the same length and the
 * same elements in corresponding positions.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code nums = [3,3,3]}
 * <p>
 * Output: {@code 3}
 * <p>
 * Explanation:
 * <ul>
 * <li>Subarrays of length 1: {@code [3]} → appears 3 times</li>
 * <li>Subarrays of length 2: {@code [3, 3]} → appears 2 times</li>
 * <li>Subarrays of length 3: {@code [3, 3, 3]} → appears once</li>
 * </ul>
 * <br>
 * The subarray {@code [3, 3, 3]} is unique, so the smallest unique subarray
 * length is 3.
 *
 * <p>
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code nums = [2,1,2,3,3]}
 * <p>
 * Output: {@code 1}
 * <p>
 * Explanation:
 * <br>
 * Subarrays of length 1:
 * <ul>
 * <li>{@code [2]} → appears 2 times</li>
 * <li>{@code [1]} → appears once</li>
 * <li>{@code [3]} → appears 2 times</li>
 * </ul>
 * <br>
 * The subarray {@code [1]} is unique, so the smallest unique subarray length is
 * 1.
 *
 * <p>
 * <strong>Example 3:</strong>
 * <p>
 * Input: {@code nums = [1,1,2,2,1]}
 * <p>
 * Output: {@code 2}
 * <p>
 * Explanation:
 * <br>
 * Subarrays of length 1:
 * <ul>
 * <li>{@code [1]} → appears 3 times</li>
 * <li>{@code [2]} → appears 2 times
 * </ul>
 * <br>
 * Subarrays of length 2:
 * <ul>
 * <li>{@code [1, 1]} → appears once</li>
 * <li>{@code [1, 2]} → appears once</li>
 * <li>{@code [2, 2]} → appears once</li>
 * <li>{@code [2, 1]} → appears once</li>
 * </ul>
 * <br>
 * There is at least one subarray of length 2 that is unique, so the smallest
 * unique subarray length is 2.
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>{@code 1 <= nums.length <= 10^5}</li>
 * <li>{@code 1 <= nums[i] <= 10^5}</li>
 * </ul>
 */
public class SmallestUniqueSubarray {
	private SmallestUniqueSubarray() {
		/* This utility class should not be instantiated */
	}

	/**
	 * Binary Search + Rolling Hash solution.
	 * Time: O(n log n)
	 * Space: O(n)
	 * This is a probabilistic solution, not a strictly deterministic one.
	 */
	static class DoubleRollingHashSolution {
		private static final long BASE = 911382323L;
		private static final long MOD1 = 1_000_000_007L;
		private static final long MOD2 = 1_000_000_009L;

		private long[] hash1;
		private long[] hash2;
		private long[] pow1;
		private long[] pow2;

		public int smallestUniqueSubarray(int[] nums) {
			int n = nums.length;

			hash1 = new long[n + 1];
			hash2 = new long[n + 1];
			pow1 = new long[n + 1];
			pow2 = new long[n + 1];

			pow1[0] = pow2[0] = 1;

			for (int i = 0; i < n; i++) {
				hash1[i + 1] = (hash1[i] * BASE + nums[i]) % MOD1;
				hash2[i + 1] = (hash2[i] * BASE + nums[i]) % MOD2;

				pow1[i + 1] = pow1[i] * BASE % MOD1;
				pow2[i + 1] = pow2[i] * BASE % MOD2;
			}

			int left = 1;
			int right = n;

			while (left < right) {
				int mid = left + (right - left) / 2;

				if (hasUnique(n, mid)) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}

			return left;
		}

		private boolean hasUnique(int n, int len) {
			Map<Long, Integer> count = new HashMap<>();

			for (int i = 0; i + len <= n; i++) {
				int j = i + len;

				long h1 = (hash1[j] - hash1[i] * pow1[len] % MOD1 + MOD1) % MOD1;

				long h2 = (hash2[j] - hash2[i] * pow2[len] % MOD2 + MOD2) % MOD2;

				long key = (h1 << 32) | h2;

				count.merge(key, 1, Integer::sum);
			}

			for (int frequency : count.values()) {
				if (frequency == 1) {
					return true;
				}
			}

			return false;
		}
	}

	/**
	 * Binary Search + HashMap solution
	 * Time: O(n^2 log n)
	 * Space: O(n^2)
	 */
	static class HashMapSolution {
		public int smallestUniqueSubarray(int[] nums) {
			int left = 1;
			int right = nums.length;

			while (left < right) {
				int mid = left + (right - left) / 2;

				if (hasUnique(nums, mid)) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}

			return left;
		}

		private boolean hasUnique(int[] nums, int len) {
			Map<List<Integer>, Integer> count = new HashMap<>();

			for (int i = 0; i + len <= nums.length; i++) {
				List<Integer> subarray = new ArrayList<>();

				for (int j = i; j < i + len; j++) {
					subarray.add(nums[j]);
				}

				count.merge(subarray, 1, Integer::sum);
			}

			return count.containsValue(1);
		}
	}

	/**
	 * Binary Search + HashMap + Doubling Technique solution
	 * Time: O(n log n)
	 * Space: O(n log n)
	 */
	static class DoublingTechniqueSolution {

		public int smallestUniqueSubarray(int[] nums) {
			int n = nums.length;
			int[][] ranks = buildRanks(nums);

			int left = 1;
			int right = n;

			while (left < right) {
				int mid = left + (right - left) / 2;

				if (hasUnique(ranks, n, mid)) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}

			return left;
		}

		private int[][] buildRanks(int[] nums) {
			int n = nums.length;
			int levels = 32 - Integer.numberOfLeadingZeros(n);

			int[][] ranks = new int[levels][];
			ranks[0] = nums.clone();

			for (int k = 1; k < levels; k++) {
				int len = 1 << k;
				int half = len / 2;

				ranks[k] = new int[n - len + 1];

				Map<Long, Integer> ids = new HashMap<>();

				for (int i = 0; i + len <= n; i++) {
					int first = ranks[k - 1][i];
					int second = ranks[k - 1][i + half];

					long key = pack(first, second);

					if (!ids.containsKey(key)) {
						ids.put(key, ids.size());
					}

					ranks[k][i] = ids.get(key);
				}
			}

			return ranks;
		}

		private boolean hasUnique(int[][] ranks, int n, int len) {
			int k = 31 - Integer.numberOfLeadingZeros(len);
			int blockSize = 1 << k;

			Map<Long, Integer> count = new HashMap<>();

			for (int i = 0; i + len <= n; i++) {
				int first = ranks[k][i];
				int last = ranks[k][i + len - blockSize];

				long key = pack(first, last);

				count.merge(key, 1, Integer::sum);
			}

			return count.containsValue(1);
		}

		private long pack(int first, int second) {
			return ((long) first << 32) | (second & 0xffffffffL);
		}
	}

	/**
	 * Suffix Array + LCP + Counting Sort solution
	 * Time: O(n log n)
	 * Space: O(n)
	 */
	static class SuffixArraySolution {

		public int smallestUniqueSubarray(int[] nums) {
			int n = nums.length;

			int[] sa = buildSuffixArray(nums);
			int[] lcp = buildLcp(nums, sa);

			int ans = n;

			for (int i = 0; i < n; i++) {
				int left = lcp[i];
				int right = i + 1 < n ? lcp[i + 1] : 0;

				int len = Math.max(left, right) + 1;

				if (len <= n - sa[i]) {
					ans = Math.min(ans, len);
				}
			}

			return ans;
		}

		private int[] buildSuffixArray(int[] nums) {
			int n = nums.length;

			int[] sa = new int[n];
			int[] rank = compress(nums);
			int[] nextRank = new int[n];
			int[] temp = new int[n];
			int[] count = new int[n + 1];

			for (int i = 0; i < n; i++) {
				sa[i] = i;
			}

			// Sort suffixes by their first element.
			countingSort(sa, temp, rank, 0, count);

			int[] swap = sa;
			sa = temp;
			temp = swap;

			for (int len = 1; len < n; len *= 2) {

				// Sort by second rank.
				countingSort(sa, temp, rank, len, count);

				// Stable sort by first rank.
				countingSort(temp, sa, rank, 0, count);

				int classes = 1;
				nextRank[sa[0]] = classes;

				for (int i = 1; i < n; i++) {
					int curr = sa[i];
					int prev = sa[i - 1];

					if (rank[curr] != rank[prev] || getRank(rank, curr + len) != getRank(rank, prev + len)) {
						classes++;
					}

					nextRank[curr] = classes;
				}

				swap = rank;
				rank = nextRank;
				nextRank = swap;

				if (classes == n) {
					break;
				}
			}

			return sa;
		}

		private void countingSort(
				int[] input,
				int[] output,
				int[] rank,
				int offset,
				int[] count) {

			Arrays.fill(count, 0);

			for (int index : input) {
				int key = getRank(rank, index + offset);
				count[key]++;
			}

			for (int i = 1; i < count.length; i++) {
				count[i] += count[i - 1];
			}

			// Traverse backwards to preserve stability.
			for (int i = input.length - 1; i >= 0; i--) {
				int index = input[i];
				int key = getRank(rank, index + offset);

				output[--count[key]] = index;
			}
		}

		private int getRank(int[] rank, int index) {
			return index < rank.length ? rank[index] : 0;
		}

		private int[] compress(int[] nums) {
			int n = nums.length;
			int[] sorted = nums.clone();

			Arrays.sort(sorted);

			int unique = 0;

			for (int num : sorted) {
				if (unique == 0 || sorted[unique - 1] != num) {
					sorted[unique++] = num;
				}
			}

			int[] rank = new int[n];

			for (int i = 0; i < n; i++) {
				rank[i] = Arrays.binarySearch(sorted, 0, unique, nums[i]) + 1;
			}

			return rank;
		}

		private int[] buildLcp(int[] nums, int[] sa) {
			int n = nums.length;

			int[] position = new int[n];
			int[] lcp = new int[n];

			for (int i = 0; i < n; i++) {
				position[sa[i]] = i;
			}

			int h = 0;

			for (int i = 0; i < n; i++) {
				int p = position[i];

				if (p == 0) {
					h = 0;
					continue;
				}

				int j = sa[p - 1];

				while (i + h < n && j + h < n && nums[i + h] == nums[j + h]) {
					h++;
				}

				lcp[p] = h;

				if (h > 0) {
					h--;
				}
			}

			return lcp;
		}
	}
}
