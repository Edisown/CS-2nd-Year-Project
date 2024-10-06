/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.CircularSinglyLinkedList;

import prelim.MyLinkedList;

/**
 * A generic implementation of a singly linked circular list.
 *
 * @param <E> the type of elements held in this list
 */
public class MySinglyLinkedCircularList<E> implements MyLinkedList<E> {
    private CircularSinglyNode<E> head;
    private int size;

    /**
     * Constructs an empty singly linked circular list.
     */
    public MySinglyLinkedCircularList() {
        head = null;
        size = 0;
    }

    /**
     * Adds a new element to the head of the list.
     * <p>
     * The algorithm for adding to the head:
     * 1. Create a new node with the given data and set its next reference to null.
     * 2. If the list is empty (i.e., head is null):
     *    - Make the new node point to itself to form a circular reference.
     *    - Set the head to be the new node.
     * 3. If the list is not empty:
     *    - Traverse the list to find the tail (the node whose next reference points to the head).
     *    - Set the new node's next reference to the current head.
     *    - Update the head to be the new node.
     *    - Update the tail's next reference to point to the new head.
     * 4. Increment the size of the list.
     *
     * @param data the data to be added to the head of the list
     */
    @Override
    public void addToHead(E data) {
        CircularSinglyNode<E> newNode = new CircularSinglyNode<>(data, null);

        if (head == null) {
            newNode.setNext(newNode);
            head = newNode;
        } else {
            CircularSinglyNode<E> tail = head;
            while (tail.getNext() != head) {
                tail = tail.getNext();
            }
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
        }
        size++;
    }

    /**
     * Adds a new element to the tail of the list.
     * <p>
     * The algorithm for adding to the tail:
     * 1. Create a new node with the given data and set its next reference to null.
     * 2. If the list is empty (i.e., head is null):
     *    - Make the new node point to itself to form a circular reference.
     *    - Set the head to be the new node.
     * 3. If the list is not empty:
     *    - Traverse the list to find the tail (the node whose next reference points to the head).
     *    - Update the tail's next reference to point to the new node.
     *    - Set the new node's next reference to point to the head.
     * 4. Increment the size of the list.
     *
     * @param data the data to be added to the tail of the list
     */
    @Override
    public void addToTail(E data) {
        CircularSinglyNode<E> newNode = new CircularSinglyNode<>(data, null);

        if (head == null) {
            newNode.setNext(newNode);
            head = newNode;
        } else {
            CircularSinglyNode<E> tail = head;
            while (tail.getNext() != head) {
                tail = tail.getNext();
            }
            tail.setNext(newNode);
            newNode.setNext(head);
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
     * 2. Check if the head node contains the data to be removed:
     *    - If the list has only one node (i.e., head's next is itself), set the head to null.
     *    - Otherwise, find the tail node and update it to point to the new head.
     * 3. If the head node does not contain the data:
     *    - Traverse the list, keeping track of the previous node.
     *    - If the current node contains the data to be removed:
     *      - Update the previous node's next reference to skip the current node.
     *      - If the current node is the head, update the head to be the next node.
     * 4. Decrement the size of the list.
     * 5. Continue until the element is found or the list is fully traversed.
     *
     * @param data the data to be removed from the list
     */
    @Override
    public void remove(E data) {
        if (head == null) {
            return;
        }

        CircularSinglyNode<E> current = head;
        CircularSinglyNode<E> previous = null;

        if (head.getData().equals(data)) {
            if (head.getNext() == head) {
                head = null;
            } else {
                CircularSinglyNode<E> tail = head;
                while (tail.getNext() != head) {
                    tail = tail.getNext();
                }
                head = head.getNext();
                tail.setNext(head);
            }
            size--;
            return;
        }

        do {
            previous = current;
            current = current.getNext();
            if (current.getData().equals(data)) {
                previous.setNext(current.getNext());
                if (current == head) {
                    head = current.getNext();
                }
                size--;
                return;
            }
        } while (current != head);
    }

    /**
     * Checks whether the specified element has been deleted from the list.
     * <p>
     * The algorithm for checking if an element is deleted:
     * 1. Start from the head and traverse the list.
     * 2. For each node, check if the data matches the specified element.
     * 3. If a match is found, return {@code false} indicating the element is not deleted.
     * 4. Continue until the end of the list or the start is reached again (i.e., circular check).
     * 5. If the element is not found, return {@code true} indicating the element is deleted.
     *
     * @param data the data to be checked
     * @return {@code true} if the element is not present in the list, {@code false} otherwise
     */
    @Override
    public boolean isDeleted(E data) {
        CircularSinglyNode<E> current = head;
        if (current == null) {
            return true;
        }
        do {
            if (current.getData().equals(data)) {
                return false;
            }
            current = current.getNext();
        } while (current != head);
        return true;
    }
}

