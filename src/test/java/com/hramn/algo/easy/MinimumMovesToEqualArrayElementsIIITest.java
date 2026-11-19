package com.hramn.algo.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MinimumMovesToEqualArrayElementsIIITest {
  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of( // Example 1
            new int[] { 2, 1, 3 }, 3),
        Arguments.of( // Example 2
            new int[] { 4, 4, 5 }, 2));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void solution(
      int[] nums,
      int expected) {
    var solution = new MinimumMovesToEqualArrayElementsIII.Solution();
    assertEquals(expected, solution.minMoves(nums));
  }
}
