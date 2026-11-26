package com.hramn.algo.easy;

/**
 * <strong>3411. Maximum Subarray With Equal Products</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Easy
 * <br>
 * <strong>LeetCode:</strong> <a href=
 * "https://leetcode.com/problems/maximum-subarray-with-equal-products/">
 * 3411. Maximum Subarray With Equal Products</a>
 * <br>
 * <strong>Topic:</strong> array, math, sliding window, lcm, gcd
 *
 * <hr>
 *
 * <p>
 * You are given an array of positive integers {@code nums}.
 *
 * <p>
 * An array {@code arr} is called product equivalent if
 * {@code prod(arr) == lcm(arr) * gcd(arr)}, where:
 * <ul>
 * <li>{@code prod(arr)} is the product of all elements of {@code arr}.</li>
 * <li>{@code gcd(arr)} is the GCD of all elements of {@code arr}.</li>
 * <li>{@code lcm(arr)} is the LCM of all elements of {@code arr}.</li>
 * </ul>
 * <p>
 * Return the length of the longest product equivalent subarray of {@code nums}.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code nums = [1,2,1,2,1,1,1]}
 * <p>
 * Output: {@code 5}
 * <p>
 * Explanation:
 * <br>
 * The longest product equivalent subarray is {@code [1, 2, 1, 1, 1]}, where
 * {@code prod([1, 2, 1, 1, 1]) = 2}, {@code gcd([1, 2, 1, 1, 1]) = 1}, and
 * {@code lcm([1, 2, 1, 1, 1]) = 2}.
 *
 * <p>
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code nums = [2,3,4,5,6]}
 * <p>
 * Output: {@code 3}
 * <p>
 * Explanation:
 * <br>
 * The longest product equivalent subarray is {@code [3, 4, 5]}.
 *
 * <p>
 * <strong>Example 3:</strong>
 * <p>
 * Input: {@code nums = [1,2,3,1,4,5,1]}
 * <p>
 * Output: {@code 5}
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>{@code 2 <= nums.length <= 100}</li>
 * <li>{@code 1 <= nums[i] <= 10}</li>
 * </ul>
 */
public class MaximumSubarrayWithEqualProducts {
	private MaximumSubarrayWithEqualProducts() {
		/* This utility class should not be instantiated */
	}

	/**
	 * Brute Force + GCD + LCM + early termination
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	static class BruteForceSolution {
		public int maxLength(int[] nums) {
			int n = nums.length;

			// a * b = GCM(a, b) * LCM(a, b)
			int result = 2;

			int max = 1;
			for (int i = 2; i <= 10; i++) {
				max *= i;
			}
			for (int i = 0; i < n && n - i > result; i++) {
				int prod = 1;
				int gcd = 0;
				int lcm = 1;
				for (int j = i; j < n; j++) {
					prod *= nums[j];
					if (prod > max) {
						break;
					}
					gcd = gcd(gcd, nums[j]);
					lcm = lcm(lcm, nums[j]);
					if (prod == gcd * lcm)
						result = Math.max(result, j - i + 1);
				}
			}
			return result;
		}

		private int gcd(int a, int b) {
			while (b != 0) {
				int temp = b;
				b = a % b;
				a = temp;
			}
			return a;
		}

		private int lcm(int a, int b) {
			return a / gcd(a, b) * b;
		}
	}

	/**
	 * Sliding Window + GCD
	 * Time: O(n log M), where M - max possible value of nums[i]
	 * Space: O(1)
	 */
	static class SlidingWindowSolution {

		public int maxLength(int[] nums) {
			int result = 2;
			int left = 0;
			int prod = 1;

			for (int right = 0; right < nums.length; right++) {

				while (gcd(prod, nums[right]) != 1) {
					prod /= nums[left];
					left++;
				}

				prod *= nums[right];

				result = Math.max(result, right - left + 1);
			}

			return result;
		}

		private int gcd(int a, int b) {
			while (b != 0) {
				int temp = b;
				b = a % b;
				a = temp;
			}
			return a;
		}
	}

	/**
	 * Sliding Window + Bitmask
	 * Time: O(n)
	 * Space: O(1)
	 */
	static class BitmaskSolution {

		public int maxLength(int[] nums) {
			int[] masks = buildMasks();

			int result = 2;
			int left = 0;
			int used = 0;

			for (int right = 0; right < nums.length; right++) {
				int mask = masks[nums[right]];

				while ((used & mask) != 0) {
					used ^= masks[nums[left]];
					left++;
				}

				used |= mask;

				result = Math.max(result, right - left + 1);
			}

			return result;
		}

		private int[] buildMasks() {
			int[] primes = { 2, 3, 5, 7 };
			int[] masks = new int[11];

			for (int num = 1; num <= 10; num++) {
				for (int i = 0; i < primes.length; i++) {
					if (num % primes[i] == 0) {
						masks[num] |= 1 << i;
					}
				}
			}

			return masks;
		}
	}
}
