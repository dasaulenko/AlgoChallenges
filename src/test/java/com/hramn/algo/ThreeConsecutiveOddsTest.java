package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ThreeConsecutiveOddsTest {
	@Test
	@DisplayName("arr = [2,6,4,1] -> false")
	void testSolutionThreeConsecutiveOdds1() {
		ThreeConsecutiveOdds task = new ThreeConsecutiveOdds();
		ThreeConsecutiveOdds.Solution solution = task.new Solution();
		boolean result = solution.threeConsecutiveOdds(new int[] {2,6,4,1});
		assertFalse(result);
	}

	@Test
	@DisplayName("arr = [1,2,34,3,4,5,7,23,12] -> true")
	void testSolutionThreeConsecutiveOdds2() {
		ThreeConsecutiveOdds task = new ThreeConsecutiveOdds();
		ThreeConsecutiveOdds.Solution solution = task.new Solution();
		boolean result = solution.threeConsecutiveOdds(new int[] {1,2,34,3,4,5,7,23,12});
		assertTrue(result);
	}
}
