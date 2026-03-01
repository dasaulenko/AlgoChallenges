package com.hramn.algo;
/**
 * 837. New 21 Game
 * https://leetcode.com/problems/new-21-game/description
 * 
 * Alice plays the following game, loosely based on the card game "21".
 * 
 * Alice starts with 0 points and draws numbers while she has less than 
 * k points. During each draw, she gains an integer number of points randomly 
 * from the range [1, maxPts], where maxPts is an integer. 
 * Each draw is independent and the outcomes have equal probabilities.
 * 
 * Alice stops drawing numbers when she gets k or more points.
 * 
 * Return the probability that Alice has n or fewer points.
 * 
 * Answers within 10^(-5) of the actual answer are considered accepted.
 * 
 * Example 1:
 * Input: n = 10, k = 1, maxPts = 10
 * Output: 1.00000
 * Explanation: Alice gets a single card, then stops.
 * 
 * Example 2:
 * Input: n = 6, k = 1, maxPts = 10
 * Output: 0.60000
 * Explanation: Alice gets a single card, then stops.
 * In 6 out of 10 possibilities, she is at or below 6 points.
 * 
 * Example 3:
 * Input: n = 21, k = 17, maxPts = 10
 * Output: 0.73278
 * 
 * Constraints:
 * 0 <= k <= n <= 10^4
 * 1 <= maxPts <= 10^4
 * 
 * TAG: 20250817
 * TAG: medium
 * TAG: probability
 * TAG: climbing_stairs
 * TAG: running_sum
 * TAG: window
 */
public class New21Game {
	/*
	 * - Alice starts at 0.
	 * - Each turn she draws uniformly from [1..mx].
	 * - She must stop once her points ≥ k.
	 * - We want the probability her final score ≤ n.
	 */

	// At first glance, this looks similar to dynamic programming on 
	// probabilities because the outcome of each draw depends on the results of 
	// previous draws.
	// - Let dp[i] = probability of reaching exactly score i.
	// - To get dp[i], Alice could have come from the last mx scores:
	// dp[0] = 1 // the probability of reaching 0 points
  // dp[i] = (dp[i-1] + dp[i-2] + ... + dp[0]) / maxPts

	// The key idea is that the probability of reaching a score i can be derived 
	// from the probabilities of reaching earlier scores within a sliding 
	// window of size maxPts.

	// Instead of recalculating probabilities for each range repeatedly, we 
	// maintain a running sum of the last maxPts probabilities, which allows us 
	// to update efficiently. This way, we can build probabilities step by step 
	// and finally add up the ones that represent valid outcomes (scores between 
	// K and N).
	class Solution { // O(N), O(M) where N = n, M = maxPts
		public double new21Game(int n, int k, int maxPts) {
			// Special Cases
			if (k == 0 || n >= k + maxPts) return 1.0;

			double[] dp = new double[maxPts];
			dp[0] = 1.0;
			double windowSum = 1.0, result = 0.0;

			for (int i = 1; i <= n; i++) {
				double prob = windowSum / maxPts;

				// If i < K, Alice can still draw more, so we add this probability into 
				// windowSum.
				if (i < k) {
					windowSum += prob;
				} else { // If i >= K, Alice stops drawing, so we add this probability to the final result.
					result += prob;
				}

				// To maintain the window size, if i >= maxPts, we remove the oldest 
				// probability from windowSum.
				if (i >= maxPts) {
					windowSum -= dp[i % maxPts];
				}

				dp[i % maxPts] = prob;
			}

			return result;
		}
	}
}
