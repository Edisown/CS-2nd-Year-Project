/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.DoublyLinkedList;

/**
 * A node in a doubly linked list that contains data and references to the next and previous nodes.
 *
 * @param <E> the type of elements held in this node
 */
public class DoublyNode<E> {
    private E data;
    private DoublyNode<E> next;
    private DoublyNode<E> prev;

    /**
     * Constructs a new node with no data and no connections to other nodes.
     */
    public DoublyNode() {
        this(null, null, null);
    }

    /**
     * Constructs a new node with specified data, next node, and previous node.
     *
     * @param data the data to be stored in this node
     * @param next the next node in the list
     * @param prev the previous node in the list
     */
    public DoublyNode(E data, DoublyNode<E> next, DoublyNode<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /**
     * Returns the data stored in this node.
     *
     * @return the data stored in this node
     */
    public E getData() {
        return data;
    }

    /**
     * Sets the data stored in this node.
     *
     * @param data the new data to be stored in this node
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Returns the next node in the list.
     *
     * @return the next node in the list
     */
    public DoublyNode<E> getNext() {
        return next;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next the new next node in the list
     */
    public void setNext(DoublyNode<E> next) {
        this.next = next;
    }

    /**
     * Returns the previous node in the list.
     *
     * @return the previous node in the list
     */
    public DoublyNode<E> getPrev() {
        return prev;
    }

    /**
     * Sets the previous node in the list.
     *
     * @param prev the new previous node in the list
     */
    public void setPrev(DoublyNode<E> prev) {
        this.prev = prev;
    }
}
