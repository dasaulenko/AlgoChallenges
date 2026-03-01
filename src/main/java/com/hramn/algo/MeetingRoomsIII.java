package com.hramn.algo;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2402. Meeting Rooms III
 * https://leetcode.com/problems/meeting-rooms-iii/description
 * 
 * You are given an integer n. There are n rooms numbered from 0 to n - 1.
 * 
 * You are given a 2D integer array meetings where meetings[i] = [starti, endi] 
 * means that a meeting will be held during the half-closed time interval 
 * [starti, endi). All the values of starti are unique.
 * 
 * Meetings are allocated to rooms in the following manner:
 * - Each meeting will take place in the unused room with the lowest number.
 * - If there are no available rooms, the meeting will be delayed until a room 
 *   becomes free. The delayed meeting should have the same duration as the 
 *   original meeting.
 * - When a room becomes unused, meetings that have an earlier original start 
 *   time should be given the room.
 * 
 * Return the number of the room that held the most meetings. If there are 
 * multiple rooms, return the room with the lowest number.
 * 
 * A half-closed interval [a, b) is the interval between a and b including a 
 * and not including b.
 * 
 * Example 1:
 * Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
 * Output: 0
 * Explanation:
 * - At time 0, both rooms are not being used. The first meeting starts in 
 *   room 0.
 * - At time 1, only room 1 is not being used. The second meeting starts in 
 *   room 1.
 * - At time 2, both rooms are being used. The third meeting is delayed.
 * - At time 3, both rooms are being used. The fourth meeting is delayed.
 * - At time 5, the meeting in room 1 finishes. The third meeting starts in 
 *   room 1 for the time period [5,10).
 * - At time 10, the meetings in both rooms finish. The fourth meeting starts 
 *   in room 0 for the time period [10,11).
 * Both rooms 0 and 1 held 2 meetings, so we return 0. 
 * 
 * Example 2:
 * Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
 * Output: 1
 * Explanation:
 * - At time 1, all three rooms are not being used. The first meeting starts in 
 *   room 0.
 * - At time 2, rooms 1 and 2 are not being used. The second meeting starts in 
 *   room 1.
 * - At time 3, only room 2 is not being used. The third meeting starts in 
 *   room 2.
 * - At time 4, all three rooms are being used. The fourth meeting is delayed.
 * - At time 5, the meeting in room 2 finishes. The fourth meeting starts in 
 *   room 2 for the time period [5,10).
 * - At time 6, all three rooms are being used. The fifth meeting is delayed.
 * - At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts 
 *   in room 1 for the time period [10,12).
 * Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we 
 * return 1. 
 * 
 * Constraints:
 * 1 <= n <= 100
 * 1 <= meetings.length <= 10^5
 * meetings[i].length == 2
 * 0 <= starti < endi <= 5 * 10^5
 * All the values of starti are unique.
 * 
 * TAG: 20250711
 * TAG: hard
 * TAG: heap
 * TAG: PriorityQueue
 */
public class MeetingRoomsIII {
	class Solution { // O(M * log(N)), O(N), N - n, M - meetings.length
		public int mostBooked(int n, int[][] meetings) {
			Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
			PriorityQueue<Event> occupied = new PriorityQueue<>((a,b) -> {
					if (a.getEnd() - b.getEnd() == 0) {
						return a.getRoom() - b.getRoom();
					} else {
						return a.getEnd() - b.getEnd();
					}
			});
			PriorityQueue<Event> available = 
					new PriorityQueue<>((a,b) -> a.getRoom() - b.getRoom());
			for (int i = 0; i < n; i++) {
				available.add(new Event(i, 0, 0));
			}
			int maxCount = 0;
			int maxRoom = Integer.MAX_VALUE;
			for (int[] m : meetings) {
				while (!occupied.isEmpty() && occupied.peek().getEnd() <= m[0]) {
					available.add(occupied.poll());
				}
				Event e = null;
				if (!available.isEmpty()) {
					e = available.poll();
					e.setEnd(m[1]);
				} else {
					e = occupied.poll();
					e.setEnd(e.getEnd() - m[0] + m[1]);
				}
				if (maxCount < e.getCounter()) {
					maxCount = e.getCounter();
					maxRoom = e.getRoom();
				} else if (maxCount == e.getCounter()) {
					maxRoom = Math.min (maxRoom, e.getRoom());
				}
				occupied.add(e);
			}
			return maxRoom;
		}

		class Event {
			private int room;
			private int end;
			private int counter;
			public Event (int room, int end, int counter) {
				this.room = room;
				this.end = end;
				this.counter = counter;
			}
			public int getRoom() {
				return room;
			}
			public int getEnd() {
				return end;
			}
			public int getCounter() {
				return counter;
			}
			public void setEnd(int end) {
				this.end = end;
				counter++;
			}
		}
	}

	class OptSolution { // O(M * log(N)), O(N), N - n, M - meetings.length
		public int mostBooked(int n, int[][] meetings) {
			Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
			PriorityQueue<int[]> ocup = new PriorityQueue<>((a,b) -> {
				if (a[1] - b[1] == 0) {
					return a[0] - b[0];
				} else {
					return a[1] - b[1];
				}
			});
			PriorityQueue<Integer> aval = new PriorityQueue<>();
			int[] rooms = new int[n];
			for (int i = 0; i < n; i++) {
				aval.add(i);
			}
			int[] maxRoom = new int[2];
			for (int[] m : meetings) {
				while (!ocup.isEmpty() && ocup.peek()[1] <= m[0]) {
					aval.add(ocup.poll()[0]);
				}
				int[] room = new int[2];
				if (!aval.isEmpty()) {
					room[0] = aval.poll();
					room[1] = m[1];
				} else {
					int[] r = ocup.poll();
					room[0] = r[0];
					room[1] = r[1] - m[0] + m[1];
				}
				ocup.add(room);
				rooms[room[0]]++;
				if (maxRoom[1] < rooms[room[0]] || 
						(maxRoom[1] == rooms[room[0]] && maxRoom[0] > room[0])) {
					maxRoom[0] = room[0];
					maxRoom[1] = rooms[room[0]];
				}
			}
			return maxRoom[0];
		}
	}

}
