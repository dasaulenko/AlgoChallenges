package com.hramn.algo.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <strong>1352. Product of the Last K Numbers</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Medium
 * <br>
 * <strong>LeetCode:</strong>
 * <a href="https://leetcode.com/problems/product-of-the-last-k-numbers/">
 * 1352. Product of the Last K Numbers</a>
 * <br>
 * <strong>Topic:</strong> array, math, prefix sum, linked list
 *
 * <hr>
 *
 * <p>
 * Design an algorithm that accepts a stream of integers and retrieves the
 * product of the last {@code k} integers of the stream.
 *
 * <p>
 * Implement the {@code ProductOfNumbers} class:
 * <ul>
 * <li>{@code ProductOfNumbers()} Initializes the object with an empty
 * stream.</li>
 * <li>{@code void add(int num)} Appends the integer {@code num} to the
 * stream.</li>
 * <li>{@code int getProduct(int k)} Returns the product of the last {@code k}
 * numbers in the current list. You can assume that always the current list has
 * at least {@code k} numbers.</li>
 * </ul>
 *
 * <p>
 * The test cases are generated so that, at any time, the product of any
 * contiguous sequence of numbers will fit into a single 32-bit integer without
 * overflowing.
 *
 * <p>
 * <strong>Example:</strong>
 * <p>
 * Input
 * <br>
 * {@code ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]}
 * <br>
 * {@code [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]}
 * <p>
 * Output
 * <br>
 * {@code [null,null,null,null,null,null,20,40,0,null,32]}
 * <p>
 * Explanation
 *
 * <pre>{@code
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3); // [3]
 * productOfNumbers.add(0); // [3,0]
 * productOfNumbers.add(2); // [3,0,2]
 * productOfNumbers.add(5); // [3,0,2,5]
 * productOfNumbers.add(4); // [3,0,2,5,4]
 * productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
 * productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
 * productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
 * productOfNumbers.add(8); // [3,0,2,5,4,8]
 * productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
 * }</pre>
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>{@code 0 <= num <= 100}</li>
 * <li>{@code 1 <= k <= 4 * 10^4}</li>
 * <li>At most {@code 4 * 10^4} calls will be made to add and getProduct.</li>
 * <li>The product of the stream at any point in time will fit in a 32-bit
 * integer.</li>
 * </ul>
 *
 * <p>
 * <strong>Follow-up:</strong> Can you implement both {@code GetProduct} and
 * {@code Add} to work in {@code O(1)} time complexity instead of {@code O(k)}
 * time complexity?
 */
public class ProductOfLastKNumbers {
	private ProductOfLastKNumbers() {
		/* This utility class should not be instantiated */
	}

	static interface ProductOfNumbersInterface {
		void add(int num);

		int getProduct(int k);
	}

	static class NodeSolution {
		private NodeSolution() {
			/* This utility class should not be instantiated */
		}

		static class ProductOfNumbers implements ProductOfNumbersInterface {
			static class Node {
				Node prev;
				int value;

				public Node(Node prev, int value) {
					this.prev = prev;
					this.value = value;
				}
			}

			private Node lastNode = null;

			public ProductOfNumbers() {
				// None
			}

			public void add(int num) {
				lastNode = new Node(lastNode, num);
			}

			public int getProduct(int k) {
				int product = 1;
				Node node = lastNode;
				for (int i = 0; i < k; i++) {
					product *= node.value;
					node = node.prev;
				}
				return product;
			}
		}
	}

	static class ListSolution {
		private ListSolution() {
			/* This utility class should not be instantiated */
		}

		static class ProductOfNumbers implements ProductOfNumbersInterface {
			private int lastZero = -1;
			private final List<Integer> products = new ArrayList<>();
			private int n = 0;

			public ProductOfNumbers() {
				products.add(1);
				n = 1;
			}

			public void add(int num) {
				if (num == 0) {
					lastZero = n - 1;
					products.add(1);
				} else
					products.add(products.get(n - 1) * num);
				n++;
			}

			public int getProduct(int k) {
				if (n - k - 1 <= lastZero)
					return 0;
				return products.get(n - 1) / products.get(n - k - 1);
			}
		}
	}

	static class ArraySolution {
		private ArraySolution() {
			/* This utility class should not be instantiated */
		}

		static class ProductOfNumbers implements ProductOfNumbersInterface {
			private final int[] products = new int[40001];
			private int size = 0;

			public ProductOfNumbers() {
				products[0] = 1;
				size = 1;
			}

			public void add(int num) {
				if (num != 0) {
					products[size] = products[size - 1] * num;
					size++;
				} else
					size = 1;
			}

			public int getProduct(int k) {
				if (size <= k)
					return 0;
				return products[size - 1] / products[size - k - 1];
			}
		}
	}

}
