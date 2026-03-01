package com.hramn.algo.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumTimeToRepairCarsTest {
	@Test
	@DisplayName("ranks = [4,2,3,1], cars = 10 -> 16")
	void testRepairCars1() {
		MinimumTimeToRepairCars parent = new MinimumTimeToRepairCars();
		MinimumTimeToRepairCars.Solution solution = parent.new Solution();
		long result = solution.repairCars(new int[] {4,2,3,1}, 10);
		assertEquals(16, result);
	}

	@Test
	@DisplayName("ranks = [5,1,8], cars = 6 -> 16")
	void testRepairCars2() {
		MinimumTimeToRepairCars parent = new MinimumTimeToRepairCars();
		MinimumTimeToRepairCars.Solution solution = parent.new Solution();
		long result = solution.repairCars(new int[] {5,1,8}, 6);
		assertEquals(16, result);
	}
}
