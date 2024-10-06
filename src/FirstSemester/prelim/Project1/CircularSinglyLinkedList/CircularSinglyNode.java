/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.CircularSinglyLinkedList;

/**
 * Represents a node in a circular singly linked list.
 *
 * @param <E> the type of data stored in the node
 */
public class CircularSinglyNode<E> {
    private E data;
    private CircularSinglyNode<E> next;

    /**
     * Constructs a new node with no data and no next node.
     */
    public CircularSinglyNode() {
        this(null, null);
    }

    /**
     * Constructs a new node with the specified data and next node.
     *
     * @param data the data to be stored in the node
     * @param next the next node in the circular list
     */
    public CircularSinglyNode(E data, CircularSinglyNode<E> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Returns the data stored in the node.
     *
     * @return the data stored in the node
     */
    public E getData() {
        return data;
    }

    /**
     * Sets the data for the node.
     *
     * @param data the new data to be stored in the node
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Returns the next node in the circular list.
     *
     * @return the next node in the circular list
     */
    public CircularSinglyNode<E> getNext() {
        return next;
    }

    /**
     * Sets the next node in the circular list.
     *
     * @param next the new next node in the circular list
     */
    public void setNext(CircularSinglyNode<E> next) {
        this.next = next;
    }
}


