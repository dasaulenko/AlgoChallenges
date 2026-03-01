package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberOfZeroFilledSubarraysTest {
	@Test
	@DisplayName("nums = [1,3,0,0,2,0,0,4] -> 6")
	void testSolutionZeroFilledSubarray1() {
		NumberOfZeroFilledSubarrays task = new NumberOfZeroFilledSubarrays();
		NumberOfZeroFilledSubarrays.Solution solution = task.new Solution();
		long result = solution.zeroFilledSubarray(new int[] {1,3,0,0,2,0,0,4});
		assertEquals(6, result);
	}

	@Test
	@DisplayName("nums = [0,0,0,2,0,0] -> 9")
	void testSolutionZeroFilledSubarray2() {
		NumberOfZeroFilledSubarrays task = new NumberOfZeroFilledSubarrays();
		NumberOfZeroFilledSubarrays.Solution solution = task.new Solution();
		long result = solution.zeroFilledSubarray(new int[] {0,0,0,2,0,0});
		assertEquals(9, result);
	}

	@Test
	@DisplayName("nums = [2,10,2019] -> 0")
	void testSolutionZeroFilledSubarray3() {
		NumberOfZeroFilledSubarrays task = new NumberOfZeroFilledSubarrays();
		NumberOfZeroFilledSubarrays.Solution solution = task.new Solution();
		long result = solution.zeroFilledSubarray(new int[] {2,10,2019});
		assertEquals(0, result);
	}
}
