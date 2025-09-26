package com.hramn.algo;
/**
 * 2929. Distribute Candies Among Children II
 * http://leetcode.com/problems/distribute-candies-among-children-ii/description
 * 
 * You are given two positive integers n and limit.
 * 
 * Return the total number of ways to distribute n candies among 3 children 
 * such that no child gets more than limit candies.
 * 
 * Example 1:
 * Input: n = 5, limit = 2
 * Output: 3
 * Explanation: There are 3 ways to distribute 5 candies such that no child 
 * gets more than 2 candies: (1, 2, 2), (2, 1, 2) and (2, 2, 1).
 * 
 * Example 2:
 * Input: n = 3, limit = 3
 * Output: 10
 * Explanation: There are 10 ways to distribute 3 candies such that no child 
 * gets more than 3 candies: (0, 0, 3), (0, 1, 2), (0, 2, 1), (0, 3, 0), 
 * (1, 0, 2), (1, 1, 1), (1, 2, 0), (2, 0, 1), (2, 1, 0) and (3, 0, 0).
 * 
 * Constraints:
 * 1 <= n <= 10^6
 * 1 <= limit <= 10^6
 * 
 * TAG: 20250601
 * TAG: medium
 * TAG: distribute
 * TAG: combinatorics
 */
public class DistributeCandiesAmongChildrenII {
	class EnumerationSolution { // O(N), O(1), N - n
		public long distributeCandies(int n, int limit) {
			long result = 0;
			if ((n / limit > 3) || (n / limit == 3 && n % limit > 0)) {
				return 0;
			}
			for (int i = 0; i <= Math.min (limit, n); i++) {
				if (n - i <= 2 * limit) {
					result += Math.min (n - i, limit) - Math.max (0, n - i - limit) + 1;
				}
			}
			return result;
		}
	}

	class CombinatoricsSolution { // O(1), O(1), 
		public long distributeCandies(int n, int limit) {
			long res = ((long)n + 2) * (n + 1) / 2;
			for (int i = 1; i <= 3; i++) {
				long rem = n - (long)i * (limit + 1);
				if (rem < 0) break;
				long val = (rem + 2) * (rem + 1) / 2;
				long c = (i < 3 ? 3 : 1);
				res += (i % 2 != 0 ? -c * val : c * val);
			}
			return res;
		}
	}

	class BestSolution { // O(1), O(1)
		public long distributeCandies(int n, int limit) {
			return totalWays(n) 
				- 3 * totalWays(n - (limit + 1))
				+ 3 * totalWays(n - 2 * (limit + 1))
				- totalWays(n - 3 * (limit + 1));
		}

		private long totalWays(long sum) {
			if (sum < 0) return 0;
			return (sum + 2) * (sum + 1) / 2;
		}
	}
}
