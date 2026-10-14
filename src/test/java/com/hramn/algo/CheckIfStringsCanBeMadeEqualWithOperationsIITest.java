package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckIfStringsCanBeMadeEqualWithOperationsIITest {
	@Test
	@DisplayName("s1 = \"abcdba\", s2 = \"cabdab\" -> true")
	void testSolutionCheckStrings1() {
		CheckIfStringsCanBeMadeEqualWithOperationsII task 
				= new CheckIfStringsCanBeMadeEqualWithOperationsII();
		CheckIfStringsCanBeMadeEqualWithOperationsII.Solution solution 
				= task.new Solution();
		boolean result = solution.checkStrings("abcdba", "cabdab");
		assert result;
	}

	@Test
	@DisplayName("s1 = \"abe\", s2 = \"bea\" -> false")
	void testSolutionCheckStrings2() {
		CheckIfStringsCanBeMadeEqualWithOperationsII task 
				= new CheckIfStringsCanBeMadeEqualWithOperationsII();
		CheckIfStringsCanBeMadeEqualWithOperationsII.Solution solution 
				= task.new Solution();
		boolean result = solution.checkStrings("abe", "bea");
		assert !result;
	}
}
