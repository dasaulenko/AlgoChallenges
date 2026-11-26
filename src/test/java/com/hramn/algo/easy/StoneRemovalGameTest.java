package com.hramn.algo.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StoneRemovalGameTest {
  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of( // Example 1
            12,
            true),
        Arguments.of( // Example 2
            1,
            false));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void solution(
      int n,
      boolean expected) {
    var solution = new StoneRemovalGame.Solution();
    assertEquals(expected, solution.canAliceWin(n));
  }
}
