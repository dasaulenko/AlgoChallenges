package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FruitsIntoBasketsIITest {
	@Test
	@DisplayName("fruits = [4,2,5], baskets = [3,5,4] -> 1")
	void testSolutionNumOfUnplacedFruits1() {
		FruitsIntoBasketsII task = new FruitsIntoBasketsII();
		FruitsIntoBasketsII.Solution solution = task.new Solution();
		int result = solution.numOfUnplacedFruits(new int[] {4,2,5}, new int[] {3,5,4});
		assertEquals(result, 1);
	}

	@Test
	@DisplayName("fruits = [3,6,1], baskets = [6,4,7] -> 0")
	void testSolutionNumOfUnplacedFruits2() {
		FruitsIntoBasketsII task = new FruitsIntoBasketsII();
		FruitsIntoBasketsII.Solution solution = task.new Solution();
		int result = solution.numOfUnplacedFruits(new int[] {3,6,1}, new int[] {6,4,7});
		assertEquals(result, 0);
	}
}
