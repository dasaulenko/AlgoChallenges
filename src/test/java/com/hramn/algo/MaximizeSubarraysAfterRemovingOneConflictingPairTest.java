package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximizeSubarraysAfterRemovingOneConflictingPairTest {
	@Test
	@DisplayName("n = 4, conflictingPairs = [[2,3],[1,4]] -> 9")
	void testSolutionMaxSubarrays1() {
		MaximizeSubarraysAfterRemovingOneConflictingPair task = new MaximizeSubarraysAfterRemovingOneConflictingPair();
		MaximizeSubarraysAfterRemovingOneConflictingPair.Solution solution = task.new Solution();
		long result = solution.maxSubarrays(4, new int[][] {{2,3},{1,4}});
		assertEquals(result, 9);
	}

	@Test
	@DisplayName("n = 5, conflictingPairs = [[1,2],[2,5],[3,5]] -> 12")
	void testSolutionMaxSubarrays2() {
		MaximizeSubarraysAfterRemovingOneConflictingPair task = new MaximizeSubarraysAfterRemovingOneConflictingPair();
		MaximizeSubarraysAfterRemovingOneConflictingPair.Solution solution = task.new Solution();
		long result = solution.maxSubarrays(5, new int[][] {{1,2},{2,5},{3,5}});
		assertEquals(result, 12);
	}
}
