package com.hramn.algo.hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MaximizeConsecutiveElementsInArrayAfterModificationTest {
  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of( // Example 1
            new int[] { 2, 1, 5, 1, 1 },
            3),
        Arguments.of( // Example 2
            new int[] { 1, 4, 7, 10 },
            1));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void solution(
      int[] nums,
      int expected) {
    var solution = new MaximizeConsecutiveElementsInArrayAfterModification.Solution();
    assertEquals(expected, solution.maxSelectedElements(nums));
  }
}
