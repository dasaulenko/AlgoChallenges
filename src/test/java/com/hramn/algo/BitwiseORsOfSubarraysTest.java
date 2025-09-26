package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BitwiseORsOfSubarraysTest {
	@Test
	@DisplayName("arr = [0] -> 1")
	void testSolutionSubarrayBitwiseORs1() {
		BitwiseORsOfSubarrays task = new BitwiseORsOfSubarrays();
		BitwiseORsOfSubarrays.Solution solution = task.new Solution();
		int result = solution.subarrayBitwiseORs(new int[] {0});
		assertEquals(result, 1);
	}

	@Test
	@DisplayName("arr = [1,1,2] -> 3")
	void testSolutionSubarrayBitwiseORs2() {
		BitwiseORsOfSubarrays task = new BitwiseORsOfSubarrays();
		BitwiseORsOfSubarrays.Solution solution = task.new Solution();
		int result = solution.subarrayBitwiseORs(new int[] {1,1,2});
		assertEquals(result, 3);
	}

	@Test
	@DisplayName("arr = [1,2,4] -> 6")
	void testSolutionSubarrayBitwiseORs3() {
		BitwiseORsOfSubarrays task = new BitwiseORsOfSubarrays();
		BitwiseORsOfSubarrays.Solution solution = task.new Solution();
		int result = solution.subarrayBitwiseORs(new int[] {1,2,4});
		assertEquals(result, 6);
	}
}
