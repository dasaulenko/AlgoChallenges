package com.hramn.algo.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LengthOfLongestFibonacciSubsequenceTest {
	@Test
	@DisplayName("[1,2,3,4,5,6,7,8] -> 5")
	void testDynamicProgrammingSolution2LenLongestFibSubseq1() {
		LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = 
				new LengthOfLongestFibonacciSubsequence();
		LengthOfLongestFibonacciSubsequence.DynamicProgrammingSolution2 solution = 
				lengthOfLongestFibonacciSubsequence.new DynamicProgrammingSolution2();
		assertEquals(5, solution.lenLongestFibSubseq(
			new int[] {1,2,3,4,5,6,7,8}));
	}

	@Test
	@DisplayName("[1,3,7,11,12,14,18] -> 3")
	void testDynamicProgrammingSolution2LenLongestFibSubseq2() {
		LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = 
				new LengthOfLongestFibonacciSubsequence();
		LengthOfLongestFibonacciSubsequence.DynamicProgrammingSolution2 solution = 
				lengthOfLongestFibonacciSubsequence.new DynamicProgrammingSolution2();
		assertEquals(3, solution.lenLongestFibSubseq(
			new int[] {1,3,7,11,12,14,18}));
	}

	@Test
	@DisplayName("[2,4,7,8,9,10,14,15,18,23,32,50] -> 5")
	void testDynamicProgrammingSolution2LenLongestFibSubseq3() {
		LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = 
				new LengthOfLongestFibonacciSubsequence();
		LengthOfLongestFibonacciSubsequence.DynamicProgrammingSolution2 solution = 
				lengthOfLongestFibonacciSubsequence.new DynamicProgrammingSolution2();
		assertEquals(5, solution.lenLongestFibSubseq(
			new int[] {2,4,7,8,9,10,14,15,18,23,32,50}));
	}

	@Test
	@DisplayName("[1,2,3,4,5,6,7,8] -> 5")
	void testDynamicProgrammingSolution1LenLongestFibSubseq1() {
		LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = 
				new LengthOfLongestFibonacciSubsequence();
		LengthOfLongestFibonacciSubsequence.DynamicProgrammingSolution1 solution = 
				lengthOfLongestFibonacciSubsequence.new DynamicProgrammingSolution1();
		assertEquals(5, solution.lenLongestFibSubseq(
			new int[] {1,2,3,4,5,6,7,8}));
	}

	@Test
	@DisplayName("[1,3,7,11,12,14,18] -> 3")
	void testDynamicProgrammingSolution1LenLongestFibSubseq2() {
		LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = 
				new LengthOfLongestFibonacciSubsequence();
		LengthOfLongestFibonacciSubsequence.DynamicProgrammingSolution1 solution = 
				lengthOfLongestFibonacciSubsequence.new DynamicProgrammingSolution1();
		assertEquals(3, solution.lenLongestFibSubseq(
			new int[] {1,3,7,11,12,14,18}));
	}

	@Test
	@DisplayName("[2,4,7,8,9,10,14,15,18,23,32,50] -> 5")
	void testDynamicProgrammingSolution1LenLongestFibSubseq3() {
		LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = 
				new LengthOfLongestFibonacciSubsequence();
		LengthOfLongestFibonacciSubsequence.DynamicProgrammingSolution1 solution = 
				lengthOfLongestFibonacciSubsequence.new DynamicProgrammingSolution1();
		assertEquals(5, solution.lenLongestFibSubseq(
			new int[] {2,4,7,8,9,10,14,15,18,23,32,50}));
	}

	@Test
	@DisplayName("[1,2,3,4,5,6,7,8] -> 5")
	void testBruteforceSolution2LenLongestFibSubseq1() {
		LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = 
				new LengthOfLongestFibonacciSubsequence();
		LengthOfLongestFibonacciSubsequence.BruteforceSolution2 solution = 
				lengthOfLongestFibonacciSubsequence.new BruteforceSolution2();
		assertEquals(5, solution.lenLongestFibSubseq(
			new int[] {1,2,3,4,5,6,7,8}));
	}

	@Test
	@DisplayName("[1,3,7,11,12,14,18] -> 3")
	void testBruteforceSolution2LenLongestFibSubseq2() {
		LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = 
				new LengthOfLongestFibonacciSubsequence();
		LengthOfLongestFibonacciSubsequence.BruteforceSolution2 solution = 
				lengthOfLongestFibonacciSubsequence.new BruteforceSolution2();
		assertEquals(3, solution.lenLongestFibSubseq(
			new int[] {1,3,7,11,12,14,18}));
	}

	@Test
	@DisplayName("[2,4,7,8,9,10,14,15,18,23,32,50] -> 5")
	void testBruteforceSolution2LenLongestFibSubseq3() {
		LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = 
				new LengthOfLongestFibonacciSubsequence();
		LengthOfLongestFibonacciSubsequence.BruteforceSolution2 solution = 
				lengthOfLongestFibonacciSubsequence.new BruteforceSolution2();
		assertEquals(5, solution.lenLongestFibSubseq(
			new int[] {2,4,7,8,9,10,14,15,18,23,32,50}));
	}

	@Test
	@DisplayName("[1,2,3,4,5,6,7,8] -> 5")
	void testBruteforceSolution1LenLongestFibSubseq1() {
		LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = 
				new LengthOfLongestFibonacciSubsequence();
		LengthOfLongestFibonacciSubsequence.BruteforceSolution1 solution = 
				lengthOfLongestFibonacciSubsequence.new BruteforceSolution1();
		assertEquals(5, solution.lenLongestFibSubseq(
			new int[] {1,2,3,4,5,6,7,8}));
	}

	@Test
	@DisplayName("[1,3,7,11,12,14,18] -> 3")
	void testBruteforceSolution1LenLongestFibSubseq2() {
		LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = 
				new LengthOfLongestFibonacciSubsequence();
		LengthOfLongestFibonacciSubsequence.BruteforceSolution1 solution = 
				lengthOfLongestFibonacciSubsequence.new BruteforceSolution1();
		assertEquals(3, solution.lenLongestFibSubseq(
			new int[] {1,3,7,11,12,14,18}));
	}
}
