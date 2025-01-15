import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a node in a graph with a unique identifier and a list of adjacent nodes.
 * Each node is identified by a character ID and maintains its own list of neighbors.
 */
public class Node {
    private char id; // Unique identifier for the node
    private List<Node> adjacentNodes; // List of nodes directly connected to this node

    /**
     * Default constructor that initializes the node with a default ID 'x'
     * and an empty list of adjacent nodes.
     */
    public Node() {
        id = 'x';
        adjacentNodes = new ArrayList<>();
    }

    /**
     * Constructs a node with the specified ID and initializes an empty list
     * of adjacent nodes.
     *
     * @param id the unique identifier for this node
     */
    public Node(char id) {
        this.id = id;
        this.adjacentNodes = new ArrayList<>();
    }

    /**
     * Retrieves the ID of this node.
     *
     * @return the character ID of the node
     */
    public char getId() {
        return id;
    }

    /**
     * Sets the ID of this node.
     *
     * @param id the new character ID for the node
     */
    public void setId(char id) {
        this.id = id;
    }

    /**
     * Retrieves the list of nodes adjacent to this node.
     *
     * @return a list of adjacent nodes
     */
    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    /**
     * Adds a node to the list of adjacent nodes.
     *
     * @param node the node to be added as adjacent
     */
    public void addAdjacentNode(Node node) {
        adjacentNodes.add(node);
    }

    /**
     * Checks if this node is equal to another object based on their IDs.
     *
     * @param obj the object to compare with this node
     * @return true if the IDs are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return id == node.id;
    }

    /**
     * Generates a hash code for this node based on its ID.
     *
     * @return the hash code for this node
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Returns a string representation of this node, which is its ID.
     *
     * @return the string representation of the node ID
     */
    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
