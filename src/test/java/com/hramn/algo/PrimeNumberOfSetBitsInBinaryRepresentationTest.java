package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrimeNumberOfSetBitsInBinaryRepresentationTest {
	@Test
	@DisplayName("left = 6, right = 10 -> 4")
	void testSolutionCountPrimeSetBits1() {
		PrimeNumberOfSetBitsInBinaryRepresentation task 
			= new PrimeNumberOfSetBitsInBinaryRepresentation();
		PrimeNumberOfSetBitsInBinaryRepresentation.Solution solution 
			= task.new Solution();
		int result = solution.countPrimeSetBits(6, 10);
		assert result == 4;
	}

	@Test
	@DisplayName("left = 10, right = 15 -> 5")
	void testSolutionCountPrimeSetBits2() {
		PrimeNumberOfSetBitsInBinaryRepresentation task 
			= new PrimeNumberOfSetBitsInBinaryRepresentation();
		PrimeNumberOfSetBitsInBinaryRepresentation.Solution solution 
			= task.new Solution();
		int result = solution.countPrimeSetBits(10, 15);
		assert result == 5;
	}
}
