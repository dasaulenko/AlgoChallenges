package com.hramn.algo.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * 225. Implement Stack using Queues
 * 
 * Implement a last-in-first-out (LIFO) stack using only two queues. The 
 * implemented stack should support all the functions of a normal stack (push, 
 * top, pop, and empty).
 * 
 * Implement the MyStack class:
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * 
 * Notes:
 * You must use only standard operations of a queue, which means that only push 
 * to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may 
 * simulate a queue using a list or deque (double-ended queue) as long as you 
 * use only a queue's standard operations.
 * 
 * Example 1:
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 * 
 * Constraints:
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 * 
 * Follow-up: Can you implement the stack using only one queue?
 */
public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		MyStack_v2 stack2 = new MyStack_v2();
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		int val = stack2.top();
		System.out.println(val);
		assert val == 3;
		val = stack2.pop();
		System.out.println(val);
		assert val == 3;
		val = stack2.pop();
		System.out.println(val);
		assert val == 2;
		MyStack_v1 stack1 = new MyStack_v1();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		val = stack1.top();
		System.out.println(val);
		assert val == 3;
		val = stack1.pop();
		System.out.println(val);
		assert val == 3;
		val = stack1.pop();
		System.out.println(val);
		assert val == 2;
	}
	
	static class MyStack_v2 {
		private List<Integer> queue;

		public MyStack_v2() {
			this.queue = new LinkedList<>();
	    }
	    
		public void push(int x) {
			int size = queue.size();
			queue.add(x);
	      	if (size != 0) {
	      		for (int i = 0; i < size; i++) {
	      			queue.add(queue.removeFirst());
	      		}	
	      	} 
		}
	    
		public int pop() {
			return queue.removeFirst();
		}
	    
		public int top() {
			return queue.getFirst();
		}
	    
		public boolean empty() {
	      	return queue.size() == 0;
		}
	}

	
	static class MyStack_v1 {
		private List<Integer> queue;

		public MyStack_v1() {
			this.queue = new LinkedList<>();
	    }
	    
		public void push(int x) {
	      	queue.add(x);  
		}
	    
		public int pop() {
			int val = 0, size = queue.size();
			for (int i = 0; i < size; i++) {
				val = queue.removeFirst();
				if (i != size - 1) {
					queue.add(val);
				}
			}
			return val;
		}
	    
		public int top() {
			int val = 0;
			for (int i = 0; i < queue.size(); i++) {
				val = queue.removeFirst();
				queue.add(val);
			}
			return val;
		}
	    
		public boolean empty() {
	      	return queue.size() == 0;
		}
	}
}
