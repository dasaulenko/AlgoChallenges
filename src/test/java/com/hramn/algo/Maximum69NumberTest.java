package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Maximum69NumberTest {
	@Test
	@DisplayName("num = 9669 -> 9969")
	void testSolutionMaximum69Number1() {
		Maximum69Number task = new Maximum69Number();
		Maximum69Number.Solution solution = task.new Solution();
		int result = solution.maximum69Number(9669);
		assertEquals(result, 9969);
	}

	@Test
	@DisplayName("num = 9996 -> 9999")
	void testSolutionMaximum69Number2() {
		Maximum69Number task = new Maximum69Number();
		Maximum69Number.Solution solution = task.new Solution();
		int result = solution.maximum69Number(9996);
		assertEquals(result, 9999);
	}

	@Test
	@DisplayName("num = 9999 -> 9999")
	void testSolutionMaximum69Number3() {
		Maximum69Number task = new Maximum69Number();
		Maximum69Number.Solution solution = task.new Solution();
		int result = solution.maximum69Number(9999);
		assertEquals(result, 9999);
	}
}
