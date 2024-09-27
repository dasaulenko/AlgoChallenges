package com.hramn.algo;

/*
 * Task
 * Есть координатная сетка в которой нижний левый квадрат имеет координаты 
 * (1,1), а верхний правый квадрат имеет координаты (n,m). В клетке с 
 * координатами (1,1) расположен робот, который может за один ход двигаться на 
 * 1 вверх или на 1 вправо. Робот не умеет двигаться по диагонали, вниз и влево.
 * Необходимо найти максимальное количество путей которыми робот может дойти до 
 * клетки с координатами (n,m).
 * 
 * m
 * 2 _ _ _
 * 1 _ _ _
 *   1 2 3 n
 *   
 * Example
 * Input: n = 3, m = 2
 * Output: 3
 */

public class MaxRoutesNumber {

	public static void main(String[] args) {
		assert Solution_1.paths(3, 2) == 3;
		assert Solution_2.paths(3, 2) == 3;
	}
	
	// Solution 1 (time O(2**(n+m))
	static class Solution_1 {
		
		static int paths(int x, int y) {
	        if (x < 1 || y < 1) { // recursion base
	        	return 0;
	        }
	        if (x == 1 && y == 1) { // recursion base
	            return 1;
	        }
	        return paths(x - 1, y) + paths(x, y - 1); // recursion basis
	    }
	}
	
	// Solution 2 (time O(n*m))
	static class Solution_2 {
		
		static int paths(int x, int y) {
	        return helper(x, y, new int[x + 1][y + 1]);
	    }
	    
	   private static int helper(int x, int y, int[][] arr) {
	        if (x < 1 || y < 1) {
	            return 0;
	        }
	        if (x == 1 && y == 1) {
	            return 1;
	        }
	        if (arr[x][y] != 0) {
	            return arr[x][y];
	        }
	        arr[x][y] = helper(x - 1, y, arr) + helper(x, y - 1, arr);
	        return arr[x][y];
	    }
	}
}
