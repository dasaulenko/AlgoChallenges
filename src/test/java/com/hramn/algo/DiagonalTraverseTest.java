package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiagonalTraverseTest {
	@Test
	@DisplayName("mat = [[1,2,3],[4,5,6],[7,8,9]] -> [1,2,4,7,5,3,6,8,9]")
	void testBestSolution_20250825FindDiagonalOrder1() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.BestSolution_20250825 solution = task.new BestSolution_20250825();
		int[] result = solution.findDiagonalOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1,2,4,7,5,3,6,8,9}, result));
	}

	@Test
	@DisplayName("mat = [[1,2],[3,4]] -> [1,2,3,4]")
	void testBestSolution_20250825FindDiagonalOrder2() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.BestSolution_20250825 solution = task.new BestSolution_20250825();
		int[] result = solution.findDiagonalOrder(new int[][] {{1,2},{3,4}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1,2,3,4}, result));
	}

	@Test
	@DisplayName("mat = [[1]] -> [1]")
	void testBestSolution_20250825FindDiagonalOrder3() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.BestSolution_20250825 solution = task.new BestSolution_20250825();
		int[] result = solution.findDiagonalOrder(new int[][] {{1}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1}, result));
	}

	@Test
	@DisplayName("mat = [[1,2,3],[4,5,6],[7,8,9]] -> [1,2,4,7,5,3,6,8,9]")
	void testSolution_20250825_2FindDiagonalOrder1() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.Solution_20250825_2 solution = task.new Solution_20250825_2();
		int[] result = solution.findDiagonalOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1,2,4,7,5,3,6,8,9}, result));
	}

	@Test
	@DisplayName("mat = [[1,2],[3,4]] -> [1,2,3,4]")
	void testSolution_20250825_2FindDiagonalOrder2() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.Solution_20250825_2 solution = task.new Solution_20250825_2();
		int[] result = solution.findDiagonalOrder(new int[][] {{1,2},{3,4}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1,2,3,4}, result));
	}

	@Test
	@DisplayName("mat = [[1]] -> [1]")
	void testSolution_20250825_2FindDiagonalOrder3() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.Solution_20250825_2 solution = task.new Solution_20250825_2();
		int[] result = solution.findDiagonalOrder(new int[][] {{1}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1}, result));
	}

	@Test
	@DisplayName("mat = [[1,2,3],[4,5,6],[7,8,9]] -> [1,2,4,7,5,3,6,8,9]")
	void testSolution_20250825_1FindDiagonalOrder1() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.Solution_20250825_1 solution = task.new Solution_20250825_1();
		int[] result = solution.findDiagonalOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1,2,4,7,5,3,6,8,9}, result));
	}

	@Test
	@DisplayName("mat = [[1,2],[3,4]] -> [1,2,3,4]")
	void testSolution_20250825_1FindDiagonalOrder2() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.Solution_20250825_1 solution = task.new Solution_20250825_1();
		int[] result = solution.findDiagonalOrder(new int[][] {{1,2},{3,4}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1,2,3,4}, result));
	}

	@Test
	@DisplayName("mat = [[1]] -> [1]")
	void testSolution_20250825_1FindDiagonalOrder3() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.Solution_20250825_1 solution = task.new Solution_20250825_1();
		int[] result = solution.findDiagonalOrder(new int[][] {{1}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1}, result));
	}

	@Test
	@DisplayName("mat = [[1,2,3],[4,5,6],[7,8,9]] -> [1,2,4,7,5,3,6,8,9]")
	void testOldSolutionFindDiagonalOrder1() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.OldSolution solution = task.new OldSolution();
		int[] result = solution.findDiagonalOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1,2,4,7,5,3,6,8,9}, result));
	}

	@Test
	@DisplayName("mat = [[1,2],[3,4]] -> [1,2,3,4]")
	void testOldSolutionFindDiagonalOrder2() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.OldSolution solution = task.new OldSolution();
		int[] result = solution.findDiagonalOrder(new int[][] {{1,2},{3,4}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1,2,3,4}, result));
	}

	@Test
	@DisplayName("mat = [[1]] -> [1]")
	void testOldSolutionFindDiagonalOrder3() {
		DiagonalTraverse task = new DiagonalTraverse();
		DiagonalTraverse.OldSolution solution = task.new OldSolution();
		int[] result = solution.findDiagonalOrder(new int[][] {{1}});
		assertNotNull(result);
		assertTrue(Arrays.equals(new int[] {1}, result));
	}
}
