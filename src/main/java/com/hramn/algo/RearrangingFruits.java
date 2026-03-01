package com.hramn.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2561. Rearranging Fruits
 * https://leetcode.com/problems/rearranging-fruits/description
 * 
 * You have two fruit baskets containing n fruits each. You are given two 
 * 0-indexed integer arrays basket1 and basket2 representing the cost of fruit 
 * in each basket. You want to make both baskets equal. To do so, you can use 
 * the following operation as many times as you want:
 * - Choose two indices i and j, and swap the ith fruit of basket1 with the jth 
 *   fruit of basket2.
 * - The cost of the swap is min(basket1[i], basket2[j]).
 * 
 * Two baskets are considered equal if sorting them according to the fruit cost 
 * makes them exactly the same baskets.
 * 
 * Return the minimum cost to make both the baskets equal or -1 if impossible.
 * 
 * Example 1:
 * Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
 * Output: 1
 * Explanation: Swap index 1 of basket1 with index 0 of basket2, which has 
 * cost 1. Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both 
 * the arrays makes them equal.
 * 
 * Example 2:
 * Input: basket1 = [2,3,4,1], basket2 = [3,2,5,1]
 * Output: -1
 * Explanation: It can be shown that it is impossible to make both the baskets 
 * equal.
 * 
 * Constraints:
 * basket1.length == basket2.length
 * 1 <= basket1.length <= 10^5
 * 1 <= basket1[i], basket2[i] <= 10^9
 * 
 * TAG: 20250802
 * TAG: hard
 * TAG: heap
 * TAG: array
 */
public class RearrangingFruits {
	class Solution { // O(N), O(N)
		public long minCost(int[] basket1, int[] basket2) {
			int n = basket1.length;
			Map<Integer, int[]> fruitCounter = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int[] arr1 = fruitCounter.getOrDefault(basket1[i], new int[3]);
				arr1[0] = basket1[i];
				arr1[1]++;
				fruitCounter.put(basket1[i], arr1);
				int[] arr2 = fruitCounter.getOrDefault(basket2[i], new int[3]);
				arr2[0] = basket2[i];
				arr2[2]++;
				fruitCounter.put(basket2[i], arr2);
			}
			int balance = 0;
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			int minCost = Integer.MAX_VALUE;
			for (int key : fruitCounter.keySet()) {
				int[] fruit = fruitCounter.get(key);
				minCost = Math.min(minCost, fruit[0]);
				int def = fruit[1] - fruit[2];
				if (def % 2 != 0) {
					return -1;
				}
				balance += def / 2; // 2 + 1
				for (int i = 0; i < Math.abs(def) / 2; i++) minHeap.add(fruit[0]);
			}
			if (balance != 0) {
				return -1;
			}
			long result = 0;
			int lim = minHeap.size() / 2;
			for (int i = 0; i < lim; i++) {
				int cost = minHeap.poll();
				if (cost <= minCost * 2) {
					result += cost;
				} else {
					result += minCost*2;
				}
			}
			return result;
		}
	}
}
