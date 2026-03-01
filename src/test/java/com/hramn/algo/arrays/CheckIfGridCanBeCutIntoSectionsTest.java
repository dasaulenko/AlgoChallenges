package com.hramn.algo.arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckIfGridCanBeCutIntoSectionsTest {
	@Test
	@DisplayName("n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]] -> true")
	void testBruteforceSolutionCheckValidCuts1() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.BruteforceSolution solution = parent.new BruteforceSolution();
		boolean result = solution.checkValidCuts(5, new int[][] {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}});
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]] -> true")
	void testBruteforceSolutionCheckValidCuts2() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.BruteforceSolution solution = parent.new BruteforceSolution();
		boolean result = solution.checkValidCuts(4, new int[][] {{0,0,1,1},{2,0,3,4},{0,2,2,3},{3,0,4,3}});
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]] -> false")
	void testBruteforceSolutionCheckValidCuts3() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.BruteforceSolution solution = parent.new BruteforceSolution();
		boolean result = solution.checkValidCuts(4, new int[][] {{0,2,2,4},{1,0,3,2},{2,2,3,4},{3,0,4,2},{3,2,4,4}});
		assertFalse(result);
	}

	@Test
	@DisplayName("n = 3, rectangles = [[0,0,1,3],[1,0,2,2],[2,0,3,2],[1,2,3,3]] -> false")
	void testBruteforceSolutionCheckValidCuts4() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.BruteforceSolution solution = parent.new BruteforceSolution();
		boolean result = solution.checkValidCuts(3, new int[][] {{0,0,1,3},{1,0,2,2},{2,0,3,2},{1,2,3,3}});
		assertFalse(result);
	}

	@Test
	@DisplayName("n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]] -> true")
	void testSortSolutionCheckValidCuts1() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.SortSolution solution = parent.new SortSolution();
		boolean result = solution.checkValidCuts(5, new int[][] {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}});
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]] -> true")
	void testSortSolutionCheckValidCuts2() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.SortSolution solution = parent.new SortSolution();
		boolean result = solution.checkValidCuts(4, new int[][] {{0,0,1,1},{2,0,3,4},{0,2,2,3},{3,0,4,3}});
		assertTrue(result);
	}

	@Test
	@DisplayName("n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]] -> false")
	void testSortSolutionCheckValidCuts3() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.SortSolution solution = parent.new SortSolution();
		boolean result = solution.checkValidCuts(4, new int[][] {{0,2,2,4},{1,0,3,2},{2,2,3,4},{3,0,4,2},{3,2,4,4}});
		assertFalse(result);
	}

	@Test
	@DisplayName("n = 3, rectangles = [[0,0,1,3],[1,0,2,2],[2,0,3,2],[1,2,3,3]] -> false")
	void testSortSolutionCheckValidCuts4() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.SortSolution solution = parent.new SortSolution();
		boolean result = solution.checkValidCuts(3, new int[][] {{0,0,1,3},{1,0,2,2},{2,0,3,2},{1,2,3,3}});
		assertFalse(result);
	}
}
