/**
 *  MALASAN, Edison M.
 *  CS211 B/LAB - 10:30 AM - 12:00 PM
 *
 */
package graphdemo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Reference class Graph
 */
public class Graph {
    private List<Node> nodes = new ArrayList<Node>();
    private int numberOfNodes = 0;

    /**
     * Method that returns false if the number of nodes is less than two and returns true if the number of nodes is greater than 1
     * @return
     */
    public boolean checkForAvailability() {
        return this.numberOfNodes > 1;
    }

    /**
     * Method that creates nodes by using the add method and increment the number of nodes
     * @param node
     */
    public void createNode(Node node) {
        this.nodes.add(node);
        this.numberOfNodes++;
    }

    /**
     * Method that get the number of nodes simply by pointing to the numberOfNodes
     *
     * @return
     */
    public int getNumberOfNodes() {
        return this.numberOfNodes;
    }
}
