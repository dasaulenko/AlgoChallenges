package com.hramn.algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 3408. Design Task Manager
 * https://leetcode.com/problems/design-task-manager/description
 * 
 * There is a task management system that allows users to manage their tasks, 
 * each associated with a priority. The system should efficiently handle adding, 
 * modifying, executing, and removing tasks.
 * 
 * Implement the TaskManager class:
 * 
 * - TaskManager(vector<vector<int>>& tasks) initializes the task manager with 
 *   a list of user-task-priority triples. Each element in the input list is of 
 *   the form [userId, taskId, priority], which adds a task to the specified 
 *   user with the given priority.
 * 
 * - void add(int userId, int taskId, int priority) adds a task with 
 *   the specified taskId and priority to the user with userId. 
 *   It is guaranteed that taskId does not exist in the system.
 * 
 * - void edit(int taskId, int newPriority) updates the priority of 
 *   the existing taskId to newPriority. It is guaranteed that taskId exists in 
 *   the system.
 * 
 * - void rmv(int taskId) removes the task identified by taskId from the system. 
 *   It is guaranteed that taskId exists in the system.
 * 
 * - int execTop() executes the task with the highest priority across all users. 
 *   If there are multiple tasks with the same highest priority, execute the one 
 *   with the highest taskId. After executing, the taskId is removed from 
 *   the system. Return the userId associated with the executed task. 
 *   If no tasks are available, return -1.
 * 
 * Note that a user may be assigned multiple tasks.
 * 
 * Example 1:
 * Input:
 * ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
 * [[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]
 * Output:
 * [null, null, null, 3, null, null, 5]
 * Explanation
 * TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3, 103, 15]]); // Initializes with three tasks for Users 1, 2, and 3.
 * taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
 * taskManager.edit(102, 8); // Updates priority of task 102 to 8.
 * taskManager.execTop(); // return 3. Executes task 103 for User 3.
 * taskManager.rmv(101); // Removes task 101 from the system.
 * taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
 * taskManager.execTop(); // return 5. Executes task 105 for User 5.
 * 
 *  Constraints:
 * 1 <= tasks.length <= 10^5
 * 0 <= userId <= 10^5
 * 0 <= taskId <= 10^5
 * 0 <= priority <= 10^9
 * 0 <= newPriority <= 10^9
 * At most 2 * 105 calls will be made in total to add, edit, rmv, and execTop methods.
 * The input is generated such that taskId will be valid.
 * 
 * TAG: medium
 * TAG: heap
 */
public class DesignTaskManager {
	class TaskManager {
		class Task {
			int userId;
			int taskId;
			int priority;
			public Task(int userId, int taskId, int priority) {
				this.userId = userId;
				this.taskId = taskId;
				this.priority = priority;
			}
		}

		private Map<Integer, Task> taskIdToTask = new HashMap<>();
		private PriorityQueue<Task> tasksMaxHeap = new PriorityQueue<> (new Comparator<>() {
			public int compare(Task t1, Task t2) {
				int dif = t2.priority - t1.priority;
				if (dif != 0) {
					return dif;
				}
				return t2.taskId - t1.taskId;
			}
		});

		public TaskManager(List<List<Integer>> tasks) { // O(N * log(N)), O(N) where N = tasks.size();
			for (List<Integer> task : tasks) {
				add(task.get(0), task.get(1), task.get(2));
			}
		}

		public void add(int userId, int taskId, int priority) { // O(log(N)), O(1) where N = tasksMaxHeap.size()
			Task task = new Task(userId, taskId, priority);
			taskIdToTask.put(taskId, task);
			tasksMaxHeap.add(task);
		}

		public void edit(int taskId, int newPriority) { // O(log(N)), O(1) where N = tasksMaxHeap.size()
			Task task = taskIdToTask.get(taskId);
			Task newTask = new Task(task.userId, taskId, newPriority);
			taskIdToTask.put(taskId, newTask);
			tasksMaxHeap.add(newTask);
		}

		public void rmv(int taskId) { // O(1), O(1)
			taskIdToTask.remove(taskId);
		}

		public int execTop() { // O(N), O(1) where N = tasksMaxHeap.size()
			Task task = tasksMaxHeap.poll();
			while (task != null && task != taskIdToTask.get(task.taskId)) {
				task = tasksMaxHeap.poll();
			}
			return task == null ? -1 : task.userId;
		}
	}

	class TaskManagerBest {
		int[] priorities = new int[100001];
		int[] userIds = new int[100001];
		PriorityQueue<Long> PQ = new PriorityQueue<>((a, b) -> Long.compare(b, a));

		public TaskManagerBest(List<List<Integer>> tasks) { // O(N * log(N)), O(N) where N = tasks.size()
			for (List<Integer> task : tasks) {
				int userId = task.get(0);
				int taskId = task.get(1);
				int priority = task.get(2);
				priorities[taskId] = priority;
				userIds[taskId] = userId;
				PQ.offer((long) priority * 100001 + taskId);
			}
		}

		public void add(int userId, int taskId, int priority) { // O(log(N)), O(1) where N = PQ.size()
			if (priorities[taskId] > 0)
				return;
			priorities[taskId] = priority;
			userIds[taskId] = userId;
			PQ.offer((long) priority * 100001 + taskId);
		}

		public void edit(int taskId, int newPriority) { // O(log(N)), O(1) where N = PQ.size()
			priorities[taskId] = newPriority;
			PQ.offer((long) newPriority * 100001 + taskId);
		}

		public void rmv(int taskId) { // O(1), O(1)
			priorities[taskId] = -1;
		}

		public int execTop() { // O(N), O(1) where N= PQ.size()
			while (!PQ.isEmpty()) {
				long current = PQ.poll();
				int taskId = (int) (current % 100001);
				int priority = (int) (current / 100001);
				if (priorities[taskId] != priority)
					continue;
				priorities[taskId] = -1;
				return userIds[taskId];
			}
			return -1;
		}
	}
}
