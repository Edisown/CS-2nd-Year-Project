/**
 * MALASAN, Edison M.
 * CS211 B/LAB - 10:30 AM - 12:00 PM
 *
 *
 * Output:
 *
 * Successfully added (1+2)
 * Successfully added (1+3)
 * List of all edges that node 1has:
 * ================================================
 * ID of Edge: 1
 * ID of the first node: 1
 * ID of the second node: 2
 *
 * ID of Edge: 2
 * ID of the first node: 1
 * ID of the second node: 3
 *
 * [(1+2), (1+3)]
 *
 */
package graphdemo1;

public class TestGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node node1 = new Node(1); // create a new instance of Node with an ID of 1
        Node node2 = new Node(2); // create a new instance of Node with an ID of 2
        Node node3 = new Node(3); // create a new instance of Node with an ID of 3
        graph.createNode(node1); // number of nodes should increment by 1
        graph.createNode(node2); // number of nodes should increment by 1
        graph.createNode(node3); // number of nodes should increment by 1
        Edge e12 = new Edge(node1, node2, 5, 1); // create an edge that connects node 1 to node 2 with a weight of 5
        Edge e13 = new Edge(node1, node3, 10, 2); // create an edge that connects node 1 to node 3 with a weight of 10

        if (graph.checkForAvailability()) {
            // two nodes can be connected via edge
            node1.addNeighbours(e12); // connect 1 and 2 (nodes)
            node1.addNeighbours(e13); // connect 1 and 3 (nodes)
            node1.getNeighbours();
        } else {
            // print a message if the nodes are less than 2
            System.out.println("There are less than 2 nodes. Add more to connect.");
        }
    }
}
