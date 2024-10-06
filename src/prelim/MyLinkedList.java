package prelim;

/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
*/

public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructs an empty singly linked list.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    /**
     * Adds a new element to the head of the list.
     *
     * @param data the data to be added to the head of the list
     */
    public void addToHead(E data) {
        Node<E> newNode = new Node<>(data, head);
        head = newNode;
        if (head == null) {
            tail = newNode;
        }
        size++;
    }


    /**
     * Adds a new element to the tail of the list.
     *
     * @param data the data to be added to the tail of the list
     */
    public void addToTail(E data) {
        Node<E> newNode = new Node<>(data, null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }


    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param data the data to be removed from the list
     */
    public void remove(E data) {
        if (head == null) {
            return;
        }

        if (head.getData().equals(data)) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            size--;
            return;
        }

        Node<E> current = head;
        while (current.getNext() != null && !current.getNext().getData().equals(data)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            if (current.getNext() == null) {
                tail = null;
            }
            size--;
        }
    }


    /**
     * Checks whether the specified element has been deleted from the list.
     *
     * @param data the data to be checked
     * @return {@code true} if the element is not present in the list, {@code false} otherwise
     */
    public boolean isDeleted(E data) {
        Node<E> current = head;

        while (current != null) {
            if (current.getData().equals(data)) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }


    /**
     * Returns the head of the list.
     *
     * @return the head node of the list
     */
    public Node<E> getHead() {
        return head;
    }


    /**
     * Sets the head of the list.
     *
     * @param head the new head node of the list
     */
    public void setHead(Node<E> head) {
        this.head = head;
    }


    /**
     * Returns the tail of the list.
     *
     * @return the tail node of the list
     */
    public Node<E> getTail() {
        return tail;
    }


    /**
     * Sets the tail of the list.
     *
     * @param tail the new tail node of the list
     */
    public void setTail(Node<E> tail) {
        this.tail = tail;
    }


    /**
     * Returns the size of the list.
     *
     * @return the number of elements in the list
     */
    public int getSize() {
        return size;
    }


    /**
     * Sets the size of the list.
     *
     * @param size the new size of the list
     */
    public void setSize(int size) {
        this.size = size;
    }
}
