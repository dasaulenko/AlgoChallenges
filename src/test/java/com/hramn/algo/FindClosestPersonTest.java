package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindClosestPersonTest {
	@Test
	@DisplayName("x = 2, y = 7, z = 4 -> 1")
	void testSolutionFindClosest1() {
		FindClosestPerson task = new FindClosestPerson();
		FindClosestPerson.Solution solution = task.new Solution();
		int result = solution.findClosest(2, 7, 4);
		assertEquals(1, result);
	}

	@Test
	@DisplayName("x = 2, y = 5, z = 6 -> 2")
	void testSolutionFindClosest2() {
		FindClosestPerson task = new FindClosestPerson();
		FindClosestPerson.Solution solution = task.new Solution();
		int result = solution.findClosest(2, 5, 6);
		assertEquals(2, result);
	}

	@Test
	@DisplayName("x = 1, y = 5, z = 3 -> 0")
	void testSolutionFindClosest3() {
		FindClosestPerson task = new FindClosestPerson();
		FindClosestPerson.Solution solution = task.new Solution();
		int result = solution.findClosest(1, 5, 3);
		assertEquals(0, result);
	}
}
