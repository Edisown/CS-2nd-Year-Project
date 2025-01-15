import java.util.*;

/**
 * A class representing an undirected graph. It extends the AbstractGraph class
 * and implements methods for adding edges, performing depth-first and breadth-first searches,
 * and finding the shortest paths from a starting node to all other nodes.
 */
public class UndirectedGraph extends AbstractGraph {

    /**
     * Adds an edge between two nodes in the undirected graph with a specified weight.
     * This method ensures the graph remains undirected by adding edges in both directions.
     *
     * @param src   the source node
     * @param des   the destination node
     * @param weight the weight of the edge
     */
    @Override
    public void addEdge(Node src, Node des, int weight) {
        adjacencyList.putIfAbsent(src, new ArrayList<>());
        adjacencyList.putIfAbsent(des, new ArrayList<>());

        adjacencyList.get(src).add(new Edge(des, weight));
        adjacencyList.get(des).add(new Edge(src, weight));
    }

    /**
     * Performs a depth-first search (DFS) starting from the specified node.
     *
     * @param start the starting node
     * @return a list of nodes visited in DFS order
     */
    @Override
    public List<Node> searchDepthFirst(Node start) {
        List<Node> visited = new ArrayList<>();
        Stack<Node> toVisit = new Stack<>();
        toVisit.push(start);

        while (!toVisit.isEmpty()) {
            Node current = toVisit.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                for (Edge edge : adjacencyList.get(current)) {
                    if (!visited.contains(edge.getDes())) {
                        toVisit.push(edge.getDes());
                    }
                }
            }
        }
        return visited;
    }

    /**
     * Performs a breadth-first search (BFS) starting from the specified node.
     *
     * @param start the starting node
     * @return a list of nodes visited in BFS order
     */
    @Override
    public List<Node> searchBreadthFirst(Node start) {
        List<Node> visited = new ArrayList<>();
        Queue<Node> toVisit = new LinkedList<>();

        toVisit.add(start);
        while (!toVisit.isEmpty()) {
            Node current = toVisit.poll();
            if (!visited.contains(current)) {
                visited.add(current);
                for (Edge edge : adjacencyList.get(current)) {
                    if (!visited.contains(edge.getDes())) {
                        toVisit.add(edge.getDes());
                    }
                }
            }
        }
        return visited;
    }

    /**
     * Finds the shortest paths from the starting node to all other nodes using Dijkstra's algorithm.
     *
     * @param start the starting node
     * @return a list of paths, where each path is a list of nodes representing the shortest path
     *         from the starting node to a specific node
     */
    @Override
    public List<List<Node>> findShortestPath(Node start) {
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> predecessors = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        List<List<Node>> paths = new ArrayList<>();

        // Initialize distances to infinity for all nodes except the start node
        for (Node node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        queue.add(start);

        // Perform Dijkstra's algorithm
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Edge edge : adjacencyList.get(current)) {
                Node neighbor = edge.getDes();
                int newDist = distances.get(current) + edge.getWeight();

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    predecessors.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // Construct paths from the predecessors map
        for (Node node : adjacencyList.keySet()) {
            List<Node> path = new ArrayList<>();
            Node current = node;

            while (current != null) {
                path.add(0, current); // Add at the beginning to construct the path in reverse order
                current = predecessors.get(current);
            }

            if (!path.isEmpty() && path.get(0).equals(start)) {
                paths.add(path);
            }
        }
        return paths;
    }
}
