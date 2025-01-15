import java.util.List;

/**
 * Graph Interface Class that holds together all the Graph theory Algorithm.
 */
public interface Graph {
    void addEdge(Node src, Node des, int weight);
    List<Node> getNodes();
    List<Node> searchDepthFirst(Node start);
    List<Node> searchBreadthFirst(Node start);
    List<List<Node>> findShortestPath(Node start);
}
