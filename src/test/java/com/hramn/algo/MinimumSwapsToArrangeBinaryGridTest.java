package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MinimumSwapsToArrangeBinaryGridTest {

	@Test
	@DisplayName("grid = [[0,0,1],[1,1,0],[1,0,0]] -> 3")
	void testMinSwaps1() {
		MinimumSwapsToArrangeBinaryGrid task = new MinimumSwapsToArrangeBinaryGrid();
		MinimumSwapsToArrangeBinaryGrid.Solution solution = task.new Solution();
		int result = solution.minSwaps(new int[][] {{0,0,1},{1,1,0},{1,0,0}});
		assertEquals(3, result);
	}

	@Test
	@DisplayName("grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]] -> -1")
	void testMinSwaps2() {
		MinimumSwapsToArrangeBinaryGrid task = new MinimumSwapsToArrangeBinaryGrid();
		MinimumSwapsToArrangeBinaryGrid.Solution solution = task.new Solution();
		int result = solution.minSwaps(new int[][] {{0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0}});
		assertEquals(-1, result);
	}
	
	@Test
	@DisplayName("grid = [[1,0,0],[1,1,0],[1,1,1]] -> 0")
	void testMinSwaps3() {
		MinimumSwapsToArrangeBinaryGrid task = new MinimumSwapsToArrangeBinaryGrid();
		MinimumSwapsToArrangeBinaryGrid.Solution solution = task.new Solution();
		int result = solution.minSwaps(new int[][] {{1,0,0},{1,1,0},{1,1,1}});
		assertEquals(0, result);
	}
	
}
