package com.hramn.algo.sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumRecolorsToGetKConsecutiveBlackBlocksTest {
	@Test
	@DisplayName("blocks = \"WBBWWBBWBW\", k = 7 -> 3")
	void testMinimumRecolors1() {
		MinimumRecolorsToGetKConsecutiveBlackBlocks parent = 
				new MinimumRecolorsToGetKConsecutiveBlackBlocks();
		MinimumRecolorsToGetKConsecutiveBlackBlocks.Solution solution = 
				parent.new Solution();
		int result = solution.minimumRecolors("WBBWWBBWBW", 7);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("blocks = \"WBWBBBW\", k = 2 -> 0")
	void testMinimumRecolors2() {
		MinimumRecolorsToGetKConsecutiveBlackBlocks parent = 
				new MinimumRecolorsToGetKConsecutiveBlackBlocks();
		MinimumRecolorsToGetKConsecutiveBlackBlocks.Solution solution = 
				parent.new Solution();
		int result = solution.minimumRecolors("WBWBBBW", 2);
		assertEquals(0, result);
	}
}
