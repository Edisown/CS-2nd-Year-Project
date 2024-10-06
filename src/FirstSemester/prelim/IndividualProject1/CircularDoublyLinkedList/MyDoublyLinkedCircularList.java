/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.CircularDoublyLinkedList;

import prelim.MyLinkedList;

/**
 * A generic implementation of a doubly linked circular list.
 *
 * @param <E> the type of elements held in this list
 */
public class MyDoublyLinkedCircularList<E> implements MyLinkedList<E> {
    private CircularDoublyNode<E> head;
    private int size;

    /**
     * Constructs an empty doubly linked circular list.
     */
    public MyDoublyLinkedCircularList() {
        head = null;
        size = 0;
    }

    /**
     * Adds a new element to the head of the list.
     * <p>
     * The algorithm for adding to the head:
     * 1. Create a new node with the given data, setting its next and previous references to null.
     * 2. If the list is empty (i.e., head is null):
     *    - Set the new node's next and previous references to point to itself, forming a circular reference.
     *    - Set the head to be the new node.
     * 3. If the list is not empty:
     *    - Identify the current tail (the node whose next reference is head).
     *    - Set the new node's next reference to the current head.
     *    - Set the new node's previous reference to the current tail.
     *    - Update the current head's previous reference to the new node.
     *    - Update the current tail's next reference to the new node.
     *    - Set the head to be the new node.
     * 4. Increment the size of the list.
     *
     * @param data the data to be added to the head of the list
     */
    @Override
    public void addToHead(E data) {
        CircularDoublyNode<E> newNode = new CircularDoublyNode<>(data, null, null);
        if (head == null) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            head = newNode;
        } else {
            CircularDoublyNode<E> tail = head.getPrev();
            newNode.setNext(head);
            newNode.setPrev(tail);
            head.setPrev(newNode);
            tail.setNext(newNode);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds a new element to the tail of the list.
     * <p>
     * The algorithm for adding to the tail:
     * 1. Create a new node with the given data, setting its next and previous references to null.
     * 2. If the list is empty (i.e., head is null):
     *    - Set the new node's next and previous references to point to itself, forming a circular reference.
     *    - Set the head to be the new node.
     * 3. If the list is not empty:
     *    - Identify the current tail (the node whose next reference is head).
     *    - Set the new node's next reference to point to the head.
     *    - Set the new node's previous reference to the current tail.
     *    - Update the current tail's next reference to the new node.
     *    - Update the head's previous reference to the new node.
     * 4. Increment the size of the list.
     *
     * @param data the data to be added to the tail of the list
     */
    @Override
    public void addToTail(E data) {
        CircularDoublyNode<E> newNode = new CircularDoublyNode<>(data, null, null);
        if (head == null) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            head = newNode;
        } else {
            CircularDoublyNode<E> tail = head.getPrev();
            newNode.setNext(head);
            newNode.setPrev(tail);
            tail.setNext(newNode);
            head.setPrev(newNode);
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
     * 2. Traverse the list starting from the head.
     * 3. For each node, check if its data matches the specified element.
     * 4. If a match is found:
     *    - Update the previous node's next reference to skip the current node.
     *    - Update the next node's previous reference to skip the current node.
     *    - If the current node is the head:
     *      - If the list has only one node (i.e., head's next is itself), set head to null.
     *      - Otherwise, update the head to be the next node.
     * 5. Decrement the size of the list.
     * 6. Continue until the element is found or the list is fully traversed.
     *
     * @param data the data to be removed from the list
     */
    @Override
    public void remove(E data) {
        if (head == null) {
            return;
        }

        CircularDoublyNode<E> current = head;
        do {
            if (current.getData().equals(data)) {
                CircularDoublyNode<E> prevNode = current.getPrev();
                CircularDoublyNode<E> nextNode = current.getNext();

                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);

                if (current == head) {
                    if (head.getNext() == head) {
                        head = null;
                    } else {
                        head = nextNode;
                    }
                }
                size--;
                return;
            }
            current = current.getNext();
        } while (current != head);
    }

    /**
     * Checks whether the specified element has been deleted from the list.
     * <p>
     * The algorithm for checking if an element is deleted:
     * 1. Start from the head and traverse the list.
     * 2. For each node, check if the data matches the specified element.
     * 3. If a match is found, return {@code false} indicating the element is not deleted.
     * 4. Continue until the end of the list or until the start is reached again (i.e., circular check).
     * 5. If the element is not found, return {@code true} indicating the element is deleted.
     *
     * @param data the data to be checked
     * @return {@code true} if the element is not present in the list, {@code false} otherwise
     */
    @Override
    public boolean isDeleted(E data) {
        if (head == null) {
            return true;
        }

        CircularDoublyNode<E> current = head;
        do {
            if (current.getData().equals(data)) {
                return false;
            }
            current = current.getNext();
        } while (current != head);
        return true;
    }
}

