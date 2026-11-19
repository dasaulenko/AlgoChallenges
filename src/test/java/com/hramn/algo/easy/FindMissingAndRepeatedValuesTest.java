package com.hramn.algo.easy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FindMissingAndRepeatedValuesTest {

	static Stream<Arguments> testCases() {
		return Stream.of(
				Arguments.of(
						new int[][] { { 1, 3 }, { 2, 2 } },
						new int[] { 2, 4 }),
				Arguments.of(
						new int[][] { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } },
						new int[] { 9, 5 }));
	}

	@ParameterizedTest
	@MethodSource("testCases")
	void simpleSolution(
			int[][] grid,
			int[] expected) {
		var solution = new FindMissingAndRepeatedValues.SimpleSolution();
		assertArrayEquals(expected, solution.findMissingAndRepeatedValues(grid));
	}

	@ParameterizedTest
	@MethodSource("testCases")
	void inPlaceSolution(
			int[][] grid,
			int[] expected) {
		var solution = new FindMissingAndRepeatedValues.InPlaceSolution();
		assertArrayEquals(expected, solution.findMissingAndRepeatedValues(grid));
	}
}
