/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.CircularDoublyLinkedList;

/**
 * Represents a node in a circular doubly linked list.
 *
 * @param <E> the type of data stored in the node
 */
public class CircularDoublyNode<E> {
    private E data;
    private CircularDoublyNode<E> next;
    private CircularDoublyNode<E> prev;

    /**
     * Constructs a new node with no data, no next node, and no previous node.
     */
    public CircularDoublyNode() {
        this(null, null, null);
    }

    /**
     * Constructs a new node with the specified data, next node, and previous node.
     *
     * @param data the data to be stored in the node
     * @param next the next node in the circular list
     * @param prev the previous node in the circular list
     */
    public CircularDoublyNode(E data, CircularDoublyNode<E> next, CircularDoublyNode<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
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
     * Returns the next node in the circular doubly linked list.
     *
     * @return the next node in the circular doubly linked list
     */
    public CircularDoublyNode<E> getNext() {
        return next;
    }

    /**
     * Sets the next node in the circular doubly linked list.
     *
     * @param next the new next node in the circular doubly linked list
     */
    public void setNext(CircularDoublyNode<E> next) {
        this.next = next;
    }

    /**
     * Returns the previous node in the circular doubly linked list.
     *
     * @return the previous node in the circular doubly linked list
     */
    public CircularDoublyNode<E> getPrev() {
        return prev;
    }

    /**
     * Sets the previous node in the circular doubly linked list.
     *
     * @param prev the new previous node in the circular doubly linked list
     */
    public void setPrev(CircularDoublyNode<E> prev) {
        this.prev = prev;
    }
}
