package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdjacentIncreasingSubarraysDetectionITest {
	@Test
	@DisplayName("nums = [2,5,7,8,9,2,3,4,3,1], k = 3 -> true")
	void testSolutionHasIncreasingSubarrays1() {
		AdjacentIncreasingSubarraysDetectionI task = new AdjacentIncreasingSubarraysDetectionI();
		AdjacentIncreasingSubarraysDetectionI.Solution solution = task.new Solution();
		boolean result = solution.hasIncreasingSubarrays(List.of(2,5,7,8,9,2,3,4,3,1), 3);
		assertEquals(true, result);
	}

	@Test
	@DisplayName("nums = [1,2,3,4,4,4,4,5,6,7], k = 5 -> false")
	void testSolutionHasIncreasingSubarrays2() {
		AdjacentIncreasingSubarraysDetectionI task = new AdjacentIncreasingSubarraysDetectionI();
		AdjacentIncreasingSubarraysDetectionI.Solution solution = task.new Solution();
		boolean result = solution.hasIncreasingSubarrays(List.of(1,2,3,4,4,4,4,5,6,7), 5);
		assertEquals(false, result);
	}
}
