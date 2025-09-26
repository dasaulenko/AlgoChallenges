package com.hramn.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 3479. Fruits Into Baskets III
 * https://leetcode.com/problems/fruits-into-baskets-iii/description
 * 
 * You are given two arrays of integers, fruits and baskets, each of length n, 
 * where fruits[i] represents the quantity of the ith type of fruit, and 
 * baskets[j] represents the capacity of the jth basket.
 * 
 * From left to right, place the fruits according to these rules:
 * - Each fruit type must be placed in the leftmost available basket with 
 *   a capacity greater than or equal to the quantity of that fruit type.
 * - Each basket can hold only one type of fruit.
 * - If a fruit type cannot be placed in any basket, it remains unplaced.
 * 
 * Return the number of fruit types that remain unplaced after all possible 
 * allocations are made.
 * 
 * Example 1:
 * Input: fruits = [4,2,5], baskets = [3,5,4]
 * Output: 1
 * Explanation:
 * - fruits[0] = 4 is placed in baskets[1] = 5.
 * - fruits[1] = 2 is placed in baskets[0] = 3.
 * - fruits[2] = 5 cannot be placed in baskets[2] = 4.
 * Since one fruit type remains unplaced, we return 1.
 * 
 * Example 2:
 * Input: fruits = [3,6,1], baskets = [6,4,7]
 * Output: 0
 * Explanation:
 * - fruits[0] = 3 is placed in baskets[0] = 6.
 * - fruits[1] = 6 cannot be placed in baskets[1] = 4 (insufficient capacity) 
 *   but can be placed in the next available basket, baskets[2] = 7.
 * - fruits[2] = 1 is placed in baskets[1] = 4.
 * Since all fruits are successfully placed, we return 0.
 * 
 * Constraints:
 * n == fruits.length == baskets.length
 * 1 <= n <= 10^5
 * 1 <= fruits[i], baskets[i] <= 10^9
 * 
 * TAG: 20250810
 * TAG: medium
 * TAG: decomposition
 */
public class FruitsIntoBasketsIII {

	public static void main (String[] args) {
		FruitsIntoBasketsIII task = new FruitsIntoBasketsIII();
		FruitsIntoBasketsIII.Solution solution = task.new Solution();
		int result = solution.numOfUnplacedFruits(new int[] {3,6,1}, new int[] {6,4,7});
		System.out.println(result);
	}

	class Solution { // O(N^2), O(sqrt(N)) where N = fruits.length = baskets.length
		public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
			int n = baskets.length;
			int m = (int)Math.sqrt(n);
			List<Integer> maxValueInSector = new ArrayList<>();

			int count = 0;
			int maxValue = 0;
			for (int i = 0; i < n; i++) {
				if (count == m) {
					maxValueInSector.add(maxValue);
					count = 1;
					maxValue = baskets[i];
				} else {
					count++;
					maxValue = Math.max(maxValue, baskets[i]);
				}
			}
			maxValueInSector.add(maxValue);

			int placed = 0;
			for (int f : fruits) {
				for (int i = 0; i < maxValueInSector.size(); i++) {
					if (maxValueInSector.get(i) >= f) {
						maxValue = 0;
						int start = i * m;
						int end = Math.min((i+1) * m, n);
						for (int j = start; j < end; j++) {
							if (baskets[j] >= f) {
								placed++;
								if (baskets[j] == maxValueInSector.get(i)) {
									baskets[j] = 0;
									for (int k = start; k < end; k++) {
										maxValue = Math.max(maxValue, baskets[k]);
									}
									maxValueInSector.set(i, maxValue);
								}
								baskets[j] = 0;
								break;
							}
						}
						break;
					}
				}
			}
			return n - placed;
		}
	}
}
