package com.hramn.algo.linkedlists;
/**
 * 2. Add Two Numbers
 * 
 * You are given two non-empty linked lists representing two non-negative 
 * integers. The digits are stored in reverse order, and each of their nodes 
 * contains a single digit. Add the two numbers and return the sum as a linked 
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the 
 * number 0 itself.
 * 
 * Example 1:
 * 2 -> 4 -> 3
 * 5 -> 6 -> 4
 * 7 -> 0 -> 8
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * 
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {

	static public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static void main(String[] args) {
		ListNode l11 = new ListNode(9);
		ListNode l12 = new ListNode(9, l11);
		ListNode l13 = new ListNode(9, l12);
		ListNode l21 = new ListNode(9);
		ListNode l22 = new ListNode(9, l21);
		ListNode l23 = new ListNode(9, l22);
		Solution solution = new Solution();
		StringBuilder sb = new StringBuilder();
		ListNode result = solution.addTwoNumbers(l13, l23);
		while(result != null) {
			sb.append(result.val);
			result = result.next;
		}
		System.out.println(sb.toString());
		assert Integer.valueOf(sb.toString()) == 8991;
	}

	// 3 -> 9 -> 4
	// 5 -> 7 -> 8
	// 493 + 875 = 1368
	// loop through nodes, sum 2 nodes, if sum > 10 then create node with 
	// sum % 10 and remember 1 or just create a node with a number
	// if we remember 1 on the previous step then sum + 1
	// 9 -> 9 -> 9
	// 9 -> 9 -> 9
	// 8 -> 9 -> 9 -> 1
	static class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode firstNode = null;
	        ListNode prevNode = null;
			int tmp = 0;
	        while (l1 != null || l2 != null) {
		        int sum = 0;
	            if (l1 != null) {
		            sum += l1.val;
		            l1 = l1.next;
	            }
	            if (l2 != null) {
		            sum += l2.val;
		            l2 = l2.next;
	            }
	            if (tmp > 0) {
		            sum += tmp;
		            tmp = 0;
	            }
	            if (sum > 9) {
		            tmp++;
		            sum = sum % 10;
	            }
	            ListNode n = new ListNode(sum);
		        if (prevNode != null) {
		            prevNode.next = n;
	            }
	            prevNode = n;
	            if (firstNode == null) {
		            firstNode = n;
	            }
	        }
	        if (tmp > 0) {
		        ListNode n = new ListNode(tmp);
		        prevNode.next = n;
	        }
	        return firstNode;
	    }
	}
	
}
