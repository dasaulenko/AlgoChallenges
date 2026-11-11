package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MinimumCostToAcquireRequiredItemsTest {

	private final MinimumCostToAcquireRequiredItems.Solution solution =
		new MinimumCostToAcquireRequiredItems.Solution();

	@ParameterizedTest(name = "{0}")
	@CsvSource({
		// LeetCode examples
		"Example 1, 3, 2, 1, 3, 2, 3",
		"Example 2, 5, 4, 15, 2, 3, 22",
		"Example 3, 5, 4, 15, 0, 0, 0",
		// Boundary cases
		"Only type 1, 3, 4, 10, 5, 0, 15",
		"Only type 2, 3, 4, 10, 0, 5, 20",
		"Minimum needs, 1, 1, 1, 1, 1, 1",
    "Maximum constraints, 1000000, 1000000, 1000000, 1000000000, 1000000000, 1000000000000000",
		// Greedy decision cases
		"Separate items, 5, 4, 15, 2, 3, 22",
		"Both items cheaper, 5, 6, 8, 3, 3, 24",
		"Both after one need met, 5, 6, 2, 5, 2, 10",
		"Equal strategies, 3, 4, 7, 2, 2, 14"
	})
	void minimumCost_shouldReturnExpectedResult(
		String scenario,
		int cost1,
		int cost2,
		int costBoth,
		int need1,
		int need2,
		long expected
	) {
		long actual = solution.minimumCost(cost1, cost2, costBoth, need1, need2);
		assertEquals(expected, actual, scenario);
	}
}
