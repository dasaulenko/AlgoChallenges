package com.hramn.algo;
/**
 * <strong>3789. Minimum Cost to Acquire Required Items</strong>
 * 
 * <p>Difficulty: Medium
 * <br>Topics: Staff, Math, Greedy
 * 
 * <p>LeetCode: 
 * <a href="https://leetcode.com/problems/minimum-cost-to-acquire-required-items/">
 * Minimum Cost to Acquire Required Items</a>
 * 
 * <h3>Problem Description</h3>
 * 
 * <p>You are given five integers {@code cost1}, {@code cost2}, 
 * {@code costBoth}, {@code need1}, and {@code need2}.
 * 
 * <p>There are three types of items available:
 * 
 * <ul>
 * 	<li>An item of type 1 costs cost1 and contributes 1 unit to the type 1 
 * 			requirement only.</li>
 * 	<li>An item of type 2 costs cost2 and contributes 1 unit to the type 2 
 * 			requirement only.</li>
 * 	<li>An item of type 3 costs costBoth and contributes 1 unit to both type 1 
 * 			and type 2 requirements.</li>
 * </ul>
 * 
 * <p>You must collect enough items so that the total contribution toward 
 * type 1 is at least {@code need1} and the total contribution toward type 2 is at 
 * least {@code need2}.
 * 
 * <p>Return an integer representing the minimum possible total cost to achieve 
 * these requirements.
 * 
 * <h3>Examples</h3>
 * 
 * <p><strong>Example 1:</strong>
 * <pre>{@code
 * Input: cost1 = 3, cost2 = 2, costBoth = 1, need1 = 3, need2 = 2
 * Output: 3
 * 
 * Explanation:
 * After buying three type 3 items, which cost 3 * 1 = 3, 
 * the total contribution to type 1 is 3 (>= need1 = 3) 
 * and to type 2 is 3 (>= need2 = 2).
 * Any other valid combination would cost more, so the minimum total cost is 3.
 * }</pre>
 * 
 * <p><strong>Example 2:</strong>
 * <pre>{@code
 * Input: cost1 = 5, cost2 = 4, costBoth = 15, need1 = 2, need2 = 3
 * Output: 22
 * 
 * Explanation:
 * We buy need1 = 2 items of type 1 and need2 = 3 items of type 2: 
 * 2 * 5 + 3 * 4 = 10 + 12 = 22.
 * Any other valid combination would cost more, so the minimum total cost is 22.
 * }</pre>
 * 
 * <p><strong>Example 3:</strong>
 * <pre>{@code
 * Input: cost1 = 5, cost2 = 4, costBoth = 15, need1 = 0, need2 = 0
 * Output: 0
 * Explanation:
 * Since no items are required (need1 = need2 = 0), we buy nothing and pay 0.
 * }</pre>
 * 
 * <h3>Constraints:</h3>
 * <pre>{@code
 * 1 <= cost1, cost2, costBoth <= 10⁶
 * 0 <= need1, need2 <= 10⁹
 * }</pre>
 */
public class MinimumCostToAcquireRequiredItems {
	static class Solution {
		public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
			if (costBoth > cost1 + cost2) costBoth = cost1 + cost2;
			if (costBoth < cost1) cost1 = costBoth;
			if (costBoth < cost2) cost2 = costBoth;

			int minNeed = Math.min(need1, need2);
			long totalCost = (long)minNeed * costBoth;

			if (need1 > need2) totalCost += (need1 - need2) * (long)cost1;
			if (need1 < need2) totalCost += (need2 - need1) * (long)cost2;

			return totalCost;
		}
	}
}
