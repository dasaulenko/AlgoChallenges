package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleTest {
	@Test
	@DisplayName("Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]] -> 11")
	void testFirstSolutionMinimumTotal1() {
		Triangle task = new Triangle();
		Triangle.FirstSolution solution = task.new FirstSolution();
		int result = solution.minimumTotal(
			List.of(
				List.of(2),
				List.of(3,4),
				List.of(6,5,7),
				List.of(4,1,8,3)
			)
		);
		assertEquals(11, result);
	}

	@Test
	@DisplayName("triangle = [[-10]] -> -10")
	void testFirstSolutionMinimumTotal2() {
		Triangle task = new Triangle();
		Triangle.FirstSolution solution = task.new FirstSolution();
		int result = solution.minimumTotal(
			List.of(List.of(-10)));
		assertEquals(-10, result);
	}

	@Test
	@DisplayName("Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]] -> 11")
	void testFastestSolutionMinimumTotal1() {
		Triangle task = new Triangle();
		Triangle.FastestSolution solution = task.new FastestSolution();
		int result = solution.minimumTotal(
			List.of(
				List.of(2),
				List.of(3,4),
				List.of(6,5,7),
				List.of(4,1,8,3)
			)
		);
		assertEquals(11, result);
	}

	@Test
	@DisplayName("triangle = [[-10]] -> -10")
	void testFastestSolutionMinimumTotal2() {
		Triangle task = new Triangle();
		Triangle.FastestSolution solution = task.new FastestSolution();
		int result = solution.minimumTotal(
			List.of(List.of(-10)));
		assertEquals(-10, result);
	}

	@Test
	@DisplayName("Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]] -> 11")
	void testInPlaceSolutionMinimumTotal1() {
		Triangle task = new Triangle();
		Triangle.InPlaceSolution solution = task.new InPlaceSolution();
		int result = solution.minimumTotal(
			new ArrayList<>(List.of(
				new ArrayList<>(List.of(2)),
				new ArrayList<>(List.of(3,4)),
				new ArrayList<>(List.of(6,5,7)),
				new ArrayList<>(List.of(4,1,8,3))
			)
		));
		assertEquals(11, result);
	}

	@Test
	@DisplayName("triangle = [[-10]] -> -10")
	void testInPlaceSolutionMinimumTotal2() {
		Triangle task = new Triangle();
		Triangle.InPlaceSolution solution = task.new InPlaceSolution();
		int result = solution.minimumTotal(
			new ArrayList<>(List.of(new ArrayList<>(List.of(-10)))));
		assertEquals(-10, result);
	}

	@Test
	@DisplayName("Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]] -> 11")
	void testFollowUpSolutionMinimumTotal1() {
		Triangle task = new Triangle();
		Triangle.FollowUpSolution solution = task.new FollowUpSolution();
		int result = solution.minimumTotal(
			List.of(
				List.of(2),
				List.of(3,4),
				List.of(6,5,7),
				List.of(4,1,8,3)
			)
		);
		assertEquals(11, result);
	}

	@Test
	@DisplayName("triangle = [[-10]] -> -10")
	void testFollowUpSolutionMinimumTotal2() {
		Triangle task = new Triangle();
		Triangle.FollowUpSolution solution = task.new FollowUpSolution();
		int result = solution.minimumTotal(
			List.of(List.of(-10)));
		assertEquals(-10, result);
	}
}
