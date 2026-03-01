package com.hramn.algo.bigtechbootcamp;
/**
 * Task
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists into one sorted list. The list should be made by 
 * splicing together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 * 
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * 
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * 
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {
	class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	class Solution {
	    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	        ListNode currNode1 = null, currNode2 = null, 
	            mCurrNode = null, resultNode = null;
	        if (list1 == null && list2 == null) {
	            return null;
	        } else if (list1 == null) {
	            mCurrNode = list2;
	            resultNode = list2;
	        } else if (list2 == null) {
	            mCurrNode = list1;
	            resultNode = list1;
	        } else if (list1.val > list2.val) {
	            mCurrNode = list2;
	            resultNode = list2;
	            currNode1 = list1;
	            currNode2 = list2.next;
	        } else {
	            mCurrNode = list1;
	            resultNode = list1;
	            currNode1 = list1.next;
	            currNode2 = list2;
	        }
	        while(currNode1 != null || currNode2 != null) {
	            if (currNode1 == null) {
	                mCurrNode.next = currNode2;
	                mCurrNode = currNode2;
	                currNode2 = currNode2.next;
	            } else if (currNode2 == null) {
	                mCurrNode.next = currNode1;
	                mCurrNode = currNode1;
	                currNode1 = currNode1.next;
	            } else if (currNode1.val > currNode2.val) {
	                mCurrNode.next = currNode2;
	                mCurrNode = currNode2;
	                currNode2 = currNode2.next;
	            } else {
	                mCurrNode.next = currNode1;
	                mCurrNode = currNode1;
	                currNode1 = currNode1.next;
	            }
	        }
	        return resultNode;
	    } 
	}
	
	class Solution_best_memory {
	    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	        ListNode dummy = new ListNode(0);
	        ListNode current = dummy;
	        while(list1 != null && list2 != null){
	           if(list1.val < list2.val){
	            current.next = list1;
	            list1 = list1.next;
	           }
	           else{
	            current.next = list2;
	            list2 = list2.next;
	           }
	           current = current.next; 
	        }
	        current.next= list1 != null ? list1 :list2; 
	        return dummy.next;
	    }
	}
}
