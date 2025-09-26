package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ImplementRouterTest {
	@Test
	// Input:
	// ["Router", "addPacket", "addPacket", "addPacket", "addPacket", "addPacket", "forwardPacket", "addPacket", "getCount"]
	// [[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]]
	// Output:
	// [null, true, true, false, true, true, [2, 5, 90], true, 1]
	void testRouter1() {
		ImplementRouter task = new ImplementRouter();
		ImplementRouter.Router router = task.new Router(3);
		boolean result1 = router.addPacket(1, 4, 90);
		assertTrue(result1);
		boolean result2 = router.addPacket(2, 5, 90);
		assertTrue(result2);
		boolean result3 = router.addPacket(1, 4, 90);
		assertFalse(result3);
		boolean result4 = router.addPacket(3, 5, 95);
		assertTrue(result4);
		boolean result5 = router.addPacket(4, 5, 105);
		assertTrue(result5);
		int[] result6 = router.forwardPacket();
		assertNotNull(result6);
		assertTrue(Arrays.equals(new int[] {2, 5, 90}, result6));
		boolean result7 = router.addPacket(5, 2, 110);
		assertTrue(result7);
		int result8 = router.getCount(5, 100, 110);
		assertEquals(1, result8);
	}

	@Test
	// Input:
	// ["Router", "addPacket", "forwardPacket", "forwardPacket"]
	// [[2], [7, 4, 90], [], []]
	// Output:
	// [null, true, [7, 4, 90], []]
	void testRouter2() {
		ImplementRouter task = new ImplementRouter();
		ImplementRouter.Router router = task.new Router(2);
		boolean result1 = router.addPacket(7, 4, 90);
		assertTrue(result1);
		int[] result2 = router.forwardPacket();
		assertNotNull(result2);
		assertTrue(Arrays.equals(new int[] {7, 4, 90}, result2));
		int[] result3 = router.forwardPacket();
		assertNotNull(result3);
		assertEquals(0, result3.length);
	}
}
