package com.hramn.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 2438. Range Product Queries of Powers
 * https://leetcode.com/problems/range-product-queries-of-powers/description
 * 
 * Given a positive integer n, there exists a 0-indexed array called powers, 
 * composed of the minimum number of powers of 2 that sum to n. The array is 
 * sorted in non-decreasing order, and there is only one way to form the array.
 * 
 * You are also given a 0-indexed 2D integer array queries, where 
 * queries[i] = [lefti, righti]. Each queries[i] represents a query where you 
 * have to find the product of all powers[j] with lefti <= j <= righti.
 * 
 * Return an array answers, equal in length to queries, where answers[i] is 
 * the answer to the ith query. Since the answer to the ith query may be too 
 * large, each answers[i] should be returned modulo 109 + 7.
 * 
 * Example 1:
 * Input: n = 15, queries = [[0,1],[2,2],[0,3]]
 * Output: [2,4,64]
 * Explanation:
 * For n = 15, powers = [1,2,4,8]. It can be shown that powers cannot be 
 * a smaller size.
 * Answer to 1st query: powers[0] * powers[1] = 1 * 2 = 2.
 * Answer to 2nd query: powers[2] = 4.
 * Answer to 3rd query: powers[0] * powers[1] * powers[2] * powers[3] = 
 * 1 * 2 * 4 * 8 = 64.
 * Each answer modulo 109 + 7 yields the same answer, so [2,4,64] is returned.
 * 
 * Example 2:
 * Input: n = 2, queries = [[0,0]]
 * Output: [2]
 * Explanation:
 * For n = 2, powers = [2].
 * The answer to the only query is powers[0] = 2. The answer modulo 109 + 7 is 
 * the same, so [2] is returned.
 * 
 * Constraints:
 * 1 <= n <= 10^9
 * 1 <= queries.length <= 10^5
 * 0 <= starti <= endi < powers.length
 * 
 * TAG: 20250811
 * TAG: medium
 * TAG: product_prefix
 * TAG: powers_of_2
 */
public class RangeProductQueriesOfPowers {
	class MySolution { // O(N^2), O(1)
		public int[] productQueries(int n, int[][] queries) {
			// Create list of powers of 2 with max value less than n
			List<Integer> powers = new ArrayList<>();
			if (n == 1) {
				powers.add(1);
			} else {
				long cur = 1;
				while (cur <= n) {
					powers.add((int)cur);
					cur = cur * 2;
				}
				cur = n;
				int index = powers.size()-1;
				while (index >= 0) {
					if (powers.get(index) <= cur) {
						cur -= powers.get(index);
					} else {
						powers.remove(index);
					}
					index--;
				}
			}

			int[] result = new int[queries.length];
			int index = 0;
			for (int[] q : queries) {
				if (q[0] == q[1]) {
					result[index] = powers.get(q[0]);
				} else {
					result[index] = powers.get(q[0]);
					for (int i = q[0]+1; i <= q[1]; i++) {
						result[index] = mod((long)result[index] * powers.get(i));
					}
				}
				index++;
			}
			return result;
		}

		private int mod(long val) {
			return (int)(val % 1_000_000_007);
		}
	}

	class BestTimeSolution { // O(N), O(1)
		public int[] productQueries(int n, int[][] queries) {
			int power = 1, MOD = (int) 1e9 + 7;
			while (power <= n) power <<= 1;
			power >>= 1;
			List<Integer> powers = new ArrayList<>();
			while (n > 0) {
				if (power <= n) {
					powers.add(power);
					n -= power;
				}
				power >>= 1;
			}

			n = powers.size();
			int[][] prefix = new int[n][n];
			for (int i = 0; i < n; i++) {
				prefix[i][i] = powers.get(n - 1 - i);
				for (int j = i + 1; j < n; j++)
					prefix[i][j] = (int)((1L * prefix[i][j - 1] * powers.get(n - 1 - j)) % MOD);
			}

			int[] res = new int[queries.length];
			for (int i = 0; i < queries.length; i++)
				res[i] = prefix[queries[i][0]][queries[i][1]];

			return res;
		}
	}
}
