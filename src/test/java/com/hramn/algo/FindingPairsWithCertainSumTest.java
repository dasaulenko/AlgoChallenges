package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindingPairsWithCertainSumTest {
	@Test
	@DisplayName("")
	// ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
	// [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
	// -> [null, 8, null, 2, 1, null, null, 11]
	void test() {
		FindingPairsWithCertainSum task = new FindingPairsWithCertainSum();
		FindingPairsWithCertainSum.FindSumPairs solution = task.new FindSumPairs(new int[] {1, 1, 2, 2, 2, 3}, new int[] {1, 4, 5, 2, 5, 4});
		int result = solution.count(7);
		assertEquals(8, result);
		solution.add(3, 2);
		result = solution.count(8);
		assertEquals(2, result);
		result = solution.count(4);
		assertEquals(1, result);
		solution.add(0, 1);
		solution.add(1, 1);
		result = solution.count(7);
		assertEquals(11, result);
	}
}
