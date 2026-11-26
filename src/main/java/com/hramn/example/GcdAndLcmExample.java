package com.hramn.example;

/**
 *
 * Важное свойство: a * b = GCM(a, b) * LCM(a, b)
 */
public class GcdAndLcmExample {
	private GcdAndLcmExample() {
		/* This utility class should not be instantiated */
	}

	/**
	 * Greatest Common Divisor (GCD)
	 * The largest positive integer that divides both numbers without leaving a
	 * remainder.
	 *
	 * @param a
	 * @param b
	 * @return the greatest common divisor of two numbers
	 */
	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public static long gcd(int[] nums) {
		long result = 0;

		for (int num : nums) {
			result = gcd(result, num);

			if (result == 1)
				break;
		}

		return result;
	}

	/**
	 * Least Common Multiple (LCM)
	 * The smallest positive integer that is divisible by both numbers without a
	 * remainder.
	 *
	 * @param a
	 * @param b
	 * @return the least common multiple of two numbers
	 */
	public static long lcm(int a, int b) {
		return (long) (a / gcd(a, b)) * b;
	}

	public static long lcm(long a, long b) {
		return (a / gcd(a, b)) * b;
	}

	public static long lcm(int[] nums) {
		long result = 1;

		for (int num : nums) {
			result = lcm(result, num);
			if (result == 0)
				break;
		}

		return result;
	}

}
