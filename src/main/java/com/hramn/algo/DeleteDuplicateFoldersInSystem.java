package com.hramn.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * 1948. Delete Duplicate Folders in System
 * https://leetcode.com/problems/delete-duplicate-folders-in-system/description
 * 
 * Due to a bug, there are many duplicate folders in a file system. 
 * You are given a 2D array paths, where paths[i] is an array representing 
 * an absolute path to the ith folder in the file system.
 * 
 * - For example, ["one", "two", "three"] represents the path "/one/two/three".
 * 
 * Two folders (not necessarily on the same level) are identical 
 * if they contain the same non-empty set of identical subfolders and 
 * underlying subfolder structure. The folders do not need to be at the root 
 * level to be identical. If two or more folders are identical, then mark 
 * the folders as well as all their subfolders.
 * 
 * - For example, folders "/a" and "/b" in the file structure below are 
 *   identical. They (as well as their subfolders) should all be marked:
 *   - /a
 *   - /a/x
 *   - /a/x/y
 *   - /a/z
 *   - /b
 *   - /b/x
 *   - /b/x/y
 *   - /b/z
 * 
 * - However, if the file structure also included the path "/b/w", then 
 *   the folders "/a" and "/b" would not be identical. Note that "/a/x" and 
 *   "/b/x" would still be considered identical even with the added folder.
 * 
 * Once all the identical folders and their subfolders have been marked, 
 * the file system will delete all of them. The file system only runs 
 * the deletion once, so any folders that become identical after the initial 
 * deletion are not deleted.
 * 
 * Return the 2D array ans containing the paths of the remaining folders after 
 * deleting all the marked folders. The paths may be returned in any order.
 * 
 * Example 1:
 * Input: paths = [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
 * Output: [["d"],["d","a"]]
 * Explanation: The file structure is as shown.
 * Folders "/a" and "/c" (and their subfolders) are marked for deletion because 
 * they both contain an empty
 * folder named "b".
 * 
 * Example 2:
 * Input: paths = [["a"],["c"],["a","b"],["c","b"],["a","b","x"],
 *                ["a","b","x","y"],["w"],["w","y"]]
 * Output: [["c"],["c","b"],["a"],["a","b"]]
 * Explanation: The file structure is as shown. 
 * Folders "/a/b/x" and "/w" (and their subfolders) are marked for deletion 
 * because they both contain an empty folder named "y".
 * Note that folders "/a" and "/c" are identical after the deletion, but 
 * they are not deleted because they were not marked beforehand.
 * 
 * Example 3:
 * Input: paths = [["a","b"],["c","d"],["c"],["a"]]
 * Output: [["c"],["c","d"],["a"],["a","b"]]
 * Explanation: All folders are unique in the file system.
 * Note that the returned array can be in a different order as 
 * the order does not matter.
 * 
 * Constraints:
 * 1 <= paths.length <= 2 * 10^4
 * 1 <= paths[i].length <= 500
 * 1 <= paths[i][j].length <= 10
 * 1 <= sum(paths[i][j].length) <= 2 * 10^5
 * path[i][j] consists of lowercase English letters.
 * No two paths lead to the same folder.
 * For any folder not at the root level, its parent folder will also be 
 * in the input.
 * 
 * TAG: 20250725
 * TAG: hard
 * TAG: tree
 * TAG: dfs
 * TAG: 
 */
public class DeleteDuplicateFoldersInSystem {
	
	class Solution {
		class Folder {
			String id;
			String name = "";
			int index = -1;
			int parentIndex = -1;
			Set<String> children = new TreeSet<>();
			String value;
		}

		public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
			
			Map<String, Folder> idToFolder = createFolders(paths);
			
			List<Folder> folders = new LinkedList<>();

			recDfs (idToFolder, "/", folders);

			Collections.sort(folders, (a,b) -> b.value.compareTo(a.value));
			Set<Integer> deleted = new HashSet<>();
			for (int i = 1; i < folders.size(); i++) {
				Folder folder = folders.get(i);
				if (folder.value.isEmpty()) {
					if (deleted.contains(folder.parentIndex)) {
						deleted.add(folder.index);
					}
				} else if (folder.value.equals(folders.get(i-1).value)) {
					deleted.add(folder.index);
					deleted.add(folders.get(i-1).index);
				}
			}
			List<List<String>> result = new ArrayList<>();
			for (int i = 0; i < paths.size(); i++) {
				if (!deleted.contains(i)) {
					result.add(paths.get(i));
				}
			}
			return result;
		}

		Map<String, Folder> createFolders(List<List<String>> paths) {
			Map<String, Folder> idToFolder = new HashMap<>();
			int n = paths.size();
			for (int i = 0; i < n; i++) {
				List<String> path = paths.get(i);
				int m = path.size();
				StringBuilder sb = new StringBuilder();
				String parrentId = null;
				String name = null;
				for (int j = 0; j < m; j++) {
					if (j == m-1) {
						name = path.get(j);
						parrentId = sb.toString();
						if (parrentId.isEmpty()) {
							parrentId = "/";
						}
					}
					sb.append("/").append(path.get(j));
				}
				String childId = sb.toString();
				Folder child = idToFolder.getOrDefault(childId, new Folder());
				child.id = childId;
				child.index = i;
				child.name = name;
				idToFolder.put(childId, child);
				Folder parent = idToFolder.getOrDefault(parrentId, new Folder());
				parent.children.add(childId);
				idToFolder.put(parrentId, parent);
			}
			return idToFolder;
		}

		String recDfs (Map<String, Folder> idToFolder, String id, List<Folder> folders) {
			Folder folder = idToFolder.get(id);
			StringBuilder fn = new StringBuilder();
			for (String str : folder.children) {
				String value = recDfs (idToFolder, str, folders);
				Folder child = idToFolder.get(str);
				fn.append(child.name).append("(").append(value).append(")");
				child.parentIndex = folder.index;
			}
			folder.value = fn.toString();
			folders.add(folder);
			return fn.toString();
		}
	}
	
	class BestTimeSolution {
		static class Node {
			Map<String, Node> children = new TreeMap<>();
			String serialization = "";
			boolean toDelete = false;
        
			void markForDeletion() {
				if (toDelete) return;
				toDelete = true;
				for (Node child : children.values()) {
					child.markForDeletion();
				}
			}
		}
    
		private final ForkJoinPool threadPool;
		private static final int PARALLEL_THRESHOLD = 500;
    
		public BestTimeSolution() {
			this.threadPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		}
    
		public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
			if (paths.isEmpty()) return new ArrayList<>();
      try {
				if (paths.size() >= PARALLEL_THRESHOLD) {
					return threadPool.submit(() -> solveProblemParallel(paths)).get();
				} else {
					return solveProblemSequential(paths);
				}
      } catch (Exception e) {
      	return solveProblemSequential(paths);
      }
    }

    private List<List<String>> solveProblemParallel(List<List<String>> paths) {
			// Step 1: Build the folder tree
			Node root = new Node();
			Map<List<String>, Node> pathToNode = new HashMap<>();

			// Build tree structure (must be sequential due to dependencies)
			for (List<String> path : paths) {
				Node current = root;
				for (String folder : path) {
					current.children.putIfAbsent(folder, new Node());
					current = current.children.get(folder);
				}
				pathToNode.put(path, current);
			}

			// Step 2: Generate serializations (can be parallelized)
			generateSerializationsParallel(root);

			// Step 3: Find and mark duplicates (can be parallelized)
			markDuplicatesParallel(root);

			// Step 4: Collect remaining paths (can be parallelized)
			return paths.parallelStream()
					.filter(path -> !pathToNode.get(path).toDelete)
					.collect(Collectors.toList());
		}

		private void generateSerializationsParallel(Node root) {
			// Use post-order traversal to ensure children are processed before parents
			List<Node> allNodes = new ArrayList<>();
			collectAllNodes(root, allNodes);

			// Process nodes in reverse topological order (leaves first)
			// Group nodes by depth for level-by-level processing
			Map<Integer, List<Node>> nodesByDepth = new HashMap<>();
			assignDepthsAndGroup(root, 0, nodesByDepth);

			// Process from deepest to shallowest
			List<Integer> depths = new ArrayList<>(nodesByDepth.keySet());
			depths.sort(Collections.reverseOrder());

			for (Integer depth : depths) {
				List<Node> nodesAtDepth = nodesByDepth.get(depth);

				if (nodesAtDepth.size() > 10) {
					// Parallelize if enough nodes at this depth
					nodesAtDepth.parallelStream().forEach(this::generateSerialization);
				} else {
					// Sequential processing for small groups
					nodesAtDepth.forEach(this::generateSerialization);
				}
			}
		}

		private void generateSerialization(Node node) {
			if (node.children.isEmpty()) {
				node.serialization = "";
				return;
			}

			StringBuilder sb = new StringBuilder();
			for (Map.Entry<String, Node> entry : node.children.entrySet()) {
				sb.append(entry.getKey())
						.append('(')
						.append(entry.getValue().serialization)
						.append(')');
			}
			node.serialization = sb.toString();
		}

		private void assignDepthsAndGroup(Node node, int depth, Map<Integer, List<Node>> nodesByDepth) {
			nodesByDepth.computeIfAbsent(depth, _ -> new ArrayList<>()).add(node);
			for (Node child : node.children.values()) {
				assignDepthsAndGroup(child, depth + 1, nodesByDepth);
			}
		}

		private void collectAllNodes(Node node, List<Node> allNodes) {
			allNodes.add(node);
			for (Node child : node.children.values()) {
				collectAllNodes(child, allNodes);
			}
		}

		private void markDuplicatesParallel(Node root) {
			// Collect all nodes with non-empty serializations
			List<Node> nonEmptyNodes = new ArrayList<>();
			collectNonEmptyNodes(root, nonEmptyNodes);

			// Group by serialization
			Map<String, List<Node>> serializationGroups = nonEmptyNodes.parallelStream()
					.filter(node -> !node.serialization.isEmpty())
					.collect(Collectors.groupingByConcurrent(node -> node.serialization));

			// Mark duplicates in parallel
			serializationGroups.entrySet().parallelStream()
					.filter(entry -> entry.getValue().size() > 1)
					.forEach(entry -> {
						for (Node duplicate : entry.getValue()) {
						duplicate.markForDeletion();
					}
			});
		}

		private void collectNonEmptyNodes(Node node, List<Node> nonEmptyNodes) {
			if (!node.children.isEmpty()) {
				nonEmptyNodes.add(node);
			}
			for (Node child : node.children.values()) {
				collectNonEmptyNodes(child, nonEmptyNodes);
			}
		}

		// Sequential fallback implementation
		private List<List<String>> solveProblemSequential(List<List<String>> paths) {
			if (paths.isEmpty()) return new ArrayList<>();

			// Build tree
			Node root = new Node();
			Map<List<String>, Node> pathToNode = new HashMap<>();

			for (List<String> path : paths) {
				Node current = root;
				for (String folder : path) {
					current.children.putIfAbsent(folder, new Node());
					current = current.children.get(folder);
				}
				pathToNode.put(path, current);
			}

			// Generate serializations using post-order traversal
			generateSerializationsSequential(root);

			// Find duplicates
			Map<String, List<Node>> serializationToNodes = new HashMap<>();
			collectSerializations(root, serializationToNodes);

			// Mark duplicates
			for (List<Node> duplicates : serializationToNodes.values()) {
				if (duplicates.size() > 1) {
					for (Node node : duplicates) {
						node.markForDeletion();
					}
				}
			}

			// Collect remaining paths
			List<List<String>> result = new ArrayList<>();
			for (List<String> path : paths) {
				if (!pathToNode.get(path).toDelete) {
					result.add(path);
				}
			}

			return result;
		}

		private String generateSerializationsSequential(Node node) {
			if (node.children.isEmpty()) {
				node.serialization = "";
				return "";
			}

			StringBuilder sb = new StringBuilder();
			for (Map.Entry<String, Node> entry : node.children.entrySet()) {
				String childSerialization = generateSerializationsSequential(entry.getValue());
				sb.append(entry.getKey()).append('(').append(childSerialization).append(')');
			}

			node.serialization = sb.toString();
			return node.serialization;
		}

		private void collectSerializations(Node node, Map<String, List<Node>> serializationToNodes) {
			if (!node.serialization.isEmpty()) {
				serializationToNodes.computeIfAbsent(node.serialization, _ -> new ArrayList<>()).add(node);
			}

			for (Node child : node.children.values()) {
				collectSerializations(child, serializationToNodes);
			}
		}

		public void shutdown() {
			if (threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		}
	}
}