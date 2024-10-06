/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.SinglyLinkedList;

public class SinglyNode<E> {
    private E data;
    private SinglyNode<E> next;

    /**
     * Constructs a new node with no data and no next node.
     */
    public SinglyNode() {
        this.data = null;
        this.next = null;
    }

    /**
     * Constructs a new node with the specified data and next node.
     *
     * @param data the data to store in the node
     * @param next the next node in the list
     */
    public SinglyNode(E data, SinglyNode<E> next) {
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
     * @param data the data to set
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Returns the next node in the list.
     *
     * @return the next node in the list
     */
    public SinglyNode<E> getNext() {
        return next;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next the next node to set
     */
    public void setNext(SinglyNode<E> next) {
        this.next = next;
    }
}
