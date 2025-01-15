import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

/**
 * Class for the directed Graph
 */

public class DirectedGraph extends AbstractGraph{

    /**
     *
     * @param src AdjancyList set for src
     * @param des AdjancyList set for des
     * @param weight AdjancyList set for weight
     */
    @Override
    public void addEdge(Node src, Node des, int weight) {
        adjacencyList.putIfAbsent(src, new ArrayList<>());
        adjacencyList.putIfAbsent(des, new ArrayList<>());

        adjacencyList.get(src).add(new Edge(des, weight));
    }

    /**
     * The Search First-depth Node Class
     * @param start node to be executed
     * @return  to visited
     */
    @Override
    public List<Node> searchDepthFirst(Node start) {
        List<Node> visited = new ArrayList<>();
        Set<Node> visitedSet = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (!visitedSet.contains(current)) {
                visited.add(current);
                visitedSet.add(current);

                // Add unvisited neighbors to the stack
                for (Edge edge : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                    Node neighbor = edge.getDes();
                    if (!visitedSet.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return visited;
    }

    /**
     * The searchBreadthFirst Node Class
     * @param start to be executed
     * @return to visited
     */
    @Override
    public List<Node> searchBreadthFirst(Node start) {
        List<Node> visited = new ArrayList<>();
        Set<Node> visitedSet = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(start);
        visitedSet.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visited.add(current);

            // Add unvisited neighbors to the queue
            for (Edge edge : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                Node neighbor = edge.getDes();
                if (!visitedSet.contains(neighbor)) {
                    visitedSet.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return visited;
    }

    /**
     * The FindShortestPath Node Class
     * @param start to be executed
     * @return to visited
     */
    @Override
    public List<List<Node>> findShortestPath(Node start) {
        List<List<Node>> shortestPaths = new ArrayList<>();
        // Dijkstra's algorithm for finding the shortest paths
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        // Initialize distances and priority queue
        for (Node node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
            previousNodes.put(node, null);
        }
        distances.put(start, 0);
        pq.offer(start);

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Edge edge : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                Node neighbor = edge.getDes();
                int newDist = distances.get(current) + edge.getWeight();

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previousNodes.put(neighbor, current);
                    pq.offer(neighbor);
                }
            }
        }

        // Reconstruct the shortest paths
        for (Node node : adjacencyList.keySet()) {
            if (node != start && distances.get(node) < Integer.MAX_VALUE) {
                List<Node> path = new ArrayList<>();
                for (Node at = node; at != null; at = previousNodes.get(at)) {
                    path.add(at);
                }
                Collections.reverse(path);
                shortestPaths.add(path);
            }
        }

        return shortestPaths;
    }
}