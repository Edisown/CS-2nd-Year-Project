package prelimproject2;

import java.util.Objects;

/**
 * The Node class represents a node in a singly linked list. Each node stores an element of type {@code E}
 * and a reference to the next node in the list.
 *
 * @param <E> The type of element stored in the node.
 */
public class Node<E> {
    private E info; // The data stored in this node.
    private Node<E> next; // Reference to the next node in the list.

    /**
     * Default constructor that initializes the node with null values.
     */
    public Node() {
        info = null;
        next = null;
    }

    /**
     * Constructs a node with the specified data and sets the next node to null.
     *
     * @param info The data to store in the node.
     */
    public Node(E info) {
        this.info = info;
    }

    /**
     * Constructs a node with the specified data and reference to the next node.
     *
     * @param info The data to store in the node.
     * @param next The next node in the list.
     */
    public Node(E info, Node<E> next) {
        this.info = info;
        this.next = next;
    }

    /**
     * Gets the data stored in the node.
     *
     * @return The data stored in the node.
     */
    public E getInfo() {
        return info;
    }

    /**
     * Sets the data stored in the node.
     *
     * @param info The data to store in the node.
     */
    public void setInfo(E info) {
        this.info = info;
    }

    /**
     * Gets the reference to the next node in the list.
     *
     * @return The next node in the list.
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Sets the reference to the next node in the list.
     *
     * @param next The next node in the list.
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }

    /**
     * Compares this node to another node by comparing the data they store.
     *
     * @param other The other node to compare with.
     * @return True if the data in both nodes are equal, false otherwise.
     */
    public boolean equals(Node<E> other) {
        return this.info.toString().equals(other.getInfo().toString());
    }

    /**
     * Returns a string representation of the data stored in the node.
     *
     * @return The string representation of the data.
     */
    @Override
    public String toString() {
        return info.toString();
    }
}
