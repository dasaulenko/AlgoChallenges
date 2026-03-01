package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

public class DesignMovieRentalSystemTest {
	/*
	Test case:
	Input
 		["MovieRentingSystem", "search", "rent", "rent", "report", "drop", "search"]
 		[[3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]], [1], [0, 1], [1, 2], [], [1, 2], [2]]
 	Output
 		[null, [1, 0, 2], null, null, [[0, 1], [1, 2]], null, [0, 1]]
	 */
	final private int n = 3;
	final private int[][] entries = new int[][] {{0, 1, 5}, {0, 2, 6}, {0, 3, 7},{1, 1, 4}, {1, 2, 7}, {2, 1, 5}};

	@Test
	void testMovieRentingSystemPQ() {
		DesignMovieRentalSystem task = new DesignMovieRentalSystem();
		DesignMovieRentalSystem.MovieRentingSystemPQ mrs = 
			task.new MovieRentingSystemPQ(n, entries);
		List<Integer> result1 = mrs.search(1);
		assertNotNull(result1);
		assertEquals(List.of(1, 0, 2), result1);
		mrs.rent(0, 1);
		mrs.rent(1, 2);
		List<List<Integer>> result2 = mrs.report();
		assertNotNull(result2);
		assertEquals(List.of(List.of(0, 1), List.of(1, 2)), result2);
		mrs.drop(1, 2);
		List<Integer> result3 = mrs.search(2);
		assertNotNull(result3);
		assertEquals(List.of(0, 1), result3);
	}

	@Test
	void testMovieRentingSystemTS() {
		DesignMovieRentalSystem task = new DesignMovieRentalSystem();
		DesignMovieRentalSystem.MovieRentingSystemTS mrs = 
			task.new MovieRentingSystemTS(n, entries);
		List<Integer> result1 = mrs.search(1);
		assertNotNull(result1);
		assertEquals(List.of(1, 0, 2), result1);
		mrs.rent(0, 1);
		mrs.rent(1, 2);
		List<List<Integer>> result2 = mrs.report();
		assertNotNull(result2);
		assertEquals(List.of(List.of(0, 1), List.of(1, 2)), result2);
		mrs.drop(1, 2);
		List<Integer> result3 = mrs.search(2);
		assertNotNull(result3);
		assertEquals(List.of(0, 1), result3);
	}
}
