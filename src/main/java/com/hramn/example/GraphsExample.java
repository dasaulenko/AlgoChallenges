package com.hramn.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphsExample {

	// Graph Representation as Adjacency Matrix
	// - Checking for the existence of an edge for O(1)
	// - Memory O(V^2)
	// - Iterating through neighbors for O(V)
	int[][] adjacencyMatrix = {
		{0, 1, 1, 0, 0},
		{1, 0, 0, 1, 0},
		{1, 0, 0, 1, 1},
		{0, 1, 1, 0, 0},
		{0, 0, 1, 0, 0}
	};

	// Graph Representation as Adjacency List
	// - Memory O(V + E)
	// - Convenient for DFS, BFS, Dijkstra
	List<List<Integer>> adjacencyList = new ArrayList<>();
	{{
		adjacencyList.add(new ArrayList<>());
		adjacencyList.add(new ArrayList<>());
		adjacencyList.add(new ArrayList<>());
		adjacencyList.add(new ArrayList<>());
		adjacencyList.add(new ArrayList<>());
		adjacencyList.get(0).add(1);
		adjacencyList.get(0).add(2);
		adjacencyList.get(1).add(0);
		adjacencyList.get(1).add(3);
		adjacencyList.get(2).add(0);
		adjacencyList.get(2).add(3);
		adjacencyList.get(2).add(4);
		adjacencyList.get(3).add(1);
		adjacencyList.get(3).add(2);
		adjacencyList.get(4).add(2);
	}};

	// Graph Representation as Edge List
	// - Convenient for Bellman-Ford and Kruskal
	record Edge(int from, int to, int weight) {}
	List<Edge> edges = List.of(
		new Edge(0, 1, 5),
		new Edge(0, 2, 3),
		new Edge(1, 3, 7),
		new Edge(2, 3, 2)
	);

	/**
	 * DFS — Depth-First Search. Recursive method.
	 * 
	 * <p><strong>Complexity:</strong>
	 * <ul>
	 *   <li>Time: O(V + E)</li>
	 *   <li>Space: O(V)</li>
	 * </ul>
	 * 
	 * @param graph
	 * @param vertex
	 * @param visited
	 */
	public static void dfsRecursive(
					List<List<Integer>> graph, 
					int vertex, 
					boolean[] visited) {
		visited[vertex] = true;
		for (int neighbor : graph.get(vertex)) {
			if (!visited[neighbor]) {
				dfsRecursive(graph, neighbor, visited);
			}
		}
	}

	/**
	 * DFS — Depth-First Search. Irerative method.
	 * 
	 * <p><strong>Complexity:</strong>
	 * <ul>
	 *   <li>Time: O(V + E)</li>
	 * </ul>
	 * 
	 * @param graph
	 * @param start
	 */
	public static void dfsIterative(
					List<List<Integer>> graph,
					int start) {

		boolean[] visited = new boolean[graph.size()];

		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(start);
		visited[start] = true;

		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			for (int neighbor : graph.get(vertex)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					stack.push(neighbor);
				}
			}
		}
	}

	/**
	 * BFS (Breadth-First Search)
	 * 
	 * <p><strong>Complexity:</strong>
	 * <ul>
	 *   <li>Time: O(V + E)</li>
	 *   <li>Space: O(V)</li>
	 * </ul>
	 * 
	 * @param graph
	 * @param start
	 */
	public static void bfs(
					List<List<Integer>> graph,
					int start) {

		boolean[] visited = new boolean[graph.size()];

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			
			for (int neighbor : graph.get(vertex)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.offer(neighbor);
				}
			}
		}
	}

	/**
	 * BFS Shortest Path
	 * 
	 * @param graph
	 * @param source
	 * @param target
	 * @return
	 */
	public static List<Integer> bfsShortestPath(
					List<List<Integer>> graph,
					int source,
					int target) {

		int n = graph.size();

		boolean[] visited = new boolean[n];
		int[] parent = new int[n];

		Arrays.fill(parent, -1);

		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(source);
		visited[source] = true;

		while (!queue.isEmpty()) {
			int vertex = queue.poll();

			if (vertex == target) break;

			for (int neighbor : graph.get(vertex)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					parent[neighbor] = vertex;
					queue.offer(neighbor);
				}
			}
		}

		if (!visited[target]) return List.of();

		List<Integer> path = new ArrayList<>();

		for (int at = target; at != -1; at = parent[at]) {
			path.add(at);
		}

		Collections.reverse(path);

		return path;
	}

	record State(int vertex, long distance) {}

	/**
	 * Dijkstra (Lazy Dijkstra)
	 * <p>Finding the shortest path in a weighted graph.
	 * 
	 * <p><Strong>Requirements:</strong>
	 * <ul>
	 *   <li>Dijkstra requires non-negative weights</li>
	 *   <li>The implementation assumes that the sum of the edge weights won’t 
	 *       overflow a long.</li>
	 * </ul>
	 * 
	 * <p>The algorithm is called Lazy Dijkstra because, instead of updating 
	 * an existing entry in the priority queue, we simply add a new one. 
	 * This is because Java’s PriorityQueue doesn’t provide a built-in 
	 * decreaseKey operation. As a result, outdated entries remain in the queue, 
	 * and whenever we poll a stale entry, we simply skip it.
	 * 
	 * <p><strong>Complexity:</strong>
	 * <ul>
	 *   <li>Time: O((V + E) * log V)</li>
	 *   <li>Space: O(V + E)</li>
	 * </ul>
	 * 
	 * @param graph
	 * @param source
	 * @return
	 */
	public static long[] dijkstra(
					List<List<Edge>> graph,
					int source) {

		int n = graph.size();

		long[] dist = new long[n];

		Arrays.fill(dist, Long.MAX_VALUE);

		dist[source] = 0;

		PriorityQueue<State> pq = new PriorityQueue<>(
						Comparator.comparingLong(State::distance)
		);

		pq.offer(new State(source, 0));

		while (!pq.isEmpty()) {
			State current = pq.poll();

			int vertex = current.vertex();
			long distance = current.distance();

			if (distance != dist[vertex]) continue;

			for (Edge edge : graph.get(vertex)) {

				if (edge.weight() < 0) {
					throw new IllegalArgumentException(
									"Dijkstra requires non-negative weights"
					);
				}

				long newDistance = distance + edge.weight();

				if (newDistance < dist[edge.to()]) {
					dist[edge.to()] = newDistance;
					pq.offer(new State(edge.to(), newDistance));
				}
			}
		}
		return dist;
	}

	record PathResult(long distance, List<Integer> path) {}

	/**
	 * Dijkstra’s Algorithm with Path Reconstruction
	 * <p>Finding the shortest path in a weighted graph and return the path.
	 * 
	 * <p><Strong>Requirements:</strong>
	 * <ul>
	 *   <li>Dijkstra requires non-negative weights</li>
	 *   <li>The implementation assumes that the sum of the edge weights won’t 
	 *       overflow a long.</li>
	 * </ul>
	 * 
	 * @param graph
	 * @param source
	 * @param target
	 * @return
	 */
	public static PathResult dijkstraPath(
					List<List<Edge>> graph,
					int source,
					int target) {

		int n = graph.size();

		long[] dist = new long[n];
		int[] parent = new int[n];

		Arrays.fill(dist, Long.MAX_VALUE);
		Arrays.fill(parent, -1);

		PriorityQueue<State> pq = new PriorityQueue<>(
						Comparator.comparingLong(State::distance)
		);

		dist[source] = 0;
		pq.offer(new State(source, 0));

		while (!pq.isEmpty()) {
			State current = pq.poll();

			int vertex = current.vertex();

			if (current.distance() != dist[vertex]) continue;

			if (vertex == target) break;

			for (Edge edge : graph.get(vertex)) {

				if (edge.weight() < 0) {
					throw new IllegalArgumentException(
									"Negative edge weight"
					);
				}

				long newDistance = dist[vertex] + edge.weight();

				if (newDistance < dist[edge.to()]) {
					dist[edge.to()] = newDistance;
					parent[edge.to()] = vertex;

					pq.offer(new State(edge.to(), newDistance));
				}
			}
		}

		if (dist[target] == Long.MAX_VALUE) {
			return new PathResult(-1, List.of());
		}

		List<Integer> path = new ArrayList<>();

		for (int at = target; at != -1; at = parent[at]) {
			path.add(at);
		}

		Collections.reverse(path);

		return new PathResult(dist[target], path);
	}

	record WeightedEdge(int from, int to, int weight) {}

	/**
	 * Bellman–Ford Algorithm
	 * <p>Finding the shortest path in a weighted graph with negative edge 
	 * weights.
	 * 
	 * <p><Strong>Requirements:</strong>
	 * <ul>
	 *   <li>The implementation assumes that the sum of the edge weights won’t 
	 *       overflow a long.</li>
	 * </ul>
	 * 
	 * <p><strong>Complexity:</strong>
	 * <ul>
	 *   <li>Time: O(V + E)</li>
	 *   <li>Space: O(V)</li>
	 * </ul>
	 * 
	 * @param vertices
	 * @param edges
	 * @param source
	 * @return
	 */
	public static long[] bellmanFord(
					int vertices,
					List<WeightedEdge> edges,
					int source) {

		long[] dist = new long[vertices];

		Arrays.fill(dist, Long.MAX_VALUE);

		dist[source] = 0;

		for (int i = 0; i < vertices - 1; i++) {

			boolean updated = false;

			for (WeightedEdge edge : edges) {

				if (dist[edge.from()] == Long.MAX_VALUE) {
					continue;
				}

				long newDistance = dist[edge.from()] + edge.weight();

				if (newDistance < dist[edge.to()]) {
					dist[edge.to()] = newDistance;
					updated = true;
				}
			}

			if (!updated) break;
		}

		// Check for a reachable negative-weight cycle

		for (WeightedEdge edge : edges) {

			if (dist[edge.from()] != Long.MAX_VALUE &&
							dist[edge.from()] + edge.weight() < dist[edge.to()]) {

				throw new IllegalStateException(
								"Negative cycle detected"
				);
			}
		}

		return dist;
	}

	/**
	 * Floyd–Warshall Algorithm
	 * 
	 * <p>Finding the shortest paths between all pairs of vertices in a weighted 
	 * graph.
	 * 
	 * <p><Strong>Requirements:</strong>
	 * <ul>
	 *   <li>The input matrix must use {@code INF = Long.MAX_VALUE / 4} for 
	 *       missing edges and {@code 0} on the main diagonal</li>
	 *   <li>Assumes that all finite distances are less than 
	 *       {@code Long.MAX_VALUE / 4}</li>
	 *   <li>Requires the absence of negative-weight cycles</li>
	 * </ul>
	 * 
	 * <p><strong>Complexity:</strong>
	 * <ul>
	 *   <li>Time: O(V^3)</li>
	 *   <li>Space: O(V^2)</li>
	 * </ul>
	 * 
	 * @param graph
	 * @return
	 */
	public static long[][] floydWarshall(long[][] graph) {

		int n = graph.length;

		long INF = Long.MAX_VALUE / 4;

		long[][] dist = new long[n][n];

		for (int i = 0; i < n; i++) {
			dist[i] = graph[i].clone();
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					if (dist[i][k] == INF || dist[k][j] == INF) continue;

					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		return dist;
	}

	/**
	 * Kahn’s Algorithm
	 * 
	 * <p>Topological sorting returns a valid order in which tasks can be 
	 * executed.
	 * 
	 * <p><Strong>Requirements:</strong>
	 * <ul>
	 *   <li>The graph must be a Directed Acyclic Graph (DAG)</li>
	 * </ul>
	 * 
	 * <p><strong>Complexity:</strong>
	 * <ul>
	 *   <li>Time: O(V + E)</li>
	 *   <li>Space: O(V)</li>
	 * </ul>
	 * 
	 * @param graph
	 * @return
	 */
	public static List<Integer> topologicalSort(
					List<List<Integer>> graph) {

		int n = graph.size();

		int[] inDegree = new int[n];

		for (int vertex = 0; vertex < n; vertex++) {
			for (int neighbor : graph.get(vertex)) {
				inDegree[neighbor]++;
			}
		}

		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		List<Integer> result = new ArrayList<>();

		while (!queue.isEmpty()) {
			int vertex = queue.poll();

			result.add(vertex);

			for (int neighbor : graph.get(vertex)) {
				inDegree[neighbor]--;

				if (inDegree[neighbor] == 0) {
					queue.offer(neighbor);
				}
			}
		}

		if (result.size() != n) {
			throw new IllegalStateException(
							"Graph contains a cycle"
			);
		}

		return result;
	}

	/**
	 * Cycle Detection
	 * 
	 * <p><Strong>Requirements:</strong>
	 * <ul>
	 *   <li>The graph must be directed.</li>
	 * </ul>
	 * 
	 * <p><strong>Complexity: </strong>
	 * O(V + E)
	 * 
	 * @param graph
	 * @return
	 */
	public static boolean hasCycle(
					List<List<Integer>> graph) {

		int[] state = new int[graph.size()];

		for (int i = 0; i < graph.size(); i++) {
			if (state[i] == 0 && dfsCycle(graph, i, state)) {
				return true;
			}
		}

		return false;
	}

	private static boolean dfsCycle(
					List<List<Integer>> graph,
					int vertex,
        	int[] state) {

		state[vertex] = 1;

		for (int neighbor : graph.get(vertex)) {

			if (state[neighbor] == 1) return true;

			if (state[neighbor] == 0 && dfsCycle(graph, neighbor, state)) return true;
    }

		state[vertex] = 2;

		return false;
	}
}
