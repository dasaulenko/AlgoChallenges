package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BestTimeToBuyAndSellStockTest {
	@Test
	@DisplayName("prices = [7,1,5,3,6,4] -> 5")
	void testSolutionMaxProfit1() {
		BestTimeToBuyAndSellStock task = new BestTimeToBuyAndSellStock();
		BestTimeToBuyAndSellStock.Solution solution = task.new Solution();
		int[] prices = {7,1,5,3,6,4};
		int expected = 5;
		int result = solution.maxProfit(prices);
		assertEquals(expected, result);
	}

	@Test
	@DisplayName("prices = [7,6,4,3,1] -> 0")
	void testSolutionMaxProfit2() {
		BestTimeToBuyAndSellStock task = new BestTimeToBuyAndSellStock();
		BestTimeToBuyAndSellStock.Solution solution = task.new Solution();
		int[] prices = {7,6,4,3,1};
		int expected = 0;
		int result = solution.maxProfit(prices);
		assertEquals(expected, result);
	}
}
