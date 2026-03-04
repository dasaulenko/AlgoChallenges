package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdjacentIncreasingSubarraysDetectionIITest {
	@Test
	@DisplayName("nums = [2,5,7,8,9,2,3,4,3,1] -> 3")
	void testSolutionMaxIncreasingSubarrays1() {
		AdjacentIncreasingSubarraysDetectionII task = new AdjacentIncreasingSubarraysDetectionII();
		AdjacentIncreasingSubarraysDetectionII.Solution solution = task.new Solution();
		int result = solution.maxIncreasingSubarrays(List.of(2,5,7,8,9,2,3,4,3,1));
		assertEquals(3, result);
	}

	@Test
	@DisplayName("nums = [1,2,3,4,4,4,4,5,6,7] -> 2")
	void testSolutionMaxIncreasingSubarrays2() {
		AdjacentIncreasingSubarraysDetectionII task = new AdjacentIncreasingSubarraysDetectionII();
		AdjacentIncreasingSubarraysDetectionII.Solution solution = task.new Solution();
		int result = solution.maxIncreasingSubarrays(List.of(1,2,3,4,4,4,4,5,6,7));
		assertEquals(2, result);
	}
}
