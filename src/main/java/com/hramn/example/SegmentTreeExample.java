package com.hramn.example;

public class SegmentTreeExample {

	/**
	 * SegmentTree
	 * 
	 * <p>Segment Tree is a data structure that efficiently supports range 
	 * queries and individual element updates.
	 * 
	 * <p>Segment Tree: Efficient range queries and point updates.
	 * 
	 * <p>Complexity
	 * <pre>
	 * Time: O(log n)
	 * Space: O(n)
	 * </pre>
	 */
	public static class SegmentTree {

		private final int n;
		private final long[] tree;

		public SegmentTree(int[] nums) {
			n = nums.length;

			if (n == 0) {
				throw new IllegalArgumentException("Array cannot be empty");
			}

			tree = new long[4 * n];

			build(0, 0, n - 1, nums);
		}

		private void build(int node, int left, int right, int[] nums) {
			if (left == right) {
				tree[node] = nums[left];
				return;
			}

			int mid = left + (right - left) / 2;

			int lc = 2 * node + 1;
			int rc = 2 * node + 2;

			build(lc, left, mid, nums);
			build(rc, mid + 1, right, nums);

			tree[node] = tree[lc] + tree[rc];
		}

		public long query(int left, int right) {
			validateRange(left, right);
			return query(0, 0, n - 1, left, right);
		}

		private long query(
						int node,
						int left,
						int right,
						int ql,
						int qr) {
			if (right < ql || left > qr) return 0;

			if (ql <= left && right <= qr) return tree[node];

			int mid = left + (right - left) / 2;

			return query(2 * node + 1, left, mid, ql, qr)
							+ query(2 * node + 2, mid + 1, right, ql, qr);
		}

		public void update(int index, int value) {
			if (index < 0 || index >= n) {
				throw new IndexOutOfBoundsException(index);
			}

			update(0, 0, n - 1, index, value);
		}

		private void update(
						int node,
						int left,
						int right,
						int index,
						int value) {
			if (left == right) {
				tree[node] = value;
				return;
			}

			int mid = left + (right - left) / 2;

			int lc = 2 * node + 1;
			int rc = 2 * node + 2;

			if (index <= mid) {
				update(lc, left, mid, index, value);
			} else {
				update(rc, mid + 1, right, index, value);
			}

			tree[node] = tree[lc] + tree[rc];
		}

		private void validateRange(int left, int right) {
			if (left < 0 || right >= n || left > right) {
				throw new IllegalArgumentException("Invalid range");
			}
		}
	}

	/**
	 * LazySegmentTree (Segment Tree with Lazy Propagation)
	 * 
	 * <p>Lazy Segment Tree is an extension of Segment Tree that efficiently 
	 * supports both range queries and range updates by deferring updates to 
	 * child nodes until necessary.
	 * 
	 * <p>Lazy Segment Tree: Efficient range queries and range updates.
	 * 
	 * <p>Complexity
	 * <pre>
	 * Time: O(log n)
	 * Space: O(n)
	 * </pre>
	 */
	public static class LazySegmentTree {

		private final int n;

		private final long[] tree;
		private final long[] lazy;

		public LazySegmentTree(int[] nums) {
			n = nums.length;

			if (n == 0) {
				throw new IllegalArgumentException("Array cannot be empty");
			}

			tree = new long[4 * n];
			lazy = new long[4 * n];

			build(0, 0, n - 1, nums);
		}

		private void build(int node, int left, int right, int[] nums) {
			if (left == right) {
				tree[node] = nums[left];
				return;
			}

			int mid = left + (right - left) / 2;

			int lc = 2 * node + 1;
			int rc = 2 * node + 2;

			build(lc, left, mid, nums);
			build(rc, mid + 1, right, nums);

			tree[node] = tree[lc] + tree[rc];
		}

		private void pushDown(int node, int left, int right) {
			if (lazy[node] == 0 || left == right) return;

			int mid = left + (right - left) / 2;

			int lc = 2 * node + 1;
			int rc = 2 * node + 2;

			long value = lazy[node];

			tree[lc] += value * (mid - left + 1);
			tree[rc] += value * (right - mid);

			lazy[lc] += value;
			lazy[rc] += value;

			lazy[node] = 0;
		}

		public void rangeAdd(int left, int right, long value) {
			validateRange(left, right);
			rangeAdd(0, 0, n - 1, left, right, value);
		}

		private void rangeAdd(
						int node,
						int left,
						int right,
						int ql,
						int qr,
						long value) {
			if (right < ql || left > qr) return;

			if (ql <= left && right <= qr) {
				tree[node] += value * (right - left + 1);
				lazy[node] += value;
				return;
			}

			pushDown(node, left, right);

			int mid = left + (right - left) / 2;

			int lc = 2 * node + 1;
			int rc = 2 * node + 2;

			rangeAdd(lc, left, mid, ql, qr, value);
			rangeAdd(rc, mid + 1, right, ql, qr, value);

			tree[node] = tree[lc] + tree[rc];
		}

		public long rangeSum(int left, int right) {
			validateRange(left, right);
			return rangeSum(0, 0, n - 1, left, right);
		}

		private long rangeSum(
						int node,
						int left,
						int right,
						int ql,
						int qr) {
			if (right < ql || left > qr) return 0;

			if (ql <= left && right <= qr) return tree[node];

			pushDown(node, left, right);

			int mid = left + (right - left) / 2;

			return rangeSum(2 * node + 1, left, mid, ql, qr)
							+ rangeSum(2 * node + 2, mid + 1, right, ql, qr);
		}

		private void validateRange(int left, int right) {
			if (left < 0 || right >= n || left > right) {
				throw new IllegalArgumentException("Invalid range");
			}
		}
	}

}
