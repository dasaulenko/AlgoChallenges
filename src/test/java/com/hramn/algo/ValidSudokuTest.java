package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidSudokuTest {
	final private char[][] trueBoard = new char[][] {
		{'5','3','.','.','7','.','.','.','.'}
 	 ,{'6','.','.','1','9','5','.','.','.'}
 	 ,{'.','9','8','.','.','.','.','6','.'}
 	 ,{'8','.','.','.','6','.','.','.','3'}
 	 ,{'4','.','.','8','.','3','.','.','1'}
 	 ,{'7','.','.','.','2','.','.','.','6'}
 	 ,{'.','6','.','.','.','.','2','8','.'}
 	 ,{'.','.','.','4','1','9','.','.','5'}
 	 ,{'.','.','.','.','8','.','.','7','9'}
	};

	final private char[][] falseBoard = new char[][] {
		{'8','3','.','.','7','.','.','.','.'}
 	 ,{'6','.','.','1','9','5','.','.','.'}
 	 ,{'.','9','8','.','.','.','.','6','.'}
 	 ,{'8','.','.','.','6','.','.','.','3'}
 	 ,{'4','.','.','8','.','3','.','.','1'}
 	 ,{'7','.','.','.','2','.','.','.','6'}
 	 ,{'.','6','.','.','.','.','2','8','.'}
 	 ,{'.','.','.','4','1','9','.','.','5'}
 	 ,{'.','.','.','.','8','.','.','7','9'}
	};

	@Test
	@DisplayName("trueBoard -> true")
	void testSolution20250904IsValidSudoku1() {
		ValidSudoku task = new ValidSudoku();
		ValidSudoku.Solution_20250904 solution = task.new Solution_20250904();
		boolean result = solution.isValidSudoku(trueBoard);
		assertTrue(result);
	}

	@Test
	@DisplayName("falseBoard -> false")
	void testSolution20250904IsValidSudoku2() {
		ValidSudoku task = new ValidSudoku();
		ValidSudoku.Solution_20250904 solution = task.new Solution_20250904();
		boolean result = solution.isValidSudoku(falseBoard);
		assertFalse(result);
	}

	@Test
	@DisplayName("trueBoard -> true")
	void testSolution20250830IsValidSudoku1() {
		ValidSudoku task = new ValidSudoku();
		ValidSudoku.Solution_20250830 solution = task.new Solution_20250830();
		boolean result = solution.isValidSudoku(trueBoard);
		assertTrue(result);
	}

	@Test
	@DisplayName("falseBoard -> false")
	void testSolution20250830IsValidSudoku2() {
		ValidSudoku task = new ValidSudoku();
		ValidSudoku.Solution_20250830 solution = task.new Solution_20250830();
		boolean result = solution.isValidSudoku(falseBoard);
		assertFalse(result);
	}

		@Test
	@DisplayName("trueBoard -> true")
	void testSolution20240504IsValidSudoku1() {
		ValidSudoku task = new ValidSudoku();
		ValidSudoku.Solution_20240504 solution = task.new Solution_20240504();
		boolean result = solution.isValidSudoku(trueBoard);
		assertTrue(result);
	}

	@Test
	@DisplayName("falseBoard -> false")
	void testSolution20240504IsValidSudoku2() {
		ValidSudoku task = new ValidSudoku();
		ValidSudoku.Solution_20240504 solution = task.new Solution_20240504();
		boolean result = solution.isValidSudoku(falseBoard);
		assertFalse(result);
	}
}
