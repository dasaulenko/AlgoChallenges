package com.hramn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class DesignTaskManagerTest {
	/*
	 * Input:
 	 * ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
 	 * [[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]
 	 * Output:
 	 * [null, null, null, 3, null, null, 5]
	 */
	final private List<List<Integer>> tasks = List.of(
		List.of(1, 101, 10),
		List.of(2, 102, 20),
		List.of(3, 103, 15));

	@Test
	void testTaskManager() {
		DesignTaskManager task = new DesignTaskManager();
		DesignTaskManager.TaskManager taskManager = task.new TaskManager(tasks);
		taskManager.add(4, 104, 5);
		taskManager.edit(102, 8);
		int result1 = taskManager.execTop();
		assertEquals(3, result1);
		taskManager.rmv(101);
		taskManager.add(5, 105, 15);
		int result2 = taskManager.execTop();
		assertEquals(5, result2);
	}

	@Test
	void testTaskManagerBest() {
		DesignTaskManager task = new DesignTaskManager();
		DesignTaskManager.TaskManagerBest taskManager = task.new TaskManagerBest(tasks);
		taskManager.add(4, 104, 5);
		taskManager.edit(102, 8);
		int result1 = taskManager.execTop();
		assertEquals(3, result1);
		taskManager.rmv(101);
		taskManager.add(5, 105, 15);
		int result2 = taskManager.execTop();
		assertEquals(5, result2);
	}
}
