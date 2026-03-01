package com.hramn.algo.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlternatingGroupsIITest {
	@Test
	@DisplayName("colors = [0,1,0,1,0], k = 3 -> 3")
	void testOptimizedSolutionNumberOfAlternatingGroups1() {
		AlternatingGroupsII parent = new AlternatingGroupsII();
		AlternatingGroupsII.OptimizedSolution solution = parent.new OptimizedSolution();
		int result = solution.numberOfAlternatingGroups(new int[]{0,1,0,1,0}, 3);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("colors = [0,1,0,0,1,0,1], k = 6 -> 2")
	void testOptimizedSolutionNumberOfAlternatingGroups2() {
		AlternatingGroupsII parent = new AlternatingGroupsII();
		AlternatingGroupsII.OptimizedSolution solution = parent.new OptimizedSolution();
		int result = solution.numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1}, 6);
		assertEquals(2, result);
	}

	@Test
	@DisplayName("colors = [1,1,0,1], k = 4 -> 0")
	void testOptimizedSolutionNumberOfAlternatingGroups3() {
		AlternatingGroupsII parent = new AlternatingGroupsII();
		AlternatingGroupsII.OptimizedSolution solution = parent.new OptimizedSolution();
		int result = solution.numberOfAlternatingGroups(new int[]{1,1,0,1}, 4);
		assertEquals(0, result);
	}

	@Test
	@DisplayName("colors = [0,1,0,1,0], k = 3 -> 3")
	void testSolutionNumberOfAlternatingGroups1() {
		AlternatingGroupsII parent = new AlternatingGroupsII();
		AlternatingGroupsII.Solution solution = parent.new Solution();
		int result = solution.numberOfAlternatingGroups(new int[]{0,1,0,1,0}, 3);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("colors = [0,1,0,0,1,0,1], k = 6 -> 2")
	void testSolutionNumberOfAlternatingGroups2() {
		AlternatingGroupsII parent = new AlternatingGroupsII();
		AlternatingGroupsII.Solution solution = parent.new Solution();
		int result = solution.numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1}, 6);
		assertEquals(2, result);
	}

	@Test
	@DisplayName("colors = [1,1,0,1], k = 4 -> 0")
	void testSolutionNumberOfAlternatingGroups3() {
		AlternatingGroupsII parent = new AlternatingGroupsII();
		AlternatingGroupsII.Solution solution = parent.new Solution();
		int result = solution.numberOfAlternatingGroups(new int[]{1,1,0,1}, 4);
		assertEquals(0, result);
	}
}
