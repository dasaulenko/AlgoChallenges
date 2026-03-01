package com.hramn.algo.sliding_window;
/**
 * 904. Fruit Into Baskets
 * 
 * You are visiting a farm that has a single row of fruit trees arranged from 
 * left to right. The trees are represented by an integer array fruits where 
 * fruits[i] is the type of fruit the ith tree produces.
 * 
 * You want to collect as much fruit as possible. However, the owner has some 
 * strict rules that you must follow:
 * 
 * You only have two baskets, and each basket can only hold a single type of 
 * fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from 
 * every tree (including the start tree) while moving to the right. The picked 
 * fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must 
 * stop.
 * Given the integer array fruits, return the maximum number of fruits you can 
 * pick.
 * 
 * Example 1:
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * 
 * Example 2:
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * 
 * Example 3:
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 * 
 * Constraints:
 * 1 <= fruits.length <= 10**5
 * 0 <= fruits[i] < fruits.length
 */
// 
public class FruitIntoBaskets {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] fruits = new int[] {1,2,3,2,2};
		System.out.println(solution.totalFruit(fruits));

	}
	
	static class Solution {
		public int totalFruit(int[] fruits) {
			int result = 0;
			int l = 0, r = 0;
			int b1 = -1, b2 = -1;
			int b1_count = 0, b2_count = 0;
			while (r < fruits.length) {
				if (b1 == fruits[r] || b1 == -1) {
					b1 = fruits[r];
					b1_count++;
					result = Math.max(result, b1_count + b2_count);
					r++;
				} else if (b2 == fruits[r] || b2 == -1) {
					b2 = fruits[r];
					b2_count++;
					result = Math.max(result, b1_count + b2_count);
					r++;
				} else {
					if (fruits[l] == b1) {
						b1_count--;
						if (b1_count == 0) {
							b1 = -1;
						}
					} else {
						b2_count--;
						if (b2_count == 0) {
							b2 = -1;
						}
					}
					l++;
				}
			}
			return result;
		}
	}
}

// [1,2,3,2,2]
// 1: l = 0, r = 0, b1 = 1, b1_counter + 1 = 1, result = 1, r + 1 = 1
// 2: l = 0, r = 1, b2 = 2, b2_counter + 1 = 1, result = 2, r + 1 = 2
// 3: l = 0, r = 2, b1_count - 1 = 0, b1 = -1, l + 1 = 1
// 4: l = 1, r = 2, b1 = 3, b1_counter + 1 = 1, result = 2, r + 1 = 3
// 5: l = 1, r = 3, b2_counter + 1 = 2, result = 3, r + 1 = 4
// 6: l = 1, r = 4, b2_counter + 1 = 3, result = 4, r + 1 = 5

