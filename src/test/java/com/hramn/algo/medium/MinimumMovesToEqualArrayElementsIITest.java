package com.hramn.algo.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MinimumMovesToEqualArrayElementsIITest {
  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of( // Example 1
            new int[] { 1, 2, 3 },
            2),
        Arguments.of( // Example 2
            new int[] { 1, 10, 2, 9 },
            16));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void medianSolution(
      int[] nums,
      int expected) {
    var solution = new MinimumMovesToEqualArrayElementsII.MedianSolution();
    assertEquals(expected, solution.minMoves2(nums));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void twoPointersSolution(
      int[] nums,
      int expected) {
    var solution = new MinimumMovesToEqualArrayElementsII.TwoPointersSolution();
    assertEquals(expected, solution.minMoves2(nums));
  }
}
