package com.hramn.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 3362. Zero Array Transformation III
 * https://leetcode.com/problems/zero-array-transformation-iii/description/
 * 
 * You are given an integer array nums of length n and a 2D array queries where 
 * queries[i] = [li, ri].
 * 
 * Each queries[i] represents the following action on nums:
 * - Decrement the value at each index in the range [li, ri] in nums by at 
 *   most 1.
 * - The amount by which the value is decremented can be chosen independently 
 *   for each index.
 * 
 * A Zero Array is an array with all its elements equal to 0.
 * 
 * Return the maximum number of elements that can be removed from queries, such 
 * that nums can still be converted to a zero array using the remaining queries. 
 * If it is not possible to convert nums to a zero array, return -1.
 * 
 * Example 1:
 * Input: nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]
 * Output: 1
 * Explanation:
 * After removing queries[2], nums can still be converted to a zero array.
 * - Using queries[0], decrement nums[0] and nums[2] by 1 and nums[1] by 0.
 * - Using queries[1], decrement nums[0] and nums[2] by 1 and nums[1] by 0.
 * 
 * Example 2:
 * Input: nums = [1,1,1,1], queries = [[1,3],[0,2],[1,3],[1,2]]
 * Output: 2
 * Explanation:
 * We can remove queries[2] and queries[3].
 * 
 * Example 3:
 * Input: nums = [1,2,3,4], queries = [[0,3]]
 * Output: -1
 * Explanation:
 * nums cannot be converted to a zero array even after using all the queries.
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 * 1 <= queries.length <= 10^5
 * queries[i].length == 2
 * 0 <= li <= ri < nums.length
 * 
 * TAG: 20250522
 * TAG: medium
 * TAG: arrays
 * TAG: heap
 */
public class ZeroArrayTransformationIII {
	class Solution { // O(N + M * log(M)), O(M), N - nums.length, M - queries.length
		public int maxRemoval(int[] nums, int[][] queries) {
			int n = nums.length;
			int m = queries.length;
			Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
			PriorityQueue<Integer> newElems = new PriorityQueue<>(
					Collections.reverseOrder());
			PriorityQueue<Integer> oldElems = new PriorityQueue<>();
			int index = 0, count = 0;
			for (int i = 0; i < n; i++) {
				while (!oldElems.isEmpty() && oldElems.peek() < i) {
					oldElems.poll();
				}
				while (index < m && queries[index][0] <= i) {
					newElems.add(queries[index++][1]);
				}
				while (oldElems.size() < nums[i] && !newElems.isEmpty() 
						&& newElems.peek() >= i) {
					oldElems.add(newElems.poll());
					count++;
				}
				if (oldElems.size() < nums[i]) {
					return -1;
				}
			}
			return m - count; 
		}
	}
}
