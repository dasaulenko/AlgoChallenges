package com.hramn.algo.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ZeroArrayTransformationIITest {

	@Test
	@DisplayName("nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]] -> 2")
	void testPrefixSumSolutionMinZeroArray1() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.PrefixSumSolution solution = 
				parent.new PrefixSumSolution();
		int result = solution.minZeroArray(
				new int[]{2,0,2}, 
				new int[][]{{0,2,1},{0,2,1},{1,1,3}});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]] -> -1")
	void testPrefixSumSolutionMinZeroArray2() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.PrefixSumSolution solution = 
				parent.new PrefixSumSolution();
		int result = solution.minZeroArray(
				new int[]{4,3,2,1}, 
				new int[][]{{1,3,2},{0,2,1}});
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("nums = [0,0,0,0], queries = [[1,3,2],[0,2,1]] -> 0")
	void testPrefixSumSolutionMinZeroArray3() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.PrefixSumSolution solution = 
				parent.new PrefixSumSolution();
		int result = solution.minZeroArray(
				new int[]{0,0,0,0}, 
				new int[][]{{1,3,2},{0,2,1}});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("nums = [0], queries = [[1,3,2],[0,2,1]] -> 0")
	void testPrefixSumSolutionMinZeroArray4() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.PrefixSumSolution solution = 
				parent.new PrefixSumSolution();
		int result = solution.minZeroArray(
				new int[]{0}, 
				new int[][]{{1,3,2},{0,2,1}});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]] -> 2")
	void testBinarySearchSolutionMinZeroArray1() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.BinarySearchSolution solution = 
				parent.new BinarySearchSolution();
		int result = solution.minZeroArray(
				new int[]{2,0,2}, 
				new int[][]{{0,2,1},{0,2,1},{1,1,3}});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]] -> -1")
	void testBinarySearchSolutionMinZeroArray2() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.BinarySearchSolution solution = 
				parent.new BinarySearchSolution();
		int result = solution.minZeroArray(
				new int[]{4,3,2,1}, 
				new int[][]{{1,3,2},{0,2,1}});
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("nums = [0,0,0,0], queries = [[1,3,2],[0,2,1]] -> 0")
	void testBinarySearchSolutionMinZeroArray3() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.BinarySearchSolution solution = 
				parent.new BinarySearchSolution();
		int result = solution.minZeroArray(
				new int[]{0,0,0,0}, 
				new int[][]{{1,3,2},{0,2,1}});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("nums = [0], queries = [[1,3,2],[0,2,1]] -> 0")
	void testBinarySearchSolutionMinZeroArray4() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.BinarySearchSolution solution = 
				parent.new BinarySearchSolution();
		int result = solution.minZeroArray(
				new int[]{0}, 
				new int[][]{{1,3,2},{0,2,1}});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]] -> 2")
	void testBruteforceSolutionMinZeroArray1() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.BruteforceSolution solution = 
				parent.new BruteforceSolution();
		int result = solution.minZeroArray(
				new int[]{2,0,2}, 
				new int[][]{{0,2,1},{0,2,1},{1,1,3}});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]] -> -1")
	void testBruteforceSolutionMinZeroArray2() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.BruteforceSolution solution = 
				parent.new BruteforceSolution();
		int result = solution.minZeroArray(
				new int[]{4,3,2,1}, 
				new int[][]{{1,3,2},{0,2,1}});
		assertEquals(-1, result);
	}

	@Test
	@DisplayName("nums = [0,0,0,0], queries = [[1,3,2],[0,2,1]] -> 0")
	void testBruteforceSolutionMinZeroArray3() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.BruteforceSolution solution = 
				parent.new BruteforceSolution();
		int result = solution.minZeroArray(
				new int[]{0,0,0,0}, 
				new int[][]{{1,3,2},{0,2,1}});
		assertEquals(0, result);
	}

	@Test
	@DisplayName("nums = [0], queries = [[1,3,2],[0,2,1]] -> 0")
	void testBruteforceSolutionMinZeroArray4() {
		ZeroArrayTransformationII parent = new ZeroArrayTransformationII();
		ZeroArrayTransformationII.BruteforceSolution solution = 
				parent.new BruteforceSolution();
		int result = solution.minZeroArray(
				new int[]{0}, 
				new int[][]{{1,3,2},{0,2,1}});
		assertEquals(0, result);
	}

}
