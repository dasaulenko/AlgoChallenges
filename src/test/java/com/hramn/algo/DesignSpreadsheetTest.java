package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DesignSpreadsheetTest {
/* 
	Input:
 	["Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue"]
	[[3], ["=5+7"], ["A1", 10], ["=A1+6"], ["B2", 15], ["=A1+B2"], ["A1"], ["=A1+B2"]]
	Output:
	[null, 12, null, 16, null, 25, null, 15]
*/
	@Test
	void testSpreadsheet() {
		DesignSpreadsheet task = new DesignSpreadsheet();
		DesignSpreadsheet.Spreadsheet spreadsheet = task.new Spreadsheet(3);
		int result1 = spreadsheet.getValue("=5+7");
		assertEquals(12, result1);
		spreadsheet.setCell("A1", 10);
		int result2 = spreadsheet.getValue("=A1+6");
		assertEquals(16, result2);
		spreadsheet.setCell("B2", 15);
		int result3 = spreadsheet.getValue("=A1+B2");
		assertEquals(25, result3);
		spreadsheet.resetCell("A1");
		int result4 = spreadsheet.getValue("=A1+B2");
		assertEquals(15, result4);
	}
}
