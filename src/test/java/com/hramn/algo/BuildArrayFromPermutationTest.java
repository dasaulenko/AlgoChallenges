package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuildArrayFromPermutationTest {
	@Test
	@DisplayName("nums = [0,2,1,5,3,4] -> [0,1,2,4,5,3]")
	void testSolutionBuildArray1() {
		BuildArrayFromPermutation main = new BuildArrayFromPermutation();
		BuildArrayFromPermutation.Solution solution = main.new Solution();
		int[] result = solution.buildArray(new int[] {0,2,1,5,3,4});
		assertNotNull(result);
		assertEquals(6, result.length);
		assertTrue(Arrays.equals(new int[] {0,1,2,4,5,3}, result));
	}

	@Test
	@DisplayName("nums = [5,0,1,2,3,4] -> [4,5,0,1,2,3]")
	void testSolutionBuildArray2() {
		BuildArrayFromPermutation main = new BuildArrayFromPermutation();
		BuildArrayFromPermutation.Solution solution = main.new Solution();
		int[] result = solution.buildArray(new int[] {5,0,1,2,3,4});
		assertNotNull(result);
		assertEquals(6, result.length);
		assertTrue(Arrays.equals(new int[] {4,5,0,1,2,3}, result));
	}

	@Test
	@DisplayName("nums = [0,2,1,5,3,4] -> [0,1,2,4,5,3]")
	void testBruteforceSolutionBuildArray1() {
		BuildArrayFromPermutation main = new BuildArrayFromPermutation();
		BuildArrayFromPermutation.BruteforceSolution solution 
				= main.new BruteforceSolution();
		int[] result = solution.buildArray(new int[] {0,2,1,5,3,4});
		assertNotNull(result);
		assertEquals(6, result.length);
		assertTrue(Arrays.equals(new int[] {0,1,2,4,5,3}, result));
	}

	@Test
	@DisplayName("nums = [5,0,1,2,3,4] -> [4,5,0,1,2,3]")
	void testBruteforceSolutionBuildArray2() {
		BuildArrayFromPermutation main = new BuildArrayFromPermutation();
		BuildArrayFromPermutation.BruteforceSolution solution 
				= main.new BruteforceSolution();
		int[] result = solution.buildArray(new int[] {5,0,1,2,3,4});
		assertNotNull(result);
		assertEquals(6, result.length);
		assertTrue(Arrays.equals(new int[] {4,5,0,1,2,3}, result));
	}
}
