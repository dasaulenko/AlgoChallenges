package com.hramn.algo;

/**
 * 3886. Sum of Sortable Integers
 * 
 * <p>You are given an integer array nums of length n.
 * 
 * <p>An integer k is called sortable if k divides n and you can sort nums in 
 * non-decreasing order by sequentially performing the following operations:
 * <ul>
 * <li>Partition nums into consecutive subarrays of length k.</li>
 * <li>Cyclically rotate each subarray independently any number of times to 
 * the left or to the right.</li>
 * </ul>
 * 
 * <p>Return an integer denoting the sum of all possible sortable integers k.
 * 
 * <p>Example 1:
 * <pre>
 * Input: nums = [3,1,2]
 * Output: 3
 * Explanation:​​​​​​​
 * - For n = 3, possible divisors are 1 and 3.
 * - For k = 1: each subarray has one element. No rotation can sort the array.
 * - For k = 3: the single subarray [3, 1, 2] can be rotated once to produce 
 *   [1, 2, 3], which is sorted.
 * - Only k = 3 is sortable. Hence, the answer is 3.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: nums = [7,6,5]
 * Output: 0
 * Explanation:
 * - For n = 3, possible divisors are 1 and 3.
 * - For k = 1: each subarray has one element. No rotation can sort the array.
 * - For k = 3: the single subarray [7, 6, 5] cannot be rotated into 
 *   non-decreasing order.
 * - No k is sortable. Hence, the answer is 0.
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: nums = [5,8]
 * Output: 3
 * Explanation:​​​​​​​
 * - For n = 2, possible divisors are 1 and 2.
 * - Since [5, 8] is already sorted, every divisor is sortable. Hence, 
 *   the answer is 1 + 2 = 3.
 * </pre>
 * 
 * <p>Constraints:
 * <pre>
 * 1 <= n == nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁵
 * </pre>
 * 
 * @see <a href="https://leetcode.com/problems/sum-of-sortable-integers">
 * 		Link to source
 * </a>
 */
public class SumOfSortableIntegers {

	class Solution {

		public int sortableIntegers(int[] nums) {
			int n = nums.length;
			if (n == 1) return 1;

			int[] prefSumPeaks = new int[n];
			prefSumPeaks[0] = 0;

			for (int i = 1; i < n; i++) {
				prefSumPeaks[i] = prefSumPeaks[i-1] + (nums[i-1] > nums[i] ? 1 : 0);
			}

			int[] maxPrefix = new int[n+1];
			maxPrefix[0] = 0;

			for (int i = 0; i < n; i++) {
				maxPrefix[i+1] = Math.max (maxPrefix[i], nums[i]);
			}

			int[] minSufix = new int[n+1];
			minSufix[n] = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				minSufix[n-i-1] = Math.min (minSufix[n-i], nums[n-i-1]);
			}

			int sum = 0;

			for (int i = 1; i * i <= n; i++) {
				if (n % i > 0) continue;

				
				if (checkSector (i, nums, prefSumPeaks, maxPrefix, minSufix)) {
					sum += i;
				}

				int sector2 = n / i;
				if (i != sector2 
								&& checkSector (sector2, nums, prefSumPeaks, maxPrefix, minSufix)) {
					sum += sector2;
				}
			}
			return sum;
		}

		private boolean checkSector (
						int sector,
						int[] nums,
						int[] prefSumPeaks, 
						int[] maxPrefix, 
						int[] minSufix) {
			int n = nums.length;
			for (int left = 0; left < n; left += sector) {
				int right = left + sector - 1;

				int peaks = 0;
				peaks = prefSumPeaks[right] - prefSumPeaks[left];
				if (nums[right] > nums[left]) peaks++;

				if (peaks > 1) return false;

				if (maxPrefix[left] > minSufix[left]) {
					return false;
				}
			}
			return true;
		}
	}
}
