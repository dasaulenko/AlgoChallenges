package com.hramn.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ZigzagConversionTest {
	@Test
	@DisplayName("s = \"PAYPALISHIRING\", numRows = 3 -> \"PAHNAPLSIIGYIR\"")
	void testSolutionConvert1() {
		ZigzagConversion task = new ZigzagConversion();
		ZigzagConversion.Solution solution = task.new Solution();
		String result = solution.convert("PAYPALISHIRING", 3);
		assert "PAHNAPLSIIGYIR".equals(result);
	}

	@Test
	@DisplayName("s = \"PAYPALISHIRING\", numRows = 4 -> \"PINALSIGYAHRPI\"")
	void testSolutionConvert2() {
		ZigzagConversion task = new ZigzagConversion();
		ZigzagConversion.Solution solution = task.new Solution();
		String result = solution.convert("PAYPALISHIRING", 4);
		assert "PINALSIGYAHRPI".equals(result);
	}
}
