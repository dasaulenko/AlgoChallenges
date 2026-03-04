package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberOfStepsToReduceNumberInBinaryRepresentationToOneTest {
	
	@Test
	@DisplayName("s = \"1101\" -> 6")
	void testSolutionNumSteps1() {
		NumberOfStepsToReduceNumberInBinaryRepresentationToOne task 
			= new NumberOfStepsToReduceNumberInBinaryRepresentationToOne();
		NumberOfStepsToReduceNumberInBinaryRepresentationToOne.Solution solution 
			= task.new Solution();
		int result = solution.numSteps("1101");
		assert result == 6;
	}

	@Test
	@DisplayName("s = \"10\" -> 1")
	void testSolutionNumSteps2() {
		NumberOfStepsToReduceNumberInBinaryRepresentationToOne task 
			= new NumberOfStepsToReduceNumberInBinaryRepresentationToOne();
		NumberOfStepsToReduceNumberInBinaryRepresentationToOne.Solution solution 
			= task.new Solution();
		int result = solution.numSteps("10");
		assert result == 1;
	}

	@Test
	@DisplayName("s = \"1\" -> 0")
	void testSolutionNumSteps3() {
		NumberOfStepsToReduceNumberInBinaryRepresentationToOne task 
			= new NumberOfStepsToReduceNumberInBinaryRepresentationToOne();
		NumberOfStepsToReduceNumberInBinaryRepresentationToOne.Solution solution 
			= task.new Solution();
		int result = solution.numSteps("1");
		assert result == 0;
	}
}
