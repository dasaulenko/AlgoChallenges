package com.hramn.algo.hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SmallestUniqueSubarrayTest {
	static Stream<Arguments> testCases() {
		return Stream.of(
				Arguments.of( // Example 1
						new int[] { 3, 3, 3 }, 3),
				Arguments.of( // Example 2
						new int[] { 2, 1, 2, 3, 3 }, 1),
				Arguments.of( // Example 3
						new int[] { 1, 1, 2, 2, 1 }, 2));
	}

	@ParameterizedTest
	@MethodSource("testCases")
	void doubleRollingHashSolution(
			int[] nums,
			int expected) {
		var solution = new SmallestUniqueSubarray.DoubleRollingHashSolution();
		assertEquals(expected, solution.smallestUniqueSubarray(nums));
	}

	@ParameterizedTest
	@MethodSource("testCases")
	void hashMapSolution(
			int[] nums,
			int expected) {
		var solution = new SmallestUniqueSubarray.HashMapSolution();
		assertEquals(expected, solution.smallestUniqueSubarray(nums));
	}

	@ParameterizedTest
	@MethodSource("testCases")
	void doublingTechniqueSolution(
			int[] nums,
			int expected) {
		var solution = new SmallestUniqueSubarray.DoublingTechniqueSolution();
		assertEquals(expected, solution.smallestUniqueSubarray(nums));
	}

	@ParameterizedTest
	@MethodSource("testCases")
	void suffixArraySolution(
			int[] nums,
			int expected) {
		var solution = new SmallestUniqueSubarray.SuffixArraySolution();
		assertEquals(expected, solution.smallestUniqueSubarray(nums));
	}
}
