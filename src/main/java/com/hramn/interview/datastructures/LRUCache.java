package com.hramn.interview.datastructures;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private static class Node {
		final int key;
		int value;
		Node next;
		Node prev;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private final Map<Integer, Node> cache;
	private final int capacity;
	private Node head;
	private Node tail;

	public LRUCache(int capacity) {
		if (capacity <= 0) 
			throw new IllegalArgumentException("Capacity must be positive");
		this.capacity = capacity;
		cache = new HashMap<>(capacity);
	}

	public int get(int key) {
		Node node = cache.get(key);
		if (node == null) return -1;
		moveNodeToTail(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = cache.get(key);
		if (node != null) {
			moveNodeToTail(node);
			node.value = value;
		} else {
			if (cache.size() == capacity) {
				removeHead();
			}
			addNewNode(key, value);
		}
	}

	private void addNewNode(int key, int value) {
		Node node = new Node (key, value);

		if (tail == null) {
			head = node;
		} else {
			tail.next = node;
			node.prev = tail;
		}
		tail = node;
		cache.put(key, node);
	}

	private void moveNodeToTail(Node node) {
		if (node == tail) return;
		Node prev = node.prev;
		Node next = node.next;
		if (prev != null) {
			prev.next = next;
		} else {
			head = next;
		}
		if (next != null) {
			next.prev = prev;
		}
		node.prev = tail;
		node.next = null;

		tail.next = node;
		tail = node;
	}

	private void removeHead() {
		if (head == null) return;
		cache.remove(head.key);
		Node next = head.next;
		head.next = null;
		if (next != null) {
			next.prev = null;
		} else {
			tail = null;
		}
		head = next;
	}
}
