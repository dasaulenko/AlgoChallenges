package com.hramn.algo.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountTotalNumberOfColoredCellsTest {
	@Test
	@DisplayName("n = 1 -> 1")
	void testSolution1ColoredCells1() {
		CountTotalNumberOfColoredCells parent = new CountTotalNumberOfColoredCells();
		CountTotalNumberOfColoredCells.Solution1 solution = parent.new Solution1();
		long result = solution.coloredCells(1);
		assertEquals(1, result);
	}

	@Test
	@DisplayName("n = 2 -> 5")
	void testSolution1ColoredCells2() {
		CountTotalNumberOfColoredCells parent = new CountTotalNumberOfColoredCells();
		CountTotalNumberOfColoredCells.Solution1 solution = parent.new Solution1();
		long result = solution.coloredCells(2);
		assertEquals(5, result);
	}

	@Test
	@DisplayName("n = 1 -> 1")
	void testSolution2ColoredCells1() {
		CountTotalNumberOfColoredCells parent = new CountTotalNumberOfColoredCells();
		CountTotalNumberOfColoredCells.Solution2 solution = parent.new Solution2();
		long result = solution.coloredCells(1);
		assertEquals(1, result);
	}

	@Test
	@DisplayName("n = 2 -> 5")
	void testSolution2ColoredCells2() {
		CountTotalNumberOfColoredCells parent = new CountTotalNumberOfColoredCells();
		CountTotalNumberOfColoredCells.Solution2 solution = parent.new Solution2();
		long result = solution.coloredCells(2);
		assertEquals(5, result);
	}
}
