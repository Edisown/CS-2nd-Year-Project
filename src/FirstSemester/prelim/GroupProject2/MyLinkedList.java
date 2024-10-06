package prelimproject2;

/**
 * The MyLinkedList interface defines the basic operations of a singly linked list.
 * It provides methods to add, remove, and retrieve elements from the list, as well as
 * check its size and status.
 *
 * @param <T> The type of elements stored in the linked list.
 */
public interface MyLinkedList<T> {

    /**
     * Adds a new element to the head of the list.
     *
     * @param data The element to be added.
     */
    void addToHead(T data);

    /**
     * Adds a new element to the tail of the list.
     *
     * @param data The element to be added.
     */
    void addToTail(T data);

    /**
     * Removes an element from the list by matching its data.
     *
     * @param data The element to be removed.
     */
    void remove(T data);

    /**
     * Returns the current size of the list.
     *
     * @return The number of elements in the list.
     */
    int getSize();

    /**
     * Checks if an element is deleted from the list.
     *
     * @param data The element to check for.
     * @return True if the element is no longer in the list, false otherwise.
     */
    boolean isDeleted(T data);

    /**
     * Retrieves an element from the list by its index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the given index.
     */
    T get(int index);

    /**
     * Checks if the list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    boolean isEmpty();
}
