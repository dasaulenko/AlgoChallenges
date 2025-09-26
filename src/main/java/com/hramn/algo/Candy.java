package com.hramn.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 135. Candy
 * https://leetcode.com/problems/candy/description
 * 
 * There are n children standing in a line. Each child is assigned a rating 
 * value given in the integer array ratings.
 * 
 * You are giving candies to these children subjected to the following 
 * requirements:
 * - Each child must have at least one candy.
 * - Children with a higher rating get more candies than their neighbors.
 * 
 * Return the minimum number of candies you need to have to distribute 
 * the candies to the children.
 * 
 * Example 1:
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 
 * 2, 1, 2 candies respectively.
 * 
 * Example 2:
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 
 * 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 * 
 * Constraints:
 * n == ratings.length
 * 1 <= n <= 2 * 10^4
 * 0 <= ratings[i] <= 2 * 10^4
 * 
 * TAG: 20250602
 * TAG: hard
 * TAG: TreeMap
 */
public class Candy {
	class Solution { // O(N), O(N)
		public int candy(int[] ratings) {
			int n = ratings.length;
			int[] children = new int[n];
			children[0] = 1;
			for (int i = 1; i < n; i++) {
				if (ratings[i] > ratings[i-1]) {
					children[i] = children[i-1] + 1;
				} else {
					children[i] = 1;
				}
			}
			int counter = children[n-1];
			for (int i = n-2; i >= 0; i--) {
				if (ratings[i] > ratings[i+1]) {
					children[i] = Math.max(children[i], children[i+1] + 1);
				}
				counter += children[i];
			}
			return counter;
		}
	}

	class TreeMapSolution {
		public int candy(int[] ratings) { // O(N * log(N)), O(N)
			int n = ratings.length;
			Map<Integer, List<Integer>> ratToInd = new TreeMap<>();
			int[] children = new int[n];
			for (int i = 0; i < n; i++) {
				int r = ratings[i];
				List<Integer> list = ratToInd.getOrDefault(r, new ArrayList<>());
				list.add(i);
				ratToInd.put(r, list);
			}
			int counter = 0;
			for (int i : ratToInd.keySet()) {
				for (int j : ratToInd.get(i)) {
					int l = (j != 0 && ratings[j-1] != i && children[j-1] > 0) ? 
							children[j-1] : 0;
					int r = (j != n - 1 && ratings[j+1] != i && children[j+1] > 0) ? 
							children[j+1] : 0;
					int cnt = Math.max(l, r) + 1;
					children[j] = cnt;
					counter += cnt;
				}
			}
			return counter;
		}
	}
}
