package com.hramn.algo.medium;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FindSubtreeSizesAfterChangesTest {
	static Stream<Arguments> testCases() {
		return Stream.of(
				Arguments.of( // Example 1
						new int[] { -1, 0, 0, 1, 1, 1 },
						"abaabc",
						new int[] { 6, 3, 1, 1, 1, 1 }),
				Arguments.of( // Example 2
						new int[] { -1, 0, 4, 0, 1 },
						"abbba",
						new int[] { 5, 2, 1, 1, 1 }));
	}

	@ParameterizedTest
	@MethodSource("testCases")
	void solution(
			int[] parent,
			String s,
			int[] expected) {
		var solution = new FindSubtreeSizesAfterChanges.Solution();
		assertArrayEquals(expected, solution.findSubtreeSizes(parent, s));
	}
}
