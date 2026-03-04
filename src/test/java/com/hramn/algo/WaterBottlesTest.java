package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WaterBottlesTest {
	@Test
	@DisplayName("numBottles = 9, numExchange = 3 -> 13")
	void testSolutionNumWaterBottles1() {
		WaterBottles task = new WaterBottles();
		WaterBottles.Solution solution = task.new Solution();
		int result = solution.numWaterBottles(9, 3);
		assertEquals(13, result);
	}

	@Test
	@DisplayName("numBottles = 15, numExchange = 4 -> 19")
	void testSolutionNumWaterBottles2() {
		WaterBottles task = new WaterBottles();
		WaterBottles.Solution solution = task.new Solution();
		int result = solution.numWaterBottles(15, 4);
		assertEquals(19, result);
	}
}
