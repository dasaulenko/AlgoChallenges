package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMaximumNumberOfFruitsCollectedTest {
	@Test
	@DisplayName("fruits = [[1,2,3,4],[5,6,8,7],[9,10,11,12],[13,14,15,16]] -> 100")
	void testSolutionMaxCollectedFruits1() {
		FindMaximumNumberOfFruitsCollected task = new FindMaximumNumberOfFruitsCollected();
		FindMaximumNumberOfFruitsCollected.Solution solution = task.new Solution();
		int result = solution.maxCollectedFruits(new int[][] {{1,2,3,4},{5,6,8,7},{9,10,11,12},{13,14,15,16}});
		assertEquals(result, 100);
	}

	@Test
	@DisplayName("fruits = [[1,1],[1,1]] -> 4")
	void testSolutionMaxCollectedFruits2() {
		FindMaximumNumberOfFruitsCollected task = new FindMaximumNumberOfFruitsCollected();
		FindMaximumNumberOfFruitsCollected.Solution solution = task.new Solution();
		int result = solution.maxCollectedFruits(new int[][] {{1,1},{1,1}});
		assertEquals(result, 4);
	}
}
