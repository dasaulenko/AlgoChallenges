package com.hramn.algo;

import java.util.PriorityQueue;

/**
 * 3551. Minimum Swaps to Sort by Digit Sum
 * 
 * <p>You are given an array nums of distinct positive integers. You need to 
 * sort the array in increasing order based on the sum of the digits of each 
 * number. If two numbers have the same digit sum, the smaller number appears 
 * first in the sorted order.
 * 
 * <p>Return the minimum number of swaps required to rearrange nums into this 
 * sorted order.
 * 
 * <p>A swap is defined as exchanging the values at two distinct positions in 
 * the array.
 * 
 * <p>Example 1:
 * <pre>
 * Input: nums = [37,100]
 * Output: 1
 * Explanation:
 * - Compute the digit sum for each integer: 
 *   [3 + 7 = 10, 1 + 0 + 0 = 1] → [10, 1]
 * - Sort the integers based on digit sum: [100, 37]. Swap 37 with 100 to 
 *   obtain the sorted order.
 * - Thus, the minimum number of swaps required to rearrange nums is 1.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: nums = [22,14,33,7]
 * Output: 0
 * Explanation:
 * - Compute the digit sum for each integer: 
 *   [2 + 2 = 4, 1 + 4 = 5, 3 + 3 = 6, 7 = 7] → [4, 5, 6, 7]
 * - Sort the integers based on digit sum: [22, 14, 33, 7]. The array is 
 *   already sorted.
 * - Thus, the minimum number of swaps required to rearrange nums is 0.
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: nums = [18,43,34,16]
 * Output: 2
 * Explanation:
 * - Compute the digit sum for each integer: 
 *   [1 + 8 = 9, 4 + 3 = 7, 3 + 4 = 7, 1 + 6 = 7] → [9, 7, 7, 7]
 * - Sort the integers based on digit sum: [16, 34, 43, 18]. Swap 18 with 16, 
 *   and swap 43 with 34 to obtain the sorted order.
 * - Thus, the minimum number of swaps required to rearrange nums is 2.
 * </pre>
 * 
 * <p>Constraints:
 * <pre>
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁹
 * nums consists of distinct positive integers.
 * </pre>
 * 
 * @see <a href="https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum">
 * 		Link to source
 * </a>
 */
public class MinimumSwapsToSortByDigitSum {

	class Solution {

		private static class Elem {
			int num;
			int pos;
			int sum;

			public Elem(int num, int pos, int sum) {
				this.num = num;
				this.pos = pos;
				this.sum = sum;
			}
		}

		public int minSwaps(int[] nums) {
			int n = nums.length;
			
			PriorityQueue<Elem> heap = new PriorityQueue<>((a,b) -> {
				int dif = a.sum - b.sum;
				if (dif == 0) return a.num - b.num;
				return dif;
			});
			
			Elem[] elems = new Elem[n];

			for (int i = 0; i < n; i++) {
				Elem elem = new Elem(nums[i], i, sum(nums[i]));
				heap.add(elem);
				elems[i] = elem;
			}

			int index = 0;
			int count = 0;
			while (!heap.isEmpty()) {
				Elem elem = heap.poll();
				if (index != elem.pos) {
					count++;
					int oldPos = elem.pos;
					elem.pos = index;
					Elem elem2 = elems[index];
					elem2.pos = oldPos;
					elems[oldPos] = elem2;
				}
				index++;
			}
			return count;
		}

		private int sum (int num) {
			int sum = 0;
			while (num > 0) {
				sum += num % 10;
				num /= 10;
			}
			return sum;
		}
	}
}
