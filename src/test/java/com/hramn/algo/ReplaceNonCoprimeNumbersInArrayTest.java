package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReplaceNonCoprimeNumbersInArrayTest {
	@Test
	@DisplayName("nums = [6,4,3,2,7,6,2] -> [12,7,6]")
	void testSolutionReplaceNonCoprimes1() {
		ReplaceNonCoprimeNumbersInArray task = new ReplaceNonCoprimeNumbersInArray();
		ReplaceNonCoprimeNumbersInArray.Solution solution = task.new Solution();
		List<Integer> result = solution.replaceNonCoprimes(new int[] {6,4,3,2,7,6,2});
		assertNotNull(result);
		assertEquals(List.of(12,7,6), result);
	}

	@Test
	@DisplayName("nums = [2,2,1,1,3,3,3] -> [2,1,1,3]")
	void testSolutionReplaceNonCoprimes2() {
		ReplaceNonCoprimeNumbersInArray task = new ReplaceNonCoprimeNumbersInArray();
		ReplaceNonCoprimeNumbersInArray.Solution solution = task.new Solution();
		List<Integer> result = solution.replaceNonCoprimes(new int[] {2,2,1,1,3,3,3});
		assertNotNull(result);
		assertEquals(List.of(2, 1, 1, 3), result);
	}
}
