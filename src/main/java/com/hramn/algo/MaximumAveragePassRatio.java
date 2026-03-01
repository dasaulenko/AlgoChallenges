package com.hramn.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1792. Maximum Average Pass Ratio
 * https://leetcode.com/problems/maximum-average-pass-ratio/description
 * 
 * There is a school that has classes of students and each class will be having 
 * a final exam. You are given a 2D integer array classes, where 
 * classes[i] = [passi, totali]. You know beforehand that in the ith class, 
 * there are totali total students, but only passi number of students will pass 
 * the exam.
 * 
 * You are also given an integer extraStudents. There are another extraStudents 
 * brilliant students that are guaranteed to pass the exam of any class 
 * they are assigned to. You want to assign each of the extraStudents 
 * students to a class in a way that maximizes the average pass ratio across 
 * all the classes.
 * 
 * The pass ratio of a class is equal to the number of students of the class 
 * that will pass the exam divided by the total number of students of 
 * the class. The average pass ratio is the sum of pass ratios of all 
 * the classes divided by the number of the classes.
 * 
 * Return the maximum possible average pass ratio after assigning 
 * the extraStudents students. Answers within 10-5 of the actual 
 * answer will be accepted.
 * 
 * Example 1:
 * Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * Output: 0.78333
 * Explanation: You can assign the two extra students to the first class. 
 * The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
 * 
 * Example 2:
 * Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
 * Output: 0.53485
 * 
 * Constraints:
 * 1 <= classes.length <= 10^5
 * classes[i].length == 2
 * 1 <= passi <= totali <= 10^5
 * 1 <= extraStudents <= 10^5
 * 
 * TAG: 20250901
 * TAG: medium
 * TAG: heap
 */
public class MaximumAveragePassRatio {
	class Solution { // O(N*log(N) + M) where N = classes.length, M = extraStudents
		public double maxAverageRatio(int[][] classes, int extraStudents) {
			PriorityQueue<double[]> ratio = new PriorityQueue<>(new Comparator<double[]>() {
				public int compare(double[] a, double[] b) {
					if (a[0] > b[0]) {
						return -1;
					} else if (a[0] < b[0]) {
						return 1;
					}
					return 0;
				}
			});
			for (int[] c : classes) {
				ratio.add(new double[] {dif(c[0], c[1]), c[0], c[1]});
			}
			for (int i = 0; i < extraStudents; i++) {
				double[] max = ratio.poll();
				max[1]++;
				max[2]++;
				max[0] = dif( max[1], max[2]);
				ratio.add(max);
			}
			double sum = 0;
			while(!ratio.isEmpty()) {
				double[] r = ratio.poll();
				sum += r[1]/r[2];
			}
			return sum / classes.length;
		}

		private double dif (double a, double b) {
			return (a+1.0)/(b+1.0) - a/b;
		}
	}
}
