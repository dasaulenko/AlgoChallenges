package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertBinaryNumberInLinkedListToIntegerTest {
	@Test
	@DisplayName("head = [1,0,1] -> 5")
	void testSolutionGetDecimalValue1() {
		ConvertBinaryNumberInLinkedListToInteger task = new ConvertBinaryNumberInLinkedListToInteger();
		ConvertBinaryNumberInLinkedListToInteger.Solution solution = task.new Solution();
		ConvertBinaryNumberInLinkedListToInteger.ListNode listNode2 = task.new ListNode(1);
		ConvertBinaryNumberInLinkedListToInteger.ListNode listNode1 = task.new ListNode(0, listNode2);
		ConvertBinaryNumberInLinkedListToInteger.ListNode listNode0 = task.new ListNode(1, listNode1);
		int result = solution.getDecimalValue(listNode0);
		assertEquals(5, result);
	}

	@Test
	@DisplayName("head = [0] -> 0")
	void testSolutionGetDecimalValue2() {
		ConvertBinaryNumberInLinkedListToInteger task = new ConvertBinaryNumberInLinkedListToInteger();
		ConvertBinaryNumberInLinkedListToInteger.Solution solution = task.new Solution();
		ConvertBinaryNumberInLinkedListToInteger.ListNode listNode0 = task.new ListNode(0);
		int result = solution.getDecimalValue(listNode0);
		assertEquals(0, result);
	}
}
