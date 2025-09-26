package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CandyTest {
	@Test
	@DisplayName("ratings = [1,0,2] -> 5")
	void testSolutionCandy1() {
		Candy task = new Candy();
		Candy.Solution solution = task.new Solution();
		int result = solution.candy(new int[] {1,0,2});
		assertEquals(5, result);
	}

	@Test
	@DisplayName("ratings = [1,2,2] -> 4")
	void testSolutionCandy2() {
		Candy task = new Candy();
		Candy.Solution solution = task.new Solution();
		int result = solution.candy(new int[] {1,2,2});
		assertEquals(4, result);
	}

	@Test
	@DisplayName("ratings = [1,0,2] -> 5")
	void testTreeMapSolutionCandy1() {
		Candy task = new Candy();
		Candy.TreeMapSolution solution = task.new TreeMapSolution();
		int result = solution.candy(new int[] {1,0,2});
		assertEquals(5, result);
	}

	@Test
	@DisplayName("ratings = [1,2,2] -> 4")
	void testTreeMapSolutionCandy2() {
		Candy task = new Candy();
		Candy.TreeMapSolution solution = task.new TreeMapSolution();
		int result = solution.candy(new int[] {1,2,2});
		assertEquals(4, result);
	}
}
