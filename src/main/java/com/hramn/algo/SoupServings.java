package com.hramn.algo;
/**
 * 808. Soup Servings
 * https://leetcode.com/problems/soup-servings/description
 * 
 * You have two soups, A and B, each starting with n mL. On every turn, one of 
 * the following four serving operations is chosen at random, each with 
 * probability 0.25 independent of all previous turns:
 * - pour 100 mL from type A and 0 mL from type B
 * - pour 75 mL from type A and 25 mL from type B
 * - pour 50 mL from type A and 50 mL from type B
 * - pour 25 mL from type A and 75 mL from type B
 * 
 * Note:
 * 
 * - There is no operation that pours 0 mL from A and 100 mL from B.
 * - The amounts from A and B are poured simultaneously during the turn.
 * - If an operation asks you to pour more than you have left of a soup, pour 
 *   all that remains of that soup.
 * - The process stops immediately after any turn in which one of 
 *   the soups is used up.
 * 
 * Return the probability that A is used up before B, plus half the probability 
 * that both soups are used up in the same turn. Answers within 10^-5 of 
 * the actual answer will be accepted.
 * 
 * Example 1:
 * Input: n = 50
 * Output: 0.62500
 * Explanation: 
 * - If we perform either of the first two serving operations, soup A will 
 *   become empty first.
 * - If we perform the third operation, A and B will become empty at the same 
 *   time.
 * - If we perform the fourth operation, B will become empty first.
 * So the total probability of A becoming empty first plus half the probability 
 * that A and B become empty at the same time, is 
 * 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
 * 
 * Example 2:
 * Input: n = 100
 * Output: 0.71875
 * Explanation: 
 * - If we perform the first serving operation, soup A will become empty first.
 * - If we perform the second serving operations, A will become empty on 
 *   performing operation [1, 2, 3], and both A and B become empty on 
 *   performing operation 4.
 * - If we perform the third operation, A will become empty on performing 
 *   operation [1, 2], and both A and B become empty on performing operation 3.
 * - If we perform the fourth operation, A will become empty on performing 
 *   operation 1, and both A and B become empty on performing operation 2.
 * So the total probability of A becoming empty first plus half the probability 
 * that A and B become empty at the same time, is 0.71875.
 * 
 * Constraints:
 * 0 <= n <= 10^9
 * 
 * TAG: 20250808
 * TAG: medium
 * TAG: dfs
 * TAG: probability
 */
public class SoupServings {
	class Solution { // O(N^2), O(N^2)
		public double soupServings(int n) {
			// Large n Optimization
			// For large n, the probability approaches 1.0 quickly.
			// We can safely return 1.0 if n > 5000 without losing accuracy (error < 1e-5).
			if (n > 5000) return 1.0;

			// Unit Conversion
			// All serving amounts are multiples of 25 mL.
			// We can sczale down the problem by dividing n by 25.
			// Example: n = 50 → m = 2 units of 25 mL each.
			int units = (int) Math.ceil(n / 25.0); // Convert mL → 25 mL units

			// Memoization
			// We avoid recalculating states (a, b) by storing results in a Double[][] dp.
			Double[][] cache = new Double[units + 1][units + 1];

			// Use DFS with memoization to recursively compute probabilities.
			return calcProb(units, units, cache);
		}

		private double calcProb(int soupA, int soupB, Double[][] cache) {
			// Base Cases
			// A ≤ 0 and B ≤ 0 → Both empty → return 0.5
			// A ≤ 0 and B > 0 → A empty first → return 1.0
			// B ≤ 0 and A > 0 → B empty first → return 0.0

			// Both soups empty → half probability
			if (soupA <= 0 && soupB <= 0) return 0.5;
			// A empty first
			if (soupA <= 0) return 1.0;
			// B empty first
			if (soupB <= 0) return 0.0;

			// If already computed, return cached result
			if (cache[soupA][soupB] != null) return cache[soupA][soupB];

			// Calculate and store probability
			double prob = 0.25 * (
				calcProb(soupA - 4, soupB, cache) +
				calcProb(soupA - 3, soupB - 1, cache) +
				calcProb(soupA - 2, soupB - 2, cache) +
				calcProb(soupA - 1, soupB - 3, cache)
			);

			cache[soupA][soupB] = prob;
			return prob;
		}
	}
}
