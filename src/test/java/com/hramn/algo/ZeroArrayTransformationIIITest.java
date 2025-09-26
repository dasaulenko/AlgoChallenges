package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ZeroArrayTransformationIIITest {
	@Test
	@DisplayName("[2,0,2], queries = [[0,2],[0,2],[1,1]] -> 1")
	void testSolutionMaxRemoval1() {
		ZeroArrayTransformationIII main = new ZeroArrayTransformationIII();
		ZeroArrayTransformationIII.Solution solution = main.new Solution();
		int result = solution.maxRemoval(
				new int[] {2,0,2}, new int[][] {{0,2},{0,2},{1,1}});
		assertEquals(1, result);
	}

	@Test
	@DisplayName("nums = [1,1,1,1], queries = [[1,3],[0,2],[1,3],[1,2]] -> 2")
	void testSolutionMaxRemoval2() {
		ZeroArrayTransformationIII main = new ZeroArrayTransformationIII();
		ZeroArrayTransformationIII.Solution solution = main.new Solution();
		int result = solution.maxRemoval(
				new int[] {1,1,1,1}, new int[][] {{1,3},{0,2},{1,3},{1,2}});
		assertEquals(2, result);
	}

	@Test
	@DisplayName("nums = [1,2,3,4], queries = [[0,3]] -> -1")
	void testSolutionMaxRemoval3() {
		ZeroArrayTransformationIII main = new ZeroArrayTransformationIII();
		ZeroArrayTransformationIII.Solution solution = main.new Solution();
		int result = solution.maxRemoval(
				new int[] {1,2,3,4}, new int[][] {{0,3}});
		assertEquals(-1, result);
	}
}
