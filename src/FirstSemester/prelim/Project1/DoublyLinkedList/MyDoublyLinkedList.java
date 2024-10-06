/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.DoublyLinkedList;

import prelim.MyLinkedList;

/**
 * A generic implementation of a doubly linked list.
 *
 * @param <E> the type of elements held in this list
 */
public class MyDoublyLinkedList<E> implements MyLinkedList<E> {

    private DoublyNode<E> head;
    private DoublyNode<E> tail;
    private int size;

    /**
     * Constructs an empty doubly linked list.
     */
    public MyDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds a new element to the head of the list.
     * <p>
     * The algorithm for adding to the head:
     * 1. Create a new node with the given data, setting its next reference to the current head, and its previous reference to null.
     * 2. If the current head is not null, set its previous reference to the new node.
     * 3. Update the head to be the new node.
     * 4. If the list was empty (i.e., head was null), set the tail to be the new node as well.
     * 5. Increment the size of the list.
     *
     * @param data the data to be added to the head of the list
     */
    @Override
    public void addToHead(E data) {
        DoublyNode<E> newNode = new DoublyNode<>(data, head, null);
        if (head != null) {
            head.setPrev(newNode);
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    /**
     * Adds a new element to the tail of the list.
     * <p>
     * The algorithm for adding to the tail:
     * 1. Create a new node with the given data, setting its next reference to null and its previous reference to the current tail.
     * 2. If the current tail is not null, set its next reference to the new node.
     * 3. Update the tail to be the new node.
     * 4. If the list was empty (i.e., tail was null), set the head to be the new node as well.
     * 5. Increment the size of the list.
     *
     * @param data the data to be added to the tail of the list
     */
    @Override
    public void addToTail(E data) {
        DoublyNode<E> newNode = new DoublyNode<>(data, null, tail);

        if (tail != null){
            tail.setNext(newNode);
        } else {
            head = newNode;
        }
        tail = newNode;
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
     * 1. Traverse the list from the head.
     * 2. For each node, check if the data matches the specified element.
     * 3. If a match is found:
     *    - Update the previous node's next reference to skip the current node.
     *    - Update the next node's previous reference to skip the current node.
     *    - If the current node is the head, update the head to be the next node.
     *    - If the current node is the tail, update the tail to be the previous node.
     *    - Decrement the size of the list.
     * 4. Continue until the end of the list or until the element is found.
     *
     * @param data the data to be removed from the list
     */
    @Override
    public void remove(E data) {
        DoublyNode<E> current = head;

        while (current != null) {
            if (current.getData().equals(data)) {
                if (current.getPrev() != null) {
                    current.getPrev().setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                } else {
                    tail = current.getPrev();
                }
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    /**
     * Checks whether the specified element has been deleted from the list.
     *
     * @param data the data to be checked
     * @return {@code true} if the element is not present in the list, {@code false} otherwise
     */
    @Override
    public boolean isDeleted(E data) {
        DoublyNode<E> current = head;

        while (current != null) {
            if (current.getData().equals(data)) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
}

