package com.hramn.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Task
 * Написать реализацию алгоритма быстрой сортировки массива чисел.
 */

public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {5,1,6,3,9,2,7,2,5,10,41,55,23};
		List<Integer> list = new ArrayList<>(
				Arrays.stream(arr).boxed().toList()); // immutable collectionß
		SolutionForArray.quickSort(arr);
		System.out.println(Arrays.toString(arr));
		SolutionForList.quickSort(list);
		System.out.println(list);
	}
	
	static class SolutionForArray {
		static void quickSort(int[] arr) {
			if (arr.length < 2) {
				return;
			}
			quickSort(arr, 0, arr.length-1);
		}
		
		private static void quickSort(int[] arr, int start, int end) {
			if (start < end) {
				int partitionIndex = partition (arr, start, end);
				quickSort(arr, start, partitionIndex-1);
				quickSort(arr, partitionIndex+1, end);
			}
		}
		
		private static int partition(int[] arr, int start, int end) {
			int pivot = arr[end];
			int i = start - 1;
			for (int j = start; j < end; j++) {
				if (arr[j] <= pivot) {
					i++;
					swap(arr, i, j);
				}
			}
			swap(arr, i+1, end);
			return i+1;
		}
		
	    private static void swap(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	}
	
	static class SolutionForList {
		
		static void quickSort(List<Integer> list) {
			if (list == null || list.size() < 2) {
				return;
			}
			quickSort(list, 0, list.size() - 1);
		}
		
		private static void quickSort(List<Integer> list, int start, int end) {
			if (start < end) {
				int partitionIndex = partition(list, start, end);
				quickSort(list, start, partitionIndex-1);
				quickSort(list, partitionIndex+1, end);
			}
		}
		
		private static int partition(List<Integer> list, int start, int end) {
		    int pivot = list.get(end);
		    int i = (start-1);
		    for (int j = start; j < end; j++) {
		        if (list.get(j) <= pivot) {
		            i++;
		            swap(list, i, j);
		        }
		    }
		    swap(list, i+1, end);
		    return i+1;
		}
		
	    private static void swap(List<Integer> list, int i, int j) {
	        Integer temp = list.get(i);
	        list.set(i, list.get(j));
	        list.set(j, temp);
	    }
	}
}
