package com.hramn.algo;
/**
 * 2106. Maximum Fruits Harvested After at Most K Steps
 * https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/description
 * 
 * Fruits are available at some positions on an infinite x-axis. You are given 
 * a 2D integer array fruits where fruits[i] = [positioni, amounti] depicts 
 * amounti fruits at the position positioni. fruits is already sorted by 
 * positioni in ascending order, and each positioni is unique.
 * 
 * You are also given an integer startPos and an integer k. Initially, 
 * you are at the position startPos. From any position, you can either walk to 
 * the left or right. It takes one step to move one unit on the x-axis, and 
 * you can walk at most k steps in total. For every position you reach, 
 * you harvest all the fruits at that position, and the fruits will disappear 
 * from that position.
 * 
 * Return the maximum total number of fruits you can harvest.
 * 
 * Example 1:
 * Input: fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
 * Output: 9
 * Explanation: 
 * The optimal way is to:
 * - Move right to position 6 and harvest 3 fruits
 * - Move right to position 8 and harvest 6 fruits
 * You moved 3 steps and harvested 3 + 6 = 9 fruits in total.
 * 
 * Example 2:
 * Input: fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4
 * Output: 14
 * Explanation: 
 * You can move at most k = 4 steps, so you cannot reach position 0 nor 10.
 * The optimal way is to:
 * - Harvest the 7 fruits at the starting position 5
 * - Move left to position 4 and harvest 1 fruit
 * - Move right to position 6 and harvest 2 fruits
 * - Move right to position 7 and harvest 4 fruits
 * You moved 1 + 3 = 4 steps and harvested 7 + 1 + 2 + 4 = 14 fruits in total.
 * 
 * Example 3:
 * Input: fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2
 * Output: 0
 * Explanation:
 * You can move at most k = 2 steps and cannot reach any position with fruits.
 * 
 * Constraints:
 * 1 <= fruits.length <= 10^5
 * fruits[i].length == 2
 * 0 <= startPos, positioni <= 2 * 10^5
 * positioni-1 < positioni for any i > 0 (0-indexed)
 * 1 <= amounti <= 10^4
 * 0 <= k <= 2 * 10^5
 * 
 * TAG: hard
 * TAG: sliding_window
 */
public class MaximumFruitsHarvestedAfterAtMostKSteps {
	class MySolution { // O(N), O(1) where N - fruits.length
		public int maxTotalFruits(int[][] fruits, int startPos, int k) {
			int n = fruits.length;
			int l = 0;
			int r = 0;
			int maxSum = 0;
			int sum = fruits[0][1];
			while (r < n) {
				int steps = 0;
				if (l == r) {
					if (fruits[l][0] < startPos) {
						steps = startPos - fruits[l][0];
					} else {
						steps = fruits[r][0] - startPos;
					}
				} else if (fruits[l][0] < startPos && fruits[r][0] < startPos) {
					steps = startPos - fruits[l][0];
				} else if (fruits[l][0] > startPos && fruits[r][0] > startPos) {
					steps = fruits[r][0] - startPos;
				} else {
					int stl = startPos - fruits[l][0];
					int str = fruits[r][0] - startPos;
					if (stl < str) {
						steps = stl * 2 + str;
					} else {
						steps = str * 2 + stl;
					}
				}
				if (steps <= k) {
					maxSum = Math.max(maxSum, sum);
					r++;
					if (r < n) {
						sum += fruits[r][1];
					}
				} else {
					if (l > startPos) {
						break;
					}
					sum -= fruits[l][1];
					l++;
					if (l > r) {
						r = l;
						if (r < n) {
							sum += fruits[l][1];
						}
					}
				}
			}
			return maxSum;
		}
	}

	class BestTimeSolution { // O(log(N) + K), O(1) where N = fruits.length, K = k 
		public int maxTotalFruits(int[][] fruits, int startPos, int k) {
			int length = fruits.length;
			int leftIndex = this.binary(fruits, startPos - k);
			int rightIndex = leftIndex;
			int s = 0;
			while (rightIndex < length && fruits[rightIndex][0] <= startPos) {
				s += fruits[rightIndex][1];
				rightIndex++;
			}
			int ans = s;
			for (int i = rightIndex; i < length && fruits[i][0] <= startPos + k; i++) {
				s += fruits[i][1];
				while (fruits[i][0] * 2 - startPos - fruits[leftIndex][0] > k &&
					startPos + fruits[i][0] - 2 * fruits[leftIndex][0] > k) {
					s -= fruits[leftIndex++][1];
				}
				ans = Math.max(ans, s);
			}
			return ans;
		}

		private int binary(int[][] fruits, int tar) {
			int left = -1;
			int right = fruits.length;
			while (left + 1 < right) {
				int mid = left + (right - left) / 2;
				int index = fruits[mid][0];
				if (index < tar) {
					left = mid;
				} else {
					right = mid;
				}
			}
			return right;
		}
	}
}
