package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest {
	@Test
	@DisplayName("s = \"1001\" -> false")
	void testSolution1CheckOnesSegment1() {
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes task 
			= new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes.Solution1 solution 
			= task.new Solution1();
		boolean result = solution.checkOnesSegment("1001");
		assert !result;
	}

	@Test
	@DisplayName("s = \"1100\" -> true")
	void testSolution1CheckOnesSegment2() {
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes task 
			= new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes.Solution1 solution 
			= task.new Solution1();
		boolean result = solution.checkOnesSegment("1100");
		assert result;
	}

	@Test
	@DisplayName("s = \"1001\" -> false")
	void testSolution2CheckOnesSegment1() {
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes task 
			= new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes.Solution2 solution 
			= task.new Solution2();
		boolean result = solution.checkOnesSegment("1001");
		assert !result;
	}

	@Test
	@DisplayName("s = \"1100\" -> true")
	void testSolution2CheckOnesSegment2() {
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes task 
			= new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes.Solution2 solution 
			= task.new Solution2();
		boolean result = solution.checkOnesSegment("1100");
		assert result;
	}

		@Test
	@DisplayName("s = \"1001\" -> false")
	void testSolution3CheckOnesSegment1() {
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes task 
			= new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes.Solution3 solution 
			= task.new Solution3();
		boolean result = solution.checkOnesSegment("1001");
		assert !result;
	}

	@Test
	@DisplayName("s = \"1100\" -> true")
	void testSolution3CheckOnesSegment2() {
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes task 
			= new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes.Solution3 solution 
			= task.new Solution3();
		boolean result = solution.checkOnesSegment("1100");
		assert result;
	}
}
