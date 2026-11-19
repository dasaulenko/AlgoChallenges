package com.hramn.algo.hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MinimumOperationsToMakeElementsWithinKSubarraysEqualTest {
  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of( // Example 1
            new int[] { 5, -2, 1, 3, 7, 3, 6, 4, -1 }, 3, 2, 8),
        Arguments.of( // Example 2
            new int[] { 9, -2, -2, -2, 1, 5 }, 2, 2, 3));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void sortSolution(
      int[] nums,
      int x,
      int k,
      int expected) {
    var solution = new MinimumOperationsToMakeElementsWithinKSubarraysEqual.SortSolution();
    assertEquals(expected, solution.minOperations(nums, x, k));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void treeMapSolution(
      int[] nums,
      int x,
      int k,
      int expected) {
    var solution = new MinimumOperationsToMakeElementsWithinKSubarraysEqual.TreeMapSolution();
    assertEquals(expected, solution.minOperations(nums, x, k));
  }
}
