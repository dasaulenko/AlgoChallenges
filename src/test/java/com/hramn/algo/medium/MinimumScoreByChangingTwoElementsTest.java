package com.hramn.algo.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MinimumScoreByChangingTwoElementsTest {
  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of( // Example 1
            new int[] { 1, 4, 7, 8, 5 }, 3),
        Arguments.of( // Example 2
            new int[] { 1, 4, 3 }, 0));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void sortSolution(
      int[] nums,
      int expected) {
    var solution = new MinimumScoreByChangingTwoElements.SortSolution();
    assertEquals(expected, solution.minimizeSum(nums));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void iteratingSolution(
      int[] nums,
      int expected) {
    var solution = new MinimumScoreByChangingTwoElements.IteratingSolution();
    assertEquals(expected, solution.minimizeSum(nums));
  }
}
