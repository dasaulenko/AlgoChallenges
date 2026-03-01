package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FruitIntoBasketsTest {
	@Test
	@DisplayName("fruits = [1,2,1] -> 3")
	void testSolutionTotalFruit1() {
		FruitIntoBaskets task = new FruitIntoBaskets();
		FruitIntoBaskets.Solution solution = task.new Solution();
		int result = solution.totalFruit(new int[] {1,2,1});
		assertEquals(result, 3);
	}

	@Test
	@DisplayName("fruits = [0,1,2,2] -> 3")
	void testSolutionTotalFruit2() {
		FruitIntoBaskets task = new FruitIntoBaskets();
		FruitIntoBaskets.Solution solution = task.new Solution();
		int result = solution.totalFruit(new int[] {0,1,2,2});
		assertEquals(result, 3);
	}

	@Test
	@DisplayName("fruits = [1,2,3,2,2] -> 4")
	void testSolutionTotalFruit3() {
		FruitIntoBaskets task = new FruitIntoBaskets();
		FruitIntoBaskets.Solution solution = task.new Solution();
		int result = solution.totalFruit(new int[] {1,2,3,2,2});
		assertEquals(result, 4);
	}
}
