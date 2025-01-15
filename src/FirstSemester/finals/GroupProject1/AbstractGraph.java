import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AbstractGraph class that connects and implements all Graph from Dept-First Search,
 * Breadth-First search, directed and directed Graph, edges, find shortest- path.
 */
public abstract class AbstractGraph implements Graph{
    protected Map<Node, List<Edge>> adjacencyList;

    public AbstractGraph(){
        adjacencyList = new HashMap<>();
    }

    /**
     * removes the Adjancy list of the Node
     * @param node
     */
    public void removeNode(Node node){
        if (containsNode(node)){
            adjacencyList.remove(node);
            //remove also all instances of the node in the
            // adjacency list since it is not supposed to exist anymore
            adjacencyList.values().forEach(list -> list.remove(node));
        }
    }

    /**
     * Getter methods of the AbstractClass
     * @return the arrayList to the adjacency key set
     */
    public List<Node> getNodes(){
        return new ArrayList<>(adjacencyList.keySet());
    }

    /**
     * Contains the Edge for the src Node and the des Node
     * @param src Node for the src
     * @param des Node for the des
     * @return the adjacencyList of the src and des
     */
    public boolean containsEdge(Node src, Node des){
        return adjacencyList.get(src).contains(des);
    }

    /**
     * Container for Node method
     * @param node for node
     * @return the adjacencyList of the node
     */
    public boolean containsNode(Node node){
        return adjacencyList.containsKey(node);
    }

    /**
     * Adds the edges for the abstractClass
     * @param src Constructors method for src
     * @param des Constructors method for des
     * @param weight Constructors method for weight
     */
    public abstract void addEdge(Node src, Node des, int weight);

    /**
     * Search-DepthFirst method class
     * @param start node
     * @return to start
     */

    public abstract List<Node> searchDepthFirst(Node start);

    /**
     * Search-BreadthFirst method class
     * @param start node
     * @return to start
     */
    public abstract List<Node> searchBreadthFirst(Node start);

    /**
     * find-ShortestPath method class
     * @param start node
     * @return start
     */
    public abstract List<List<Node>> findShortestPath(Node start);
}
