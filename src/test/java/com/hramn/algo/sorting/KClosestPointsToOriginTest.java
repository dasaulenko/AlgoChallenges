package com.hramn.algo.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KClosestPointsToOriginTest {

	@Test
	@DisplayName("points = [[1,3],[-2,2]], k = 1 -> [[-2,2]]")
	void testKClosest1 () {
		KClosestPointsToOrigin kClosestPointsToOrigin = 
				new KClosestPointsToOrigin();
		KClosestPointsToOrigin.Solution solution = 
				kClosestPointsToOrigin.new Solution();
		int[][] result = solution.kClosest(new int[][]{{1,3},{-2,2}}, 1);
		assertNotNull(result);
		assertEquals(result.length, 1);
		assertEquals(result[0].length, 2);
		assertEquals(result[0][0], -2);
		assertEquals(result[0][1], 2);
	}

	@Test
	@DisplayName("points = [[3,3],[5,-1],[-2,4]], k = 2 -> [[3,3],[-2,4]]")
	void testKClosest2 () {
		KClosestPointsToOrigin kClosestPointsToOrigin = 
				new KClosestPointsToOrigin();
		KClosestPointsToOrigin.Solution solution = 
				kClosestPointsToOrigin.new Solution();
		int[][] result = solution.kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
		assertNotNull(result);
		assertEquals(result.length, 2);
		assertEquals(result[0].length, 2);
		assertEquals(result[0][0], 3);
		assertEquals(result[0][1], 3);
		assertEquals(result[1].length, 2);
		assertEquals(result[1][0], -2);
		assertEquals(result[1][1], 4);
	}

}
