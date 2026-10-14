package com.hramn.algo;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortIntegersByNumberOf1BitsTest {

	@Test
	@DisplayName("arr = [0,1,2,3,4,5,6,7,8] -> [0,1,2,4,8,3,5,6,7]")
	void testSolutionSortByBits1() {
		SortIntegersByNumberOf1Bits task = new SortIntegersByNumberOf1Bits();
		SortIntegersByNumberOf1Bits.Solution solution = task.new Solution();
		int[] arr = {0,1,2,3,4,5,6,7,8};
		int[] expected = {0,1,2,4,8,3,5,6,7};
		int[] result = solution.sortByBits(arr);
		assert Arrays.equals(result, expected);
	}

	@Test
	@DisplayName("arr = [1024,512,256,128,64,32,16,8,4,2,1] -> [1,2,4,8,16,32,64,128,256,512,1024]")
	void testSolutionSortByBits2() {
		SortIntegersByNumberOf1Bits task = new SortIntegersByNumberOf1Bits();
		SortIntegersByNumberOf1Bits.Solution solution = task.new Solution();
		int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
		int[] expected = {1,2,4,8,16,32,64,128,256,512,1024};
		int[] result = solution.sortByBits(arr);
		assert Arrays.equals(result, expected);
	}
}
