package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountHillsAndValleysInArrayTest {
	@Test
	@DisplayName("nums = [2,4,1,1,6,5] -> 3")
	void testSolutionCountHillValley1() {
		CountHillsAndValleysInArray task = new CountHillsAndValleysInArray();
		CountHillsAndValleysInArray.Solution solution = task.new Solution();
		int result = solution.countHillValley(new int[] {2,4,1,1,6,5});
		assertEquals(result, 3);
	}

	@Test
	@DisplayName("nums = [6,6,5,5,4,1] -> 0")
	void testSolutionCountHillValley2() {
		CountHillsAndValleysInArray task = new CountHillsAndValleysInArray();
		CountHillsAndValleysInArray.Solution solution = task.new Solution();
		int result = solution.countHillValley(new int[] {6,6,5,5,4,1});
		assertEquals(result, 0);
	}
}
