package com.hramn.algo.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 735. Asteroid Collision
 * 
 * We are given an array asteroids of integers representing asteroids in a row.
 * 
 * For each asteroid, the absolute value represents its size, and the sign 
 * represents its direction (positive meaning right, negative meaning left). 
 * Each asteroid moves at the same speed.
 * 
 * Find out the state of the asteroids after all collisions. If two asteroids 
 * meet, the smaller one will explode. If both are the same size, both will 
 * explode. Two asteroids moving in the same direction will never meet.
 * 
 * Example 1:
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never 
 * collide.
 * 
 * Example 2:
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * 
 * Example 3:
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide 
 * resulting in 10.
 * 
 * Constraints:
 * 2 <= asteroids.length <= 10**4
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 */
public class AsteroidCollision {

	public static void main(String[] args) {
		int[] asteroids = new int[] {10, 2, -5};
		Solution_v1 solution_v1 = new Solution_v1();
		int[] result_v1 = solution_v1.asteroidCollision(asteroids);
		System.out.println(Arrays.toString(result_v1));
		Solution_v2 solution_v2 = new Solution_v2();
		int[] result_v2 = solution_v2.asteroidCollision(asteroids);
		System.out.println(Arrays.toString(result_v2));
	}

	static class Solution_v1 {
		public int[] asteroidCollision (int[] asteroids) {
			if (asteroids == null || asteroids.length <= 1) {
				return asteroids;
			}
			List<Integer> stack = new LinkedList<>();
			for (int cur : asteroids) {
				if (stack.size() > 0) {
					boolean cont = true;
					while (cont) {
						int last = stack.getLast();
						if (last > 0 && ((cur > 0) != (last > 0))) {
							if (Math.abs(cur) > Math.abs(last)) {
								stack.removeLast();
							} else if (Math.abs(cur) < Math.abs(last)) {
								cont = false;
							} else {
								stack.removeLast();
								cont = false;
							}
						} else {
							stack.add(cur);
							cont = false;
						}
					}
				} else {
					stack.add(cur);
				}
			}
			return stack.stream().mapToInt(Integer::intValue).toArray();
		}
	}
	
	static class Solution_v2 {
		public int[] asteroidCollision (int[] asteroids) {
			List<Integer> stack = new LinkedList<>();
			for (int i : asteroids) {
				if (i > 0) {
					stack.add(i);
				} else {
					while (stack.size() != 0 && stack.getLast() > 0 && 
							Math.abs(i) > Math.abs(stack.getLast())) {
						stack.removeLast();
					}
					if (stack.size() != 0 && Math.abs(i) == stack.getLast()) {
						stack.removeLast();
					} else if (stack.size() == 0 || stack.getLast() < 0) {
						stack.add(i);
					}
				}
			}
			return stack.stream().mapToInt(Integer::intValue).toArray();
		}
	}
}
