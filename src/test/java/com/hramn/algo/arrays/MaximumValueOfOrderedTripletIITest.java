package com.hramn.algo.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaximumValueOfOrderedTripletIITest {
	@Test
	@DisplayName("nums = [12,6,1,2,7] -> 77")
	void testSolutionMaximumTripletValue1() {
		MaximumValueOfOrderedTripletII parent = new MaximumValueOfOrderedTripletII();
		MaximumValueOfOrderedTripletII.Solution solution = parent.new Solution();
		long result = solution.maximumTripletValue(new int[] {12,6,1,2,7});
		assertEquals(77, result);
	}

	@Test
	@DisplayName("nums = [1,10,3,4,19] -> 133")
	void testSolutionMaximumTripletValue2() {
		MaximumValueOfOrderedTripletII parent = new MaximumValueOfOrderedTripletII();
		MaximumValueOfOrderedTripletII.Solution solution = parent.new Solution();
		long result = solution.maximumTripletValue(new int[] {1,10,3,4,19});
		assertEquals(133, result);
	}

	@Test
	@DisplayName("nums = [1,2,3] -> 0")
	void testSolutionMaximumTripletValue3() {
		MaximumValueOfOrderedTripletII parent = new MaximumValueOfOrderedTripletII();
		MaximumValueOfOrderedTripletII.Solution solution = parent.new Solution();
		long result = solution.maximumTripletValue(new int[] {1,2,3});
		assertEquals(0, result);
	}
}
