package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckIfGridCanBeCutIntoSectionsTest {
	private final int n1 = 5;
	private final int[][] rectangles1 = new int[][] {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}};
	private final boolean expected1 = true;
	private final int n2 = 4;
	private final int[][] rectangles2 = new int[][] {{0,0,1,1},{2,0,3,4},{0,2,2,3},{3,0,4,3}};
	private final boolean expected2 = true;
	private final int n3 = 4;
	private final int[][] rectangles3 = new int[][] {{0,2,2,4},{1,0,3,2},{2,2,3,4},{3,0,4,2},{3,2,4,4}};
	private final boolean expected3 = false;
	private final int n4 = 3;
	private final int[][] rectangles4 = new int[][] {{0,0,1,3},{1,0,2,2},{2,0,3,2},{1,2,3,3}};
	private final boolean expected4 = false;
	
	@Test
	@DisplayName("n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]] -> true")
	void testBruteforceSolutionCheckValidCuts1() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.BruteforceSolution solution = parent.new BruteforceSolution();
		boolean result = solution.checkValidCuts(n1, rectangles1);
		assertEquals(expected1, result);
	}

	@Test
	@DisplayName("n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]] -> true")
	void testBruteforceSolutionCheckValidCuts2() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.BruteforceSolution solution = parent.new BruteforceSolution();
		boolean result = solution.checkValidCuts(n2, rectangles2);
		assertEquals(expected2, result);
	}

	@Test
	@DisplayName("n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]] -> false")
	void testBruteforceSolutionCheckValidCuts3() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.BruteforceSolution solution = parent.new BruteforceSolution();
		boolean result = solution.checkValidCuts(n3, rectangles3);
		assertEquals(expected3, result);
	}

	@Test
	@DisplayName("n = 3, rectangles = [[0,0,1,3],[1,0,2,2],[2,0,3,2],[1,2,3,3]] -> false")
	void testBruteforceSolutionCheckValidCuts4() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.BruteforceSolution solution = parent.new BruteforceSolution();
		boolean result = solution.checkValidCuts(n4, rectangles4);
		assertEquals(expected4, result);
	}

	@Test
	@DisplayName("n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]] -> true")
	void testSortSolutionCheckValidCuts1() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.SortSolution solution = parent.new SortSolution();
		boolean result = solution.checkValidCuts(n1, rectangles1);
		assertEquals(expected1, result);
	}

	@Test
	@DisplayName("n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]] -> true")
	void testSortSolutionCheckValidCuts2() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.SortSolution solution = parent.new SortSolution();
		boolean result = solution.checkValidCuts(n2, rectangles2);
		assertEquals(expected2, result);
	}

	@Test
	@DisplayName("n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]] -> false")
	void testSortSolutionCheckValidCuts3() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.SortSolution solution = parent.new SortSolution();
		boolean result = solution.checkValidCuts(n3, rectangles3);
		assertEquals(expected3, result);
	}

	@Test
	@DisplayName("n = 3, rectangles = [[0,0,1,3],[1,0,2,2],[2,0,3,2],[1,2,3,3]] -> false")
	void testSortSolutionCheckValidCuts4() {
		CheckIfGridCanBeCutIntoSections parent = new CheckIfGridCanBeCutIntoSections();
		CheckIfGridCanBeCutIntoSections.SortSolution solution = parent.new SortSolution();
		boolean result = solution.checkValidCuts(n4, rectangles4);
		assertEquals(expected4, result);
	}
}
