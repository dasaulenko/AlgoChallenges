package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PartitionArraySuchThatMaximumDifferenceIsKTest {
	@Test
	@DisplayName("nums = [3,6,1,2,5], k = 2 -> 2")
	void testSolutionPartitionArray1() {
		PartitionArraySuchThatMaximumDifferenceIsK task = new PartitionArraySuchThatMaximumDifferenceIsK();
		PartitionArraySuchThatMaximumDifferenceIsK.Solution solution = task.new Solution();
		int result = solution.partitionArray(new int[] {3,6,1,2,5}, 2);
		assertEquals(2, result);
	}

	@Test
	@DisplayName("nums = [1,2,3], k = 1 -> 2")
	void testSolutionPartitionArray2() {
		PartitionArraySuchThatMaximumDifferenceIsK task = new PartitionArraySuchThatMaximumDifferenceIsK();
		PartitionArraySuchThatMaximumDifferenceIsK.Solution solution = task.new Solution();
		int result = solution.partitionArray(new int[] {1,2,3}, 1);
		assertEquals(2, result);
	}

	@Test
	@DisplayName("nums = [2,2,4,5], k = 0 -> 3")
	void testSolutionPartitionArray3() {
		PartitionArraySuchThatMaximumDifferenceIsK task = new PartitionArraySuchThatMaximumDifferenceIsK();
		PartitionArraySuchThatMaximumDifferenceIsK.Solution solution = task.new Solution();
		int result = solution.partitionArray(new int[] {2,2,4,5}, 0);
		assertEquals(3, result);
	}
}
