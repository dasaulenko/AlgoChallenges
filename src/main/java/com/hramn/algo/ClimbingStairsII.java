package com.hramn.algo;
/**
 * 3693. Climbing Stairs II
 * 
 * <p>You are climbing a staircase with n + 1 steps, numbered from 0 to n.
 * 
 * <p>You are also given a 1-indexed integer array costs of length n, where 
 * costs[i] is the cost of step i.
 * 
 * <p>From step i, you can jump only to step i + 1, i + 2, or i + 3. The cost of 
 * jumping from step i to step j is defined as: costs[j] + (j - i)²
 * 
 * <p>You start from step 0 with cost = 0.
 * 
 * <p>Return the minimum total cost to reach step n.
 * 
 * <p>Example 1:
 * <pre>
 * Input: n = 4, costs = [1,2,3,4]
 * Output: 13
 * Explanation:
 * One optimal path is 0 → 1 → 2 → 4
 * Jump	Cost Calculation	Cost
 * 0 → 1	costs[1] + (1 - 0)² = 1 + 1	2
 * 1 → 2	costs[2] + (2 - 1)² = 2 + 1	3
 * 2 → 4	costs[4] + (4 - 2)² = 4 + 4	8
 * Thus, the minimum total cost is 2 + 3 + 8 = 13
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: n = 4, costs = [5,1,6,2]
 * Output: 11
 * Explanation:
 * One optimal path is 0 → 2 → 4
 * Jump	Cost Calculation	Cost
 * 0 → 2	costs[2] + (2 - 0)² = 1 + 4	5
 * 2 → 4	costs[4] + (4 - 2)² = 2 + 4	6
 * Thus, the minimum total cost is 5 + 6 = 11
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: n = 3, costs = [9,8,3]
 * Output: 12
 * Explanation:
 * The optimal path is 0 → 3 with total cost = costs[3] + (3 - 0)² = 3 + 9 = 12
 * </pre>
 * 
 * @see <a href="https://leetcode.com/problems/climbing-stairs-ii">
 * 		Link to source
 * </a>
 */
public class ClimbingStairsII {
	class Solution {
		public int climbStairs(int n, int[] costs) {
			int[] dp = new int[n+1];
			dp[0] = 0;
			for (int j = 1; j < n+1; j++) {
				dp[j] = Integer.MAX_VALUE;
				int i = j - 1;
				while(j-i <= 3 && i >= 0) {
					int num = j - i;
					dp[j] = Math.min(dp[j], dp[i] + costs[j-1] + (num * num));
					i--;
				}
			}
			return dp[n];
		}
	}
}
