package com.hramn.algo.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumIndexOfValidSplitTest {
	@Test
	@DisplayName("nums = [1,2,2,2] -> 2")
	void testMinimumIndex1() {
		MinimumIndexOfValidSplit parent = new MinimumIndexOfValidSplit();
		MinimumIndexOfValidSplit.Solution solution = parent.new Solution();
		int result = solution.minimumIndex(List.of(1,2,2,2));
		assertEquals(2, result);
	}

	@Test
	@DisplayName("nums = [2,1,3,1,1,1,7,1,2,1] -> 4")
	void testMinimumIndex2() {
		MinimumIndexOfValidSplit parent = new MinimumIndexOfValidSplit();
		MinimumIndexOfValidSplit.Solution solution = parent.new Solution();
		int result = solution.minimumIndex(List.of(2,1,3,1,1,1,7,1,2,1));
		assertEquals(4, result);
	}

	@Test
	@DisplayName("nums = [3,3,3,3,7,2,2] -> -1")
	void testMinimumIndex3() {
		MinimumIndexOfValidSplit parent = new MinimumIndexOfValidSplit();
		MinimumIndexOfValidSplit.Solution solution = parent.new Solution();
		int result = solution.minimumIndex(List.of(3,3,3,3,7,2,2));
		assertEquals(-1, result);
	}


}
