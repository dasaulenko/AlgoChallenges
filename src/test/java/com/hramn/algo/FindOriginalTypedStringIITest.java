package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindOriginalTypedStringIITest {
	@Test
	@DisplayName("word = \"aabbccdd\", k = 7 -> 5")
	void testSolutionPossibleStringCount1() {
		FindOriginalTypedStringII task = new FindOriginalTypedStringII();
		FindOriginalTypedStringII.Solution solution = task.new Solution();
		int result = solution.possibleStringCount("aabbccdd", 7);
		assertEquals(result, 5);
	}

	@Test
	@DisplayName("word = \"aabbccdd\", k = 8 -> 1")
	void testSolutionPossibleStringCount2() {
		FindOriginalTypedStringII task = new FindOriginalTypedStringII();
		FindOriginalTypedStringII.Solution solution = task.new Solution();
		int result = solution.possibleStringCount("aabbccdd", 8);
		assertEquals(result, 1);
	}

	@Test
	@DisplayName("word = \"aaabbb\", k = 3 -> 8")
	void testSolutionPossibleStringCount3() {
		FindOriginalTypedStringII task = new FindOriginalTypedStringII();
		FindOriginalTypedStringII.Solution solution = task.new Solution();
		int result = solution.possibleStringCount("aabbccdd", 8);
		assertEquals(result, 1);
	}

	@Test
	@DisplayName("word = \"oooocccdddssssssxxxxxxcccllllllqqqqwwwwvvvvbbbbbbbncccccccccpppppppppppppmm\", k = 31 -> 421718274")
	void testSolutionPossibleStringCount4() {
		FindOriginalTypedStringII task = new FindOriginalTypedStringII();
		FindOriginalTypedStringII.Solution solution = task.new Solution();
		int result = solution.possibleStringCount("oooocccdddssssssxxxxxxcccllllllqqqqwwwwvvvvbbbbbbbncccccccccpppppppppppppmm", 31);
		assertEquals(result, 421718274);
	}
}
