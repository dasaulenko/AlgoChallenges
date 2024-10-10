package com.hramn.algo;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode() {}
	public TreeNode(int val) { this.val = val; }
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public static TreeNode createTree(Integer[] arr) {
		TreeNode root = null, parent = null;
		List<TreeNode> queue = new LinkedList<>();
		int counter = -1;
		for (int i = 0; i < arr.length; i++) {
			counter++;
			TreeNode n = null;
			if (arr[i] != null) {
				 n = new TreeNode(arr[i]); 
				if (counter == 1) {
					parent.left = n; 
				} else if (counter == 2) {
					parent.right = n;
				} else if (counter == 0) {
					root = n;
					parent = n;
				}
			}
			queue.add(n);
			if (counter == 2) {
				queue.removeFirst();
				counter = 0;
				parent = queue.getFirst();
			} 
		}
		return root;
	}
}
