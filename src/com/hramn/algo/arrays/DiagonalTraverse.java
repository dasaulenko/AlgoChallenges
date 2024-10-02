package com.hramn.algo.arrays;

import java.util.Arrays;

/**
 * 498. Diagonal Traverse
 * 
 * Given an m x n matrix mat, return an array of all the elements of the array 
 * in a diagonal order.
 * 
 * Example 1:
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * 
 * Example 2:
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 * 
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10**4
 * 1 <= m * n <= 10**4
 * -10**5 <= mat[i][j] <= 10**5
 */
public class DiagonalTraverse {

	public static void main(String[] args) {
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.findDiagonalOrder(mat)));
	}
	
	static class Solution {
	    public int[] findDiagonalOrder(int[][] mat) {
	        int length = mat.length * mat[0].length;
	        int[] result = new int[length];
	        int i = 0, r = 0, c = 0, inc = 1;
	        while (i < length)  {
	    	    while (r >= 0 && r < mat.length && c >=0 && c < mat[0].length) {
	                result[i++] = mat[r][c];
	                r = r - inc;
	                c = c + inc;
	            }
	            if (r == mat.length) {
	    	        r--;
		            c += 2;
	            } else if (c == mat[0].length) {
		            c--;
		            r += 2;
	            } else if (r == -1) {
		            r++;
	            } else if (c == -1) {
	                c++;
	            }
	            inc *= -1;
	        }
	        return result;
	    }
	}

}
