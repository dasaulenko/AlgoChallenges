package com.hramn.algo.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.hramn.algo.medium.ProductOfLastKNumbers.ArraySolution;
import com.hramn.algo.medium.ProductOfLastKNumbers.ListSolution;
import com.hramn.algo.medium.ProductOfLastKNumbers.NodeSolution;
import com.hramn.algo.medium.ProductOfLastKNumbers.ProductOfNumbersInterface;

public class ProductOfLastKNumbersTest {

	static Stream<Named<Supplier<ProductOfNumbersInterface>>> implementations() {
		return Stream.of(
				Named.of("NodeSolution", NodeSolution.ProductOfNumbers::new),
				Named.of("ListSolution", ListSolution.ProductOfNumbers::new),
				Named.of("ArraySolution", ArraySolution.ProductOfNumbers::new));
	}

	@ParameterizedTest(name = "{0}")
	@MethodSource("implementations")
	void testLeetCodeExample(Supplier<ProductOfNumbersInterface> factory) {
		ProductOfNumbersInterface solution = factory.get();

		solution.add(3);
		solution.add(0);
		solution.add(2);
		solution.add(5);
		solution.add(4);

		assertEquals(20, solution.getProduct(2));
		assertEquals(40, solution.getProduct(3));
		assertEquals(0, solution.getProduct(4));

		solution.add(8);

		assertEquals(32, solution.getProduct(2));
	}
}
