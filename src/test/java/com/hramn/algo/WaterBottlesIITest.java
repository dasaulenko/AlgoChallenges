package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WaterBottlesIITest {
	@Test
	@DisplayName("numBottles = 13, numExchange = 6 -> 15")
	void testSolutionMaxBottlesDrunk1() {
		WaterBottlesII task = new WaterBottlesII();
		WaterBottlesII.Solution solution = task.new Solution();
		int result = solution.maxBottlesDrunk(13, 6);
		assertEquals(15, result);
	}

	@Test
	@DisplayName("numBottles = 10, numExchange = 3 -> 13")
	void testSolutionMaxBottlesDrunk2() {
		WaterBottlesII task = new WaterBottlesII();
		WaterBottlesII.Solution solution = task.new Solution();
		int result = solution.maxBottlesDrunk(10, 3);
		assertEquals(13, result);
	}
}
