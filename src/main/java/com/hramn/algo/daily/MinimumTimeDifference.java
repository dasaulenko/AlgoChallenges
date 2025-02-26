package com.hramn.algo.daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Task
 * Given a list of 24-hour clock time points in "HH:MM" format, return the 
 * minimum minutes difference between any two time-points in the list.
 * 
 * Example 1:
 * Input: timePoints = ["23:59","00:00"]
 * Output: 1
 * 
 * Example 2:
 * Input: timePoints = ["00:00","23:59","00:00"]
 * Output: 0
 * 
 * Constraints:
 * 2 <= timePoints.length <= 2 * 104
 * timePoints[i] is in the format "HH:MM".
 */
public class MinimumTimeDifference {
	
	public static void main(String[] args) {
		// List<String> list = Arrays.asList("23:59", "00:00");
		List<String> list = Arrays.asList("00:00", "23:59", "00:00");
		Solution solution = new Solution();
		System.out.println(solution.findMinDifference(list));
	}
	
	static class Solution {
	    public int findMinDifference(List<String> timePoints) {
	        Collections.sort(timePoints);
	        Integer min = null;
	        for (int i = 1; i < timePoints.size(); i++) {
	        	int minutes = compareTwoTimes(timePoints.get(i-1), timePoints.get(i));
	        	if (minutes == 0) {
	        		return 0;
	        	}
	        	if (min == null || min > minutes) {
	        		min = minutes;
	        	}
	        }
	        int minutes = compareTwoTimes(timePoints.get(0), timePoints.get(timePoints.size()-1));
	        return min > minutes ? minutes : min;
	    }
	    
	    private int compareTwoTimes(String time1, String time2) {
	    	if (time1.equals(time2)) return 0;
	    	int[] arr1 = Arrays.stream(time1.split(":")).mapToInt(Integer::valueOf).toArray();
	    	int[] arr2 = Arrays.stream(time2.split(":")).mapToInt(Integer::valueOf).toArray();
	    	int minutes1 = (arr2[0] - arr1[0]) * 60 - arr1[1] + arr2[1];
	    	int minutes2 = (arr1[0] + 24 - arr2[0]) * 60 - arr2[1] + arr1[1];
	    	return minutes1 > minutes2 ? minutes2 : minutes1;
	    }
	}
	
	class Solution_best_runtime {
	    public int findMinDifference(List<String> timePoints) {
	        if (timePoints.size() > 1440) return 0; 

	        boolean[] seen = new boolean[1440]; 
	        
	        for (String time : timePoints) {
	            int minutes = convertToMinutes(time);
	            if (seen[minutes]) return 0; 
	            seen[minutes] = true;
	        }
	        
	        int first = Integer.MAX_VALUE, prev = Integer.MAX_VALUE;
	        int minDiff = Integer.MAX_VALUE;
	        
	        for (int i = 0; i < 1440; i++) {
	            if (seen[i]) {
	                if (first == Integer.MAX_VALUE) {
	                    first = i;
	                } else {
	                    minDiff = Math.min(minDiff, i - prev);
	                }
	                prev = i;
	            }
	        }
	        

	        minDiff = Math.min(minDiff, 1440 - prev + first);
	        
	        return minDiff;
	    }
	    
	    private int convertToMinutes(String time) {
	        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 
	             + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
	    }
	}
	
	class Solution_best_memory {
	    final int MINUTES_IN_A_DAY = 1440;

	    private int convertTimeToMinutes(String time){
	        int hour = Integer.parseInt(time.substring(0, 2));
	        int minutes = Integer.parseInt(time.substring(3, 5));

	        return 60 * hour + minutes;
	    }

	    public int findMinDifference(List<String> timePoints) {
	        //a day has 24 hours * 60 minutes = 60 * 20 + 60 * 4 = 1200 + 240 = 1440

	        //11:59 PM and 12:00 AM

	        //then by using MINUTES_IN_A_DAY * 2
	        //12:00 am is either minute 0 or minute 1440, 11:59 pm is either minute 1439 or minute 1440 + 1439

	        int[]minutes = new int[MINUTES_IN_A_DAY * 2];

	        int result = Integer.MAX_VALUE;

	        for(int i = 0; i < minutes.length; i++){
	            minutes[i] = Integer.MAX_VALUE;
	        }      

	        for(String timePoint: timePoints){
	            int timeInMinutes = convertTimeToMinutes(timePoint);

	            if(minutes[timeInMinutes] != Integer.MAX_VALUE){
	                return 0;
	            }

	            minutes[timeInMinutes] = timeInMinutes;
	            minutes[timeInMinutes + MINUTES_IN_A_DAY] = timeInMinutes + MINUTES_IN_A_DAY;
	        }

	        int leftPointer = 0;

	        while(leftPointer < minutes.length){
	            for(int i = leftPointer; i < minutes.length && (minutes[i] == Integer.MAX_VALUE); i++){
	                leftPointer++;
	            }

	            int rightPointer = leftPointer + 1;

	            for(int i = rightPointer;  i < minutes.length && (minutes[i] == Integer.MAX_VALUE); i++){
	                rightPointer++;
	            }

	            if(rightPointer >= minutes.length){
	                break;
	            }
	            else{
	                result = Math.min(result, minutes[rightPointer] - minutes[leftPointer]);

	                leftPointer = rightPointer;
	            }
	        }

	        return result;
	    }
	}
}
