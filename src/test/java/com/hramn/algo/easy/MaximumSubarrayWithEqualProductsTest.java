package com.hramn.algo.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MaximumSubarrayWithEqualProductsTest {
  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of( // Example 1
            new int[] { 1, 2, 1, 2, 1, 1, 1 },
            5),
        Arguments.of( // Example 2
            new int[] { 2, 3, 4, 5, 6 },
            3),
        Arguments.of( // Example 3
            new int[] { 1, 2, 3, 1, 4, 5, 1 },
            5));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void bruteForceSolution(
      int[] nums,
      int expected) {
    var solution = new MaximumSubarrayWithEqualProducts.BruteForceSolution();
    assertEquals(expected, solution.maxLength(nums));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void slidingWindowSolution(
      int[] nums,
      int expected) {
    var solution = new MaximumSubarrayWithEqualProducts.SlidingWindowSolution();
    assertEquals(expected, solution.maxLength(nums));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void bitmaskSolution(
      int[] nums,
      int expected) {
    var solution = new MaximumSubarrayWithEqualProducts.BitmaskSolution();
    assertEquals(expected, solution.maxLength(nums));
  }
}
