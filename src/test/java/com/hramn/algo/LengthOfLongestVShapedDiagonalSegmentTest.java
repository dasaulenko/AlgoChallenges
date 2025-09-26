package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LengthOfLongestVShapedDiagonalSegmentTest {
	final int[][] testGrid1 = new int[][] {
		{2,2,1,2,2},
		{2,0,2,2,0},
		{2,0,1,1,0},
		{1,0,2,2,2},
		{2,0,0,2,2}
	};

	final int[][] testGrid2 = new int[][] {
		{2,2,2,2,2},
		{2,0,2,2,0},
		{2,0,1,1,0},
		{1,0,2,2,2},
		{2,0,0,2,2}
	};

	final int[][] testGrid3 = new int[][] {
		{1,2,2,2,2},
		{2,2,2,2,0},
		{2,0,0,0,0},
		{0,0,2,2,2},
		{2,0,0,2,0}
	};

	final int[][] testGrid4 = new int[][] {{1}};

	final int[][] testGrid5 = new int[][] {
		{1,1,0,1,1,1,0,2,1,2},
		{0,1,0,0,2,1,2,1,2,0},
		{2,0,2,0,2,1,0,2,0,1},
		{2,2,2,0,2,0,2,0,1,0},
		{1,0,1,0,1,0,1,0,1,1}
	};
	
	@Test
	@DisplayName("testGrid1 -> 5")
	void testSolution20250904LenOfVDiagonal1() {
		LengthOfLongestVShapedDiagonalSegment task = new LengthOfLongestVShapedDiagonalSegment();
		LengthOfLongestVShapedDiagonalSegment.Solution20250904 solution = task.new Solution20250904();
		int result = solution.lenOfVDiagonal(testGrid1);
		assertEquals(5, result);
	}

	@Test
	@DisplayName("testGrid2 -> 4")
	void testSolution20250904LenOfVDiagonal2() {
		LengthOfLongestVShapedDiagonalSegment task = new LengthOfLongestVShapedDiagonalSegment();
		LengthOfLongestVShapedDiagonalSegment.Solution20250904 solution = task.new Solution20250904();
		int result = solution.lenOfVDiagonal(testGrid2);
		assertEquals(4, result);
	}

	@Test
	@DisplayName("testGrid3 -> 5")
	void testSolution20250904LenOfVDiagonal3() {
		LengthOfLongestVShapedDiagonalSegment task = new LengthOfLongestVShapedDiagonalSegment();
		LengthOfLongestVShapedDiagonalSegment.Solution20250904 solution = task.new Solution20250904();
		int result = solution.lenOfVDiagonal(testGrid3);
		assertEquals(5, result);
	}

	@Test
	@DisplayName("testGrid4 -> 1")
	void testSolution20250904LenOfVDiagonal4() {
		LengthOfLongestVShapedDiagonalSegment task = new LengthOfLongestVShapedDiagonalSegment();
		LengthOfLongestVShapedDiagonalSegment.Solution20250904 solution = task.new Solution20250904();
		int result = solution.lenOfVDiagonal(testGrid4);
		assertEquals(1, result);
	}

	@Test
	@DisplayName("testGrid5 -> 6")
	void testSolution20250904LenOfVDiagonal5() {
		LengthOfLongestVShapedDiagonalSegment task = new LengthOfLongestVShapedDiagonalSegment();
		LengthOfLongestVShapedDiagonalSegment.Solution20250904 solution = task.new Solution20250904();
		int result = solution.lenOfVDiagonal(testGrid5);
		assertEquals(6, result);
	}
}
