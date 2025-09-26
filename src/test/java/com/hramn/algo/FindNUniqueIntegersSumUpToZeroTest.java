package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindNUniqueIntegersSumUpToZeroTest {
	@Test
	@DisplayName("n = 5 -> sum elements of arr = 0")
	void testSolution20250907SumZero1() {
		FindNUniqueIntegersSumUpToZero task = new FindNUniqueIntegersSumUpToZero();
		FindNUniqueIntegersSumUpToZero.Solution20250907 solution = task.new Solution20250907();
		int[] result = solution.sumZero(5);
		int sum = 0;
		for (int num : result) {
			sum += num;
		}
		assertEquals(0, sum);
	}

	@Test
	@DisplayName("n = 3 -> sum elements of arr = 0")
	void testSolution20250907SumZero2() {
		FindNUniqueIntegersSumUpToZero task = new FindNUniqueIntegersSumUpToZero();
		FindNUniqueIntegersSumUpToZero.Solution20250907 solution = task.new Solution20250907();
		int[] result = solution.sumZero(3);
		int sum = 0;
		for (int num : result) {
			sum += num;
		}
		assertEquals(0, sum);
	}

	@Test
	@DisplayName("n = 1 -> sum elements of arr = 0")
	void testSolution20250907SumZero3() {
		FindNUniqueIntegersSumUpToZero task = new FindNUniqueIntegersSumUpToZero();
		FindNUniqueIntegersSumUpToZero.Solution20250907 solution = task.new Solution20250907();
		int[] result = solution.sumZero(1);
		int sum = 0;
		for (int num : result) {
			sum += num;
		}
		assertEquals(0, sum);
	}
}
