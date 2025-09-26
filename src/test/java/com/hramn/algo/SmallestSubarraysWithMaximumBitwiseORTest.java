package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SmallestSubarraysWithMaximumBitwiseORTest {
	@Test
	@DisplayName("nums = [1,0,2,1,3] -> [3,3,2,2,1]")
	void testSolutionSmallestSubarrays1() {
		SmallestSubarraysWithMaximumBitwiseOR task = new SmallestSubarraysWithMaximumBitwiseOR();
		SmallestSubarraysWithMaximumBitwiseOR.Solution solution = task.new Solution();
		int[] result = solution.smallestSubarrays(new int[] {1,0,2,1,3});
		assertNotNull(result);
		assertTrue(Arrays.equals(result, new int[] {3,3,2,2,1}));
	}

	@Test
	@DisplayName("nums = [1,2] -> [2,1]")
	void testSolutionSmallestSubarrays2() {
		SmallestSubarraysWithMaximumBitwiseOR task = new SmallestSubarraysWithMaximumBitwiseOR();
		SmallestSubarraysWithMaximumBitwiseOR.Solution solution = task.new Solution();
		int[] result = solution.smallestSubarrays(new int[] {1,2});
		assertNotNull(result);
		assertTrue(Arrays.equals(result, new int[] {2,1}));
	}
}
