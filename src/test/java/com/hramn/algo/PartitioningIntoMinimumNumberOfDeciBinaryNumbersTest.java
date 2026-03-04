package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest {

	@Test
	@DisplayName("n = \"32\" -> 3")
	void testMinPartitions1() {
		PartitioningIntoMinimumNumberOfDeciBinaryNumbers task = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();
		PartitioningIntoMinimumNumberOfDeciBinaryNumbers.Solution solution = task.new Solution();
		int result = solution.minPartitions("32");
		assertEquals(3, result);
	}

	@Test
	@DisplayName("n = \"82734\" -> 8")
	void testMinPartitions2() {
		PartitioningIntoMinimumNumberOfDeciBinaryNumbers task = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();
		PartitioningIntoMinimumNumberOfDeciBinaryNumbers.Solution solution = task.new Solution();
		int result = solution.minPartitions("82734");
		assertEquals(8, result);
	}
	
	@Test
	@DisplayName("n = \"27346209830709182346\" -> 9")
	void testMinPartitions3() {
		PartitioningIntoMinimumNumberOfDeciBinaryNumbers task = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();
		PartitioningIntoMinimumNumberOfDeciBinaryNumbers.Solution solution = task.new Solution();
		int result = solution.minPartitions("27346209830709182346");
		assertEquals(9, result);
	}
	
}
