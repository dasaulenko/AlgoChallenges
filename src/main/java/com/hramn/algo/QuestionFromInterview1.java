package com.hramn.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Task
 * A ticket machine is a device similar to an ATM and was introduced by Indian 
 * Railways in order to make purchasing train tickets easier. The first step in 
 * buying a ticket is choosing the destination of the journey. The destination 
 * can be one of N destinations offered in advance, names of local and national 
 * places.
 * 
 * The keyboard of the ticket machine has 28 keys {26 uppercase alphabets from 
 * A to Z, ENTER, BACKSPACE}. The travelers choose the destination by typing 
 * its name letter by letter. Once the destination is typed, they press the 
 * ENTER key to purchase the ticket. If they type the wrong letter, they use 
 * the BACKSPACE key to correct.
 * 
 * We, as an engineer building the system, already know all N destinations. 
 * We’re receiving the next key pressed, by the traveler, in a data stream.
 * 
 * Question: When the client presses ENTER, check if the entered word points to 
 * the valid destination or not.
 * 
 * Input:
 * N = 5, destinations = [“DELHI”, “BANGALORE”, “MUMBAI”, “CHENNAI”, “GURGAON”]
 * Keys pressed by the traveler = [“D”, “E”, “R”, BACKSPACE, “L”, “H”, “I”, 
 * ENTER]
 * Output: YES (the destination DELHI is valid)
 * 
 * Question: We can observe that by entering each additional letter, the number 
 * of possible destinations reduces. We want to make the system a little smart. 
 * After choosing each letter, the keyboard must change its appearance. Only 
 * keys that can be chosen in the next step should be highlighted in GREEN 
 * color, all other keys should be GRAY-ed out (the travelers still can press 
 * gray-ed keys).
 * 
 * Input:
 * destinations = [“DEL”, “DUBAI”, “BANGALORE”, “BOMBAY”, “CHENNAI”]
 * Keys pressed by the traveler in the order = [“D”, “E”, “R”, BACKSPACE, “L”, 
 * “H”, “I”, ENTER]
 * 
 * Initially, when no key is pressed, only [“D”, “B”, “C”] should be GREEN colored.
 * After the “D” is pressed, only “E”, “U” and BACKSPACE should be GREEN colored.
 * After the “E” is pressed, only “L” and BACKSPACE should be GREEN colored.
 * After the “R” is pressed, only BACKSPACE should be GREEN colored.
 * After the BACKSPACE is pressed, only “L” and BACKSPACE should be GREEN colored.
 * After the “L” is pressed, only “H” and BACKSPACE should be GREEN colored.
 * After the “H” is pressed, only “I” and BACKSPACE should be GREEN colored.
 * After the “I” is pressed, only ENTER and BACKSPACE should be GREEN colored.
 */
public class QuestionFromInterview1 {
	
	public static void main(String[] args) {
//		String[] destinations = {"DELHI", "BANGALORE", "MUMBAI", "CHENNAI", "GURGAON"};
//		String[] pressed = {"D", "E", "R", "BACKSPACE", "L", "H", "I", "ENTER"};
		String[] destinations = {"DELHI", "DUBAI", "BANGALORE", "BOMBAY", "CHENNAI"};
		String[] pressed = {"", "D", "E", "R", "BACKSPACE", "L", "H", "I", "ENTER"};
		Solution solution = new Solution(destinations);
//		System.out.println(solution.check(destinations, pressed));
		for (String key : pressed) {
			System.out.println(Arrays.toString(solution.allowedKeys(key)));
		}
	}
	
	static class Solution {
		public String check(String[] destinations, String[] pressed) {
			String dest = "";
			for (String key : pressed) {
				if (key.length() > 1) {
					if (key.equals("BACKSPACE")) {
						dest = dest.substring(0, dest.length() - 1);
					} else if (key.equals("ENTER")) {
						break;
					}
				} else {
					dest = dest + key;
				}
			}
			Set<String> set = new HashSet<>(Arrays.asList(destinations));
			if (set.contains(dest)) {
				return "YES (the destination " + dest + " is valid)";
			} else {
				return "NO";
			}
		}
		
		private String[] destinations;
		private String currentString = "";
		
		public Solution(String[] destinations) {
			this.destinations = destinations;
		}
		
		public String[] allowedKeys(String key) {
			Set<String> result = new HashSet<>();	
			if ("BACKSPACE".equals(key)) {
				if (currentString.length() > 0) {
					key = currentString.substring(currentString.length() - 1, currentString.length());
					currentString = currentString.substring(0, currentString.length() - 1);
				}
			}  else if (!"ENTER".equals(key)) {
				currentString += key;
			}
			if (currentString.length() > 0) {
				result.add("BACKSPACE");
			}
			for (String dest : destinations) {
				if (currentString.length() == 0) {
					result.add(dest.substring(0,1));
				} else if (dest.indexOf(currentString) == 0) {
					if (dest.length() == currentString.length()) {
						result.add("ENTER");
					} else {
						result.add(dest.substring(currentString.length(),currentString.length()+1));
					}
				}
			}
			return result.toArray(String[]::new);
		}
	}
}
