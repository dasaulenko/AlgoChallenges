package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AvoidFloodInCityTest {
	@Test
	@DisplayName("rains = [1,2,3,4] -> [-1,-1,-1,-1]")
	void testSolutionAvoidFlood1() {
		AvoidFloodInCity task = new AvoidFloodInCity();
		AvoidFloodInCity.Solution solution = task.new Solution();
		int[] result = solution.avoidFlood(new int[] {1,2,3,4});
		assertArrayEquals(new int[] {-1,-1,-1,-1}, result);
	}

	@Test
	@DisplayName("rains = [1,2,0,0,2,1] -> [-1,-1,2,1,-1,-1]")
	void testSolutionAvoidFlood2() {
		AvoidFloodInCity task = new AvoidFloodInCity();
		AvoidFloodInCity.Solution solution = task.new Solution();
		int[] result = solution.avoidFlood(new int[] {1,2,0,0,2,1});
		assertArrayEquals(new int[] {-1,-1,2,1,-1,-1}, result);
	}

	@Test
	@DisplayName("rains = [1,2,0,1,2] -> []")
	void testSolutionAvoidFlood3() {
		AvoidFloodInCity task = new AvoidFloodInCity();
		AvoidFloodInCity.Solution solution = task.new Solution();
		int[] result = solution.avoidFlood(new int[] {1,2,0,1,2});
		assertArrayEquals(new int[] {}, result);
	}
}
