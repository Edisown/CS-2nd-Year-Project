package prelim;

/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */

public class Node<E> {
    private E data;
    private Node<E> next;

    /**
     * Constructs a new  with no data and no next .
     */
    public Node() {
        this.data = null;
        this.next = null;
    }

    /**
     * Constructs a new  with the specified data and next .
     *
     * @param data the data to store in the 
     * @param next the next  in the list
     */
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Returns the data stored in the .
     *
     * @return the data stored in the 
     */
    public E getData() {
        return data;
    }

    /**
     * Sets the data for the .
     *
     * @param data the data to set
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Returns the next  in the list.
     *
     * @return the next  in the list
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Sets the next  in the list.
     *
     * @param next the next  to set
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
