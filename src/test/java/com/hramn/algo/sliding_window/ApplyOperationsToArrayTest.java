package com.hramn.algo.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplyOperationsToArrayTest {
	@Test
	@DisplayName("[1,2,2,1,1,0] -> [1,4,2,0,0,0]")
	void testApplyOperations1() {
		ApplyOperationsToArray applyOperationsToArray = 
				new ApplyOperationsToArray();
		ApplyOperationsToArray.Solution solution = 
				applyOperationsToArray.new Solution();
		int[] result = solution.applyOperations(new int[] {1,2,2,1,1,0});
		assertNotNull(result);
		assertEquals(6, result.length);
		assertTrue(Arrays.equals(result, new int[] {1,4,2,0,0,0}));
	}

	@Test
	@DisplayName("[0,1] -> [1,0]")
	void testApplyOperations2() {
		ApplyOperationsToArray applyOperationsToArray = 
				new ApplyOperationsToArray();
		ApplyOperationsToArray.Solution solution = 
				applyOperationsToArray.new Solution();
		int[] result = solution.applyOperations(new int[] {0,1});
		assertNotNull(result);
		assertEquals(2, result.length);
		assertTrue(Arrays.equals(result, new int[] {1,0}));
	}
}
