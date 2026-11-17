package com.hramn.algo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <strong>3420. Count Non-Decreasing Subarrays After K Operations</strong>
 *
 * <p>
 * Difficulty: Hard
 * <br>
 * LeetCode: <a href=
 * "https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/">
 * 3420. Count Non-Decreasing Subarrays After K Operations</a>
 * <br>
 * Topics: array, stack, queue, sliding window
 *
 * <h3>Problem Description</h3>
 *
 * <p>
 * You are given an array {@code nums} of {@code n} integers and an integer
 * {@code k}.
 *
 * <p>
 * For each subarray of {@code nums}, you can apply up to {@code k} operations
 * on it. In each
 * operation, you increment any element of the subarray by 1.
 *
 * <p>
 * Note that each subarray is considered independently, meaning changes made to
 * one subarray do not persist to another.
 *
 * <p>
 * Return the number of subarrays that you can make non-decreasing ​​​​​after
 * performing at most {@code k} operations.
 *
 * <p>
 * An array is said to be non-decreasing if each element is greater than or
 * equal to its previous element, if it exists.
 *
 * <h3>Examples</h3>
 *
 * <p>
 * <strong>Example 1:</strong>
 *
 * <pre>{@code
 * Input: nums = [6,3,1,2,4,4], k = 7
 * Output: 17
 * Explanation:
 * Out of all 21 possible subarrays of nums, only the subarrays [6, 3, 1], [6,
 * 3, 1, 2], [6, 3, 1, 2, 4] and [6, 3, 1, 2, 4, 4] cannot be made
 * non-decreasing after applying up to k = 7 operations. Thus, the number of
 * non-decreasing subarrays is 21 - 4 = 17.
 * }</pre>
 *
 * <p>
 * <strong>Example 2:</strong>
 *
 * <pre>{@code
 * Input: nums = [6,3,1,3,6], k = 4
 * Output: 12
 * Explanation:
 * The subarray [3, 1, 3, 6] along with all subarrays of nums with three or
 * fewer elements, except [6, 3, 1], can be made non-decreasing after k
 * operations. There are 5 subarrays of a single element, 4 subarrays of two
 * elements, and 2 subarrays of three elements except [6, 3, 1], so there are 1
 * + 5 + 4 + 2 = 12 subarrays that can be made non-decreasing.
 * }</pre>
 *
 * <h3>Constraints</h3>
 *
 * <pre>{@code
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= 10^9
 * }</pre>
 */
public class CountNonDecreasingSubarraysAfterKOperations {

	static class SolutionWithIndexes {

		public long countNonDecreasingSubarrays(int[] nums, int k) {

			Deque<Integer> starts = new ArrayDeque<>();
			long ans = 0;
			long water = 0;
			int n = nums.length;
			int r = n - 1;

			for (int l = n - 1; l >= 0; l--) {
				int x = nums[l];

				while (!starts.isEmpty() && nums[starts.peekFirst()] <= x) {
					int s = starts.pollFirst();
					int end = starts.isEmpty() ? r + 1 : starts.peekFirst();
					water += (long) (x - nums[s]) * (end - s);
				}

				starts.offerFirst(l);

				while (water > k) {
					water -= nums[starts.peekLast()] - nums[r];
					if (starts.peekLast() == r)
						starts.pollLast();
					r--;
				}
				ans += r - l + 1;
			}
			return ans;
		}
	}

	static class SolutionWithPairs {

		public long countNonDecreasingSubarrays(int[] nums, int k) {

			int n = nums.length;
			Deque<int[]> deque = new ArrayDeque<>();
			long cost = 0;
			long answer = 0;
			int right = n - 1;

			for (int left = n - 1; left >= 0; left--) {
				int value = nums[left];
				int count = 1;

				// Add a new element to the left.
				// Merge all groups smaller than value.
				while (!deque.isEmpty() && deque.peekLast()[0] < value) {
					int[] group = deque.pollLast();
					int groupValue = group[0];
					int groupCount = group[1];

					cost += (long) (value - groupValue) * groupCount;
					count += groupCount;
				}

				deque.offerLast(new int[] { value, count });

				// Shrink the window from the right until the cost fits the budget.
				while (cost > k) {
					int[] group = deque.peekFirst();
					int adjustedValue = group[0];

					cost -= (long) adjustedValue - nums[right];

					group[1]--;

					if (group[1] == 0)
						deque.pollFirst();

					right--;
				}

				// All subarrays [left, end], where left <= end <= right, are valid.
				answer += right - left + 1;
			}

			return answer;
		}
	}

	private CountNonDecreasingSubarraysAfterKOperations() {
	}
}
