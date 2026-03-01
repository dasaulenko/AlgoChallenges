package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistributeCandiesAmongChildrenIITest {
	@Test
	@DisplayName("n = 5, limit = 2 -> 3")
	void testEnumerationSolutionDistributeCandies1() {
		DistributeCandiesAmongChildrenII task = new DistributeCandiesAmongChildrenII();
		DistributeCandiesAmongChildrenII.EnumerationSolution solution = task.new EnumerationSolution();
		long result = solution.distributeCandies(5, 2);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("n = 3, limit = 3 -> 10")
	void testEnumerationSolutionDistributeCandies2() {
		DistributeCandiesAmongChildrenII task = new DistributeCandiesAmongChildrenII();
		DistributeCandiesAmongChildrenII.EnumerationSolution solution = task.new EnumerationSolution();
		long result = solution.distributeCandies(3, 3);
		assertEquals(10, result);
	}

	@Test
	@DisplayName("n = 5, limit = 2 -> 3")
	void testCombinatoricsSolutionDistributeCandies1() {
		DistributeCandiesAmongChildrenII task = new DistributeCandiesAmongChildrenII();
		DistributeCandiesAmongChildrenII.CombinatoricsSolution solution = task.new CombinatoricsSolution();
		long result = solution.distributeCandies(5, 2);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("n = 3, limit = 3 -> 10")
	void testCombinatoricsSolutionDistributeCandies2() {
		DistributeCandiesAmongChildrenII task = new DistributeCandiesAmongChildrenII();
		DistributeCandiesAmongChildrenII.CombinatoricsSolution solution = task.new CombinatoricsSolution();
		long result = solution.distributeCandies(3, 3);
		assertEquals(10, result);
	}

	@Test
	@DisplayName("n = 5, limit = 2 -> 3")
	void testBestSolutionDistributeCandies1() {
		DistributeCandiesAmongChildrenII task = new DistributeCandiesAmongChildrenII();
		DistributeCandiesAmongChildrenII.BestSolution solution = task.new BestSolution();
		long result = solution.distributeCandies(5, 2);
		assertEquals(3, result);
	}

	@Test
	@DisplayName("n = 3, limit = 3 -> 10")
	void testBestSolutionDistributeCandies2() {
		DistributeCandiesAmongChildrenII task = new DistributeCandiesAmongChildrenII();
		DistributeCandiesAmongChildrenII.BestSolution solution = task.new BestSolution();
		long result = solution.distributeCandies(3, 3);
		assertEquals(10, result);
	}
}
