package com.hramn.algo.sliding_window;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description
 * 
 * 2570. Merge Two 2D Arrays by Summing Values
 * 
 * You are given two 2D integer arrays nums1 and nums2.
 * 
 * - nums1[i] = [id(i), val(i)] indicate that the number with the id id(i) has a 
 *   value equal to val(i).
 * - nums2[i] = [id(i), val(i)] indicate that the number with the id id(i) has a 
 *   value equal to val(i).
 * 
 * Each array contains unique ids and is sorted in ascending order by id.
 * 
 * Merge the two arrays into one array that is sorted in ascending order by id, 
 * respecting the following conditions:
 * 
 * - Only ids that appear in at least one of the two arrays should be included 
 *   in the resulting array.
 * - Each id should be included only once and its value should be the sum of 
 *   the values of this id in the two arrays. If the id does not exist in one 
 *   of the two arrays, then assume its value in that array to be 0.
 * 
 * Return the resulting array. The returned array must be sorted in ascending order by id.
 * 
 * Example 1:
 * Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
 * Output: [[1,6],[2,3],[3,2],[4,6]]
 * Explanation: The resulting array contains the following:
 * - id = 1, the value of this id is 2 + 4 = 6.
 * - id = 2, the value of this id is 3.
 * - id = 3, the value of this id is 2.
 * - id = 4, the value of this id is 5 + 1 = 6.
 * 
 * Example 2:
 * Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
 * Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
 * Explanation: There are no common ids, so we just include each id with its 
 * value in the resulting list.
 * 
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 200
 * nums1[i].length == nums2[j].length == 2
 * 1 <= idi, vali <= 1000
 * Both arrays contain unique ids.
 * Both arrays are in strictly ascending order by id.
 */
public class MergeTwo2DArraysBySummingValues {
	class TwoPointersSolution { // O(M + N), O(M + N)
		public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
			List<int[]> resultList = new ArrayList<>();
			int i =0, j = 0;
			while (i < nums1.length && j < nums2.length) {
				int id1 = nums1[i][0], val1 = nums1[i][1];
				int id2 = nums2[j][0], val2 = nums2[j][1];
				if (id1 < id2) {
					resultList.add(new int[]{id1, val1});
					i++;
				} else if (id2 < id1) {
					resultList.add(new int[]{id2, val2});
					j++;
				} else {
					resultList.add(new int[]{id1, val1 + val2});
					i++;
					j++;
				}
			}

			while (i < nums1.length) {
				resultList.add(nums1[i]);
				i++;
			}

			while (j < nums2.length) {
				resultList.add(nums2[j]);
				j++;
			}

			int[][] result = new int[resultList.size()][2];
			for (int k = 0; k < resultList.size(); k++) {
				result[k] = resultList.get(k);
			}
			return result;
		}
	}

	class TreeMapSolution { // O((M + N) * log(M + N)), O(M + N)
		public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
			Map<Integer, Integer> idToValue = new TreeMap<>();
			int i =0, j = 0;
			while (i < nums1.length || j < nums2.length) {
				if (i < nums1.length) {
					int val = idToValue.getOrDefault(nums1[i][0], 0);
					idToValue.put(nums1[i][0], val + nums1[i][1]);
					i++;
				}
				if (j < nums2.length) {
					int val = idToValue.getOrDefault(nums2[j][0], 0);
					idToValue.put(nums2[j][0], val + nums2[j][1]);
					j++;
				}
			}
			int[][] result = new int[idToValue.size()][2];
			i = 0;
			for (int id : idToValue.keySet()) {
				result[i][0] = id;
				result[i][1] = idToValue.get(id);
				i++;
			}
			return result;
		}
	}
}
