package com.hramn.algo.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MaximumValueOfOrderedTripletITest {
	static Stream<Arguments> testCases() {
		return Stream.of(
				Arguments.of( // Example 1
						new int[] { 12, 6, 1, 2, 7 },
						77),
				Arguments.of( // Example 2
						new int[] { 1, 10, 3, 4, 19 },
						133),
				Arguments.of( // Example 3
						new int[] { 1, 2, 3 },
						0));
	}

	@ParameterizedTest
	@MethodSource("testCases")
	void solution(
			int[] nums,
			int expected) {
		var solution = new MaximumValueOfOrderedTripletI.Solution();
		assertEquals(expected, solution.maximumTripletValue(nums));
	}
}
