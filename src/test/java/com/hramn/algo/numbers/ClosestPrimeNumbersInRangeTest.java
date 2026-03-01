package com.hramn.algo.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClosestPrimeNumbersInRangeTest {
	@Test
	@DisplayName("left = 10, right = 19 -> [11,13]")
	void testBruteforceSolutionClosestPrimes1() {
		ClosestPrimeNumbersInRange parent = new ClosestPrimeNumbersInRange();
		ClosestPrimeNumbersInRange.BruteforceSolution solution = 
				parent.new BruteforceSolution();
		int[] result = solution.closestPrimes(10, 19);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertEquals(11, result[0]);
		assertEquals(13, result[1]);
	}

	@Test
	@DisplayName("left = 4, right = 6 -> [-1,-1]")
	void testBruteforceSolutionClosestPrimes2() {
		ClosestPrimeNumbersInRange parent = new ClosestPrimeNumbersInRange();
		ClosestPrimeNumbersInRange.BruteforceSolution solution = 
				parent.new BruteforceSolution();
		int[] result = solution.closestPrimes(4, 6);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertEquals(-1, result[0]);
		assertEquals(-1, result[1]);
	}

	@Test
	@DisplayName("left = 10, right = 19 -> [11,13]")
	void testSieveOfEratosthenesSolutionClosestPrimes1() {
		ClosestPrimeNumbersInRange parent = new ClosestPrimeNumbersInRange();
		ClosestPrimeNumbersInRange.SieveOfEratosthenesSolution solution = 
				parent.new SieveOfEratosthenesSolution();
		int[] result = solution.closestPrimes(10, 19);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertEquals(11, result[0]);
		assertEquals(13, result[1]);
	}

	@Test
	@DisplayName("left = 4, right = 6 -> [-1,-1]")
	void testSieveOfEratosthenesSolutionPrimes2() {
		ClosestPrimeNumbersInRange parent = new ClosestPrimeNumbersInRange();
		ClosestPrimeNumbersInRange.SieveOfEratosthenesSolution solution = 
				parent.new SieveOfEratosthenesSolution();
		int[] result = solution.closestPrimes(4, 6);
		assertNotNull(result);
		assertEquals(2, result.length);
		assertEquals(-1, result[0]);
		assertEquals(-1, result[1]);
	}
}
