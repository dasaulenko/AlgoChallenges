package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumManhattanDistanceAfterKChangesTest {
	@Test
	@DisplayName("s = \"NWSE\", k = 1 -> 3")
	void testSolutionMaxDistance1() {
		MaximumManhattanDistanceAfterKChanges task = new MaximumManhattanDistanceAfterKChanges();
		MaximumManhattanDistanceAfterKChanges.Solution solution = task.new Solution();
		int result = solution.maxDistance("NWSE", 1);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("s = \"NSWWEW\", k = 3 -> 6")
	void testSolutionMaxDistance2() {
		MaximumManhattanDistanceAfterKChanges task = new MaximumManhattanDistanceAfterKChanges();
		MaximumManhattanDistanceAfterKChanges.Solution solution = task.new Solution();
		int result = solution.maxDistance("NSWWEW", 3);
		assertEquals(6, result);
	}
}
