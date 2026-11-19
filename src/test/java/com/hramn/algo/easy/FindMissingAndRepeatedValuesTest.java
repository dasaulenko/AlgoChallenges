package com.hramn.algo.easy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FindMissingAndRepeatedValuesTest {

	static Stream<Arguments> testCases() {
		return Stream.of(
				Arguments.of( // Example 1
						new int[][] { { 1, 3 }, { 2, 2 } },
						new int[] { 2, 4 }),
				Arguments.of( // Example 2
						new int[][] { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } },
						new int[] { 9, 5 }),
				Arguments.of( // Minimum size
						new int[][] { { 1, 1 }, { 3, 4 } },
						new int[] { 1, 2 }),
				Arguments.of( // Te maximum number is repeated
						new int[][] { { 4, 2 }, { 3, 4 } },
						new int[] { 4, 1 }),
				Arguments.of( // The minimum number is missing
						new int[][] { { 1, 2 }, { 3, 3 } },
						new int[] { 3, 4 }),
				Arguments.of( // The first number is repeated
						new int[][] { { 1, 2 }, { 1, 4 } },
						new int[] { 1, 3 }),
				Arguments.of( // Repeaded number is in different rows
						new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 1 } },
						new int[] { 1, 9 }));
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
