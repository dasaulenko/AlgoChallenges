package com.hramn.algo.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CheckIfAllAsAppearsBeforeAllBsTest {
  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of( // Example 1
            "aaabbb",
            true),
        Arguments.of( // Example 2
            "abab",
            false));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void iteratingSolution(
      String s,
      boolean expected) {
    var solution = new CheckIfAllAsAppearsBeforeAllBs.IteratingSolution();
    assertEquals(expected, solution.checkString(s));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void indexOfSolution(
      String s,
      boolean expected) {
    var solution = new CheckIfAllAsAppearsBeforeAllBs.IndexOfSolution();
    assertEquals(expected, solution.checkString(s));
  }
}
