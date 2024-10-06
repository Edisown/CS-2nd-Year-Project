/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.SinglyLinkedList;

import prelim.MyLinkedList;

/**
 * A generic implementation of a singly linked list.
 *
 * @param <E> the type of elements held in this list
 */
public class MySinglyLinkedList<E> implements MyLinkedList<E> {
    private SinglyNode<E> head;
    private SinglyNode<E> tail;
    private int size;

    /**
     * Constructs an empty singly linked list.
     */
    public MySinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds a new element to the head of the list.
     * <p>
     * The algorithm for adding to the head:
     * 1. Create a new node with the given data, setting its next reference to the current head.
     * 2. Update the head to be the new node.
     * 3. If the list was empty (i.e., head was null), set the tail to be the new node as well.
     * 4. Increment the size of the list.
     *
     * @param data the data to be added to the head of the list
     */
    @Override
    public void addToHead(E data) {
        SinglyNode<E> newNode = new SinglyNode<>(data, head);
        head = newNode;
        if (head == null) {
            tail = newNode;
        }
        size++;
    }

    /**
     * Adds a new element to the tail of the list.
     * <p>
     * The algorithm for adding to the tail:
     * 1. Create a new node with the given data and no next node.
     * 2. If the tail is not null, set its next reference to the new node.
     * 3. Update the tail to be the new node.
     * 4. If the list was empty (i.e., tail was null), set the head to be the new node as well.
     * 5. Increment the size of the list.
     *
     * @param data the data to be added to the tail of the list
     */
    @Override
    public void addToTail(E data) {
        SinglyNode<E> newNode = new SinglyNode<>(data, null);
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
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     * <p>
     * The algorithm for removing an element:
     * 1. Check if the list is empty (i.e., head is null). If so, exit the method.
     * 2. If the head node contains the data to be removed, update the head to be the next node.
     *    - If the new head is null (i.e., the list becomes empty), also set the tail to null.
     * 3. Otherwise, traverse the list starting from the head.
     * 4. For each node, check if the next node contains the data to be removed.
     * 5. If a match is found:
     *    - Update the current node's next reference to skip the node containing the data.
     *    - If the removed node was the tail, update the tail to be the current node.
     *    - Decrement the size of the list.
     * 6. Continue until the end of the list or until the element is found.
     *
     * @param data the data to be removed from the list
     */
    @Override
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

        SinglyNode<E> current = head;
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
     * <p>
     * The algorithm for checking if an element is deleted:
     * 1. Traverse the list starting from the head.
     * 2. For each node, check if the data matches the specified element.
     * 3. If a match is found, return {@code false} indicating the element is not deleted.
     * 4. Continue until the end of the list.
     * 5. If the element is not found in the list, return {@code true} indicating the element is deleted.
     *
     * @param data the data to be checked
     * @return {@code true} if the element is not present in the list, {@code false} otherwise
     */
    @Override
    public boolean isDeleted(E data) {
        SinglyNode<E> current = head;

        while (current != null) {
            if (current.getData().equals(data)) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
}


