package com.hramn.example;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueAndStackExample {

	/**
	 * Stack Example
	 * LIFO - Last In First Out
	 */
	public static void stack() {
		// Stack
		Deque<Integer> stack = new ArrayDeque<>();

		// Add element
		stack.push(10);

		// Read top element
		stack.peek(); // 30

		// Read and remove top element
		stack.pop(); // 30

		// Check the stack
		stack.isEmpty();

		// Get stack size
		stack.size();
	}

	/**
	 * Queue
	 * FIFO - First In First Out
	 */
	public static void queue() {
		// Queue
		Queue<Integer> queue = new ArrayDeque<>();

		// Add element
		queue.offer(10);

		// Read first element
		queue.peek(); // 30

		// Read and remove first element
		queue.poll(); // 30

		// Check the queue
		queue.isEmpty();

		// Get queue size
		queue.size();
	}

	/**
	 * Deque
	 * Double-Ended Queue
	 */
	public static void dqueue() {
		Deque<Integer> deque = new ArrayDeque<>();

		deque.offerFirst(30);

		deque.offerLast(10);

		deque.pollFirst();

		deque.pollLast();
	}

	/**
	 * Heap
	 */
	public static void heap() {
		// Heap
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		minHeap.offer(30);

		minHeap.peek();

		minHeap.poll();

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

		maxHeap.offer(30);

		maxHeap.poll();
	}
}
